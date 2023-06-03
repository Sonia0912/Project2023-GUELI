package ast;

import java.util.ArrayList;

import semanticanalysis.STentry;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class IdNode implements Node {
	private String id ;
	private STentry type ;
	private boolean init ;
	private int nesting ;
  
	public IdNode (String _id) {
		id = _id ;
	}
  
	public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
		ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
		nesting = _nesting ;

		STentry st_type = ST.lookup(id) ;
		if (st_type == null)
			errors.add(new SemanticError("Id " + id + " not declared"));
		else {
			if(!st_type.getInitialized())
				errors.add(new SemanticError("Var " + id + " has not been initialised"));
				type = st_type ;
				//init = ST.lookup(id).getInitialized() ;
		}

		return errors;
	}
  
	public Type typeCheck () {
		if (type != null && type.gettype() instanceof ArrowType) {
			System.out.println("Wrong usage of function identifier");
			return new ErrorType() ;
		}
/*		if (!init) {
			System.out.println("Var " + id + " has not been initialised");
			return new ErrorType() ;
		}*/
		if(type == null)
			return new ErrorType() ;
		return type.gettype() ;
	}
  
	public String codeGeneration() {
		String getAR="";
		for (int i=0; i < nesting - type.getnesting(); i++) 
	    	 getAR += "store T1 0(T1) \n";
	    return 
		       "move AL T1 \n"
		       + getAR  //risalgo la catena statica
		       + "subi T1 " + type.getoffset() +"\n" //metto offset sullo stack
			   + "store A0 0(T1) \n" ; //carico sullo stack il valore all'indirizzo ottenuto
	}

	public String toPrint(String s) {
		return s+"Id:" + id + " at nestlev " + type.getnesting() +"\n" ;
	}
  
}  