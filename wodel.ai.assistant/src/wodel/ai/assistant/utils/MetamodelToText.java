package wodel.ai.assistant.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class MetamodelToText {

	private EPackage metamodel;
	private String strMetamodelDescription;

	public MetamodelToText()
	{
		strMetamodelDescription="";
	}
	public boolean loadMM(String ecoreFilePath)
	{
		boolean bRet;

		bRet =  true;

		metamodel = loadMetamodel(ecoreFilePath);

		if (metamodel != null) {
			// Explorar y describir el metamodelo
			strMetamodelDescription = generateMetamodelDescription();
		} else {
			bRet = false;
			System.out.println("Error al cargar el metamodelo.");
		}
		return bRet;
	}

	public String getMetamodelDescription()
	{
		return strMetamodelDescription;
	}
	
	public static EPackage loadMetamodel(String path) {
		// Configuración del EMF para cargar recursos XMI (como archivos .ecore)
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());

		// Crear un ResourceSet y cargar el recurso
		ResourceSet resourceSet = new ResourceSetImpl();
		URI fileURI = URI.createFileURI(path);
		Resource resource = resourceSet.getResource(fileURI, true);

		try {
			resource.load(null);
			return (EPackage) resource.getContents().get(0); // Obtener el EPackage raíz
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Método para generar la descripción textual del metamodelo y almacenarla en una variable
	private String generateMetamodelDescription() {
		if (metamodel == null) {
			return "Error loading the metamodel.";
		}

		StringBuilder descriptionBuilder = new StringBuilder();
		descriptionBuilder.append("Metamodel: ").append(metamodel.getName()).append("\n");

		for (EClassifier classifier : metamodel.getEClassifiers()) {
			if (classifier instanceof EClass) {
				EClass eClass = (EClass) classifier;
				descriptionBuilder.append("  Class: ").append(eClass.getName()).append("\n");

				for (EAttribute attr : eClass.getEAttributes()) {
					descriptionBuilder.append("    Attribute: ").append(attr.getName())
					.append(" (Type: ").append(attr.getEType().getName()).append(")\n");
				}

				for (EReference ref : eClass.getEReferences()) {
					descriptionBuilder.append("    Reference: ").append(ref.getName())
					.append(" -> ").append(ref.getEType().getName())
					.append(" (Multiplicity: ").append(ref.getLowerBound())
					.append("..").append(ref.getUpperBound()).append(")\n");
				}
			}
		}
		return descriptionBuilder.toString();
	}
	
	public String loadModelAsString(String path) {
		return AssistantUtils.loadModelAsString(path);
	}
}
