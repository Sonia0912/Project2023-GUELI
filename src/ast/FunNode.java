package ast;
import java.util.ArrayList;
import java.util.HashMap;

import evaluator.SimpLanlib;
import semanticanalysis.STentry;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class FunNode implements Node {
	private String id;
	private Type returntype ; 
	private ArrayList<ParNode> parlist ;
	private Node body ;
	private ArrowType type ;
	private int nesting ;
	private String flabel ;
  
	public FunNode (String _id, Type _type, ArrayList<ParNode> _parlist, Node _body) {
		id = _id ;
		returntype = _type;
		parlist = _parlist ;
		body = _body ;
	}

	public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {

		ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
		nesting = _nesting ;

		// Salviamo la vecchia ST da restorare dopo aver controllato il body
		SymbolTable oldST = new SymbolTable();
		oldST.setSymbol_table(ST.getSymbol_table());
		oldST.setOffset(ST.getOffset());
		
		if (ST.lookup(id) != null)
			errors.add(new SemanticError("Identifier " + id + " already declared"));
		else {
			HashMap<String,STentry> HM = new HashMap<String,STentry>() ;
			ArrayList<Type> partypes = new ArrayList<Type>() ;
		
			ST.add(HM);
			
			for (ParNode arg : parlist){
    	  			partypes.add(arg.getType());
    	  			if (ST.top_lookup(arg.getId()))
    	  					errors.add(new SemanticError("Parameter id " + arg.getId() + " already declared")) ;
    	  			else {
						ST.insert(arg.getId(), arg.getType(), nesting+1, "") ;
						//in questo modo dichiaro che i parametri della funzione saranno sicuramente inizializzati
						STentry a = ST.lookup(arg.getId());
						a.setInitialized(true);
					}
			}

			type = new ArrowType(partypes, returntype) ;
			
			ST.increaseoffset() ; // aumentiamo di 1 l'offset per far posto al return value

			// aggiungiamo la funzione anche prima di controllare il body per permettere la ricorsione
			flabel = SimpLanlib.freshFunLabel() ;
			ST.insert(id, type, nesting, flabel) ;

			if(body != null) {
				errors.addAll(body.checkSemantics(ST, nesting));
			}
			ST.remove();
			//ST.union(oldST,ST);
			ST.restore(oldST.getSymbol_table(), oldST.getOffset());
			
			//flabel = SimpLanlib.freshFunLabel() ;
			ST.insert(id, type, nesting, flabel) ;
		}
		return errors ; // problemi con la generazione di codice!
	}
  
 	public Type typeCheck () {

		if(body == null && returntype.getClass().equals(ast.VoidType.class)) {
			return new VoidType() ;
		} else if(body != null && body.typeCheck().getClass().equals(returntype.getClass())) {
			return returntype ;
		} else {
			System.out.println("Type Error: Function return type doesn't match statement/expression type") ;
			return new ErrorType() ;
		}

  	}

  	public String codeGeneration() {
	  

	    SimpLanlib.putCode(
	    			flabel + ":\n"
	    			+ "pushr RA \n"
	    			+ body.codeGeneration()
	    			+ "popr RA \n"
	    			+ "addi SP " + 	parlist.size() + "\n"
	    			+ "pop \n"
	    			+ "store FP 0(FP) \n"
	    			+ "move FP AL \n"
	    			+ "subi AL 1 \n"
	    			+ "pop \n"
	    			+ "rsub RA \n" 
	    		);
	    
		return  "push "+ flabel +"\n";
  	}
  
  	public String toPrint(String s) {
		String parlstr="";
		for (Node par:parlist){
		  parlstr += par.toPrint(s);
		}
		if(body != null) {
			return s+"Fun:" + id +"\n"
					+parlstr
					+ "\n"
					+body.toPrint(s+"  ") ;
		} else {
			return s+"Fun:" + id +"\n"
					+parlstr
					+ "\n"
					+" (no body) " ;
		}
	  }
	  
	}