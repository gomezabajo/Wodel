package efinder.ocl.ui;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS;
import org.eclipse.ocl.xtext.completeoclcs.DefCS;

import efinder.ocl.ui.ConstraintsContentProvider.InvariantData;
import efinder.ocl.ui.emf.OclEMFUtils;

public class OclDocumentData {
	private CompleteOCLDocumentCS doc;
	private List<InvariantData> invs;
	private List<DefCS> operations;

	public OclDocumentData(CompleteOCLDocumentCS doc) {
		this.doc = doc;
		this.invs = OclEMFUtils.getInvariants(doc).stream().map(InvariantData::new).collect(Collectors.toList());
		this.operations = OclEMFUtils.getOperations(doc);
	}
	
	public List<InvariantData> getInvariants() {
		return invs;
	}

	public List<DefCS> getOperations() {
		return operations;
	}
	
	public CompleteOCLDocumentCS getDoc() {
		return doc;
	}
}