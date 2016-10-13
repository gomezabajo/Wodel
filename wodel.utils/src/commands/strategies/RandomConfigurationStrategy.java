package commands.strategies;

import manager.ModelManager;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

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
		System.out.println("RANDOM: c.getInstanceClass().getSimpleName().toLowerCase(): " + c.getInstanceClass().getSimpleName().toLowerCase());
		if (c.getInstanceClass().getSimpleName().toLowerCase().equals("int") ||
				c.getInstanceClass().getSimpleName().toLowerCase().equals("double") ||
				c.getInstanceClass().getSimpleName().toLowerCase().equals("string") ||
				c.getInstanceClass().getSimpleName().toLowerCase().equals("boolean"))
			return true;
		return false;
	}
	
	public Object getValue() {
		Object ret = null;
		int max = 10;
		System.out.println("RANDOM: this.value.getClass().getSimpleName().toLowerCase(): " + this.value.getClass().getSimpleName().toLowerCase());
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
		return ret;
	}
	public Object getValue(EObject o){
		Object ret = null;
		int max = 10;
		System.out.println("RANDOM: this.value.getClass().getSimpleName().toLowerCase(): " + this.value.getClass().getSimpleName().toLowerCase());
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
		return ret;
	}
}
