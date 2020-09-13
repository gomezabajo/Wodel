package wodel.fa2re.parser;
// Generated from SE.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SEParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		OPENC=10, CLOSEC=11, COLON=12, SEMICOLON=13, COMMA=14, NUM=15, FILENAME=16, 
		WS=17;
	public static final String[] tokenNames = {
		"<INVALID>", "'default'", "'FileName'", "'Ordering'", "'automatic'", "'StateElimination'", 
		"'manual'", "'steps'", "'Type'", "'Mode'", "'{'", "'}'", "':'", "';'", 
		"','", "NUM", "FILENAME", "WS"
	};
	public static final int
		RULE_start = 0, RULE_eMode = 1, RULE_type = 2, RULE_ordering = 3;
	public static final String[] ruleNames = {
		"start", "eMode", "type", "ordering"
	};

	@Override
	public String getGrammarFileName() { return "SE.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SEParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(SEParser.SEMICOLON, 0); }
		public TerminalNode FILENAME() { return getToken(SEParser.FILENAME, 0); }
		public TerminalNode COLON() { return getToken(SEParser.COLON, 0); }
		public TerminalNode OPENC() { return getToken(SEParser.OPENC, 0); }
		public EModeContext eMode() {
			return getRuleContext(EModeContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEListener ) ((SEListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEListener ) ((SEListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8); match(T__4);
			setState(9); match(OPENC);
			setState(10); match(T__7);
			setState(11); match(COLON);
			setState(12); match(FILENAME);
			setState(13); match(SEMICOLON);
			setState(14); eMode();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EModeContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(SEParser.SEMICOLON, 0); }
		public TerminalNode COLON() { return getToken(SEParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public EModeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eMode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEListener ) ((SEListener)listener).enterEMode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEListener ) ((SEListener)listener).exitEMode(this);
		}
	}

	public final EModeContext eMode() throws RecognitionException {
		EModeContext _localctx = new EModeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_eMode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16); match(T__0);
			setState(17); match(COLON);
			setState(18);
			_la = _input.LA(1);
			if ( !(_la==T__8 || _la==T__2) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(19); match(SEMICOLON);
			setState(20); type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode CLOSEC() { return getToken(SEParser.CLOSEC, 0); }
		public TerminalNode SEMICOLON() { return getToken(SEParser.SEMICOLON, 0); }
		public TerminalNode COLON() { return getToken(SEParser.COLON, 0); }
		public OrderingContext ordering() {
			return getRuleContext(OrderingContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEListener ) ((SEListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEListener ) ((SEListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22); match(T__1);
			setState(23); match(COLON);
			setState(30);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(24); match(T__3);
				setState(25); match(SEMICOLON);
				setState(26); ordering();
				}
				break;
			case T__5:
				{
				setState(27); match(T__5);
				setState(28); match(SEMICOLON);
				setState(29); match(CLOSEC);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderingContext extends ParserRuleContext {
		public TerminalNode CLOSEC() { return getToken(SEParser.CLOSEC, 0); }
		public TerminalNode SEMICOLON() { return getToken(SEParser.SEMICOLON, 0); }
		public List<TerminalNode> NUM() { return getTokens(SEParser.NUM); }
		public List<TerminalNode> COMMA() { return getTokens(SEParser.COMMA); }
		public TerminalNode COLON() { return getToken(SEParser.COLON, 0); }
		public TerminalNode NUM(int i) {
			return getToken(SEParser.NUM, i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SEParser.COMMA, i);
		}
		public OrderingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordering; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEListener ) ((SEListener)listener).enterOrdering(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEListener ) ((SEListener)listener).exitOrdering(this);
		}
	}

	public final OrderingContext ordering() throws RecognitionException {
		OrderingContext _localctx = new OrderingContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ordering);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32); match(T__6);
			setState(33); match(COLON);
			{
			setState(34); match(NUM);
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(35); match(COMMA);
				setState(36); match(NUM);
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42); match(SEMICOLON);
			setState(43); match(CLOSEC);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\23\60\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4!\n\4\3\5\3\5\3\5\3\5\3\5\7"+
		"\5(\n\5\f\5\16\5+\13\5\3\5\3\5\3\5\3\5\2\2\6\2\4\6\b\2\3\4\2\3\3\t\t-"+
		"\2\n\3\2\2\2\4\22\3\2\2\2\6\30\3\2\2\2\b\"\3\2\2\2\n\13\7\7\2\2\13\f\7"+
		"\f\2\2\f\r\7\4\2\2\r\16\7\16\2\2\16\17\7\22\2\2\17\20\7\17\2\2\20\21\5"+
		"\4\3\2\21\3\3\2\2\2\22\23\7\13\2\2\23\24\7\16\2\2\24\25\t\2\2\2\25\26"+
		"\7\17\2\2\26\27\5\6\4\2\27\5\3\2\2\2\30\31\7\n\2\2\31 \7\16\2\2\32\33"+
		"\7\b\2\2\33\34\7\17\2\2\34!\5\b\5\2\35\36\7\6\2\2\36\37\7\17\2\2\37!\7"+
		"\r\2\2 \32\3\2\2\2 \35\3\2\2\2!\7\3\2\2\2\"#\7\5\2\2#$\7\16\2\2$)\7\21"+
		"\2\2%&\7\20\2\2&(\7\21\2\2\'%\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*"+
		",\3\2\2\2+)\3\2\2\2,-\7\17\2\2-.\7\r\2\2.\t\3\2\2\2\4 )";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}