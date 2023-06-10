package ast;

import java.util.ArrayList;

import semanticanalysis.STentry;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class IdNode implements Node {
	private String id ;
	private STentry stentry;
	private int nesting ;
  
	public IdNode (String _id) {
		id = _id ;
	}
  
	public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
		ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
		nesting = _nesting ;

		STentry st = ST.lookup(id) ;
		if (st == null)
			errors.add(new SemanticError("Id " + id + " not declared"));
		else {
			// Se e' dichiarata nello scope corrente ma non e' inizializzata ritorno errore
			if(ST.top_lookup(id) && !st.getInitialized()) {
				errors.add(new SemanticError("Var " + id + " has not been initialised"));
			}
			// Se e' dichiarata in un altro scope e non e' ancora stata inizializzata -> warning
			else if(!ST.top_lookup(id) && !st.getInitialized()) {
				System.out.println("WARNING: var " + id + " (nestlvl: " + st.getnesting() + ") might not be initialised");
			}
			stentry = st ;
		}

		return errors;
	}
  
	public Type typeCheck () {
		if (stentry != null && stentry.gettype() instanceof ArrowType) {
			System.out.println("Wrong usage of function identifier");
			return new ErrorType() ;
		}
		if (stentry == null)
			return new ErrorType() ;
		return stentry.gettype() ;
	}
  
	public String codeGeneration() {
		String getAR = "";
		for (int i = 0; i < nesting - stentry.getnesting(); i++)
	    	 getAR += "store T1 0(T1) \n";
	    return 
		       "move AL T1 \n"
		       + getAR  //risalgo la catena statica
		       + "subi T1 " + stentry.getoffset() +"\n" //metto offset sullo stack
			   + "store A0 0(T1) \n" ; //carico sullo stack il valore all'indirizzo ottenuto
	}

	public String toPrint(String s) {
		return s+"Id:" + id + " at nestlev " + stentry.getnesting() +"\n" ;
	}
  
}  