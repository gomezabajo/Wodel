package es.main.generators

import generator.Intent
import generator.RegexInput
import generator.Entity
import generator.SimpleInput
import java.io.File
import java.io.BufferedWriter
import java.io.FileWriter
import org.eclipse.emf.ecore.resource.Resource
import java.io.FileInputStream
import zipUtils.Zipper
import es.main.CongaResource
import java.io.OutputStreamWriter
import java.io.FileOutputStream
import java.nio.charset.StandardCharsets

abstract class BotGenerator {
	public static final int REGEX = 0;
	public static final int SIMPLE = 1;
	public static final int COMPOSITE = 2;
	public static final int TRAINING = 3;

	String path;
	Zipper zip;

	new(String path, String botName) {
		this.path = path
		this.zip = new Zipper(path, botName);
	}

	abstract def File doGenerate(Resource resource);

	def intentType(Intent intent) {
		var input = intent.inputs.get(0)
		if (input.inputs.get(0) instanceof RegexInput) {
			return REGEX
		} else {
			return TRAINING
		}
	}

	def entityType(Entity entity) {
		if (entity !== null) {
			var input = entity.inputs.get(0)
			if (input.inputs.get(0) instanceof RegexInput) {
				return REGEX
			} else if (input.inputs.get(0) instanceof SimpleInput) {
				return SIMPLE
			} else {
				return COMPOSITE
			}
		}
	}

	def close() {
		zip.close

		var file = new File(path);
		var contents = file.listFiles;
		if (contents !== null) {
			for (f : contents) {
				if (!f.equals(zip.file)) {
					removeFile(f)
				}
			}
		}

		CongaResource.remove.add(file)

	}

	def void removeFile(File file) {
		var contents = file.listFiles();
		if (contents !== null) {
			for (File f : contents) {
				removeFile(f);
			}
		}
		file.delete();
	}

	def File getZipFile() {
		return zip.file
	}

	def File generateFile(String fileName, CharSequence content) {
		var newName = fileName.replace(":", "").replace("*", "")
		.replace("?", "").replace("\"", "").replace("<", "").replace(">", "").replace("|", "")
		generateFile(newName, content.toString)
	}

	def File generateFile(String fileName, String content) {
		var file = new File(path + File.separator + fileName);
		if (file.exists) {
			file.delete();
		}
		var folder = file.parentFile
		if (folder !== null && !folder.exists) {
			folder.mkdirs
		}
		
		var bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
		bw.write(content);
		bw.close
		return file
	}

//	def File generateFolder(String fileName) {
//		var file = new File(path +File.separator +fileName);
//		if (!file.exists) {
//			file.mkdirs();
//		}
//		return file;
//	}
	def void saveFileIntoZip(File f, String name) {
		var packageValue = new FileInputStream(f);
		zip.addFile(name, packageValue)
		packageValue.close
	}

	def void saveFileIntoZip(File f, String folder, String name) {
		var packageValue = new FileInputStream(f);
		zip.addFileToFolder(folder, name, packageValue)
		packageValue.close
	}
}
