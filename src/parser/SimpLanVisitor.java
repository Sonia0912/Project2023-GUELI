// Generated from /Users/gian/ANTLR/SimpLan-master/src/parser/SimpLan.g4 by ANTLR 4.12.0
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpLanParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpLanVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code singExp}
	 * labeled alternative in {@link SimpLanParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingExp(SimpLanParser.SingExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code progDecStm}
	 * labeled alternative in {@link SimpLanParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgDecStm(SimpLanParser.ProgDecStmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idDec}
	 * labeled alternative in {@link SimpLanParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdDec(SimpLanParser.IdDecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funDec}
	 * labeled alternative in {@link SimpLanParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDec(SimpLanParser.FunDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(SimpLanParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bodyFun}
	 * labeled alternative in {@link SimpLanParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyFun(SimpLanParser.BodyFunContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(SimpLanParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asg}
	 * labeled alternative in {@link SimpLanParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsg(SimpLanParser.AsgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code invFun}
	 * labeled alternative in {@link SimpLanParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvFun(SimpLanParser.InvFunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStm}
	 * labeled alternative in {@link SimpLanParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStm(SimpLanParser.IfStmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intVal}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntVal(SimpLanParser.IntValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExp(SimpLanParser.AndExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusExp(SimpLanParser.PlusExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExp(SimpLanParser.OrExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolVal}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolVal(SimpLanParser.BoolValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pareExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPareExp(SimpLanParser.PareExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunExp(SimpLanParser.FunExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code divExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivExp(SimpLanParser.DivExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExp(SimpLanParser.VarExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExp(SimpLanParser.EqExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondExp(SimpLanParser.CondExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExp(SimpLanParser.IfExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegExp(SimpLanParser.NegExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code molExp}
	 * labeled alternative in {@link SimpLanParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMolExp(SimpLanParser.MolExpContext ctx);
}