/**
 */
package mutatorenvironment.provider;


import java.util.Collection;
import java.util.List;

import mutatorenvironment.ModifyInformationMutator;
import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.MutatorenvironmentPackage;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link mutatorenvironment.ModifyInformationMutator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ModifyInformationMutatorItemProvider extends MutatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifyInformationMutatorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(MutatorenvironmentPackage.Literals.MODIFY_INFORMATION_MUTATOR__OBJECT);
			childrenFeatures.add(MutatorenvironmentPackage.Literals.MODIFY_INFORMATION_MUTATOR__ATTRIBUTES);
			childrenFeatures.add(MutatorenvironmentPackage.Literals.MODIFY_INFORMATION_MUTATOR__REFERENCES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ModifyInformationMutator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ModifyInformationMutator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ModifyInformationMutator)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ModifyInformationMutator_type") :
			getString("_UI_ModifyInformationMutator_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ModifyInformationMutator.class)) {
			case MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__OBJECT:
			case MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__ATTRIBUTES:
			case MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__REFERENCES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.MODIFY_INFORMATION_MUTATOR__OBJECT,
				 MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.MODIFY_INFORMATION_MUTATOR__OBJECT,
				 MutatorenvironmentFactory.eINSTANCE.createSpecificObjectSelection()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.MODIFY_INFORMATION_MUTATOR__OBJECT,
				 MutatorenvironmentFactory.eINSTANCE.createSpecificReferenceSelection()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.MODIFY_INFORMATION_MUTATOR__OBJECT,
				 MutatorenvironmentFactory.eINSTANCE.createCompleteSelection()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.MODIFY_INFORMATION_MUTATOR__OBJECT,
				 MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.MODIFY_INFORMATION_MUTATOR__OBJECT,
				 MutatorenvironmentFactory.eINSTANCE.createOtherSelection()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.MODIFY_INFORMATION_MUTATOR__OBJECT,
				 MutatorenvironmentFactory.eINSTANCE.createOtherTypeSelection()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.MODIFY_INFORMATION_MUTATOR__ATTRIBUTES,
				 MutatorenvironmentFactory.eINSTANCE.createAttributeSet()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.MODIFY_INFORMATION_MUTATOR__ATTRIBUTES,
				 MutatorenvironmentFactory.eINSTANCE.createAttributeInit()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.MODIFY_INFORMATION_MUTATOR__ATTRIBUTES,
				 MutatorenvironmentFactory.eINSTANCE.createAttributeUnset()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.MODIFY_INFORMATION_MUTATOR__ATTRIBUTES,
				 MutatorenvironmentFactory.eINSTANCE.createAttributeSwap()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.MODIFY_INFORMATION_MUTATOR__ATTRIBUTES,
				 MutatorenvironmentFactory.eINSTANCE.createAttributeCopy()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.MODIFY_INFORMATION_MUTATOR__ATTRIBUTES,
				 MutatorenvironmentFactory.eINSTANCE.createAttributeReverse()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.MODIFY_INFORMATION_MUTATOR__REFERENCES,
				 MutatorenvironmentFactory.eINSTANCE.createReferenceSet()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.MODIFY_INFORMATION_MUTATOR__REFERENCES,
				 MutatorenvironmentFactory.eINSTANCE.createReferenceInit()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.MODIFY_INFORMATION_MUTATOR__REFERENCES,
				 MutatorenvironmentFactory.eINSTANCE.createReferenceSwap()));
	}

}
