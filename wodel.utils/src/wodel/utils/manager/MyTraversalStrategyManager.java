package wodel.utils.manager;

/******************************************************************************
 * Copyright (c) 2004, 2014 IBM Corporation, Zeligsoft Inc., CEA, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 *    Zeligsoft - Bug 137213
 *    SAP AG - Bug 240352
 *    Christian W. Damus (CEA) - bug 433050
 *    
 ****************************************************************************/


import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.dynamichelpers.ExtensionTracker;
import org.eclipse.core.runtime.dynamichelpers.IExtensionChangeHandler;
import org.eclipse.core.runtime.dynamichelpers.IExtensionTracker;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.validation.internal.EMFModelValidationPlugin;
import org.eclipse.emf.validation.internal.EMFModelValidationStatusCodes;
import org.eclipse.emf.validation.internal.util.Log;
import org.eclipse.emf.validation.service.ITraversalStrategy;


/**
 * Central access point for dynamically contributed traversal strategies
 * (provided by plug-ins via the <tt>traversal</tt> extension point).
 * The <code>TraversalStrategyManager</code> maps an element that is to be
 * validated to the {@link ITraversalStrategy} implementation that traverses
 * its sub-tree (in batch validation).
 *
 * @author Christian W. Damus (cdamus)
 * 
 * @see org.eclipse.emf.validation.service.ITraversalStrategy
 * @see org.eclipse.emf.validation.service.IBatchValidator
 */
class MyTraversalStrategyManager {
	private static final String TRAVERSAL_EXT_P_NAME = "traversal"; //$NON-NLS-1$
	private static final String E_TRAVERSAL_STRATEGY = "traversalStrategy"; //$NON-NLS-1$
	private static final String A_NAMESPACE_URI = "namespaceUri"; //$NON-NLS-1$
	private static final String A_CLASS = "class"; //$NON-NLS-1$
	private static final String E_ECLASS = "eclass"; //$NON-NLS-1$
	private static final String A_NAME = "name"; //$NON-NLS-1$
	
	private static final MyTraversalStrategyManager INSTANCE =
		new MyTraversalStrategyManager();
	
	private volatile Map<String, Descriptor> packageDescriptors =
	    new java.util.HashMap<String, Descriptor>();

	private final Object traversalsLock = new Object();

	private final IExtensionChangeHandler extensionHandler = new IExtensionChangeHandler() {

		public void addExtension(IExtensionTracker tracker, IExtension extension) {
			registerTraversals(extension.getConfigurationElements());
		}

		public void removeExtension(IExtension extension, Object[] objects) {
			// traversal strategies cannot be undefined
		}
	};
	
	/**
	 * Not instantiated by clients.
	 */
	private MyTraversalStrategyManager() {
		initStrategies();
	}
	
	/**
	 * Obtains the singleton instance of the class.
	 * 
	 * @return the singleton instance
	 */
	public static MyTraversalStrategyManager getInstance() {
		return INSTANCE;
	}
	
	/**
	 * Obtains the traversal strategy appropriate for batch validation of the
	 * specified <code>eObject</code>.  This traversal strategy may be a custom
	 * strategy provided through the <tt>traversal</tt> extension point, or
	 * it may be the default strategy that simply recurses over the entire
	 * content tree.
	 * 
	 * @param eObject the eObject that is a validation root
	 * @return the appropriate traversal strategy for it
	 */
	public ITraversalStrategy getTraversalStrategy(EObject eObject) {
		EObject root = EcoreUtil.getRootContainer(eObject);
		EPackage ePackage = root.eClass().getEPackage();
		
		return getDescriptor(ePackage).getStrategy(root);
	}

	/**
	 * Initializes the traversal strategies contributed by plug-ins.
	 * The traversal strategy manager ensures that plug-in code is only
	 * invoked (i.e., traversal strategy implementations instantiated) when
	 * required by a validation operation.
	 */
	private void initStrategies() {
		if ( EMFPlugin.IS_ECLIPSE_RUNNING) {
			IExtensionPoint extPoint = Platform.getExtensionRegistry()
				.getExtensionPoint("org.eclipse.emf.validation",
					TRAVERSAL_EXT_P_NAME);
			
			IExtensionTracker extTracker = EMFModelValidationPlugin
				.getExtensionTracker();
			
			if (extTracker != null) {
				extTracker.registerHandler(extensionHandler, ExtensionTracker
					.createExtensionPointFilter(extPoint));
				
				for (IExtension extension : extPoint.getExtensions()) {
					extensionHandler.addExtension(extTracker, extension);
				}
			}
		}
	}
	
