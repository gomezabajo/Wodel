/*******************************************************************************
 * Copyright (c) 2000, 2010 IBM Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Stephan Michels, stephan@apache.org - 104944 [JUnit] Unnecessary code in JUnitProgressBar
 *******************************************************************************/
package wodeltest.run.utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

/**
 * A progress bar with a red/green indication for success or failure.
 */
public class JUnitProgressBar extends Canvas {
	private static final int DEFAULT_WIDTH = 160;
	private static final int DEFAULT_HEIGHT = 18;
	
	public static class Ok {
		private Display display;
		private Color color;
		public Ok(Display display) {
			this.display = display;
			this.color = new Color(this.display, 95, 191, 95);
		}
		public Color getColor() {
			return this.color;
		}
	}
	
	public static class Failure {
		private Display display;
		private Color color;
		public Failure(Display display) {
			this.display = display;
			this.color = new Color(this.display, 159, 63, 63);
		}
		public Color getColor() {
			return this.color;
		}
	}

	public static class Stopped {
		private Display display;
		private Color color;
		public Stopped(Display display) {
			this.display = display;
			this.color = new Color(this.display, 120, 120, 120);
		}
		public Color getColor() {
			return this.color;
		}
	}

	private int fCurrentTotalCount= 0;
	private int fCurrentOkCount= 0;
	private int fCurrentFailureCount= 0;
	private int fMaxTotalCount= 0;
	private int fColorOkBarWidth= 0;
	private int fColorFailureBarWidth= 0;
	private Color fOKColor;
	private Color fFailureColor;
	private Color fStoppedColor;
	private boolean fError;
	private boolean fStopped= false;

	public JUnitProgressBar(Composite parent) {
		super(parent, SWT.NONE);

		addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				fColorOkBarWidth= scale(fCurrentOkCount);
				fColorFailureBarWidth = scale(fCurrentFailureCount);
				redraw();
			}
		});
		addPaintListener(this::paint);
		Display display= parent.getDisplay();
		fFailureColor= new Failure(display).getColor();
		fOKColor= new Ok(display).getColor();
		fStoppedColor= new Stopped(display).getColor();
	}

	public void setMaximum(int max) {
		fMaxTotalCount= max;
	}

	public void reset() {
		fError= false;
		fStopped= false;
		fCurrentTotalCount= 0;
		fCurrentOkCount= 0;
		fCurrentFailureCount= 0;
		fMaxTotalCount= 0;
		fColorOkBarWidth = 0;
		fColorFailureBarWidth= 0;
		redraw();
	}

	public void reset(boolean hasErrors, boolean stopped, int currentOkCount, int currentFailureCount, int currentTotalCount, int maximum) {
		boolean noChange= fError == hasErrors && fStopped == stopped && fCurrentOkCount == currentOkCount && fCurrentFailureCount == currentFailureCount && fCurrentTotalCount == currentTotalCount && fMaxTotalCount == maximum;
		fError= hasErrors;
		fStopped= stopped;
		fCurrentOkCount = currentOkCount;
		fCurrentFailureCount = currentFailureCount;
		fCurrentTotalCount = currentTotalCount;
		fMaxTotalCount= maximum;
		fColorOkBarWidth = scale(fCurrentOkCount);
		fColorFailureBarWidth = scale(fCurrentFailureCount);
		if (! noChange)
			redraw();
	}

	private void setStatusColor(GC gc) {
		if (fStopped)
			gc.setBackground(fStoppedColor);
		else if (fError)
			gc.setBackground(fFailureColor);
		else
			gc.setBackground(fOKColor);
	}

	public void stopped() {
		fStopped= true;
		redraw();
	}

	private int scale(int value) {
		if (this.fMaxTotalCount > 0) {
			Rectangle r= getClientArea();
			if (r.width != 0)
				return Math.max(0, value*(r.width-2)/this.fMaxTotalCount);
		}
		return value;
	}

	private void drawBevelRect(GC gc, int x, int y, int w, int h, Color topleft, Color bottomright) {
		gc.setForeground(topleft);
		gc.drawLine(x, y, x+w-1, y);
		gc.drawLine(x, y, x, y+h-1);

		gc.setForeground(bottomright);
		gc.drawLine(x+w, y, x+w, y+h);
		gc.drawLine(x, y+h, x+w, y+h);
	}

	private void paint(PaintEvent event) {
		GC gc = event.gc;
		Display disp= getDisplay();

		Rectangle rect= getClientArea();
		gc.fillRectangle(rect);
		drawBevelRect(gc, rect.x, rect.y, rect.width-1, rect.height-1,
			disp.getSystemColor(SWT.COLOR_WIDGET_NORMAL_SHADOW),
			disp.getSystemColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));

		fColorOkBarWidth= Math.min(rect.width-2, fColorOkBarWidth);
		Rectangle killed = new Rectangle(rect.x + 1, rect.y - 1, rect.x + fColorOkBarWidth + 1, rect.height-2);
		gc.setBackground(fOKColor);
		gc.fillRectangle(killed);
		fColorFailureBarWidth= Math.min(rect.width-2, fColorFailureBarWidth);
		Rectangle live = new Rectangle(rect.x + fColorOkBarWidth + 1, rect.y - 1, rect.x + fColorOkBarWidth + fColorFailureBarWidth + 1, rect.height-2);
		gc.setBackground(fFailureColor);
		gc.fillRectangle(live);
	}

	@Override
	public Point computeSize(int wHint, int hHint, boolean changed) {
		checkWidget();
		Point size= new Point(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		if (wHint != SWT.DEFAULT) size.x= wHint;
		if (hHint != SWT.DEFAULT) size.y= hHint;
		return size;
	}

	public void refresh(boolean hasErrors) {
		fError= hasErrors;
		redraw();
	}
}
