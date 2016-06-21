/**
 */
package mutatorenvironment.provider;


import java.util.Collection;
import java.util.List;

import mutatorenvironment.Block;
import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.MutatorenvironmentPackage;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link mutatorenvironment.Block} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BlockItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addFromPropertyDescriptor(object);
			addRepeatPropertyDescriptor(object);
			addMinPropertyDescriptor(object);
			addMaxPropertyDescriptor(object);
			addFixedPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Block_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Block_name_feature", "_UI_Block_type"),
				 MutatorenvironmentPackage.Literals.BLOCK__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the From feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFromPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Block_from_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Block_from_feature", "_UI_Block_type"),
				 MutatorenvironmentPackage.Literals.BLOCK__FROM,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Repeat feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRepeatPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Block_repeat_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Block_repeat_feature", "_UI_Block_type"),
				 MutatorenvironmentPackage.Literals.BLOCK__REPEAT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Min feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMinPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Block_min_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Block_min_feature", "_UI_Block_type"),
				 MutatorenvironmentPackage.Literals.BLOCK__MIN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Block_max_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Block_max_feature", "_UI_Block_type"),
				 MutatorenvironmentPackage.Literals.BLOCK__MAX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fixed feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFixedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Block_fixed_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Block_fixed_feature", "_UI_Block_type"),
				 MutatorenvironmentPackage.Literals.BLOCK__FIXED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
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
			childrenFeatures.add(MutatorenvironmentPackage.Literals.BLOCK__COMMANDS);
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
	 * This returns Block.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Block"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Block)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Block_type") :
			getString("_UI_Block_type") + " " + label;
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

		switch (notification.getFeatureID(Block.class)) {
			case MutatorenvironmentPackage.BLOCK__NAME:
			case MutatorenvironmentPackage.BLOCK__REPEAT:
			case MutatorenvironmentPackage.BLOCK__MIN:
			case MutatorenvironmentPackage.BLOCK__MAX:
			case MutatorenvironmentPackage.BLOCK__FIXED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case MutatorenvironmentPackage.BLOCK__COMMANDS:
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
				(MutatorenvironmentPackage.Literals.BLOCK__COMMANDS,
				 MutatorenvironmentFactory.eINSTANCE.createCompositeMutator()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.BLOCK__COMMANDS,
				 MutatorenvironmentFactory.eINSTANCE.createCreateObjectMutator()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.BLOCK__COMMANDS,
				 MutatorenvironmentFactory.eINSTANCE.createModifySourceReferenceMutator()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.BLOCK__COMMANDS,
				 MutatorenvironmentFactory.eINSTANCE.createModifyTargetReferenceMutator()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.BLOCK__COMMANDS,
				 MutatorenvironmentFactory.eINSTANCE.createCreateReferenceMutator()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.BLOCK__COMMANDS,
				 MutatorenvironmentFactory.eINSTANCE.createRemoveObjectMutator()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.BLOCK__COMMANDS,
				 MutatorenvironmentFactory.eINSTANCE.createModifyInformationMutator()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.BLOCK__COMMANDS,
				 MutatorenvironmentFactory.eINSTANCE.createRemoveRandomReferenceMutator()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.BLOCK__COMMANDS,
				 MutatorenvironmentFactory.eINSTANCE.createRemoveSpecificReferenceMutator()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.BLOCK__COMMANDS,
				 MutatorenvironmentFactory.eINSTANCE.createRemoveCompleteReferenceMutator()));

		newChildDescriptors.add
			(createChildParameter
				(MutatorenvironmentPackage.Literals.BLOCK__COMMANDS,
				 MutatorenvironmentFactory.eINSTANCE.createSelectObjectMutator()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return MutatorEnvironmentEditPlugin.INSTANCE;
	}

}
