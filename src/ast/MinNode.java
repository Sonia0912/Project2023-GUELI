package ast;

import java.util.ArrayList;

import evaluator.SimpLanlib;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class MinNode implements Node {
    private Node left;
    private Node right;

    public MinNode (Node _left, Node _right) {
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
        if ((left.typeCheck() instanceof IntType) && (right.typeCheck() instanceof IntType) )
            return new BoolType() ;
        else {
            System.out.println("Type Error: Non integers in less than operation") ;
            return new ErrorType() ;
        }
    }


    public String codeGeneration() {
        String label = SimpLanlib.freshLabel();
        String exit = SimpLanlib.freshLabel();
        return left.codeGeneration() +
                "pushr A0 \n" +
                right.codeGeneration() +
                "popr T1 \n" +
                "bl A0 T1 " + label+ "\n"+
                "storei A0 1 \n" +
                "b " + exit +"\n"+
                label+": storei A0 0 \n"+
                exit + ": \n";
    }

    public String toPrint(String s) {
        return s+"<\n" + left.toPrint(s+"  ") + right.toPrint(s+"  ") ;
    }

}