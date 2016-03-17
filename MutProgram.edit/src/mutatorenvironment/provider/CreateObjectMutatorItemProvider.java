/**
 */
package mutatorenvironment.provider;


import java.util.Collection;
import java.util.List;

import mutatorenvironment.CreateObjectMutator;
import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.MutatorenvironmentPackage;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link mutatorenvironment.CreateObjectMutator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CreateObjectMutatorItemProvider extends MutatorItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateObjectMutatorItemProvider(AdapterFactory adapterFactory) {
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

			addRefTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Ref Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRefTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CreateObjectMutator_refType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CreateObjectMutator_refType_feature", "_UI_CreateObjectMutator_type"),
				 MutatorenvironmentPackage.Literals.CREATE_OBJECT_MUTATOR__REF_TYPE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
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
			childrenFeatures.add(MutatorenvironmentPackage.Literals.CREATE_OBJECT_MUTATOR__CONTAINER);
			childrenFeatures.add(MutatorenvironmentPackage.Literals.CREATE_OBJECT_MUTATOR__ATTRIBUTES);
			childrenFeatures.add(MutatorenvironmentPackage.Literals.CREATE_OBJECT_MUTATOR__REFERENCES);
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
	 * This returns CreateObjectMutator.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CreateObjectMutator"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((CreateObjectMutator)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_CreateObjectMutator_type") :
			getString("_UI_CreateObjectMutator_type") + " " + label;
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

		switch (notification.getFeatureID(CreateObjectMutator.class)) {
			case MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__CONTAINER:
			case MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__ATTRIBUTES:
			case MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__REFERENCES:
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
				(MutatorenvironmentPackage.Literals.CREATE_OBJECT_MUTATOR__CONTAINER,
				 MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.CREATE_OBJECT_MUTATOR__CONTAINER,
				 MutatorenvironmentFactory.eINSTANCE.createSpecificObjectSelection()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.CREATE_OBJECT_MUTATOR__CONTAINER,
				 MutatorenvironmentFactory.eINSTANCE.createSpecificReferenceSelection()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.CREATE_OBJECT_MUTATOR__CONTAINER,
				 MutatorenvironmentFactory.eINSTANCE.createCompleteSelection()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.CREATE_OBJECT_MUTATOR__CONTAINER,
				 MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.CREATE_OBJECT_MUTATOR__CONTAINER,
				 MutatorenvironmentFactory.eINSTANCE.createOtherSelection()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.CREATE_OBJECT_MUTATOR__CONTAINER,
				 MutatorenvironmentFactory.eINSTANCE.createOtherTypeSelection()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.CREATE_OBJECT_MUTATOR__ATTRIBUTES,
				 MutatorenvironmentFactory.eINSTANCE.createAttributeSet()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.CREATE_OBJECT_MUTATOR__ATTRIBUTES,
				 MutatorenvironmentFactory.eINSTANCE.createAttributeInit()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.CREATE_OBJECT_MUTATOR__ATTRIBUTES,
				 MutatorenvironmentFactory.eINSTANCE.createAttributeUnset()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.CREATE_OBJECT_MUTATOR__ATTRIBUTES,
				 MutatorenvironmentFactory.eINSTANCE.createAttributeSwap()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.CREATE_OBJECT_MUTATOR__ATTRIBUTES,
				 MutatorenvironmentFactory.eINSTANCE.createAttributeCopy()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.CREATE_OBJECT_MUTATOR__ATTRIBUTES,
				 MutatorenvironmentFactory.eINSTANCE.createAttributeReverse()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.CREATE_OBJECT_MUTATOR__REFERENCES,
				 MutatorenvironmentFactory.eINSTANCE.createReferenceSet()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.CREATE_OBJECT_MUTATOR__REFERENCES,
				 MutatorenvironmentFactory.eINSTANCE.createReferenceInit()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.CREATE_OBJECT_MUTATOR__REFERENCES,
				 MutatorenvironmentFactory.eINSTANCE.createReferenceSwap()));
	}

}