	private void registerTraversals(IConfigurationElement[] configs) {
		synchronized (traversalsLock) {
			// copy on write
			packageDescriptors = new java.util.HashMap<String, Descriptor>(
				packageDescriptors);
			
			for (int i = 0; i < configs.length; i++) {
				IConfigurationElement config = configs[i];
				
				if (config.getName().equals(E_TRAVERSAL_STRATEGY)) {
					addStrategy(config);
				}
			}
		}
	}
	
	/**
	 * Adds the strategy contributed in the specified plug-in
	 * <code>config</code>uration element.
	 * 
	 * @param config the traversal strategy contribution of a plug-in
	 */
	private void addStrategy(IConfigurationElement config) {
		String nsUri = config.getAttribute(A_NAMESPACE_URI);
		String className = config.getAttribute(A_CLASS);
		
		if (nsUri == null) {
			Log.warningMessage(
				EMFModelValidationStatusCodes.TRAVERSAL_NO_NAMESPACE_URI,
				EMFModelValidationStatusCodes.TRAVERSAL_NO_NAMESPACE_URI_MSG,
				new Object[] {config.getDeclaringExtension().getNamespaceIdentifier()});
		} else if (className == null) {
			Log.warningMessage(
				EMFModelValidationStatusCodes.TRAVERSAL_NO_CLASS,
				EMFModelValidationStatusCodes.TRAVERSAL_NO_CLASS_MSG,
				new Object[] {nsUri});
		} else {
			Descriptor descriptor = getDescriptor(nsUri);
			
			descriptor.addTraversalStrategy(config);
		}
	}
	
	/**
	 * Obtains the EPackage descriptor for the specified namespace URI.
	 * The descriptor has all of the plug-in extension configuration data
	 * required to create traversal strategies for the indicated package.
	 * <p>
	 * This method must only be called under synchronization on the {@code traversalsLock}.
	 * 
	 * @param nsUri the namespace URI of an EPackage
	 * @return the corresponding descriptor
	 */
	private Descriptor getDescriptor(String nsUri) {
		Descriptor result = packageDescriptors.get(nsUri);
		
		if (result == null) {
			result = new Descriptor(nsUri);
			packageDescriptors.put(nsUri, result);
		}
		
		return result;
	}
	
	private Descriptor getDescriptor(EPackage ePackage) {
		Descriptor result;
		
		synchronized(traversalsLock) {
			final String nsURI = ePackage.getNsURI();
			result = packageDescriptors.get(nsURI);
			
			if (result == null) {
				result = new Descriptor(nsURI);
				packageDescriptors.put(nsURI, result);
			
				// we just created the descriptor for this package. Is
				// this package locally defined in some resource set? If
				// so, we must remove the descriptor and its EClass
				// cache when it is unloaded
				Resource resource = ePackage.eResource();
				if (resource != null) {
					ResourceSet rset = resource.getResourceSet();
					if ((rset != null) && (rset.getPackageRegistry().getEPackage(nsURI) == ePackage)) {
						ePackage.eAdapters().add(new DescriptorRemover(nsURI));
					}
				}
			}
		}
		
		return result;
	}
	
	/**
	 * A descriptor for an EPackage that has all of the information required
	 * to create traversal strategies for instances of its EClasses.
	 *
	 * @author Christian W. Damus (cdamus)
	 */
	private static class Descriptor {
		private final String nsUri;
		private Map<Object, ThreadLocal<ITraversalStrategy>> eclassMap =
		    new java.util.HashMap<Object, ThreadLocal<ITraversalStrategy>>();
		private ThreadLocal<ITraversalStrategy> packageDefaultStrategy;
		private boolean isResolved;
		
		/**
		 * The namespace URI of the EPackage that I handle.
		 * 
		 * @param nsUri my EPackage's namespace URI
		 */
		Descriptor(String nsUri) {
			this.nsUri = nsUri;
		}
		
