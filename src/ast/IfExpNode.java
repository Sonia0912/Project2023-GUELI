package ast;

import java.util.ArrayList;

import evaluator.SimpLanlib;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class IfExpNode implements Node {
	private Node guard ;
	private Node thenExp ;
	private Node elseExp ;

	private ArrayList<Node> thenStms;
	private ArrayList<Node> elseStms;
  


    public IfExpNode(Node condExp, ArrayList<Node> _thenStms, Node _thenExp, ArrayList<Node> _elseStms, Node _elseExp) {
		guard = condExp;
		thenExp = _thenExp;
		elseExp = _elseExp;
		thenStms = _thenStms;
		elseStms = _elseStms;

    }

    @Override
  public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
	  ArrayList<SemanticError> errors = new ArrayList<SemanticError>();

	  errors.addAll(guard.checkSemantics(ST, _nesting));

		for (Node then: thenStms) {
			errors.addAll(then.checkSemantics(ST,_nesting));
		}
		for (Node i: elseStms) {
			errors.addAll(i.checkSemantics(ST,_nesting));
		}

	  errors.addAll(thenExp.checkSemantics(ST, _nesting));
	  errors.addAll(elseExp.checkSemantics(ST, _nesting));

	  return errors;
  }
  
	public Type typeCheck() {
		if (guard.typeCheck() instanceof BoolType) {

			for (Node a: thenStms) {
				if(a.typeCheck().equals(ErrorType.class)){
					return new ErrorType();
				}
			}

			for (Node b: elseStms) {
				if(b.typeCheck().equals(ErrorType.class)){
					return new ErrorType();
				}
			}


			Type thenType = thenExp.typeCheck() ;
			Type elseType = elseExp.typeCheck() ;

			if (thenType.getClass().equals(elseType.getClass()))
        		return thenType;
			else {
        		System.out.println("Type Error: incompatible types in then and else branches");
        		return new ErrorType() ;	
			}
		} else {
			System.out.println("Type Error: non boolean condition in if");
			return new ErrorType() ;
		}   
	}
  
  	public String codeGeneration() {
  		String lthen = SimpLanlib.freshLabel(); 
  		String lend = SimpLanlib.freshLabel();
		StringBuilder thenStmString = new StringBuilder();
		StringBuilder elseStmString = new StringBuilder();

		for (Node a: thenStms) {
			thenStmString.append(a.codeGeneration());
		}

		for (Node b: elseStms) {
			elseStmString.append(b.codeGeneration());
		}

  		return guard.codeGeneration() +
			 "storei T1 0 \n" +
			 "beq A0 T1 "+ lthen + "\n" +
			 thenStmString + thenExp.codeGeneration()+
			 "b " + lend + "\n" +
			 lthen + ":\n" +
			 elseStmString  + elseExp.codeGeneration()+
			 lend + ":\n" ;
  	}

  	public String toPrint(String s) {
		String thenStmString = "";
		String elseStmString = "";

		for (Node a: thenStms) {
			thenStmString += a.toPrint("");
		}

		for (Node b: elseStms) {
			elseStmString += b.toPrint("");
		}

		String thenString = thenExp.toPrint(s+"  ");
		String elseString = elseExp.toPrint(s+"  ");
	    return s+"If\n" + guard.toPrint(s+"  ") + thenStmString + thenString + elseStmString  + elseString ;
	}
	  
}  