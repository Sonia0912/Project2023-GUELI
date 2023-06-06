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
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
        errors.addAll(exp.checkSemantics(ST,_nesting));
        return errors;
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
        String label = SimpLanlib.freshLabel();
        String exit = SimpLanlib.freshLabel();
        return    exp.codeGeneration()
                + "storei T1 0 \n"
                + "beq A0 T1 " + label + "\n"
                + "storei A0 0 \n"
                + "b " + exit + "\n"
                + label + ":\n"
                + "storei A0 1 \n"
                + exit + ":\n"
                ;
    }

    public String toPrint(String s){
        return s+"Negation (!) of \n" + exp.toPrint(s+"  ") ;
    }
}