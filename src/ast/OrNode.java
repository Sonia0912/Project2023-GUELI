package ast;

import java.util.ArrayList;

import evaluator.SimpLanlib;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class OrNode implements Node {
    private Node left;
    private Node right;

    public OrNode (Node _left, Node _right) {
        left = _left ;
        right = _right ;
    }

    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();

        errors.addAll(left.checkSemantics(ST, _nesting));
        errors.addAll(right.checkSemantics(ST, _nesting));

        return errors;
    }

    public Type typeCheck() {
        if ((left.typeCheck() instanceof BoolType) && (right.typeCheck() instanceof BoolType) )
            return new BoolType() ;
        else {
            System.out.println("Type Error: Non boolean in OR operation") ;
            return new ErrorType() ;
        }
    }


    public String codeGeneration() {
        String exit = SimpLanlib.freshLabel();
        return left.codeGeneration() +
                "storei T1 1\n" +
                "beq A0 T1 " + exit +"\n"+
                right.codeGeneration() +
                exit + ": \n";
    }

    public String toPrint(String s) {
        return s + left.toPrint(s+"  ") + " \t \t \t OR \n \t"+ right.toPrint(s+"  ") ;
    }

}