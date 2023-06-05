package ast;
import java.util.ArrayList;

import semanticanalysis.STentry;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class CallNode implements Node {
	private String id ;
	private STentry entry ; 
	private ArrayList<Node> parameters ; 
	private int nesting ;

  	public CallNode(String _id, ArrayList<Node> _parameters) {
		id = _id;
		parameters = _parameters ;
	}

	public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
		ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
		nesting = _nesting ;
		STentry tmp = ST.lookup(id) ;
		if (tmp != null) {
				entry = tmp ;
				for (Node par : parameters){
					errors.addAll(par.checkSemantics(ST, nesting));
				}

		} else {
			 	errors.add(new SemanticError("Fun " + id + " not declared")) ;
		}
		return errors;
  }
  
	public Type typeCheck() {
		  if(entry != null){
			  Type _type = entry.gettype() ;
			  if ( _type instanceof ArrowType ) {
				  ArrayList<Type> _partype = ((ArrowType) _type).get_inputtype();
				  if ( _partype.size() != parameters.size() ) {
					  System.out.println("Wrong number of parameters in the invocation of "+id);
					  return new ErrorType() ;
				  } else {
					  boolean ok = true ;
					  for (int i = 0 ; i < parameters.size() ; i++) {
						  Type par_i = (parameters.get(i)).typeCheck() ;
						  if ( !(par_i.getClass().equals(_partype.get(i).getClass()) )) {
							  System.out.println("Wrong type for "+(i+1)+"-th parameter in the invocation of "+id);
							  ok = false ;
						  }
					  }
					  if (ok) return ((ArrowType) _type).get_outputtype() ;
					  else return new ErrorType() ;
				  }
			  } else {
				  System.out.println("Invocation of a non-function "+id) ;
				  return new ErrorType() ;
			  }
		  }else {
			  System.out.println("Invocation of a function non declared "+id) ;
			  return new ErrorType() ;
		  }

	}

  	public String codeGeneration() {
		// Generiamo il codice per i parametri
		StringBuilder parCode = new StringBuilder();
		for (int i = 0; i < parameters.size() ; i++)
			parCode.append(parameters.get(i).codeGeneration()).append("pushr A0\n");

		// Prepariamo la deferenziazione
		StringBuilder getAR= new StringBuilder();
		for (int i = 0; i < nesting - entry.getnesting() ; i++)
			getAR.append("store T1 0(T1) \n");

		return    "pushr FP \n"			// carico il frame pointer
				+ "move SP FP \n"
				+ "addi FP 1 \n"	    // salvo in FP il puntatore all'indirizzo del frame pointer caricato
				+ "move AL T1\n"		// risalgo la catena statica
				+ getAR
				+ "pushr T1 \n"			// salvo sulla pila l'access link statico
				+ parCode 				// calcolo i parametri attuali con l'access link del chiamante
				+ "move FP AL \n"
				+ "subi AL 1 \n"
				+ "jsub " + entry.getlabel() + "\n";

  	}

	public String toPrint(String s) {  //
	    String parlstr="";
		for (Node par : parameters)
			parlstr+=par.toPrint(s+"  ");		
		return s+"Call:" + id + " at nestlev " + nesting +"\n" + entry.gettype().toPrint(s+"  ") + parlstr ;        
	} 
}  