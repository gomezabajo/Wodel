package wodel.fa2re.parser;

import java.util.List;

import com.google.common.collect.ArrayListMultimap;

/*
 * Classe que faz extends ao Base Listener gerado automaticamente pelo ANTLR4
 * para percorrer a CST criando os valores da AST que têm que ser percorridos.
 * Os valores da AST são o FileName lido a partir do nó Start, o valor do
 * eMode (default ou steps), o valor da forma de eliminação de estados e o
 * ordering desses estados.
 */
public class SEAst extends SEBaseListener {
	private ArrayListMultimap<String, String> values = ArrayListMultimap.create();

	@Override
	public void enterStart(SEParser.StartContext ctx) {
		values.put("start", ctx.FILENAME().getText());
	}

	@Override
	public void enterEMode(SEParser.EModeContext ctx) {
		values.put("eMode", ctx.getChild(2).getText());
	}

	@Override
	public void enterType(SEParser.TypeContext ctx) {
		values.put("type", ctx.getChild(2).getText());
	}

	@Override // valores lidos colocados num multimap.
	public void enterOrdering(SEParser.OrderingContext ctx) {
		for (int i = 2; i < ctx.getChildCount() - 2; i += 2)
			values.put("ordering", ctx.getChild(i).getText());
	}
	
	public List<String> getNode(String key) {
		return values.get(key);
	}
	
	public List<String> getFileName() {
		return values.get("start");
	}
	
	public List<String> getOrdering() {
		return values.get("ordering");
	}
	
	public List<String> getMode() {
		return values.get("eMode");
	}
}
