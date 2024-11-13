/**
 * generated by Xtext 2.30.0
 */
package wodeledu.dsls.formatting2;

import com.google.inject.Inject;
import edutest.AlternativeResponse;
import edutest.MutatorTests;
import edutest.Program;
import edutest.ProgramConfiguration;
import edutest.Test;
import edutest.TestConfiguration;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.XbaseGenerated;
import wodeledu.dsls.services.EduTestGrammarAccess;

@SuppressWarnings("all")
public class EduTestFormatter extends AbstractFormatter2 {
  @Inject
  @Extension
  private EduTestGrammarAccess _eduTestGrammarAccess;

  protected void _format(final Program program, @Extension final IFormattableDocument document) {
    document.<ProgramConfiguration>format(program.getConfig());
    EList<MutatorTests> _exercises = program.getExercises();
    for (final MutatorTests mutatorTests : _exercises) {
      document.<MutatorTests>format(mutatorTests);
    }
  }

  protected void _format(final AlternativeResponse alternativeResponse, @Extension final IFormattableDocument document) {
    document.<TestConfiguration>format(alternativeResponse.getConfig());
    EList<Test> _tests = alternativeResponse.getTests();
    for (final Test test : _tests) {
      document.<Test>format(test);
    }
  }

  @XbaseGenerated
  public void format(final Object alternativeResponse, final IFormattableDocument document) {
    if (alternativeResponse instanceof XtextResource) {
      _format((XtextResource)alternativeResponse, document);
      return;
    } else if (alternativeResponse instanceof AlternativeResponse) {
      _format((AlternativeResponse)alternativeResponse, document);
      return;
    } else if (alternativeResponse instanceof Program) {
      _format((Program)alternativeResponse, document);
      return;
    } else if (alternativeResponse instanceof EObject) {
      _format((EObject)alternativeResponse, document);
      return;
    } else if (alternativeResponse == null) {
      _format((Void)null, document);
      return;
    } else if (alternativeResponse != null) {
      _format(alternativeResponse, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(alternativeResponse, document).toString());
    }
  }
}
