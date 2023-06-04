package ast;

import java.util.ArrayList;

import evaluator.SimpLanlib;
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
        return  exp.checkSemantics(ST,_nesting);
    }

    public Type typeCheck () {
        if ((exp.typeCheck() instanceof BoolType)  )
            return new BoolType() ;
        else {
            System.out.println("Type Error: Non boolean expression in negation(!)") ;
            return new ErrorType() ;
        }
    }

    public String codeGeneration() {
        return exp.codeGeneration() ;
    }

    public String toPrint(String s){
        return s+"Negation (!) of \n" + exp.toPrint(s+"  ") ;
    }
}