// Generated from java-escape by ANTLR 4.11.1
package parser;

import java.util.HashMap;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SVMLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, LOAD=4, STORE=5, STOREI=6, MOVE=7, ADD=8, ADDI=9, 
		SUB=10, SUBI=11, MUL=12, MULI=13, DIV=14, DIVI=15, PUSH=16, PUSHR=17, 
		POP=18, POPR=19, BRANCH=20, BRANCHEQ=21, BRANCHLESSEQ=22, JUMPSUB=23, 
		RETURNSUB=24, HALT=25, REG=26, LABEL=27, NUMBER=28, WHITESP=29, LINECOMENTS=30, 
		ERR=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "LOAD", "STORE", "STOREI", "MOVE", "ADD", "ADDI", 
			"SUB", "SUBI", "MUL", "MULI", "DIV", "DIVI", "PUSH", "PUSHR", "POP", 
			"POPR", "BRANCH", "BRANCHEQ", "BRANCHLESSEQ", "JUMPSUB", "RETURNSUB", 
			"HALT", "REG", "LABEL", "NUMBER", "WHITESP", "LINECOMENTS", "ERR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "':'", "'load'", "'store'", "'storei'", "'move'", 
			"'add'", "'addi'", "'sub'", "'subi'", "'mul'", "'muli'", "'div'", "'divi'", 
			"'push'", "'pushr'", "'pop'", "'popr'", "'b'", "'beq'", "'bleq'", "'jsub'", 
			"'rsub'", "'halt'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "LOAD", "STORE", "STOREI", "MOVE", "ADD", "ADDI", 
			"SUB", "SUBI", "MUL", "MULI", "DIV", "DIVI", "PUSH", "PUSHR", "POP", 
			"POPR", "BRANCH", "BRANCHEQ", "BRANCHLESSEQ", "JUMPSUB", "RETURNSUB", 
			"HALT", "REG", "LABEL", "NUMBER", "WHITESP", "LINECOMENTS", "ERR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public int lexicalErrors=0;


	public SVMLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SVM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 30:
			ERR_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void ERR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 System.err.println("Invalid char: "+ getText()); lexicalErrors++;  
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u0000\u001f\u00e9\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0002\u001e\u0007\u001e\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019"+
		"\u00bd\b\u0019\u0001\u001a\u0001\u001a\u0005\u001a\u00c1\b\u001a\n\u001a"+
		"\f\u001a\u00c4\t\u001a\u0001\u001b\u0001\u001b\u0003\u001b\u00c8\b\u001b"+
		"\u0001\u001b\u0001\u001b\u0005\u001b\u00cc\b\u001b\n\u001b\f\u001b\u00cf"+
		"\t\u001b\u0003\u001b\u00d1\b\u001b\u0001\u001c\u0004\u001c\u00d4\b\u001c"+
		"\u000b\u001c\f\u001c\u00d5\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0005\u001d\u00de\b\u001d\n\u001d\f\u001d\u00e1"+
		"\t\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0000\u0000\u001f\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012"+
		"%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c"+
		"9\u001d;\u001e=\u001f\u0001\u0000\u0004\u0002\u0000AZaz\u0003\u000009"+
		"AZaz\u0003\u0000\t\n\r\r  \u0002\u0000\n\n\r\r\u00f4\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'"+
		"\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000"+
		"\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000"+
		"\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005"+
		"\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000"+
		"\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000"+
		"\u0001?\u0001\u0000\u0000\u0000\u0003A\u0001\u0000\u0000\u0000\u0005C"+
		"\u0001\u0000\u0000\u0000\u0007E\u0001\u0000\u0000\u0000\tJ\u0001\u0000"+
		"\u0000\u0000\u000bP\u0001\u0000\u0000\u0000\rW\u0001\u0000\u0000\u0000"+
		"\u000f\\\u0001\u0000\u0000\u0000\u0011`\u0001\u0000\u0000\u0000\u0013"+
		"e\u0001\u0000\u0000\u0000\u0015i\u0001\u0000\u0000\u0000\u0017n\u0001"+
		"\u0000\u0000\u0000\u0019r\u0001\u0000\u0000\u0000\u001bw\u0001\u0000\u0000"+
		"\u0000\u001d{\u0001\u0000\u0000\u0000\u001f\u0080\u0001\u0000\u0000\u0000"+
		"!\u0085\u0001\u0000\u0000\u0000#\u008b\u0001\u0000\u0000\u0000%\u008f"+
		"\u0001\u0000\u0000\u0000\'\u0094\u0001\u0000\u0000\u0000)\u0096\u0001"+
		"\u0000\u0000\u0000+\u009a\u0001\u0000\u0000\u0000-\u009f\u0001\u0000\u0000"+
		"\u0000/\u00a4\u0001\u0000\u0000\u00001\u00a9\u0001\u0000\u0000\u00003"+
		"\u00bc\u0001\u0000\u0000\u00005\u00be\u0001\u0000\u0000\u00007\u00d0\u0001"+
		"\u0000\u0000\u00009\u00d3\u0001\u0000\u0000\u0000;\u00d9\u0001\u0000\u0000"+
		"\u0000=\u00e4\u0001\u0000\u0000\u0000?@\u0005(\u0000\u0000@\u0002\u0001"+
		"\u0000\u0000\u0000AB\u0005)\u0000\u0000B\u0004\u0001\u0000\u0000\u0000"+
		"CD\u0005:\u0000\u0000D\u0006\u0001\u0000\u0000\u0000EF\u0005l\u0000\u0000"+
		"FG\u0005o\u0000\u0000GH\u0005a\u0000\u0000HI\u0005d\u0000\u0000I\b\u0001"+
		"\u0000\u0000\u0000JK\u0005s\u0000\u0000KL\u0005t\u0000\u0000LM\u0005o"+
		"\u0000\u0000MN\u0005r\u0000\u0000NO\u0005e\u0000\u0000O\n\u0001\u0000"+
		"\u0000\u0000PQ\u0005s\u0000\u0000QR\u0005t\u0000\u0000RS\u0005o\u0000"+
		"\u0000ST\u0005r\u0000\u0000TU\u0005e\u0000\u0000UV\u0005i\u0000\u0000"+
		"V\f\u0001\u0000\u0000\u0000WX\u0005m\u0000\u0000XY\u0005o\u0000\u0000"+
		"YZ\u0005v\u0000\u0000Z[\u0005e\u0000\u0000[\u000e\u0001\u0000\u0000\u0000"+
		"\\]\u0005a\u0000\u0000]^\u0005d\u0000\u0000^_\u0005d\u0000\u0000_\u0010"+
		"\u0001\u0000\u0000\u0000`a\u0005a\u0000\u0000ab\u0005d\u0000\u0000bc\u0005"+
		"d\u0000\u0000cd\u0005i\u0000\u0000d\u0012\u0001\u0000\u0000\u0000ef\u0005"+
		"s\u0000\u0000fg\u0005u\u0000\u0000gh\u0005b\u0000\u0000h\u0014\u0001\u0000"+
		"\u0000\u0000ij\u0005s\u0000\u0000jk\u0005u\u0000\u0000kl\u0005b\u0000"+
		"\u0000lm\u0005i\u0000\u0000m\u0016\u0001\u0000\u0000\u0000no\u0005m\u0000"+
		"\u0000op\u0005u\u0000\u0000pq\u0005l\u0000\u0000q\u0018\u0001\u0000\u0000"+
		"\u0000rs\u0005m\u0000\u0000st\u0005u\u0000\u0000tu\u0005l\u0000\u0000"+
		"uv\u0005i\u0000\u0000v\u001a\u0001\u0000\u0000\u0000wx\u0005d\u0000\u0000"+
		"xy\u0005i\u0000\u0000yz\u0005v\u0000\u0000z\u001c\u0001\u0000\u0000\u0000"+
		"{|\u0005d\u0000\u0000|}\u0005i\u0000\u0000}~\u0005v\u0000\u0000~\u007f"+
		"\u0005i\u0000\u0000\u007f\u001e\u0001\u0000\u0000\u0000\u0080\u0081\u0005"+
		"p\u0000\u0000\u0081\u0082\u0005u\u0000\u0000\u0082\u0083\u0005s\u0000"+
		"\u0000\u0083\u0084\u0005h\u0000\u0000\u0084 \u0001\u0000\u0000\u0000\u0085"+
		"\u0086\u0005p\u0000\u0000\u0086\u0087\u0005u\u0000\u0000\u0087\u0088\u0005"+
		"s\u0000\u0000\u0088\u0089\u0005h\u0000\u0000\u0089\u008a\u0005r\u0000"+
		"\u0000\u008a\"\u0001\u0000\u0000\u0000\u008b\u008c\u0005p\u0000\u0000"+
		"\u008c\u008d\u0005o\u0000\u0000\u008d\u008e\u0005p\u0000\u0000\u008e$"+
		"\u0001\u0000\u0000\u0000\u008f\u0090\u0005p\u0000\u0000\u0090\u0091\u0005"+
		"o\u0000\u0000\u0091\u0092\u0005p\u0000\u0000\u0092\u0093\u0005r\u0000"+
		"\u0000\u0093&\u0001\u0000\u0000\u0000\u0094\u0095\u0005b\u0000\u0000\u0095"+
		"(\u0001\u0000\u0000\u0000\u0096\u0097\u0005b\u0000\u0000\u0097\u0098\u0005"+
		"e\u0000\u0000\u0098\u0099\u0005q\u0000\u0000\u0099*\u0001\u0000\u0000"+
		"\u0000\u009a\u009b\u0005b\u0000\u0000\u009b\u009c\u0005l\u0000\u0000\u009c"+
		"\u009d\u0005e\u0000\u0000\u009d\u009e\u0005q\u0000\u0000\u009e,\u0001"+
		"\u0000\u0000\u0000\u009f\u00a0\u0005j\u0000\u0000\u00a0\u00a1\u0005s\u0000"+
		"\u0000\u00a1\u00a2\u0005u\u0000\u0000\u00a2\u00a3\u0005b\u0000\u0000\u00a3"+
		".\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005r\u0000\u0000\u00a5\u00a6\u0005"+
		"s\u0000\u0000\u00a6\u00a7\u0005u\u0000\u0000\u00a7\u00a8\u0005b\u0000"+
		"\u0000\u00a80\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005h\u0000\u0000\u00aa"+
		"\u00ab\u0005a\u0000\u0000\u00ab\u00ac\u0005l\u0000\u0000\u00ac\u00ad\u0005"+
		"t\u0000\u0000\u00ad2\u0001\u0000\u0000\u0000\u00ae\u00af\u0005A\u0000"+
		"\u0000\u00af\u00bd\u00050\u0000\u0000\u00b0\u00b1\u0005R\u0000\u0000\u00b1"+
		"\u00bd\u0005A\u0000\u0000\u00b2\u00b3\u0005F\u0000\u0000\u00b3\u00bd\u0005"+
		"P\u0000\u0000\u00b4\u00b5\u0005S\u0000\u0000\u00b5\u00bd\u0005P\u0000"+
		"\u0000\u00b6\u00b7\u0005A\u0000\u0000\u00b7\u00bd\u0005L\u0000\u0000\u00b8"+
		"\u00b9\u0005T\u0000\u0000\u00b9\u00bd\u00051\u0000\u0000\u00ba\u00bb\u0005"+
		"T\u0000\u0000\u00bb\u00bd\u00052\u0000\u0000\u00bc\u00ae\u0001\u0000\u0000"+
		"\u0000\u00bc\u00b0\u0001\u0000\u0000\u0000\u00bc\u00b2\u0001\u0000\u0000"+
		"\u0000\u00bc\u00b4\u0001\u0000\u0000\u0000\u00bc\u00b6\u0001\u0000\u0000"+
		"\u0000\u00bc\u00b8\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000"+
		"\u0000\u00bd4\u0001\u0000\u0000\u0000\u00be\u00c2\u0007\u0000\u0000\u0000"+
		"\u00bf\u00c1\u0007\u0001\u0000\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c4\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000"+
		"\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c36\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c5\u00d1\u00050\u0000\u0000\u00c6\u00c8"+
		"\u0005-\u0000\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00cd\u0002"+
		"19\u0000\u00ca\u00cc\u000209\u0000\u00cb\u00ca\u0001\u0000\u0000\u0000"+
		"\u00cc\u00cf\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000"+
		"\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000"+
		"\u00cf\u00cd\u0001\u0000\u0000\u0000\u00d0\u00c5\u0001\u0000\u0000\u0000"+
		"\u00d0\u00c7\u0001\u0000\u0000\u0000\u00d18\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d4\u0007\u0002\u0000\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d6\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7"+
		"\u00d8\u0006\u001c\u0000\u0000\u00d8:\u0001\u0000\u0000\u0000\u00d9\u00da"+
		"\u0005/\u0000\u0000\u00da\u00db\u0005/\u0000\u0000\u00db\u00df\u0001\u0000"+
		"\u0000\u0000\u00dc\u00de\b\u0003\u0000\u0000\u00dd\u00dc\u0001\u0000\u0000"+
		"\u0000\u00de\u00e1\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000"+
		"\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e2\u0001\u0000\u0000"+
		"\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e2\u00e3\u0006\u001d\u0001"+
		"\u0000\u00e3<\u0001\u0000\u0000\u0000\u00e4\u00e5\t\u0000\u0000\u0000"+
		"\u00e5\u00e6\u0006\u001e\u0002\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000"+
		"\u00e7\u00e8\u0006\u001e\u0000\u0000\u00e8>\u0001\u0000\u0000\u0000\b"+
		"\u0000\u00bc\u00c2\u00c7\u00cd\u00d0\u00d5\u00df\u0003\u0000\u0001\u0000"+
		"\u0006\u0000\u0000\u0001\u001e\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}