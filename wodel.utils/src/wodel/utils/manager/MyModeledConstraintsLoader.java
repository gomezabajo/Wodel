package wodel.utils.manager;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.validation.internal.EMFModelValidationDebugOptions;
import org.eclipse.emf.validation.internal.EMFModelValidationPlugin;
import org.eclipse.emf.validation.internal.EMFModelValidationStatusCodes;
import org.eclipse.emf.validation.internal.modeled.ClassProvider;
import org.eclipse.emf.validation.internal.modeled.ModeledConstraintDescriptor;
import org.eclipse.emf.validation.internal.modeled.ModeledConstraintProvider;
import org.eclipse.emf.validation.internal.modeled.model.validation.Binding;
import org.eclipse.emf.validation.internal.modeled.model.validation.Category;
import org.eclipse.emf.validation.internal.modeled.model.validation.ClientContext;
import org.eclipse.emf.validation.internal.modeled.model.validation.Constraint;
import org.eclipse.emf.validation.internal.modeled.model.validation.ConstraintBindingsBundle;
import org.eclipse.emf.validation.internal.modeled.model.validation.ConstraintProvider;
import org.eclipse.emf.validation.internal.modeled.model.validation.Constraints;
import org.eclipse.emf.validation.internal.modeled.model.validation.ConstraintsBundle;
import org.eclipse.emf.validation.internal.modeled.model.validation.Parser;
import org.eclipse.emf.validation.internal.modeled.model.validation.Selector;
import org.eclipse.emf.validation.internal.service.ClientContextManager;
import org.eclipse.emf.validation.internal.service.GetBatchConstraintsOperation;
import org.eclipse.emf.validation.internal.service.GetLiveConstraintsOperation;
import org.eclipse.emf.validation.internal.service.IClientContext;
import org.eclipse.emf.validation.internal.service.IProviderDescriptor;
import org.eclipse.emf.validation.internal.service.IProviderOperation;
import org.eclipse.emf.validation.internal.util.Log;
import org.eclipse.emf.validation.internal.util.Trace;
import org.eclipse.emf.validation.internal.util.XmlConstraintFactory;
import org.eclipse.emf.validation.model.CategoryManager;
import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.ConstraintExistsException;
import org.eclipse.emf.validation.service.ConstraintFactory;
import org.eclipse.emf.validation.service.ConstraintRegistry;
import org.eclipse.emf.validation.service.IConstraintParser;
import org.eclipse.emf.validation.service.IModelConstraintProvider;
import org.osgi.framework.Bundle;

/**
 * <p>
 * Provides services for loading modeled constraints into the validation system.
 * </p>
 * 
 * @author Boris Gruschko
 * @since 1.4
 *
 */
public class MyModeledConstraintsLoader {
	
	private	Set<URI>	loadedConstraintProviders;
	
	private final static MyModeledConstraintsLoader instance = new MyModeledConstraintsLoader();
	
	public static MyModeledConstraintsLoader getInstance() {
		return instance;
	}
	
	private MyModeledConstraintsLoader() {
		loadedConstraintProviders = new HashSet<URI>();
	}
	
	/**
	 * <p>
	 * Loads constraint bundles into the validation system.
	 * </p>
	 * <p>
	 * This method is provided to support the standalone use case. For loading bundles 
	 * in a running platform use either {@link ModeledConstraintsLoader#loadConstraintBundles(ResourceSet, URI, ModelValidationService, Bundle)} or
	 * use the modeledConstraintProviders extension point.
	 * </p>
	 * @param rs optional resource set to be used for resource loading. if this argument is null, a resource set will be created.
	 * @param uri URI of the resource containing the modeled constraints.
	 * @param validationService {@link ModelValidationService} to be used.
	 * @param resourceLocator {@link ResourceLocator} for locating message bundles.
	 */
	public void loadConstraintBundles(ResourceSet rs, URI uri, MyModelValidationService validationService, ResourceLocator resourceLocator) {
		loadConstraintBundles(rs, uri, validationService, new ClassProvider.ClassLoaderProvider(resourceLocator));
	}
	
	/**
	 * <p>
	 * Loads constraint bundles into the validation system.
	 * </p>
	 * @param rs optional resource set to be used for resource loading. if this argument is null, a resource set will be created.
	 * @param uri URI of the resource containing the modeled constraints.
	 * @param validationService {@link ModelValidationService} to be used.
	 * @param bundle {@link Bundle} for locating internationalization messages.
	 */
	public void loadConstraintBundles(ResourceSet rs, URI uri, MyModelValidationService validationService, Bundle bundle) {
		loadConstraintBundles(rs, uri, validationService, new ClassProvider.BundleProvider(bundle));
	}
	
