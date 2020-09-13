package wodel.fa2re.parser;
// Generated from SE.g4 by ANTLR 4.4
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SELexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		OPENC=10, CLOSEC=11, COLON=12, SEMICOLON=13, COMMA=14, NUM=15, FILENAME=16, 
		WS=17;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'"
	};
	public static final String[] ruleNames = {
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"OPENC", "CLOSEC", "COLON", "SEMICOLON", "COMMA", "NUM", "FILENAME", "WS"
	};


	public SELexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SE.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\23\u0091\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\6\20}\n\20\r\20\16\20~\3\21\6\21\u0082\n\21\r\21\16\21\u0083"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\6\22\u008c\n\22\r\22\16\22\u008d\3\22\3"+
		"\22\2\2\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23\3\2\5\3\2\62;\4\2\62;c|\5\2\13\f\17\17\"\"\u0093"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\3%\3\2\2\2\5-\3\2\2\2\7\66\3\2\2\2\t?\3\2\2\2\13I\3\2\2\2\rZ\3\2"+
		"\2\2\17a\3\2\2\2\21g\3\2\2\2\23l\3\2\2\2\25q\3\2\2\2\27s\3\2\2\2\31u\3"+
		"\2\2\2\33w\3\2\2\2\35y\3\2\2\2\37|\3\2\2\2!\u0081\3\2\2\2#\u008b\3\2\2"+
		"\2%&\7f\2\2&\'\7g\2\2\'(\7h\2\2()\7c\2\2)*\7w\2\2*+\7n\2\2+,\7v\2\2,\4"+
		"\3\2\2\2-.\7H\2\2./\7k\2\2/\60\7n\2\2\60\61\7g\2\2\61\62\7P\2\2\62\63"+
		"\7c\2\2\63\64\7o\2\2\64\65\7g\2\2\65\6\3\2\2\2\66\67\7Q\2\2\678\7t\2\2"+
		"89\7f\2\29:\7g\2\2:;\7t\2\2;<\7k\2\2<=\7p\2\2=>\7i\2\2>\b\3\2\2\2?@\7"+
		"c\2\2@A\7w\2\2AB\7v\2\2BC\7q\2\2CD\7o\2\2DE\7c\2\2EF\7v\2\2FG\7k\2\2G"+
		"H\7e\2\2H\n\3\2\2\2IJ\7U\2\2JK\7v\2\2KL\7c\2\2LM\7v\2\2MN\7g\2\2NO\7G"+
		"\2\2OP\7n\2\2PQ\7k\2\2QR\7o\2\2RS\7k\2\2ST\7p\2\2TU\7c\2\2UV\7v\2\2VW"+
		"\7k\2\2WX\7q\2\2XY\7p\2\2Y\f\3\2\2\2Z[\7o\2\2[\\\7c\2\2\\]\7p\2\2]^\7"+
		"w\2\2^_\7c\2\2_`\7n\2\2`\16\3\2\2\2ab\7u\2\2bc\7v\2\2cd\7g\2\2de\7r\2"+
		"\2ef\7u\2\2f\20\3\2\2\2gh\7V\2\2hi\7{\2\2ij\7r\2\2jk\7g\2\2k\22\3\2\2"+
		"\2lm\7O\2\2mn\7q\2\2no\7f\2\2op\7g\2\2p\24\3\2\2\2qr\7}\2\2r\26\3\2\2"+
		"\2st\7\177\2\2t\30\3\2\2\2uv\7<\2\2v\32\3\2\2\2wx\7=\2\2x\34\3\2\2\2y"+
		"z\7.\2\2z\36\3\2\2\2{}\t\2\2\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2"+
		"\2\2\177 \3\2\2\2\u0080\u0082\t\3\2\2\u0081\u0080\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0086\7\60\2\2\u0086\u0087\7f\2\2\u0087\u0088\7q\2\2\u0088\u0089\7v\2"+
		"\2\u0089\"\3\2\2\2\u008a\u008c\t\4\2\2\u008b\u008a\3\2\2\2\u008c\u008d"+
		"\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\u0090\b\22\2\2\u0090$\3\2\2\2\6\2~\u0083\u008d\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}