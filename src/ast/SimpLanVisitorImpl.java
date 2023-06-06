package ast;

import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ParseTree;
import parser.*;
import parser.SimpLanParser.DecContext;
import parser.SimpLanParser.ExpContext;
import parser.SimpLanParser.ParamContext;
import parser.SimpLanParser.StmContext;

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

		ArrayList<Node> thenStms = new ArrayList<Node>();
		ArrayList<Node> elseStms = new ArrayList<Node>();

		boolean elseBranch = false;
		for(ParseTree i : ctx.children) {
			if(i.getText().equals("else"))
				elseBranch = true;
			if(i.getClass().equals(parser.SimpLanParser.AsgContext.class) ||
					i.getClass().equals(SimpLanParser.IfStmContext.class) ||
					i.getClass().equals(SimpLanParser.InvFunContext.class)) {
				if(!elseBranch)
					thenStms.add(visit(i));
				else
					elseStms.add(visit(i));
			}
		}
		return new IfStmNode(condExp, thenStms, elseStms);
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

		ArrayList<Node> thenStms = new ArrayList<Node>();
		ArrayList<Node> elseStms = new ArrayList<Node>();
		Node thenExp = null;
		Node elseExp = null;

		boolean elseBranch = false;
		for(ParseTree i : ctx.children) {
			if(i.getText().equals("else"))
				elseBranch = true;
			if(i.getClass().equals(parser.SimpLanParser.AsgContext.class) ||
					i.getClass().equals(SimpLanParser.IfStmContext.class) ||
					i.getClass().equals(SimpLanParser.InvFunContext.class)) {
				if(!elseBranch)
					thenStms.add(visit(i));
				else
					elseStms.add(visit(i));
				}else if(i.getClass().equals(SimpLanParser.ExpContext.class) ||
					i.getClass().equals(SimpLanParser.PlusExpContext.class) ||
					i.getClass().equals(SimpLanParser.MinusExpContext.class) ||
					i.getClass().equals(SimpLanParser.EqExpContext.class) ||
					i.getClass().equals(SimpLanParser.NegExpContext.class) ||
					i.getClass().equals(SimpLanParser.CondExpContext.class) ||
					i.getClass().equals(SimpLanParser.AndExpContext.class) ||
					i.getClass().equals(SimpLanParser.OrExpContext.class) ||
					i.getClass().equals(SimpLanParser.MolExpContext.class) ||
					i.getClass().equals(SimpLanParser.IfExpContext.class) ||
					i.getClass().equals(SimpLanParser.DivExpContext.class) ||
					i.getClass().equals(SimpLanParser.PareExpContext.class) ||
					i.getClass().equals(SimpLanParser.SingExpContext.class) ||
					i.getClass().equals(SimpLanParser.VarExpContext.class) ||
					i.getClass().equals(SimpLanParser.IntValContext.class) ||
					i.getClass().equals(SimpLanParser.BoolValContext.class) ||
					i.getClass().equals(SimpLanParser.FunExpContext.class)
				){
					if(!elseBranch)
						thenExp = (visit(i));
					else
						elseExp = (visit(i));
				}

			}

		return  new IfExpNode(condExp,thenStms,thenExp,elseStms,elseExp);

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
		Node res;
		ArrayList<Node> args = new ArrayList<Node>();
		for (ExpContext exp : ctx.exp())
			args.add(visit(exp));
		if(ctx.ID().getText().equals("print"))
			res = new PrintNode(args.get(0));
		else
			res = new CallNode(ctx.ID().getText(), args);

		return res;
	}
}