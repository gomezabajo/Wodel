package wodel.wodeltest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.modisco.java.generation.Messages;

public class MyGenerateJavaExtended extends MyGenerateJava {
	
	public boolean status = false;
	private static boolean[] st = new boolean[1];

	public MyGenerateJavaExtended() {
		super();
	}

	public MyGenerateJavaExtended(URI modelURI, File targetFolder,
			List<? extends Object> arguments) throws IOException {
		super(modelURI, targetFolder, arguments);
	}

	public MyGenerateJavaExtended(EObject model, File targetFolder,
			List<? extends Object> arguments) throws IOException {
		super(model, targetFolder, arguments);
	}
	
	public MyGenerateJavaExtended(Resource resource, File targetFolder,
			List<? extends Object> arguments, boolean serialized) throws IOException {
		super(resource, targetFolder, arguments, serialized, st);
		status = st[0];
	}

	@Override
	public void doGenerate(Monitor monitor) throws IOException {
		super.doGenerate(monitor);

		// apply default java code formatting to generated files
		if (monitor != null) {
			monitor.setTaskName(Messages.Generate_JavaStructures_0);
		}
		MyJavaUtils.formatJavaCode(this.targetFolder);
	}

	/**
	 * This can be used to launch the generation from a standalone application.
	 *
	 * @param args
	 *            Arguments of the generation.
	 */
	public static void main(String[] args) {
		try {
			if (args.length < 2) {
				System.out.println(org.eclipse.modisco.java.generation.files.Messages.GenerateJava_0);
			} else {
				URI modelURI = URI.createFileURI(args[0]);
				File folder = new File(args[1]);
				List<String> arguments = new ArrayList<String>();
				for (int i = 2; i < args.length; i++) {
					arguments.add(args[i]);
				}
				MyGenerateJavaExtended generator = new MyGenerateJavaExtended(modelURI, folder, arguments);
				generator.doGenerate(new BasicMonitor());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

