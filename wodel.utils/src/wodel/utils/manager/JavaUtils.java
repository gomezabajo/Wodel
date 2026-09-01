package wodel.utils.manager;

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
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;

/**
 * Java utility methods.
 *
 * Provides support for formatting generated Java source code
 * and handling temporary empty-comment markers.
 *
 * @author Pablo Gomez-Abajo
 */
public final class JavaUtils {

    private static final String EMPTY_COMMENT_MARKER = "\t\t//";

    private JavaUtils() {
        // Utility class.
    }

    /**
     * Removes Java line and block comments while preserving strings
     * and character literals.
     *
     * @param sequence Java source code
     * @return source code without comments
     */
    private static CharSequence removeComments(CharSequence sequence) {
        if (sequence == null) {
            return "";
        }

        String source = sequence.toString();
        StringBuilder result = new StringBuilder(source.length());

        boolean inString = false;
        boolean inChar = false;
        boolean inLineComment = false;
        boolean inBlockComment = false;
        boolean escaped = false;

        for (int i = 0; i < source.length(); i++) {
            char current = source.charAt(i);
            char next = i + 1 < source.length()
                    ? source.charAt(i + 1)
                    : '\0';

            if (inLineComment) {
                if (current == '\n') {
                    inLineComment = false;
                    result.append(current);
                }
                continue;
            }

            if (inBlockComment) {
                if (current == '*' && next == '/') {
                    inBlockComment = false;
                    i++;
                } else if (current == '\n') {
                    // Keep line structure.
                    result.append(current);
                }
                continue;
            }

            if (inString) {
                result.append(current);

                if (escaped) {
                    escaped = false;
                } else if (current == '\\') {
                    escaped = true;
                } else if (current == '"') {
                    inString = false;
                }

                continue;
            }

            if (inChar) {
                result.append(current);

                if (escaped) {
                    escaped = false;
                } else if (current == '\\') {
                    escaped = true;
                } else if (current == '\'') {
                    inChar = false;
                }

                continue;
            }

            if (current == '"') {
                inString = true;
                result.append(current);
                continue;
            }

            if (current == '\'') {
                inChar = true;
                result.append(current);
                continue;
            }

            if (current == '/' && next == '/') {
                inLineComment = true;
                i++;
                continue;
            }

            if (current == '/' && next == '*') {
                inBlockComment = true;
                i++;
                continue;
            }

            result.append(current);
        }

        return result.toString()
                .replaceAll("(?m)^[ \\t]*\\r?\\n", "");
    }

    /**
     * Formats Java source code using the Eclipse JDT formatter.
     *
     * @param sequence source code
     * @param comments true to preserve and format comments;
     *                 false to remove comments
     * @return formatted Java source code
     */
    public static CharSequence format(
            CharSequence sequence,
            boolean comments) {

        if (sequence == null) {
            return null;
        }

        String code = sequence.toString();

        if (!comments) {
            code = removeComments(code).toString();
        }

        CodeFormatter formatter =
                ToolFactory.createCodeFormatter(null);

        int kind = CodeFormatter.K_COMPILATION_UNIT;

        if (comments) {
            kind |= CodeFormatter.F_INCLUDE_COMMENTS;
        }

        TextEdit edit = formatter.format(
                kind,
                code,
                0,
                code.length(),
                0,
                System.lineSeparator());

        /*
         * CodeFormatter.format() returns null if JDT cannot
         * format the supplied source. In that case, keep the
         * original source rather than breaking code generation.
         */
        if (edit == null) {
            return code;
        }

        IDocument document = new Document(code);

        try {
            edit.apply(document);
            return document.get();
        } catch (MalformedTreeException | BadLocationException e) {
            e.printStackTrace();
            return code;
        }
    }

