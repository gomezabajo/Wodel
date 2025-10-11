package wodel.views;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

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
    
    
    @Override
    public void createPartControl(Composite parent) {
        text = new Text(parent,
                SWT.READ_ONLY | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);

        OutputStream out = new OutputStream() {
            StringBuffer buffer = new StringBuffer();

            @Override
            public void write(final int b) throws IOException {
                if (text.isDisposed())
                    return;
                buffer.append((char) b);
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                super.write(b, off, len);
                flush();
            }

            @Override
            public void flush() throws IOException {
                final String newText = buffer.toString();
                Display.getDefault().asyncExec(new Runnable() {
                    public void run() {
                        text.append(newText);
                    }
                });
                buffer = new StringBuffer();
            }
        };

        System.setOut(new PrintStream(out));
        final PrintStream oldOut = System.out;

        text.addDisposeListener(new DisposeListener() {
            public void widgetDisposed(DisposeEvent e) {
                System.setOut(oldOut);
            }
        });
    }
    
    @Override
    public void setFocus() {
        text.setFocus();
    }
}