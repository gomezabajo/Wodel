/*
 * generated by Xtext 2.36.0
 */
package wodeledu.dsls.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class MutaTextAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("wodeledu/dsls/parser/antlr/internal/InternalMutaText.tokens");
	}
}
