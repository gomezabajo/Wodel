package wodel.views;

//import static wodel.ai.assistant.utils.AssistantUtils.buildPath;
//import static wodel.ai.assistant.utils.AssistantUtils.loadModelAsString;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.part.ViewPart;

//import wodel.ai.assistant.AITask;
//import wodel.ai.assistant.MOpTask;
//import wodel.ai.assistant.chat.ParameterExtractor;
//import wodel.ai.assistant.chat.PlannerAgent;
//import wodel.ai.assistant.mock.WodelMock;
//import wodel.utils.manager.ProjectUtils;
//import wodel.ai.experiments.ExperimentResult;


/**
 * Interactive chat-like console view that accepts user input and parses it with
 * a simple command parser.
 *
 */
public class ConsoleChatView extends ViewPart {

	public static final String ID = "wodel.views.ConsoleChatView";

	// chat UI instead of plain StyledText
	private org.eclipse.swt.custom.ScrolledComposite scroll;
	private Composite messagesArea;      // vertical list of message rows
	private Text input;                  // same as before

	// session conversation memory
	private enum Sender { USER, BOT, SYSTEM }

	private static class ChatMessage {
		final Sender sender;
		final String text;
		final LocalDateTime timestamp;

		ChatMessage(Sender sender, String text, LocalDateTime timestamp) {
			this.sender = sender;
			this.text = text;
			this.timestamp = timestamp;
		}
	}

	private final List<ChatMessage> conversation = new ArrayList<>();

	private final List<String> history = new ArrayList<>();
	private int historyIndex = -1;

	private CommandParser parser;

	// Capture System.out
	private PrintStream previousOut;
	private PrintStream mirroringOut;

	private org.eclipse.swt.graphics.Color chatBackground;
	private org.eclipse.swt.graphics.Color userBubbleBg;
	private org.eclipse.swt.graphics.Color botBubbleBg;
	private org.eclipse.swt.graphics.Color systemBubbleBg;
	private org.eclipse.swt.graphics.Color headerFg;

	private final DateTimeFormatter timeFormatter =
			DateTimeFormatter.ofPattern("HH:mm");

