package ast;

import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

import java.util.ArrayList;

public class AsgNode implements Node{

    private String id;
    private Node exp;
    private int nesting;

    public AsgNode(String _id, Node _exp) {
        id = _id ;
        exp = _exp ;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {

        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
        nesting = _nesting ;

        errors.addAll(exp.checkSemantics(ST, _nesting));

        // Controlliamo che la variabile esista
        if (ST.lookup(id) == null)
            errors.add(new SemanticError("Var id " + id + " never declared"));
        else
            // Controlliamo che il tipo sia corretto
            if (!ST.lookup(id).gettype().equals(exp.typeCheck()))
                errors.add(new SemanticError("Var id " + id + " type doesn't correspond to exp type"));

        return errors ;

    }

    @Override
    public Type typeCheck() {
        return null;
    }

    @Override
    public String codeGeneration() {
        return null;
    }

    @Override
    public String toPrint(String s) {
        return null;
    }
}