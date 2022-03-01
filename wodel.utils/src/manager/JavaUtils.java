package manager;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.model.IWorkbenchAdapter;

import com.google.common.base.Charsets;

/**
 * @author Pablo Gomez-Abajo
 * 
 * Java code formatting
 * 
 */

public class JavaUtils {

	/**
	 * Removes comments from Java code
	 */
	private static CharSequence removeComments(CharSequence sequence) {
		List<String> comments = new ArrayList<String>();
		Pattern commentsPattern = Pattern.compile("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)");

        String text = sequence.toString();
        String noStrings = text.replaceAll("(\".*?(?<!\\\\)\")", "");
        Matcher commentsMatcher = commentsPattern.matcher(noStrings);

        while (commentsMatcher.find()) {
            String comment = commentsMatcher.group();
            if (!comments.contains(comment)) {
            	comments.add(comment);
            }
        }
        comments.sort((c1, c2) -> c2.length() - c1.length());
        
        for (String comment : comments) {
        	Pattern commentPattern = null;
        	if (comment.length() == 2) {
        		commentPattern = Pattern.compile(Pattern.quote(comment) + "\r?\n");
        	}
        	else {
        		commentPattern = Pattern.compile(Pattern.quote(comment));
        	}
        	Matcher commentMatcher = commentPattern.matcher(text);
        	text = commentMatcher.replaceAll("");
        }

        return text.replaceAll("(?m)^[ \t]*\r?\n", "");
	}
	
	/**
	 * Correct indentation for Java code
	 */
	public static CharSequence format(CharSequence sequence, boolean comments) {
		String code = null;
		if (comments == false) {
			code = removeComments(sequence).toString();
		}
		CodeFormatter codeFormatter = ToolFactory.createCodeFormatter(null);
		TextEdit textEdit = codeFormatter.format(CodeFormatter.K_COMPILATION_UNIT, // format a compilation unit
				code, // source to format
                0, // starting position
                code.length(), // length
                0, // initial indentation
                System.getProperty("line.separator") // line separator
		);
		IDocument doc = new Document(code);
		try {
        	textEdit.apply(doc);
        	return doc.get();
		} catch (MalformedTreeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private static void removeComments(IFile file) {
		try {
			InputStream is = file.getContents();
			InputStreamReader ir = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(ir);
			List<String> lines = new ArrayList<String>();
			String read = "";
			while ((read = br.readLine()) != null) {
				if (read.endsWith("\t\t//")) {
					lines.add(read.substring(0, read.indexOf("\t\t//")));
				}
			}
			br.close();
			is.close();
			is.close();
			String content = "";
			for (String line : lines) {
				content += line + "\n";
			}
			is = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
			file.delete(true, new NullProgressMonitor());
			file.create(is, true, new NullProgressMonitor());
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void removeComments(IFolder folder) {
		try {
			for (IResource resource : folder.members()) {
				if (resource instanceof IFile) {
					removeComments((IFile) resource);
				}
				if (resource instanceof IFolder) {
					removeComments((IFolder) resource);
				}
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void removeComments(IProject project) {
		try {
			IFolder folder = project.getFolder("src");
			for (IResource resource : folder.members()) {
				if (resource instanceof IFile) {
					removeComments((IFile) resource);
				}
				if (resource instanceof IFolder) {
					removeComments((IFolder) resource);
				}
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void addComments(IFile file) {
		try {
			InputStream is = file.getContents();
			InputStreamReader ir = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(ir);
			List<String> lines = new ArrayList<String>();
			String read = "";
			while ((read = br.readLine()) != null) {
				lines.add(read + "\t\t//");
			}
			br.close();
			is.close();
			is.close();
			String content = "";
			for (String line : lines) {
				content += line + "\n";
			}
			is = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
			file.delete(true, new NullProgressMonitor());
			file.create(is, true, new NullProgressMonitor());
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void addComments(IFolder folder) {
		try {
			for (IResource resource : folder.members()) {
				if (resource instanceof IFile) {
					addComments((IFile) resource);
				}
				if (resource instanceof IFolder) {
					addComments((IFolder) resource);
				}
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addComments(IProject project) {
		try {
			IFolder folder = project.getFolder("src");
			for (IResource resource : folder.members()) {
				if (resource instanceof IFile) {
					addComments((IFile) resource);
				}
				if (resource instanceof IFolder) {
					addComments((IFolder) resource);
				}
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void removeEmptyComments(File file) {
		try {
			if (file.isDirectory()) {
				for (File f : file.listFiles()) {
					removeEmptyComments(f);
				}
			}
			else {
				FileInputStream fis = new FileInputStream(file);
				InputStreamReader is = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(is);

				List<String> lines = new ArrayList<String>();
				String line = "";
				while ((line = br.readLine()) != null) {
					if (line.endsWith("//")) {
						line = line.substring(0, line.indexOf("//"));
						if (line.length() > 0) {
							lines.add(line);
						}
					}
					else {
						lines.add(line);
					}
				}
				br.close();
				is.close();
				fis.close();
				
				FileOutputStream fos = new FileOutputStream(file);
				OutputStreamWriter os = new OutputStreamWriter(fos);
				PrintWriter pw = new PrintWriter(os);
				
				for (String code : lines) {
					pw.println(code);
				}
				pw.flush();
				pw.close();
				os.close();
				fos.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void removeEmptyComments(String path) {
		File file = new File(path);
		removeEmptyComments(file);
	}
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}