		/**
		 * Obtains the namespace URI of the EPackage that I handle.
		 * 
		 * @returnmy EPackage's namespace URI
		 */
		final String getNamespaceUri() {
			return nsUri;
		}
		
		/**
		 * Determines whether <code>other</code> is a descriptor for the
		 * same EPackage as me. 
		 */
		@Override
        public boolean equals(Object other) {
			return (other instanceof Descriptor) && 
				getNamespaceUri().equals(
					((Descriptor)other).getNamespaceUri());
		}
		
		// overrides the inherited implementation
		@Override
        public int hashCode() {
			return getNamespaceUri().hashCode();
		}
		
		/**
		 * Adds a traversal strategy for the EPackage that I handle.
		 * This method will not add traversal strategies for EClasses that
		 * already have one defined, and likewise for the package's default.
		 * 
		 * @param config the extension point data for the traversal strategy
		 */
		void addTraversalStrategy(IConfigurationElement config) {
			IConfigurationElement[] eclasses = config.getChildren(E_ECLASS);

            ThreadLocal<ITraversalStrategy> strategy =
                new ThreadLocalLazyStrategy(config);
			
			if ((eclasses.length == 0) && (packageDefaultStrategy == null)) {
				// can only have one wildcard strategy
				packageDefaultStrategy = strategy;
			} else {
				for (int i = 0; i < eclasses.length; i++) {
					IConfigurationElement next = eclasses[i];
					String eclassName = next.getAttribute(A_NAME);
					
					if (!eclassMap.containsKey(eclassName)) {
						// take the first one registered against a name
						eclassMap.put(eclassName, strategy);
					}
				}
			}
		}
		
		/**
		 * Resolves all of my eclass names to EClass instances in the specified
		 * package.
		 * 
		 * @param ePackage the EPackage that I provide traversal strategies for
		 */
		private void resolve(EPackage ePackage) {
			isResolved = true;
			
			Map<Object, ThreadLocal<ITraversalStrategy>> newMap =
			    new java.util.HashMap<Object, ThreadLocal<ITraversalStrategy>>();
			
			for (Map.Entry<Object, ThreadLocal<ITraversalStrategy>> next : eclassMap.entrySet()) {
				String eclassName = (String)next.getKey();
				
				EClassifier eclass = ePackage.getEClassifier(eclassName);
				if (eclass instanceof EClass) {
					newMap.put(eclass, next.getValue());
				} else {
					// not a valid eclass
					Log.warningMessage(
						EMFModelValidationStatusCodes.TRAVERSAL_ECLASS,
						EMFModelValidationStatusCodes.TRAVERSAL_ECLASS_MSG,
						new Object[] {eclassName, ePackage.getNsURI()});
				}
			}
			
			eclassMap = newMap;
		}
		
		/**
		 * Obtains the particular traversal strategy for the specified model
		 * element.  This strategy will either be one that is declared by an
		 * extension for the element's EClass (or a superclass thereof), or
		 * the default for the package.  The default package default is the
		 * basic eContents recursion strategy.
		 * 
		 * @param eObject the model element
		 * @return the most appropriate traversal strategy available
		 */
		ITraversalStrategy getStrategy(EObject eObject) {
			EClass eclass = eObject.eClass();
			
			synchronized (this) {
    			if (!isResolved) {
    				resolve(eclass.getEPackage());
    			}
    			
    			ThreadLocal<ITraversalStrategy> strategy = eclassMap.get(eclass);
				
    			if (strategy == null) {
    				strategy = inheritStrategy(eclass);
    				eclassMap.put(eclass, strategy);
    			}
                
                return strategy.get();
			}
		}
		
		/**
		 * Inherits the traversal strategy for the specified <code>eclass</code>
		 * from one of its ancestors (searched left-to-right, depth-first), if
		 * available.  If no inherited strategy is found, then the package's
		 * default is used.
		 * 
		 * @param eclass the eclass to find an inherited traversal strategy for
		 * @return the inherited strategy, or the package's default, if none
		 *     better is found
		 */
		private ThreadLocal<ITraversalStrategy> inheritStrategy(EClass eclass) {
		    ThreadLocal<ITraversalStrategy> result = getInheritedStrategy(eclass);
			
			if (result == null) {
				// use the wildcard strategy
				if (packageDefaultStrategy == null) {
					// default wildcard strategy
					packageDefaultStrategy = new ThreadLocalLazyStrategy();
				}
				
				result = packageDefaultStrategy;
			}
			
			return result;
		}
		