	@Override
	public void createPartControl(Composite parent) {
		Composite root = new Composite(parent, SWT.NONE);
		GridLayout gl = new GridLayout(1, false);
		gl.marginWidth = 6;
		gl.marginHeight = 6;
		gl.verticalSpacing = 6;
		root.setLayout(gl);

		Display display = root.getDisplay();

		chatBackground = new org.eclipse.swt.graphics.Color(display, 236, 229, 221); // beige-ish

		// Bubble colors
		userBubbleBg   = new org.eclipse.swt.graphics.Color(display, 220, 248, 198); // light green
		botBubbleBg    = new org.eclipse.swt.graphics.Color(display, 255, 255, 255); // white
		systemBubbleBg = new org.eclipse.swt.graphics.Color(display, 240, 240, 240); // light gray

		// Header text color
		headerFg       = new org.eclipse.swt.graphics.Color(display, 110, 110, 110);

		// scrollable conversation area
		scroll = new org.eclipse.swt.custom.ScrolledComposite(root, SWT.V_SCROLL | SWT.BORDER);
		scroll.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		scroll.setExpandHorizontal(true);
		scroll.setExpandVertical(true);

		messagesArea = new Composite(scroll, SWT.NONE);
		messagesArea.setBackground(chatBackground);   // NEW
		GridLayout messagesLayout = new GridLayout(1, false);
		messagesLayout.marginWidth = 0;
		messagesLayout.marginHeight = 0;
		messagesLayout.verticalSpacing = 4;
		messagesArea.setLayout(messagesLayout);

		scroll.setContent(messagesArea);
		scroll.setMinSize(messagesArea.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		// Input line
		input = new Text(root, SWT.BORDER | SWT.SINGLE);
		input.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		input.setMessage("Type a message ...");

		parser = null; //new DefaultCommandParser();

		// Send on Enter
		input.addTraverseListener(new TraverseListener() {
			@Override public void keyTraversed(TraverseEvent e) {
				if (e.detail == SWT.TRAVERSE_RETURN) {
					e.doit = false;
					handleSend();
				}
			}
		});

		// History navigation
		input.addListener(SWT.KeyDown, evt -> {
			switch (evt.keyCode) {
			case SWT.ARROW_UP:
				navigateHistory(-1);
				break;
			case SWT.ARROW_DOWN:
				navigateHistory(1);
				break;
			default:
				if (!input.getText().isEmpty()) historyIndex = -1;
			}
		});

		// Mirror System.out -> as SYSTEM messages
		previousOut = System.out;
		mirroringOut = new PrintStream(new OutputStream() {
			StringBuilder buffer = new StringBuilder();
			@Override public void write(int b) throws IOException {
				buffer.append((char) b);
			}
			@Override public void write(byte[] b, int off, int len) throws IOException {
				buffer.append(new String(b, off, len));
				flush();
			}
			@Override public void flush() throws IOException {
				if (buffer.length() == 0) return;
				String s = buffer.toString();
				buffer.setLength(0);
				asyncAppendSystemMessage(s);
			}
		}, true);
		System.setOut(mirroringOut);

		// Restore System.out and dispose colors on view dispose
		root.addDisposeListener(new DisposeListener() {
			@Override public void widgetDisposed(DisposeEvent e) {
				try { mirroringOut.flush(); } catch (Exception ignore) {}
				System.setOut(previousOut);
				if (chatBackground != null) chatBackground.dispose();
				if (userBubbleBg != null) userBubbleBg.dispose();
				if (botBubbleBg != null) botBubbleBg.dispose();
				if (systemBubbleBg != null) systemBubbleBg.dispose();
				if (headerFg != null) headerFg.dispose();
			}
		});

		// Greet
		input.setFocus();
	}

	private void addMessage(Sender sender, String text) {
		if (messagesArea == null || messagesArea.isDisposed()) return;
		Display display = messagesArea.getDisplay();
		if (display.isDisposed()) return;

		display.asyncExec(() -> {
			if (messagesArea.isDisposed()) return;

			ChatMessage msg = new ChatMessage(sender, text, LocalDateTime.now());
			conversation.add(msg); // <-- in-memory session state

			createMessageRow(msg);

			messagesArea.layout(true, true);
			scroll.setMinSize(messagesArea.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			// Scroll to bottom
			scroll.setOrigin(0, Math.max(0,
					messagesArea.computeSize(SWT.DEFAULT, SWT.DEFAULT).y));
		});
	}

	private void createMessageRow(ChatMessage msg) {
	    boolean isUser   = msg.sender == Sender.USER;
	    boolean isBot    = msg.sender == Sender.BOT;
	    boolean isSystem = msg.sender == Sender.SYSTEM;

	    // ---- Row container ----
	    Composite row = new Composite(messagesArea, SWT.NONE);
	    row.setBackground(chatBackground);
	    GridLayout rowLayout = new GridLayout(1, false);
	    rowLayout.marginWidth = 0;
	    rowLayout.marginHeight = 0;
	    rowLayout.verticalSpacing = 2;
	    row.setLayout(rowLayout);
	    row.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

	    // ---- Bubble canvas ----
	    org.eclipse.swt.widgets.Canvas bubble = new org.eclipse.swt.widgets.Canvas(row, SWT.DOUBLE_BUFFERED);
	    GridData bubbleData = new GridData(
	            isUser ? SWT.END : SWT.BEGINNING,   // RIGHT for user, LEFT for bot/system
	            SWT.CENTER,
	            false,
	            false
	    );
	    bubbleData.widthHint = 380;                 // max bubble width
	    bubbleData.horizontalIndent = isUser ? 40 : 10;
	    bubble.setLayoutData(bubbleData);

	    // Pick bubble color
	    org.eclipse.swt.graphics.Color bg;
	    if (isUser) {
	        bg = userBubbleBg;
	    } else if (isBot) {
	        bg = botBubbleBg;
	    } else {
	        bg = systemBubbleBg;
	    }

	    // ----- Pre-compute text layout so we know the canvas height -----

	    String who;
	    if (isUser) {
	        who = "You";
	    } else if (isBot) {
	        who = "Bot";
	    } else {
	        who = "System";
	    }
	    final String headerText = who + " · " + timeFormatter.format(msg.timestamp);
	    final String bodyText   = msg.text;

	    final int paddingX = 12;
	    final int paddingY = 8;
	    final int headerBodySpacing = 4;

	    int contentWidth = bubbleData.widthHint - 2 * paddingX;

	    GC gc = new GC(bubble);
	    gc.setFont(bubble.getFont());

	    // Measure header
	    final Point headerExtent = gc.textExtent(headerText);

	    // Wrap body text into lines that fit contentWidth
	    final java.util.List<String> bodyLines = wrapText(bodyText, contentWidth, gc);
	    final int lineHeight = gc.getFontMetrics().getHeight();

	    int totalHeight = paddingY                 // top padding
	            + headerExtent.y
	            + headerBodySpacing
	            + bodyLines.size() * lineHeight
	            + paddingY;                       // bottom padding

	    bubbleData.heightHint = totalHeight;
	    gc.dispose();

	    // ----- Paint bubble + text -----
	    bubble.addPaintListener(e -> {
	        GC g = e.gc;
	        Rectangle area = bubble.getClientArea();
	        int arc = 18;

	        g.setAntialias(SWT.ON);

	        // Bubble
	        g.setBackground(bg);
	        g.fillRoundRectangle(0, 0, area.width - 1, area.height - 1, arc, arc);
	        g.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_GRAY));
	        g.drawRoundRectangle(0, 0, area.width - 1, area.height - 1, arc, arc);

	        int x = paddingX;
	        int y = paddingY;

	        // Header text (transparent background)
	        g.setForeground(headerFg);
	        g.drawText(headerText, x, y, true);  // true => transparent background

	        y += headerExtent.y + headerBodySpacing;

	        // Body lines
	        g.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_BLACK));
	        for (String line : bodyLines) {
	            g.drawText(line, x, y, true);    // true => transparent background
	            y += lineHeight;
	        }
	    });
	}

	/**
	 * Simple word-wrapping: breaks text into lines that fit within maxWidth
	 * using the given GC's font metrics.
	 */
	private List<String> wrapText(String text, int maxWidth, GC gc) {
	    List<String> result = new ArrayList<>();

	    // Respect explicit newlines first
	    String[] paragraphs = text.split("\\R");
	    for (String paragraph : paragraphs) {
	        if (paragraph.isEmpty()) {
	            result.add("");
	            continue;
	        }
	        StringBuilder current = new StringBuilder();
	        for (String word : paragraph.split("\\s+")) {
	            if (current.length() == 0) {
	                current.append(word);
	            } else {
	                String candidate = current.toString() + " " + word;
	                Point ext = gc.textExtent(candidate);
	                if (ext.x > maxWidth) {
	                    result.add(current.toString());
	                    current.setLength(0);
	                    current.append(word);
	                } else {
	                    current.append(" ").append(word);
	                }
	            }
	        }
	        result.add(current.toString());
	    }
	    return result;
	}
	
	
	private void asyncAppendSystemMessage(String s) {
		if (s == null || s.isBlank()) return;

		// Optional
		String text = s.strip();
		if (text.isEmpty()) return;

		//addMessage(Sender.SYSTEM, text);
	}

	private void handleSend() {
		String text = input.getText().trim();
		if (text.isEmpty()) return;

		history.add(text);
		historyIndex = -1;

		// Right-side user bubble
		addMessage(Sender.USER, text);

		try {
			String reply = parser.parse(text);
			if (reply != null && !reply.isEmpty()) {
				// Left-side bot bubble
				addMessage(Sender.BOT, reply);
			}
		} catch (Exception ex) {
			addMessage(Sender.SYSTEM, "Error: " + ex.getMessage());
		}

		input.setText("");
	}


	private void navigateHistory(int delta) {
		if (history.isEmpty()) return;
		if (historyIndex == -1) historyIndex = history.size();
		historyIndex += delta;
		if (historyIndex < 0) historyIndex = 0;
		if (historyIndex >= history.size()) historyIndex = history.size() - 1;
		input.setText(history.get(historyIndex));
		input.setSelection(input.getText().length());
	}

	@Override
	public void setFocus() {
		if (input != null && !input.isDisposed()) {
			input.setMessage("Type a message ...");
			input.setFocus();
		}
	}

	// ---------------- Parser SPI ----------------

	/**
	 * Minimal parser SPI. Replace with your own domain-specific implementation
	 */
	public static interface CommandParser {
		/**
		 * @param userInput raw text from input box
		 * @return reply text to show in the transcript (no prefix), or empty string for no reply
		 */
		String parse(String userInput) throws Exception;
	}

	private void clearConversation() {
		if (messagesArea == null || messagesArea.isDisposed()) return;

		for (org.eclipse.swt.widgets.Control child : messagesArea.getChildren()) {
			child.dispose();
		}
		conversation.clear();
		messagesArea.layout(true, true);
		scroll.setMinSize(messagesArea.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}


	/**
	 * A toy parser that demonstrates a few commands:
	 *  /help  — shows available commands
	 *  /time  — prints current local time
	 *  /clear — clears the transcript
	 *  /echo <text> — echoes the rest
	 *  /sum <nums> — sums numbers (space/comma separated)
	 * Fallback: basic reflection on the input.
	 */
	/*
	private class DefaultCommandParser implements CommandParser {

		private String executeCommand(String cmd, String rest) throws Exception {
			switch (cmd) {
			//            case "/help":
			//                return String.join(System.lineSeparator(),
			//                    "Commands:",
			//                    "  /help              Show this help",
			//                    "  /time              Current time",
			//                    "  /clear             Clear the transcript",
			//                    "  /echo <text>       Echo back text",
			//                    "  /sum <nums>        Sum numbers (space or comma separated)",
			//                    "  /wodel             Evaluate mutation operator(s)",
			//                    "  /followup          Generate followup(s) via LLM",
			//                    "  /momot             Generate followup(s) via MOMoT",
			//                    "  /verify            Verify followup(s) properties",
			//                    "  /run               Run Wodel"
			//                );
			//
			//            case "/time":
			//                return LocalDateTime.now()
			//                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			//
			//            case "/echo":
			//                return rest;
			//
			//            case "/sum":
			//                if (rest.isBlank()) {
			//                    return "Provide numbers, e.g. /sum 1 2 3";
			//                }
			//                String[] toks = rest.replace(",", " ").trim().split("\\s+");
			//                double sum = 0.0;
			//                try {
			//                    for (String t : toks) {
			//                        sum += Double.parseDouble(t);
			//                    }
			//                } catch (NumberFormatException ex) {
			//                    return "All arguments must be numbers. Example: /sum 1 2 3";
			//                }
			//                return "Sum = " + sum;
			//            case "/wodel": {
			//                IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			//                if (window == null) return "Cannot run /wodel (no active workbench window).";
			//
			//                Command command = window.getService(ICommandService.class)
			//                                        .getCommand("wodelEvaluateWodel");
			//                IEvaluationService evalService = window.getService(IEvaluationService.class);
			//                IEvaluationContext context = evalService.getCurrentState();
			//                ExecutionEvent event = new ExecutionEvent(command, new LinkedHashMap<String, String>(), null, context);
			//                command.executeWithChecks(event);
			//                return "(mutation operator(s) evaluated)";
			//            }
			//
			//            case "/followup": {
			//                IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			//                if (window == null) return "Cannot run /followup (no active workbench window).";
			//
			//                Command command = window.getService(ICommandService.class)
			//                                        .getCommand("wodel.dsls.ui.context.menu.AIMeTFollowUpGenerator");
			//                IEvaluationService evalService = window.getService(IEvaluationService.class);
			//                IEvaluationContext context = evalService.getCurrentState();
			//                ExecutionEvent event = new ExecutionEvent(command, new LinkedHashMap<String, String>(), null, context);
			//                command.executeWithChecks(event);
			//                return "(followups generated via LLM)";
			//            }
			//
			//            case "/momot": {
			//                IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			//                if (window == null) return "Cannot run /momot (no active workbench window).";
			//
			//                Command command = window.getService(ICommandService.class)
			//                                        .getCommand("wodelFollowupRunGenerateResources");
			//                IEvaluationService evalService = window.getService(IEvaluationService.class);
			//                IEvaluationContext context = evalService.getCurrentState();
			//                ExecutionEvent event = new ExecutionEvent(command, new LinkedHashMap<String, String>(), null, context);
			//                command.executeWithChecks(event);
			//                return "(followups generated via MOMoT)";
			//            }
			//
			//            case "/verify": {
			//                IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			//                if (window == null) return "Cannot run /verify (no active workbench window).";
			//
			//                Command command = window.getService(ICommandService.class)
			//                                        .getCommand("verifyFollowupProperties");
			//                IEvaluationService evalService = window.getService(IEvaluationService.class);
			//                IEvaluationContext context = evalService.getCurrentState();
			//                ExecutionEvent event = new ExecutionEvent(command, new LinkedHashMap<String, String>(), null, context);
			//                command.executeWithChecks(event);
			//                return "(followups verified)";
			//            }
			//
			//            case "/run": {
			//                IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			//                if (window == null) return "Cannot run /run (no active workbench window).";
			//
			//                Command command = window.getService(ICommandService.class)
			//                                        .getCommand("wodelRunWodel");
			//                IEvaluationService evalService = window.getService(IEvaluationService.class);
			//                IEvaluationContext context = evalService.getCurrentState();
			//                ExecutionEvent event = new ExecutionEvent(command, new LinkedHashMap<String, String>(), null, context);
			//                command.executeWithChecks(event);
			//                return "(Wodel executed)";
			//            }
			//
			//            case "/clear":
			//                Display.getDefault().asyncExec(() -> clearConversation());
			//                return "Conversation cleared.";
			//
			default:
				// Unknown command
				return null;
			}
		}

		/*
		private static WodelMock configureWodelMock() {
			WodelMock wodel = WodelMock.getInstance();
			String[] fragments = Platform.getLocation().toFile().getPath().replace("\\", "/").split("/");
			String[] paramFragmentsWodelModel = Arrays.copyOf(fragments, fragments.length + 3);
			paramFragmentsWodelModel[fragments.length] = ProjectUtils.getProject().getName();
			paramFragmentsWodelModel[fragments.length + 1] = "src";
			paramFragmentsWodelModel[fragments.length + 2] = "dfa.wodel";    		
			String[] paramFragmentsMM = Arrays.copyOf(fragments, fragments.length + 3);
			paramFragmentsMM[fragments.length] = ProjectUtils.getProject().getName();
			paramFragmentsMM[fragments.length + 1] = "model";
			paramFragmentsMM[fragments.length + 2] = "DFAAutomaton.ecore";    		
			String[] paramFragmentsFollowups = Arrays.copyOf(fragments, fragments.length + 3);
			paramFragmentsFollowups[fragments.length] = ProjectUtils.getProject().getName();
			paramFragmentsFollowups[fragments.length + 1] = "model";
			paramFragmentsFollowups[fragments.length + 2] = "followups";
			String[] paramFragmentsSeed = Arrays.copyOf(fragments, fragments.length + 4);
			paramFragmentsSeed[fragments.length] = ProjectUtils.getProject().getName();
			paramFragmentsSeed[fragments.length + 1] = "model";
			paramFragmentsSeed[fragments.length + 2] = "dfamodels";    		
			paramFragmentsSeed[fragments.length + 3] = "dfa_1.model";    		
			String[] paramFragmentsSeedPath = Arrays.copyOf(fragments, fragments.length + 3);
			paramFragmentsSeedPath[fragments.length] = ProjectUtils.getProject().getName();
			paramFragmentsSeedPath[fragments.length + 1] = "model";
			paramFragmentsSeedPath[fragments.length + 2] = "dfamodels";    		
			wodel.withParameter(AITask.WODEL_MODEL, loadModelAsString(buildPath(paramFragmentsWodelModel)))
			.withParameter(AITask.MM_PATH, buildPath(paramFragmentsMM));
			return wodel;
		}

		private static Map<String, Object> completeParams(MOpTask task, String utterance) {
			Map<String, Object> params = new LinkedHashMap<>(WodelMock.getInstance().getAllParams());	// Get System params
			if (task.hasUserParams()) {
				ParameterExtractor pc = new ParameterExtractor(task);			
				params.putAll(pc.getParameters(utterance));
			} 
			return params;
		}

		private static String asShortString(Map<String, Object> params) {
			String result = "{";
			for (String key : params.keySet()) {
				if (params.get(key)==null) result += "\n" + key + ": null";
				else result += "\n" + key + ": "+truncTo(25, params.get(key).toString());
			}
			result += "}";
			return result;
		}

		private static String truncTo(int n, String value) {
			return value.length() > n
					? value.substring(0, n) + "..."
							: value;		
		}

		@Override
		public String parse(String utterance) throws Exception {
			//            String[] parts = userInput.trim().split("\\s+", 2);
			//            String cmd = parts[0];
			//            String rest = parts.length > 1 ? parts[1] : "";
			//
			//            if (cmd.startsWith("/")) {
			//                String reply = executeCommand(cmd.toLowerCase(Locale.ROOT), rest);
			//                return reply; // may be null if command not recognized
			//            }

			PlannerAgent agent = new PlannerAgent(configureWodelMock());
			MOpTask selected = agent.getIntent(utterance);
			if (selected!=null && selected instanceof AITask ait)
				ait.withModel("o4-mini");
			//addMessage(Sender.SYSTEM, "User says: "+utterance);
			//addMessage(Sender.SYSTEM, "Selected task: "+selected);
			Object response = null;
			Map<String, Object> params = null;
			if (selected!=null) {			
				params = completeParams(selected, utterance);
				//addMessage(Sender.SYSTEM, "Params: "+ asShortString(params));
				selected.withParameters(params);
				//addMessage(Sender.SYSTEM, selected.canExecute());
				if (selected.canExecute()==null) {				
					//addMessage(Sender.SYSTEM, "-- Execution ---------------------------------");
					response = selected.executeWithInput(utterance);
					//addMessage(Sender.SYSTEM, "Response: "+response);
				}
			}
			//addMessage(Sender.SYSTEM, "==============================================");
			String botReply = "";
			if (response != null && !(response instanceof List<?>)) {
				if (response instanceof ExperimentResult expRet) {
					List<?> durations = expRet.getDurations();
					int numModels = durations.size();
					int numReq = Integer.valueOf(params.get("10").toString());
					final double lapse = durations.stream().filter(d -> d instanceof Double).mapToDouble(d -> (double) d).sum();
					int numFups = expRet.getNumberOfFollowUps();
					int numFixes = expRet.getNumberOfXMIFixes();
					double ratio = 100.0 * numModels / numReq;
					double perc = 100.0 * numFups / numModels;
					botReply += "The follow-up generation process took " + String.format("%.2f", lapse) + " ms.\n";
					botReply += "Overall, " + numModels + " follow-ups out of the requested total of " + numReq + " (" + String.format("%.2f", ratio) + "%) were generated successfully.\n";
					botReply += numFixes > 0 ? "The generation process needed to perform " + numFixes + " fixes over the generated follow-ups. I needed to fix (" + String.format("%.2f", perc) + ") out of the " + numModels + " generated follow-ups.\n" : "The " + numModels + " follow-ups were generated at the first attempt.\n"; 
				}
			}
			if (response instanceof List<?> lst && lst != null && lst.size() > 1) {
				if (lst.get(0) instanceof ExperimentResult expRet) {
					List<?> durations = expRet.getDurations();
					int numModels = durations.size();
					int numReq = Integer.valueOf(params.get("10").toString());
					final double lapse = durations.stream().filter(d -> d instanceof Double).mapToDouble(d -> (double) d).sum();
					int numFups = expRet.getNumberOfFollowUps();
					int numFixes = expRet.getNumberOfXMIFixes();
					double ratio = 100.0 * numModels / numReq;
					double perc = 100.0 * numFups / numModels;
					botReply += "The follow-up generation process took " + String.format("%.2f", lapse) + " ms.\n";
					botReply += "Overall, " + numModels + " follow-ups out of the requested total of " + numReq + " (" + String.format("%.2f", ratio) + "%) were generated successfully.\n";
					botReply += numFixes > 0 ? "The generation process needed to perform " + numFixes + " fixes over the generated follow-ups. I needed to fix (" + String.format("%.2f", perc) + ") out of the " + numModels + " generated follow-ups.\n" : "The " + numModels + " follow-ups were generated at the first attempt.\n"; 
				}
				if (lst.get(1) instanceof String) {
					botReply += "I evaluated successfully " + params.get(AITask.MR_NAME) + " over the generated follow-ups.\n";
				}
			}
			return botReply;
		}
	}
		*/
}