	/**
	 * Loads constraint categories into the validation system.
	 * 
	 * @param rs rs optional resource set to be used for resource loading.
	 * @param uri URI of the resource containing the modeled constraints.
	 * @param bundle {@link Bundle} for locating internationalization messages.
	 */
	public void loadCategories(ResourceSet rs, URI uri, Bundle bundle) {
		Resource r = getResource(rs, uri);
		
		for ( EObject o :  r.getContents() ) {
			if ( o instanceof ConstraintsBundle) {
				ConstraintsBundle constraintsBundle = (ConstraintsBundle) o;
				registerCategories(constraintsBundle.getCategories(), new ClassProvider.BundleProvider(bundle));
			}
		}
	}
	
	private void loadConstraintBundles(ResourceSet rs, URI uri, MyModelValidationService validationService, ClassProvider classPovider) {
		Resource r = getResource(rs, uri);
		
		for ( EObject o :  r.getContents() ) {
			if ( o instanceof ConstraintsBundle) {
				ConstraintsBundle bundle = (ConstraintsBundle) o;
				registerCategories(bundle.getCategories(), classPovider);
				
				for ( ConstraintProvider provider : bundle.getProviders() ) {
					registerConstraintsProvider(provider, validationService, classPovider);
				}
				
				for ( ConstraintBindingsBundle bindings : bundle.getConstraintBindingsBundles()) {
					registerConstraintBindingsBundle(bindings, classPovider);
				}

				for ( Parser parser : bundle.getParsers() ) {
					registerParser(classPovider, parser);
				}
			}
		}
	}

	private void registerParser(ClassProvider classPovider, Parser parser) {
		try {
			String language = parser.getLanguage();
			String className = parser.getClassName(); 
			
			if ( language == null ) {
				Log.warningMessage(
						EMFModelValidationStatusCodes.CONSTRAINT_PARSER_TYPE,
						EMFModelValidationStatusCodes.CONSTRAINT_PARSER_TYPE_MSG,
						new Object[] {className, language});
			} else if ( className == null ) {
				Log.warningMessage(
						EMFModelValidationStatusCodes.CONSTRAINT_PARSER_TYPE,
						EMFModelValidationStatusCodes.CONSTRAINT_PARSER_TYPE_MSG,
						new Object[] {className, language});
			} else {
				((XmlConstraintFactory)ConstraintFactory.getInstance()).registerParser(language,
						(IConstraintParser) classPovider.loadClass(className).newInstance());
				Trace.trace(
						EMFModelValidationDebugOptions.PARSERS,
						"Initialized parser for constraint language: " + language); //$NON-NLS-1$
			}
			
		} catch (Exception e) {
			Trace.catching(getClass(), "loadConstraintBundles", e); //$NON-NLS-1$
		}
	}
	
	private void registerConstraintBindingsBundle(
			ConstraintBindingsBundle bindings, ClassProvider classProvider) {
		
		for ( ClientContext ctx : bindings.getClientContexts()) {
			if ( ctx instanceof Selector) {
				assert classProvider != null;
				
				Selector sel = (Selector) ctx;
				
				Class<?> selectorClass = null;
				
				try {
					selectorClass = classProvider.loadClass(sel.getClassName());
				} catch (ClassNotFoundException e) {
					throw new RuntimeException(e);
				}
				
				
				IClientSelector instance = null;
				
				try {
					 instance = (IClientSelector) selectorClass.newInstance();
				} catch (InstantiationException e) {
					throw new RuntimeException(e);
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				}
				
				IClientContext oldCtx = ClientContextManager.getInstance().getClientContext(sel.getId());
				
				if ( oldCtx == null ) {
					
					org.eclipse.emf.validation.internal.service.ClientContext newCtx =
						new org.eclipse.emf.validation.internal.service.ClientContext(sel.getId(), EMFModelValidationPlugin.getPluginId());
					
					newCtx.setSelector(instance);
					
					ClientContextManager.getInstance().addClientContext( newCtx);
				} else {
					// already present
					throw new RuntimeException("Context already present: " + sel.getId()); //$NON-NLS-1$
				}
				
			} else {
				throw new UnsupportedOperationException("Enablements not implemented yet."); //$NON-NLS-1$
			}
		}
		
		for ( Binding binding : bindings.getBindings()) {
			for ( ClientContext ctx : binding.getClientContexts()) {
				org.eclipse.emf.validation.internal.service.ClientContext context = 
					(org.eclipse.emf.validation.internal.service.ClientContext) ClientContextManager.getInstance().getClientContext(ctx.getId());
				
				if ( context == null ) {
					throw new IllegalStateException("Context not found"); //$NON-NLS-1$
				}

				for ( Constraint constraint: binding.getConstraints()) {
					context.includeConstraint(constraint.getId());
				}
				
				for ( Constraint constraint : binding.getExcludedConstraints()) {
					context.excludeConstraint(constraint.getId());
				}
				
				for ( Category category : binding.getCategories()) {
					context.includeCategory(category.getId());
				}

				for ( Category category : binding.getExcludedCategories()) {
					context.excludeCategory(category.getId());
				}
			}
		}
		
	}

		
	private void registerCategories(EList<Category> categories, ClassProvider classProvider) {
		for ( Category category : categories) {
			org.eclipse.emf.validation.model.Category valCategory = CategoryManager.getInstance().getCategory(category.getPath());
			
			valCategory.setName(classProvider.bind(category.getName(), null));
			valCategory.setMandatory(category.isMandatory());
			
			registerCategories(category.getSubCategories(), classProvider);
		}
	}
	