		/**
		 * Searches depth-first and left-to-right in the inheritance
		 * hierarchy for a strategy that is inherited by the specified
		 * <code>eclass</code>.
		 * 
		 * @param eclass an EClass
		 * @return the inherited strategy, or <code>null</code> if none was
		 *     provided by any extension point
		 */
		private ThreadLocal<ITraversalStrategy> getInheritedStrategy(EClass eclass) {
		    ThreadLocal<ITraversalStrategy> result = null;
			
			for (Iterator<EClass> iter = eclass.getESuperTypes().iterator();
					(result == null) && iter.hasNext();) {
				
				EClass next = iter.next();
				
				if (eclassMap.containsKey(next)) {
					result = eclassMap.get(next);
				} else {
					result = getInheritedStrategy(next);
				}
			}
			
			return result;
		}
		
		/**
		 * Initializes the traversal strategy implementation declared by the
		 * specified <code>config</code>uration element.  This is only done
		 * when the strategy is actually needed to perform a validation.
		 * 
		 * @param config the traversal strategy extension declaration
		 * @return the traversal strategy declared by the <code>config</code>,
		 *    or the default eContents recursion strategy if a problem occurred
		 *    in instantiating it
		 */
		private ITraversalStrategy initializeStrategy(IConfigurationElement config) {
			ITraversalStrategy result;
			
			try {
				result = (ITraversalStrategy)config.createExecutableExtension(A_CLASS);
			} catch (ClassCastException e) {
				Log.errorMessage(
					EMFModelValidationStatusCodes.TRAVERSAL_INTERFACE,
					EMFModelValidationStatusCodes.TRAVERSAL_INTERFACE_MSG,
					new Object[] {config.getAttribute(A_CLASS)});
				result = new ITraversalStrategy.Recursive();
			} catch (CoreException e) {
				Log.log(e.getStatus());
				result = new ITraversalStrategy.Recursive();
			}
			
			// replace all ocurrences of the configuration element with the
			//   newly instantiated traversal strategy for future look-ups
			if (packageDefaultStrategy != null) {
			    ((ThreadLocalLazyStrategy) packageDefaultStrategy).preinitialize(result, config);
			}
			
			for (Object next : eclassMap.values()) {
				((ThreadLocalLazyStrategy) next).preinitialize(result, config);
			}
			
			return result;
		}
		
		private class ThreadLocalLazyStrategy extends ThreadLocal<ITraversalStrategy> {
		    private final IConfigurationElement config;
            
            ThreadLocalLazyStrategy() {
                this(null);  // used only for the package default strategy
            }
		    
		    ThreadLocalLazyStrategy(IConfigurationElement config) {
		        this.config = config;
		    }
		    
		    @Override
            protected ITraversalStrategy initialValue() {
		        return (config == null)? new ITraversalStrategy.Recursive() :
		            initializeStrategy(config);
		    }
		    
		    void preinitialize(ITraversalStrategy strategy, IConfigurationElement config) {
		        if (config == this.config) {
		            set(strategy);
		        }
		    }
		}
	}
	
	/**
	 * An adapter that removes the descriptor for a dynamic EPackage when that EPackage is unloaded.
	 */
	private class DescriptorRemover extends AdapterImpl {
		private final String nsURI;
		
		DescriptorRemover(String nsURI) {
			this.nsURI = nsURI;
		}
		
		@Override
		public void unsetTarget(Notifier oldTarget) {
			super.unsetTarget(oldTarget);

			Descriptor descriptor;
			
			// my EPackage was unloaded.  Purge its descriptor
			synchronized(traversalsLock) {
				descriptor = packageDescriptors.remove(nsURI);
			}
			
			// Remove the thread-locals as well as we can
			if (descriptor != null) {
				if (descriptor.eclassMap != null) {
					for (ThreadLocal<?> next : descriptor.eclassMap.values()) {
						next.remove();
					}
					descriptor.eclassMap.clear();
				}
				
				if (descriptor.packageDefaultStrategy != null) {
					descriptor.packageDefaultStrategy.remove();
				}
			}
		}
	}
}
