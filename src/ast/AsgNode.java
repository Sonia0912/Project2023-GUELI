package ast;

import semanticanalysis.STentry;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

import java.util.ArrayList;

public class AsgNode implements Node{
    /*
    X = exp;
    1. verifica che X sia sia stata dichiarata;
    2. controllo che il tipo che ritorna exp sia lo stesso di X
     */

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

        STentry var = ST.lookup(id);
        // Controlliamo che la variabile esista
        if (var == null)
            errors.add(new SemanticError("Var " + id + " never declared"));
        else
            // Controlliamo che il tipo sia corretto
            if (!var.gettype().getClass().equals(exp.typeCheck().getClass()))
                errors.add(new SemanticError("Var " + id + " type doesn't correspond to exp type"));
            else {
                var.setInitialized(true);
                //ST.update(id,var);
            }

        return errors ;

    }

    @Override
    public Type typeCheck() {
        return exp.typeCheck();
    }

    @Override
    public String codeGeneration() {
        return exp.codeGeneration() +
                "pushr A0 \n" ;
    }

    @Override
    public String toPrint(String s) {
        return s + "Asg: Var " + id + " = " + exp.toPrint(s)+"\t";
    }
}
