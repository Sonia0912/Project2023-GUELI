package ast;

import java.util.ArrayList;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class DecNode implements Node {
	private String id;
	private Node type;
	private int nesting;
	
	public DecNode(String _id, Node _type) {
		id = _id ;
		type = _type ;
	}
  
	public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
   		ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
  		nesting = _nesting ;
        
        if (ST.top_lookup(id))
        	errors.add(new SemanticError("Var id " + id + " already declared"));
        else ST.insert(id, (Type) type, nesting,"") ;
 
        return errors ;
	}

	@Override
	public Type typeCheck() {
		return (Type) type;
	}

	@Override
	public String codeGeneration() {
		return "pushr A0 \n";
	}

	public String toPrint(String s) {
		return s + "Dec:" + id + type.toPrint(" ") + "\n";
	}

}  