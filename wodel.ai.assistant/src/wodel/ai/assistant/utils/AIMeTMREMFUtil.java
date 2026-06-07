package wodel.ai.assistant.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import wodel.utils.manager.ModelManager;
import wodel.utils.exceptions.ReferenceNonExistingException;

public class AIMeTMREMFUtil {

	public static void cleanModel(Resource model, String featureTestCase, String featureFollowup) {
		try {
			EObject root = ModelManager.getRoot(model);
			Object ob = ModelManager.getReferenced("test", root);
			if (ob == null) {
				return;
			}
			EObject test = ob instanceof EObject ? (EObject) ob : null;
			if (test == null) {
				return;
			}
			EStructuralFeature original = test.eClass().getEStructuralFeature(featureTestCase);
			test.eSet(original, null);
			EStructuralFeature followup = test.eClass().getEStructuralFeature(featureFollowup);
			test.eSet(followup, null);
			ModelManager.saveOutModel(model, model.getURI().toFileString());
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