	private void registerConstraintsProvider(ConstraintProvider provider, MyModelValidationService validationService, ClassProvider classProvider) {
		URI providerUri = EcoreUtil.getURI(provider);
		if ( !loadedConstraintProviders.contains(providerUri)) {
			loadedConstraintProviders.add(providerUri);
			
			MyModelValidationService validationServiceToBeUsed = validationService == null ? MyModelValidationService.getInstance() : validationService;
			
			ModeledConstraintProvider modeledProvider = null;
			
			
			if ( provider.getClassName() == null ) {
				modeledProvider = new ModeledConstraintProvider();
				
				for ( Constraints constraints : provider.getConstraints() ) {
					for ( Constraint constraint : constraints.getConstraints()) {
						ModeledConstraintDescriptor descriptor = new ModeledConstraintDescriptor(provider.getPluginId(), classProvider);
						descriptor.setInitializationData(constraint);
						
						for ( Category category : constraints.getCategories() ) {
							CategoryManager.getInstance().getCategory(category.getPath()).addConstraint(descriptor);
							try {
								ConstraintRegistry.getInstance().register(descriptor);
							} catch (ConstraintExistsException e) {
								// TODO: log and throw exception
								throw new RuntimeException(e);
							}
						}
					}
				}
			} else {
				Class<?> clazz;
				try {
					clazz = classProvider.loadClass(provider.getClassName());
				} catch (ClassNotFoundException e) {
					// TODO: log and throw exception
					throw new RuntimeException(e);
				}
				
				if ( ModeledConstraintProvider.class.isAssignableFrom(clazz) ) {
					try {
						modeledProvider = (ModeledConstraintProvider) clazz.newInstance();
					} catch (InstantiationException e) {
						// TODO: log and throw exception
						throw new RuntimeException(e);
					} catch (IllegalAccessException e) {
						// TODO: log and throw exception
						throw new RuntimeException(e);
					}
				} else {
					// TODO: log and throw exception
				}
			}
			
			modeledProvider.setConstraintProviderModel(provider);
			validationServiceToBeUsed.registerProvider(new _ProviderDescriptor(
					modeledProvider));
			
			
		}
	}
	
	private Resource getResource(ResourceSet rs, URI uri) {
		if ( rs == null ) {
			// create a default one if none has been provided
			rs = new ResourceSetImpl();
		}
		
		Resource r = rs.getResource(uri, true);
		return r;
	}
	
	private static class _ProviderDescriptor implements IProviderDescriptor {

		private final ModeledConstraintProvider provider;

		public _ProviderDescriptor(ModeledConstraintProvider provider) {
			this.provider = provider;
		}
		
		public IModelConstraintProvider getProvider() {
			return provider;
		}

		public boolean isCache() {
			return false;
		}

		public boolean isCacheEnabled() {
			return false;
		}

		public boolean isXmlProvider() {
			return false;
		}

		public boolean provides(
				IProviderOperation<? extends Collection<? extends IModelConstraint>> operation) {
			if (operation instanceof GetLiveConstraintsOperation) {
				return providesLiveConstraints(operation);
			} else if (operation instanceof GetBatchConstraintsOperation) {
				return providesBatchConstraints(operation);
			}

			return false;

		}

		private boolean providesBatchConstraints(
				IProviderOperation<? extends Collection<? extends IModelConstraint>> operation) {
			if ( provider.isLive()) {
				return false;
			}
			
			GetBatchConstraintsOperation op = (GetBatchConstraintsOperation) operation;
			
			return provider.getModel().getPackage().contains(op.getEObject().eClass().getEPackage());
		}

		private boolean providesLiveConstraints(
				IProviderOperation<? extends Collection<? extends IModelConstraint>> operation) {
			if ( !provider.isLive()) {
				return false;
			}
			
			return false;
		}
		
	}
	
	
}
