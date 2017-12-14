package manager;

import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;

/**
 * @author Pablo Gomez-Abajo
 * 
 * Java code formatting
 * 
 */

public class JavaUtils {

	/**
	 * Removes comments from Java code
	 */
	private static CharSequence removeComments(CharSequence sequence) {
		return sequence.toString().replaceAll("//.*", "").replaceAll("(?m)^[ \t]*\r?\n", "");
	}
	
	/**
	 * Correct indentation for Java code
	 */
	public static CharSequence format(CharSequence sequence, boolean comments) {
		String code = null;
		if (comments == false) {
			code = removeComments(sequence).toString();
		}
		CodeFormatter codeFormatter = ToolFactory.createCodeFormatter(null);
		TextEdit textEdit = codeFormatter.format(CodeFormatter.K_COMPILATION_UNIT, // format a compilation unit
				code, // source to format
                0, // starting position
                code.length(), // length
                0, // initial indentation
                System.getProperty("line.separator") // line separator
		);
		IDocument doc = new Document(code);
		try {
        	textEdit.apply(doc);
        	return doc.get();
		} catch (MalformedTreeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
