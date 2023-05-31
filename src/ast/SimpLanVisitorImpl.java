package ast;

import java.util.ArrayList;

import parser.*;
import parser.SimpLanParser.BodyContext;
import parser.SimpLanParser.DecContext;
import parser.SimpLanParser.ExpContext;
import parser.SimpLanParser.ParamContext;
import parser.SimpLanParser.ProgContext;
import parser.SimpLanParser.StmContext;
import parser.SimpLanParser.TypeContext;

public class SimpLanVisitorImpl extends SimpLanBaseVisitor<Node> {

	@Override
	public Node visitSingExp(SimpLanParser.SingExpContext ctx) {
		return new ProgNode(visit(ctx.exp()));
	}

	@Override
	public Node visitProgDecStm(SimpLanParser.ProgDecStmContext ctx) {

		ArrayList<Node> declarations = new ArrayList<Node>();
		ArrayList<Node> statements = new ArrayList<Node>();

		for(DecContext dc : ctx.dec()) {
			declarations.add(visit(dc));
		}

		for(StmContext st : ctx.stm()) {
			statements.add(visit(st));
		}

		Node exp = visit(ctx.exp());

		return new ProgDecStmNode(declarations, statements, exp);

	}

	@Override
	public Node visitIdDec(SimpLanParser.IdDecContext ctx) {
		return new DecNode(ctx.ID().getText(), visit(ctx.type()));
	}

	@Override
	public Node visitFunDec(SimpLanParser.FunDecContext ctx) {

		ArrayList<ParNode> _param = new ArrayList<ParNode>() ;

		for (ParamContext vc : ctx.param())
			_param.add( new ParNode(vc.ID().getText(), (Type) visit( vc.type() )) );

		//get the exp body
		Node body = visit(ctx.body());

		return new FunNode(ctx.ID().getText(), (Type) visit(ctx.type()), _param, body);
	}

	@Override
	public Node visitBodyFun(SimpLanParser.BodyFunContext ctx) {
		ArrayList<Node> declarations = new ArrayList<Node>();
		ArrayList<Node> statements = new ArrayList<Node>();

		for(DecContext dc : ctx.dec()) {
			declarations.add(visit(dc));
		}

		for(StmContext st : ctx.stm()) {
			statements.add(visit(st));
		}

		Node exp = visit(ctx.exp());

		return new BodyNode(declarations, statements, exp);
	}

	@Override
	public Node visitType(SimpLanParser.TypeContext ctx) {
		if(ctx.getText().equals("int")) {
			return new IntType();
		} else if(ctx.getText().equals("bool")) {
			return new BoolType();
		} else return new VoidType();
	}

	@Override
	public Node visitAsg(SimpLanParser.AsgContext ctx) {
		return null;
	}

	@Override
	public Node visitInvFun(SimpLanParser.InvFunContext ctx) {
		return null;
	}

	@Override
	public Node visitIfStm(SimpLanParser.IfStmContext ctx) {
		return null;
	}

	@Override
	public Node visitVarExp(SimpLanParser.VarExpContext ctx) {
		return null;
	}

	@Override
	public Node visitPlusEqExp(SimpLanParser.PlusEqExpContext ctx) {
		return null;
	}

	@Override
	public Node visitAndOrExp(SimpLanParser.AndOrExpContext ctx) {
		return null;
	}

	@Override
	public Node visitIntVal(SimpLanParser.IntValContext ctx) {
		return null;
	}

	@Override
	public Node visitCondExp(SimpLanParser.CondExpContext ctx) {
		return null;
	}

	@Override
	public Node visitIfExp(SimpLanParser.IfExpContext ctx) {
		return null;
	}

	@Override
	public Node visitMolDivExp(SimpLanParser.MolDivExpContext ctx) {
		return null;
	}

	@Override
	public Node visitNegExp(SimpLanParser.NegExpContext ctx) {
		return null;
	}

	@Override
	public Node visitBoolVal(SimpLanParser.BoolValContext ctx) {
		return null;
	}

	@Override
	public Node visitPareExp(SimpLanParser.PareExpContext ctx) {
		return null;
	}

	@Override
	public Node visitFunExp(SimpLanParser.FunExpContext ctx) {
		return null;
	}
}