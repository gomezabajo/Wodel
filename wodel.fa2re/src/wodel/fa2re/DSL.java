package wodel.fa2re;

import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import wodel.fa2re.parser.SEAst;
import wodel.fa2re.parser.SELexer;
import wodel.fa2re.parser.SEParser;
import wodel.fa2re.parser.SEParser.StartContext;

/*
 * DSL lida que contém o texto, um conversor para o autómato e a AST gerada
 */
public class DSL {
	private String dslText;
	private Conversor conversor;
	private SEAst ast;
	private String graphImageName;
	private String regularExpression;
	private String minimizedRE;

	public DSL(String dslText) {
		this.dslText = dslText;
	}

	public String getDSLText() {
		return dslText;
	}

	/*
	 * análise semântica do ficheiro lido. lança duas exceções quando: 1 - o
	 * ficheiro não existe 2 - os estados, caso existam em ordering, sejam
	 * estados intermédios possíveis de eliminar
	 */
	public boolean evaluate() {
		CharStream in = new ANTLRInputStream(dslText);
		SELexer lexer = new SELexer(in);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		SEParser parser = new SEParser(tokens);
		StartContext startContext = parser.start();

		ParseTreeWalker walker = new ParseTreeWalker();
		ast = new SEAst();
		walker.walk(ast, startContext);

		Automaton a = new Automaton();
		a.readGraph(ast.getFileName().get(0));
		Vector<State> states = a.getStates();

		try {
			String type = "png";
			graphImageName = ast.getFileName().get(0).replaceAll(".dot", "")
					+ "." + type;
			a.generateAutomataImage(ast.getFileName().get(0));

			List<String> order = ast.getOrdering();

			if (!checkIfOrderApplies(order, states)) {
				JOptionPane
						.showMessageDialog(
								new JFrame(),
								"Error: The states in the DSL didn't match the ones in the dot file.\n"
										+ "They have to exist and can't be either the initial or the final states.",
								"Unmatched states", JOptionPane.ERROR_MESSAGE);
				return false;
			}

			conversor = new Conversor(states, order);
			
			/*String tests = "e(ab+c)*+(ab+c)*";
			regularExpression = tests;
			minimizedRE = conversor.minimize(regularExpression);*/
			
			regularExpression = conversor.convert2();
			minimizedRE = conversor.minimize(regularExpression);

			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(),
					"Error: The file couldn't be found or does not exist.",
					"File not found", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	// verifica se a ordem de estados coincide com os estados lidos do ficheiro
	// .dot
	public boolean checkIfOrderApplies(List<String> order, Vector<State> states) {
		if (order.size() > 0) {
			Vector<State> midStates = new Vector<State>();
			Vector<String> midStatesIdentifiers = new Vector<String>();

			for (State s : states)
				if (!s.isFinal() && !s.isInitial()) {
					midStates.add(s);
					midStatesIdentifiers.add("" + s.getIdentifier());
				}

			if (order.size() != midStates.size())
				return false;

			for (String s : order)
				if (!midStatesIdentifiers.contains(s))
					return false;

			return true;
		} else
			return true;
	}

	public SEAst getAST() {
		return ast;
	}

	public String getGraphImageName() {
		return graphImageName;
	}

	public String getRegularExpression() {
		return regularExpression;
	}
	
	public String getMinimizedExpression() {
		return minimizedRE;
	}

	public void setRegularExpression(String regularExpression) {
		this.regularExpression = regularExpression;
	}

	public Conversor getConversor() {
		return conversor;
	}

	public void setConversor(Conversor conversor) {
		this.conversor = conversor;
	}
}