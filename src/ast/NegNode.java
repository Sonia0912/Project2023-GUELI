package ast;

import java.util.ArrayList;

import semanticanalysis.STentry;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class NegNode implements Node {
    private Node exp ;
    private int nesting ;

    public NegNode (Node _id) {
        exp = _id ;
    }

    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        return  null;
    }

    public Type typeCheck () {
       return null;
    }

    public String codeGeneration() {
        return null;
    }

    public String toPrint(String s){
            return null;
        }
}