    /**
     * Removes temporary empty-comment markers from an Eclipse file.
     */
    private static void removeComments(IFile file) {
        if (file == null || !file.exists() ||
                !"java".equalsIgnoreCase(file.getFileExtension())) {
            return;
        }

        try (
            InputStream input = file.getContents();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            input,
                            StandardCharsets.UTF_8))
        ) {

            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {

                if (line.endsWith(EMPTY_COMMENT_MARKER)) {
                    line = line.substring(
                            0,
                            line.length()
                                    - EMPTY_COMMENT_MARKER.length());
                }

                content.append(line)
                       .append(System.lineSeparator());
            }

            try (InputStream newContents =
                    new ByteArrayInputStream(
                            content.toString().getBytes(
                                    StandardCharsets.UTF_8))) {

                file.setContents(
                        newContents,
                        IResource.FORCE,
                        new NullProgressMonitor());
            }

        } catch (IOException | CoreException e) {
            e.printStackTrace();
        }
    }

    /**
     * Recursively removes temporary empty-comment markers.
     */
    private static void removeComments(IFolder folder) {
        if (folder == null || !folder.exists()) {
            return;
        }

        try {
            for (IResource resource : folder.members()) {

                if (resource instanceof IFile) {
                    removeComments((IFile) resource);

                } else if (resource instanceof IFolder) {
                    removeComments((IFolder) resource);
                }
            }

        } catch (CoreException e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes temporary empty-comment markers from Java files
     * contained in the project's src folder.
     */
    public static void removeComments(IProject project) {
        if (project == null || !project.exists()) {
            return;
        }

        IFolder sourceFolder = project.getFolder("src");

        if (sourceFolder.exists()) {
            removeComments(sourceFolder);
        }
    }

    /**
     * Adds temporary empty-comment markers to an Eclipse Java file.
     */
    private static void addComments(IFile file) {
        if (file == null || !file.exists() ||
                !"java".equalsIgnoreCase(file.getFileExtension())) {
            return;
        }

        try (
            InputStream input = file.getContents();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            input,
                            StandardCharsets.UTF_8))
        ) {

            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {

                if (!line.endsWith(EMPTY_COMMENT_MARKER)) {
                    line += EMPTY_COMMENT_MARKER;
                }

                content.append(line)
                       .append(System.lineSeparator());
            }

            try (InputStream newContents =
                    new ByteArrayInputStream(
                            content.toString().getBytes(
                                    StandardCharsets.UTF_8))) {

                file.setContents(
                        newContents,
                        IResource.FORCE,
                        new NullProgressMonitor());
            }

        } catch (IOException | CoreException e) {
            e.printStackTrace();
        }
    }

    /**
     * Recursively adds temporary empty-comment markers.
     */
    private static void addComments(IFolder folder) {
        if (folder == null || !folder.exists()) {
            return;
        }

        try {
            for (IResource resource : folder.members()) {

                if (resource instanceof IFile) {
                    addComments((IFile) resource);

                } else if (resource instanceof IFolder) {
                    addComments((IFolder) resource);
                }
            }

        } catch (CoreException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds temporary empty-comment markers to Java files
     * contained in the project's src folder.
     */
    public static void addComments(IProject project) {
        if (project == null || !project.exists()) {
            return;
        }

        IFolder sourceFolder = project.getFolder("src");

        if (sourceFolder.exists()) {
            addComments(sourceFolder);
        }
    }

    /**
     * Removes temporary empty-comment markers from generated
     * Java files on the filesystem.
     */
    private static void removeEmptyComments(File file) {
        if (file == null || !file.exists()) {
            return;
        }

        if (file.isDirectory()) {

            File[] children = file.listFiles();

            if (children != null) {
                for (File child : children) {
                    removeEmptyComments(child);
                }
            }

            return;
        }

        if (!file.getName().toLowerCase().endsWith(".java")) {
            return;
        }

        try (
            FileInputStream input = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            input,
                            StandardCharsets.UTF_8))
        ) {

            List<String> lines = new ArrayList<>();

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.endsWith(EMPTY_COMMENT_MARKER)) {

                    line = line.substring(
                            0,
                            line.length()
                                    - EMPTY_COMMENT_MARKER.length());

                    /*
                     * Preserve the previous behaviour:
                     * discard lines that contained only the
                     * temporary comment marker.
                     */
                    if (!line.isEmpty()) {
                        lines.add(line);
                    }

                } else {
                    lines.add(line);
                }
            }

            try (
                FileOutputStream output =
                        new FileOutputStream(file);

                OutputStreamWriter writer =
                        new OutputStreamWriter(
                                output,
                                StandardCharsets.UTF_8);

                PrintWriter printer =
                        new PrintWriter(writer)
            ) {

                for (String code : lines) {
                    printer.println(code);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeEmptyComments(String path) {
        if (path != null) {
            removeEmptyComments(new File(path));
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }

        try {
            Double.parseDouble(strNum);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }
}