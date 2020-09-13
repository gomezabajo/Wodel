package wodel.fa2re.parser;
// Generated from SE.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SEParser}.
 */
public interface SEListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SEParser#ordering}.
	 * @param ctx the parse tree
	 */
	void enterOrdering(@NotNull SEParser.OrderingContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEParser#ordering}.
	 * @param ctx the parse tree
	 */
	void exitOrdering(@NotNull SEParser.OrderingContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull SEParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull SEParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEParser#eMode}.
	 * @param ctx the parse tree
	 */
	void enterEMode(@NotNull SEParser.EModeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEParser#eMode}.
	 * @param ctx the parse tree
	 */
	void exitEMode(@NotNull SEParser.EModeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull SEParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull SEParser.TypeContext ctx);
}