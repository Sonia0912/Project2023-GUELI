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

		for(SimpLanParser.DecContext dc : ctx.dec()) {
			declarations.add(visit(dc));
		}

		if(ctx.stm() != null) {
			for(SimpLanParser.StmContext st : ctx.stm()) {
				statements.add(visit(st));
			}
		}

		if(ctx.exp() != null){
			Node exp = visit(ctx.exp());
			return new ProgDecStmNode(declarations, statements, exp);
		}

		return new ProgDecStmNode(declarations, statements, null);
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

		if(!ctx.body().getText().equals("")) {
			Node body = visit(ctx.body());
			return new FunNode(ctx.ID().getText(), (Type) visit(ctx.type()), _param, body);
		}

		return new FunNode(ctx.ID().getText(), (Type) visit(ctx.type()), _param, null);
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

		if(ctx.exp() != null){
			Node exp = visit(ctx.exp());
			return new BodyNode(declarations, statements, exp);
		}

		return new BodyNode(declarations, statements, null);
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
		return new AsgNode(ctx.ID().getText(), visit(ctx.exp()) );
	}

	@Override
	public Node visitInvFun(SimpLanParser.InvFunContext ctx) {
		ArrayList<Node> _param = new ArrayList<Node>() ;

		for (ExpContext vc : ctx.exp()){
			_param.add(visit(vc));
		}

		return new CallNode(ctx.ID().getText(),_param);
	}

	@Override
	public Node visitIfStm(SimpLanParser.IfStmContext ctx) {
		Node condExp = visit (ctx.cond);

		if(ctx.thenBranch != null && ctx.elseBranch != null) {
			Node thenStm = visit (ctx.thenBranch);
			Node elseStm = visit (ctx.elseBranch);
			return new IfNode(condExp, thenStm, elseStm);
		} else if(ctx.thenBranch != null && ctx.elseBranch == null ) {
			Node thenStm = visit (ctx.thenBranch);
			return new IfNode(condExp, thenStm, null);
		} else if(ctx.thenBranch == null && ctx.elseBranch != null ) {
			Node elseStm = visit (ctx.elseBranch);
			return new IfNode(condExp, null, elseStm);
		} else
			return new IfNode(condExp, null, null);
	}

	@Override
	public Node visitVarExp(SimpLanParser.VarExpContext ctx) {
		return new IdNode(ctx.ID().getText());
	}

	@Override
	public Node visitEqExp(SimpLanParser.EqExpContext ctx) {
		return new EqualNode(visit(ctx.left),visit(ctx.right));
	}

	@Override
	public Node visitPlusExp(SimpLanParser.PlusExpContext ctx) {
		return new PlusNode(visit(ctx.left),visit(ctx.right));
	}

	@Override
	public Node visitMinusExp(SimpLanParser.MinusExpContext ctx) {
		return new MinusNode(visit(ctx.left),visit(ctx.right));
	}

	@Override
	public Node visitAndExp(SimpLanParser.AndExpContext ctx) {
		return new AndNode(visit(ctx.left),visit(ctx.right));
	}

	@Override
	public Node visitOrExp(SimpLanParser.OrExpContext ctx) {
		return new OrNode(visit(ctx.left),visit(ctx.right));
	}

	@Override
	public Node visitIntVal(SimpLanParser.IntValContext ctx) {
		return new IntNode(Integer.parseInt(ctx.INTEGER().getText()));
	}

	@Override
	public Node visitCondExp(SimpLanParser.CondExpContext ctx) {
		if(ctx.magg != null)
			return new MaggNode(visit(ctx.left),visit(ctx.right));
		else if(ctx.min != null)
			return new MinNode(visit(ctx.left),visit(ctx.right));
		else if (ctx.maggeq != null)
			return new MaggEqNode(visit(ctx.left),visit(ctx.right));
		else if (ctx.mineq != null)
			return new MinEqNode(visit(ctx.left),visit(ctx.right));
		else return new EqualNode(visit(ctx.left),visit(ctx.right));
	}

	@Override
	public Node visitIfExp(SimpLanParser.IfExpContext ctx) {
		Node condExp = visit (ctx.cond);
		Node thenExp = visit (ctx.thenBranch);
		Node elseExp = visit (ctx.elseBranch);

		return new IfNode(condExp, thenExp, elseExp);
	}

	@Override
	public Node visitDivExp(SimpLanParser.DivExpContext ctx) {
		return new DivNode(visit(ctx.left),visit(ctx.right));
	}

	@Override
	public Node visitMolExp(SimpLanParser.MolExpContext ctx) {
		return new MultNode(visit(ctx.left),visit(ctx.right));
	}

	@Override
	public Node visitNegExp(SimpLanParser.NegExpContext ctx) {
		return new NegNode(visit(ctx.exp()));
	}

	@Override
	public Node visitBoolVal(SimpLanParser.BoolValContext ctx) {
		return new BoolNode(Boolean.parseBoolean(ctx.getText()));
	}

	@Override
	public Node visitPareExp(SimpLanParser.PareExpContext ctx) {
		return visit (ctx.exp());
	}

	@Override
	public Node visitFunExp(SimpLanParser.FunExpContext ctx) {
		//this corresponds to a function invocation
		//declare the result
		Node res;
		//get the invocation arguments
		ArrayList<Node> args = new ArrayList<Node>();
		for (ExpContext exp : ctx.exp())
			args.add(visit(exp));
		// this is ad-hoc for this project...
		if(ctx.ID().getText().equals("print"))
			res = new PrintNode(args.get(0));
		else
			//instantiate the invocation
			res = new CallNode(ctx.ID().getText(), args);

		return res;
	}
}