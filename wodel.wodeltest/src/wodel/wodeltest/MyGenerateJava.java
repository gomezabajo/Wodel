package wodel.wodeltest;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.eclipse.acceleo.common.IAcceleoConstants;
import org.eclipse.acceleo.common.internal.utils.AcceleoPackageRegistry;
import org.eclipse.acceleo.model.mtl.Module;
import org.eclipse.acceleo.model.mtl.resource.AcceleoResourceSetImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.modisco.java.generation.files.GenerateJava;

public class MyGenerateJava extends GenerateJava {
	
	/**
	 * Allows the public constructor to be used. Note that a generator created
	 * this way cannot be used to launch generations before one of
	 * {@link #initialize(EObject, File, List)} or
	 * {@link #initialize(URI, File, List)} is called.
	 * <p>
	 * The main reason for this constructor is to allow clients of this
	 * generation to call it from another Java file, as it allows for the
	 * retrieval of {@link #getProperties()} and
	 * {@link #getGenerationListeners()}.
	 * </p>
	 *
	 * @generated
	 */
	public MyGenerateJava() {
		super();
    }
	
	/**
	 * This allows clients to instantiates a generator with all required information.
	 *
	 * @param modelURI
	 *            URI where the model on which this generator will be used is located.
	 * @param targetFolder
	 *            This will be used as the output folder for this generation : it will be the base path
	 *            against which all file block URLs will be resolved.
	 * @param arguments
	 *            If the template which will be called requires more than one argument taken from the model,
	 *            pass them here.
	 * @throws IOException
	 *             This can be thrown in three scenarios : the module cannot be found, it cannot be loaded, or
	 *             the model cannot be loaded.
	 * @generated
	 */
	public MyGenerateJava(URI modelURI, File targetFolder,
			List<? extends Object> arguments) throws IOException {
        super(modelURI, targetFolder, arguments);
    }

	/**
	 * This allows clients to instantiates a generator with all required information.
	 *
	 * @param model
	 *            We'll iterate over the content of this element to find Objects matching the first parameter
	 *            of the template we need to call.
	 * @param targetFolder
	 *            This will be used as the output folder for this generation : it will be the base path
	 *            against which all file block URLs will be resolved.
	 * @param arguments
	 *            If the template which will be called requires more than one argument taken from the model,
	 *            pass them here.
	 * @throws IOException
	 *             This can be thrown in two scenarios : the module cannot be found, or it cannot be loaded.
	 * @generated
	 */
	public MyGenerateJava(EObject model, File targetFolder,
			List<? extends Object> arguments) throws IOException {
        super(model, targetFolder, arguments);
    }


	/**
	 * This allows clients to instantiates a generator with all required information.
	 *
	 * @param model
	 *            We'll iterate over the content of this element to find Objects matching the first parameter
	 *            of the template we need to call.
	 * @param targetFolder
	 *            This will be used as the output folder for this generation : it will be the base path
	 *            against which all file block URLs will be resolved.
	 * @param arguments
	 *            If the template which will be called requires more than one argument taken from the model,
	 *            pass them here.
	 * @throws IOException
	 *             This can be thrown in two scenarios : the module cannot be found, or it cannot be loaded.
	 * @generated
	 */
	public MyGenerateJava(Resource model, File targetFolder,
			List<? extends Object> arguments, boolean serialized, boolean[] status) throws IOException {
        status[0] = initialize(model, targetFolder, arguments, serialized);
    }
	
	/**
	 * This will initialize all required information for this generator.
	 * 
	 * @param resource
	 *            Loaded model.
	 * @param folder
	 *            This will be used as the output folder for this generation : it will be the base path
	 *            against which all file block URLs will be resolved.
	 * @param arguments
	 *            If the template which will be called requires more than one argument taken from the model,
	 *            pass them here.
	 * @throws IOException
	 *             This can be thrown in three scenarios : the module cannot be found, it cannot be loaded, or
	 *             the model cannot be loaded.
	 */
	public boolean initialize(Resource resource, File folder, List<?> arguments, boolean serialized) throws IOException {
		ResourceSet modulesResourceSet = new AcceleoResourceSetImpl();
		modulesResourceSet.setPackageRegistry(AcceleoPackageRegistry.INSTANCE);

		URIConverter uriConverter = createURIConverter();
		if (uriConverter != null) {
			modulesResourceSet.setURIConverter(uriConverter);
		}

		Map<URI, URI> uriMap = EcorePlugin.computePlatformURIMap();

		// make sure that metamodel projects in the workspace override those in plugins
		modulesResourceSet.getURIConverter().getURIMap().putAll(uriMap);

		registerResourceFactories(modulesResourceSet);
		registerPackages(modulesResourceSet);

		ResourceSet modelResourceSet = new AcceleoResourceSetImpl();
		modelResourceSet.setPackageRegistry(AcceleoPackageRegistry.INSTANCE);
		if (uriConverter != null) {
			modelResourceSet.setURIConverter(uriConverter);
		}

		// make sure that metamodel projects in the workspace override those in plugins
		modelResourceSet.getURIConverter().getURIMap().putAll(uriMap);

		registerResourceFactories(modelResourceSet);
		registerPackages(modelResourceSet);

		addListeners();
		addProperties();

		String moduleName = getModuleName();
		if (moduleName.endsWith('.' + IAcceleoConstants.MTL_FILE_EXTENSION)) {
			moduleName = moduleName.substring(0, moduleName.lastIndexOf('.'));
		}
		if (!moduleName.endsWith('.' + IAcceleoConstants.EMTL_FILE_EXTENSION)) {
			moduleName += '.' + IAcceleoConstants.EMTL_FILE_EXTENSION;
		}

		URL moduleURL = findModuleURL(moduleName);

		if (moduleURL == null) {
			throw new IOException("'" + getModuleName() + ".emtl' not found"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		URI moduleURI = createTemplateURI(moduleURL.toString());
		moduleURI = URI.createURI(moduleURI.toString(), true);
		module = (Module) MyModelUtils.load(moduleURI, modulesResourceSet);
		
		model = MyModelUtils.load(resource, serialized);
		if (model == null) {
			return false;
		}
		targetFolder = folder;
		generationArguments = arguments;

		this.postInitialize();
		return true;
	}

}
