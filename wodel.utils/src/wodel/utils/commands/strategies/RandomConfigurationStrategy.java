package wodel.utils.commands.strategies;

import java.util.List;

import wodel.utils.manager.ModelManager;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Pablo Gomez-Abajo
 * 
 * RandomConfigurationStrategy configures a random attribute numeric or literal
 * 
 */

public class RandomConfigurationStrategy extends AttributeConfigurationStrategy {
	
	protected Object value;

	public RandomConfigurationStrategy(String a2m) {
		super(a2m);
		// TODO Auto-generated constructor stub
	}

	public RandomConfigurationStrategy(Object value, String a2m) {
		super(a2m);
		this.value = value;
	}
	
	@Override
	public boolean sameType(EClassifier c) {
		if (c.getInstanceClass() != null) {
			String className = c.getInstanceClassName();
			if (className.equals("int") || className.equals("java.lang.Integer") ||
				className.equals("double") || className.equals("java.lang.Double") ||
				className.equals("string") || className.equals("java.lang.String") ||
				className.equals("boolean") || className.equals("java.lang.Boolean"))
			return true;
		}
		if (c.getClass().getSimpleName().toLowerCase().equals("eenumimpl")) {
			return true;
		}
		return false;
	}
	
	public Object getValue() {
		Object ret = null;
		int max = 10;
		String className = this.value.getClass().getSimpleName().toLowerCase();
		if (className.equals("integer")) {
			int i = 0;
			do {
				i++;
				ret = ModelManager.rn.nextInt(100);
			}
			while ((ret == this.value) && (i < max));
		}
		if (className.toLowerCase().equals("double")) {
			int i = 0;
			do {
				i++;
				ret = ModelManager.rn.nextDouble()*100;
			}
			while ((ret == this.value) && (i < max));
		}
		if (className.equals("string")) {
			int size = ModelManager.rn.nextInt(5);
			int i = 0;
			do {
				i++;
				ret = "";
				for (int j=0; j<size; j++) {
					int newchar = ModelManager.rn.nextInt(94) + 32;
					while (!Character.isLetter(newchar)) {
						newchar = ModelManager.rn.nextInt(94) + 32;
					}
					ret = ret + String.valueOf((char) newchar);
				}
			}
			while ((((String) ret).equals((String) this.value)) && (i < max));
		}
		if (className.equals("boolean")) {
			ret = !(boolean) this.value;
		}
		if (this.value instanceof EEnumLiteral) {
			int i = 0;
			List<EEnumLiteral> literals = ((EEnumLiteral) this.value).getEEnum().getELiterals();
			EEnumLiteral lit = null;
			do {
				i++;
				lit = literals.get(ModelManager.getRandomIndex(literals));
			}
			while ((((EEnumLiteral) this.value).getLiteral().equals(lit.getLiteral())) && (i < max));
			ret = lit;
   		}
		return ret;
	}
	public Object getValue(EObject o){
		Object ret = null;
		int max = 10;
		if (this.value.getClass().getSimpleName().toLowerCase().equals("integer")) {
			int i = 0;
			do {
				i++;
				ret = ModelManager.rn.nextInt(100);
			}
			while ((ret == this.value) && (i < max));
		}
		if (this.value.getClass().getSimpleName().toLowerCase().equals("double")) {
			int i = 0;
			do {
				i++;
				ret = ModelManager.rn.nextDouble()*100;
			}
			while ((ret == this.value) && (i < max));
		}
		if (this.value.getClass().getSimpleName().toLowerCase().equals("string")) {
			int size = ModelManager.rn.nextInt(5);
			int i = 0;
			do {
				i++;
				ret = "";
				for (int j=0; j<size; j++) {
					int newchar = ModelManager.rn.nextInt(94) + 32;
					while (!Character.isLetter(newchar)) {
						newchar = ModelManager.rn.nextInt(94) + 32;
					}
					ret = ret + String.valueOf((char) newchar);
				}
			}
			while ((((String) ret).equals((String) this.value)) && (i < max));
		}
		if (this.value.getClass().getSimpleName().toLowerCase().equals("boolean")) {
			ret = !(boolean) this.value;
		}
		if (this.value instanceof EEnumLiteral) {
			int i = 0;
			List<EEnumLiteral> literals = ((EEnumLiteral) this.value).getEEnum().getELiterals();
			EEnumLiteral lit = null;
			do {
				i++;
				lit = literals.get(ModelManager.getRandomIndex(literals));
			}
			while ((((EEnumLiteral) this.value).getLiteral().equals(lit.getLiteral())) && (i < max));
			ret = lit;
   		}
		return ret;
	}
}
