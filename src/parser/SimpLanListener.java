// Generated from java-escape by ANTLR 4.11.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpLanParser}.
 */
public interface SimpLanListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code singExp}
	 * labeled alternative in {@link SimpLanParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterSingExp(SimpLanParser.SingExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singExp}
	 * labeled alternative in {@link SimpLanParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitSingExp(SimpLanParser.SingExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code progDecStm}
	 * labeled alternative in {@link SimpLanParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProgDecStm(SimpLanParser.ProgDecStmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code progDecStm}
	 * labeled alternative in {@link SimpLanParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProgDecStm(SimpLanParser.ProgDecStmContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idDec}
	 * labeled alternative in {@link SimpLanParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterIdDec(SimpLanParser.IdDecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idDec}
	 * labeled alternative in {@link SimpLanParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitIdDec(SimpLanParser.IdDecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funDec}
	 * labeled alternative in {@link SimpLanParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterFunDec(SimpLanParser.FunDecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funDec}
	 * labeled alternative in {@link SimpLanParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitFunDec(SimpLanParser.FunDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpLanParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(SimpLanParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpLanParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(SimpLanParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bodyFun}
	 * labeled alternative in {@link SimpLanParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBodyFun(SimpLanParser.BodyFunContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bodyFun}
	 * labeled alternative in {@link SimpLanParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBodyFun(SimpLanParser.BodyFunContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpLanParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SimpLanParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpLanParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SimpLanParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code asg}
	 * labeled alternative in {@link SimpLanParser#stm}.
	 * @param ctx the parse tree
	 */
	void enterAsg(SimpLanParser.AsgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code asg}
	 * labeled alternative in {@link SimpLanParser#stm}.
	 * @param ctx the parse tree
	 */
	void exitAsg(SimpLanParser.AsgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code invFun}
	 * labeled alternative in {@link SimpLanParser#stm}.
	 * @param ctx the parse tree
	 */
	void enterInvFun(SimpLanParser.InvFunContext ctx);
	/**
	 * Exit a parse tree produced by the {@code invFun}
	 * labeled alternative in {@link SimpLanParser#stm}.
	 * @param ctx the parse tree
	 */
	void exitInvFun(SimpLanParser.InvFunContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStm}
	 * labeled alternative in {@link SimpLanParser#stm}.
	 * @param ctx the parse tree
	 */
	void enterIfStm(SimpLanParser.IfStmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStm}
	 * labeled alternative in {@link SimpLanParser#stm}.
	 * @param ctx the parse tree
	 */
	void exitIfStm(SimpLanParser.IfStmContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intVal}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIntVal(SimpLanParser.IntValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intVal}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIntVal(SimpLanParser.IntValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code minusExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterMinusExp(SimpLanParser.MinusExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code minusExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitMinusExp(SimpLanParser.MinusExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterAndExp(SimpLanParser.AndExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitAndExp(SimpLanParser.AndExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterPlusExp(SimpLanParser.PlusExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitPlusExp(SimpLanParser.PlusExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterOrExp(SimpLanParser.OrExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitOrExp(SimpLanParser.OrExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolVal}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBoolVal(SimpLanParser.BoolValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolVal}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBoolVal(SimpLanParser.BoolValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pareExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterPareExp(SimpLanParser.PareExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pareExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitPareExp(SimpLanParser.PareExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterFunExp(SimpLanParser.FunExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitFunExp(SimpLanParser.FunExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterDivExp(SimpLanParser.DivExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitDivExp(SimpLanParser.DivExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterVarExp(SimpLanParser.VarExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitVarExp(SimpLanParser.VarExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterEqExp(SimpLanParser.EqExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitEqExp(SimpLanParser.EqExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterCondExp(SimpLanParser.CondExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitCondExp(SimpLanParser.CondExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIfExp(SimpLanParser.IfExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIfExp(SimpLanParser.IfExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterNegExp(SimpLanParser.NegExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitNegExp(SimpLanParser.NegExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code molExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterMolExp(SimpLanParser.MolExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code molExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitMolExp(SimpLanParser.MolExpContext ctx);
}