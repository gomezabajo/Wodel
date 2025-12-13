package wodel.views;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class ConsoleView extends ViewPart {

	public static final String ID = "wodel.views.ConsoleView";

	private Text text;

	// System.out of the *runtime* Eclipse instance
	private PrintStream originalOut;

	@Override
	public void createPartControl(Composite parent) {
		text = new Text(parent, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		text.setEditable(false);

		// Save original before redirecting
		originalOut = System.out;

		// Stream that writes into the Text widget
		OutputStream uiStream = new ConsoleOutputStream();

		// Tee to originalOut (PDE console) + UI console
		OutputStream tee = new TeeOutputStream(originalOut, uiStream);

		// New System.out that goes to both
		PrintStream ps = new PrintStream(tee, true, StandardCharsets.UTF_8);
		System.setOut(ps);
		// Also stderr mirrored:
		// System.setErr(ps);

		// Restore original streams when the view is disposed
		text.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				if (originalOut != null) {
					System.setOut(originalOut);
				}
				// If redirected err too, restore it here as well.
			}
		});
	}

	/**
	 * OutputStream that appends text to the SWT Text widget on the UI thread.
	 */
	private class ConsoleOutputStream extends OutputStream {

		private final StringBuilder buffer = new StringBuilder();

		@Override
		public synchronized void write(int b) throws IOException {
			if (text == null || text.isDisposed()) {
				return;
			}
			// Optional: ignore CRs to avoid '\r\n' weirdness
			if (b == '\r') {
				return;
			}
			buffer.append((char) b);

			// Flush on newline for responsiveness
			if (b == '\n') {
				flushBufferToUI();
			}
		}

		@Override
		public synchronized void write(byte[] b, int off, int len) throws IOException {
			if (text == null || text.isDisposed()) {
				return;
			}
			buffer.append(new String(b, off, len, StandardCharsets.UTF_8));
			// For block writes, flush immediately
			flushBufferToUI();
		}

		@Override
		public synchronized void flush() throws IOException {
			flushBufferToUI();
		}

		private void flushBufferToUI() {
			if (buffer.length() == 0) {
				return;
			}

			final String msg = buffer.toString();
			buffer.setLength(0);

			Display display = text.getDisplay();
			if (display.isDisposed()) {
				return;
			}

			display.asyncExec(() -> {
				if (!text.isDisposed()) {
					text.append(msg);
					// Optional: auto-scroll to bottom
					text.setSelection(text.getCharCount());
				}
			});
		}
	}

	/**
	 * Tee OutputStream that writes to two outputs.
	 * NOTE: close() is a NO-OP so that external System.out.close() calls
	 * do NOT kill our logging.
	 */
	private static class TeeOutputStream extends OutputStream {
		private final OutputStream out1;
		private final OutputStream out2;

		TeeOutputStream(OutputStream out1, OutputStream out2) {
			this.out1 = out1;
			this.out2 = out2;
		}

		@Override
		public void write(int b) throws IOException {
			out1.write(b);
			out2.write(b);
		}

		@Override
		public void write(byte[] b, int off, int len) throws IOException {
			out1.write(b, off, len);
			out2.write(b, off, len);
		}

		@Override
		public void flush() throws IOException {
			out1.flush();
			out2.flush();
		}

		@Override
		public void close() throws IOException {
			// INTENTIONALLY DO NOTHING:
			// some code may call System.out.close(), but no need 
			// to close either the PDE console or our UI stream.
		}
	}

	@Override
	public void setFocus() {
		if (text != null && !text.isDisposed()) {
			text.setFocus();
		}
	}
}
