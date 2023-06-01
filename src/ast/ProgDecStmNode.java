package ast;

import evaluator.SimpLanlib;
import semanticanalysis.STentry;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;
import semanticanalysis.VoidType;

import java.util.ArrayList;
import java.util.HashMap;

public class ProgDecStmNode implements Node {

    private ArrayList<Node> dec ;
    private ArrayList<Node> stm ;
    private Node exp ;
    private int nesting ;

    public ProgDecStmNode (ArrayList<Node> _dec, ArrayList<Node> _stm, Node _exp) {
        dec = _dec ;
        stm = _stm ;
        exp = _exp ;
    }

    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        nesting = _nesting + 1 ;
        HashMap<String, STentry> H = new HashMap<String, STentry>();
        ST.add(H);

        //declare resulting list
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();

        for (Node d : dec) {
            errors.addAll(d.checkSemantics(ST, nesting)) ;
        }

        for (Node s : stm) {
            errors.addAll(s.checkSemantics(ST, nesting)) ;
        }

        if(exp != null)//check semantics in the exp body
            errors.addAll(exp.checkSemantics(ST, nesting));

        //System.out.println("-- TableSymbol of ProDecStm --");
        //ST.printST();
        //clean the scope, we are leaving a let scope
        ST.remove();

        //return the result
        return errors;
    }

    public Type typeCheck () {
        if(stm != null) {
            for (Node s: stm)
                s.typeCheck();
        }
        if(exp != null)
            return exp.typeCheck();
        return new VoidType();
    }

    // TODO
    public String codeGeneration() {
        String declCode="";
        for (Node d: dec)
            declCode += d.codeGeneration();
        return  "move SP FP  \n"
                + "pushr FP \n"
                + "move SP AL \n"
                + "pushr AL \n"
                + declCode
                + exp.codeGeneration()
                + "halt\n" +
                SimpLanlib.getCode();
    }

    public String toPrint(String s) {
        String statementstr = "";
        String declstr = "";
        for (Node d : dec)
            declstr += d.toPrint(s+"\t");
        for (Node st : stm)
            statementstr += st.toPrint(s+"\t");
        if (exp != null)
            return s+"ProgDecStm \n" + declstr + statementstr + "\n" + exp.toPrint(s+"\t") ;

        return s+"ProgDecStm \n" + declstr + statementstr + "\n";
    }

}
