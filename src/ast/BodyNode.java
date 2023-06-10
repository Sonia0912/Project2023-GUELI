package ast;

import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

import java.util.ArrayList;

public class BodyNode implements Node{

    private ArrayList<Node> dec ;
    private ArrayList<Node> stm ;
    private Node exp ;
    private int nesting ;

    public BodyNode (ArrayList<Node> _dec, ArrayList<Node> _stm, Node _exp) {
        dec = _dec ;
        stm = _stm ;
        exp = _exp ;
    }

    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        nesting = _nesting;

        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();

        for (Node d : dec)
            errors.addAll(d.checkSemantics(ST, nesting)) ;

        for (Node s : stm)
            errors.addAll(s.checkSemantics(ST, nesting)) ;

        if(exp != null)
            errors.addAll(exp.checkSemantics(ST, nesting)) ;

        return errors;
    }

    public Type typeCheck () {
        for (Node s: stm){
            if(s.typeCheck() instanceof ErrorType)
                return new ErrorType();
        }
        if(exp != null)
            return exp.typeCheck();
        return new VoidType();
    }

    public String codeGeneration() {
        String declCode = "";
        String stmsCode = "";
        String expCode = "";
        for(Node d: dec) {
            declCode += d.codeGeneration();
        }
        for (Node s: stm) {
            stmsCode += s.codeGeneration();
        }
        if(exp != null)
            expCode = exp.codeGeneration();

        return    declCode
                + stmsCode
                + expCode
                + "addi SP " + dec.size() + "\n" ;
    }

    public String toPrint(String s) {
        String statementstr = "";
        String declstr = "";
        for (Node d : dec)
            declstr += d.toPrint(s+"\t");
        for (Node st : stm)
            statementstr += st.toPrint(s+"\t");
        if(exp != null)
            return s+"Body \n" + declstr + statementstr + "\n" + exp.toPrint(s+"\t") ;
        return s+"Body \n" + declstr + statementstr + "\n";
    }

}
