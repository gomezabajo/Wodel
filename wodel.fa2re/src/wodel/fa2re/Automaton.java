package wodel.fa2re;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.DefaultGraph;
import org.graphstream.stream.file.FileSource;
import org.graphstream.stream.file.FileSourceFactory;

import com.google.common.collect.ArrayListMultimap;

/*
 * Autómato que guarda a informação lida do ficheiro .dot
 * É a ponte entre a classe GraphViz e a classe Graphviewer
 * A classe Graphviz é responsável por gerar a imagem do autómato.
 * A classe Graphviewer guarda a informação do ficheiro .dot em estruturas internas
 * e converte-as para as estruturas do nosso trabalho (State e Conversor) para ser possível
 * gerar a expressão regular.
 */
public class Automaton {
	private Graph graph = new DefaultGraph("G");

	// leitura do ficheiro a partir do nome passado na DSL.
	void readGraph(String filename) {
		FileSource fs;
		try {
			fs = FileSourceFactory.sourceFor(filename);
			fs.addSink(this.graph);
			try {
				fs.readAll(filename);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				fs.removeSink(this.graph);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	// estados lidos a partir do ficheiro .dot
	// coloca-os num vetor de estados (State) para serem usados no Conversor
	Vector<State> getStates() {
		Vector<State> states = new Vector<State>();
		int k = 0;
		for (Node node : graph) {
			ArrayListMultimap<String, Integer> t = ArrayListMultimap.create();
			Collection<Edge> edges = node.getLeavingEdgeSet();
			for (Edge edge : edges) {
				String label = edge.getAttribute("label");
				String dest = edge.getNode1().toString();
				if (k != 0) {
					String[] tokens = label.split(",");
					for (String token : tokens) {
						t.put(token.replaceAll("\\s", ""),
								Integer.parseInt(dest));
					}
				}
			}
			String shape = node.getAttribute("shape");
			if (shape.equals("doublecircle")) // estado final
				states.add(new State(Integer.parseInt(node.getId()), t, false,
						true));
			else if (k == 1) // estado inicial
				states.add(new State(Integer.parseInt(node.getId()), t, true,
						false));
			else if (k == 1 && shape.equals("doublecircle")) // estado inicial e
																// final
				states.add(new State(Integer.parseInt(node.getId()), t, true,
						true));
			else if (k != 0) // outros estados intermédios
				states.add(new State(Integer.parseInt(node.getId()), t, false,
						false));
			k++;
		}
		return states;
	}

	// Adiciona ao ficheiro .dot a informação de RankDir=LR para desenhar
	// o autómato na horizontal (ocupando menos espaço e sendo mais fácil de
	// ler).
	void addRankdirToFile(String filename) {
		BufferedReader in = null;
		ArrayList<String> lines = new ArrayList<String>();
		try {
			in = new BufferedReader(new FileReader(filename));
			String read = null;
			while ((read = in.readLine()) != null) {
				lines.add(read);
			}
		} catch (IOException e) {
			System.out.println("There was a problem: " + e);
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (Exception e) {
			}
		}
		lines.add(1, "\trankdir=LR;");
		FileWriter writer;
		try {
			writer = new FileWriter("rk" + filename);
			for (String str : lines)
				writer.write(str + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Gera a imagem a partir do nome do ficheiro passado na DSL.
	String generateAutomataImage(String filename) {
		GraphViz gv = new GraphViz();
		addRankdirToFile(filename);
		try {
			gv.readSource("rk" + filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		gv.setMaxDpi();
		String imageName = filename.replaceAll(".dot", "") + ".png";
		File out = new File(imageName);
		gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), "png", "dot"), out);
		try {
			Files.deleteIfExists(Paths.get("rk" + filename));
		} catch (DirectoryNotEmptyException x) {
			System.err.format("%s not empty%n", Paths.get("rk" + filename));
		} catch (IOException x) {
			// File permission problems are caught here.
			System.err.println(x);
		}
		return imageName;
	}
}
