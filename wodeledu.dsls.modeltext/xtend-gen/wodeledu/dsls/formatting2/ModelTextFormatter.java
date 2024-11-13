/**
 * generated by Xtext 2.30.0
 */
package wodeledu.dsls.formatting2;

import com.google.inject.Inject;
import java.util.Arrays;
import modeltext.Element;
import modeltext.IdentifyElements;
import modeltext.ValuedFeature;
import modeltext.Word;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.XbaseGenerated;
import wodeledu.dsls.services.ModelTextGrammarAccess;

@SuppressWarnings("all")
public class ModelTextFormatter extends AbstractFormatter2 {
  @Inject
  @Extension
  private ModelTextGrammarAccess _modelTextGrammarAccess;

  protected void _format(final IdentifyElements identifyElements, @Extension final IFormattableDocument document) {
    EList<Element> _elements = identifyElements.getElements();
    for (final Element element : _elements) {
      document.<Element>format(element);
    }
  }

  protected void _format(final Element element, @Extension final IFormattableDocument document) {
    EList<ValuedFeature> _feature = element.getFeature();
    for (final ValuedFeature valuedFeature : _feature) {
      document.<ValuedFeature>format(valuedFeature);
    }
    EList<Word> _words = element.getWords();
    for (final Word word : _words) {
      document.<Word>format(word);
    }
  }

  @XbaseGenerated
  public void format(final Object element, final IFormattableDocument document) {
    if (element instanceof XtextResource) {
      _format((XtextResource)element, document);
      return;
    } else if (element instanceof Element) {
      _format((Element)element, document);
      return;
    } else if (element instanceof IdentifyElements) {
      _format((IdentifyElements)element, document);
      return;
    } else if (element instanceof EObject) {
      _format((EObject)element, document);
      return;
    } else if (element == null) {
      _format((Void)null, document);
      return;
    } else if (element != null) {
      _format(element, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element, document).toString());
    }
  }
}
