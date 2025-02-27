/**
 * generated by Xtext 2.30.0
 */
package wodel.dsls.formatting2;

import asple.Declaration;
import asple.Identifier;
import asple.Program;
import asple.Statement;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.XbaseGenerated;
import wodel.dsls.services.ASPLEGrammarAccess;

@SuppressWarnings("all")
public class ASPLEFormatter extends AbstractFormatter2 {
  @Inject
  @Extension
  private ASPLEGrammarAccess _aSPLEGrammarAccess;

  protected void _format(final Program program, @Extension final IFormattableDocument document) {
    EList<Declaration> _declarations = program.getDeclarations();
    for (final Declaration declaration : _declarations) {
      document.<Declaration>format(declaration);
    }
    EList<Statement> _statements = program.getStatements();
    for (final Statement statement : _statements) {
      document.<Statement>format(statement);
    }
  }

  protected void _format(final Declaration declaration, @Extension final IFormattableDocument document) {
    EList<Identifier> _identifiers = declaration.getIdentifiers();
    for (final Identifier identifier : _identifiers) {
      document.<Identifier>format(identifier);
    }
  }

  @XbaseGenerated
  public void format(final Object declaration, final IFormattableDocument document) {
    if (declaration instanceof XtextResource) {
      _format((XtextResource)declaration, document);
      return;
    } else if (declaration instanceof Declaration) {
      _format((Declaration)declaration, document);
      return;
    } else if (declaration instanceof Program) {
      _format((Program)declaration, document);
      return;
    } else if (declaration instanceof EObject) {
      _format((EObject)declaration, document);
      return;
    } else if (declaration == null) {
      _format((Void)null, document);
      return;
    } else if (declaration != null) {
      _format(declaration, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(declaration, document).toString());
    }
  }
}
