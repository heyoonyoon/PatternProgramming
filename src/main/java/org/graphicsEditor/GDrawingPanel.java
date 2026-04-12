package org.graphicsEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GDrawingPanel extends JPanel {
	private enum EDrawingState {
		eIdle,
		eDrawing,
		eMoving,
		eResizing,
		eShearing
	}
	private EDrawingState eDrawingState;
	private BufferedImage bufferImage;
	private Vector<GShape> shapes;
	private GShape currentShape;
	private GShape.EShapeType currentShapeType;

	// constructors
	public GDrawingPanel() {
		this.setBackground(Color.WHITE);
		this.eDrawingState = EDrawingState.eIdle;
		this.shapes = new Vector<GShape>();
		GMouseHandler mouseHandler = new GMouseHandler();
		this.addMouseListener(mouseHandler);
		this.addMouseMotionListener(mouseHandler);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (bufferImage != null) {
			g.drawImage(bufferImage, 0, 0, null);
		} else {
			Graphics2D panelGraphics = (Graphics2D) g;
			for (GShape shape : this.shapes) {
				shape.draw(panelGraphics);
			}
		}
	}

	void startRectangularShape(int x, int y) {
		this.currentShape = new GShape(x, y, x, y);

		if (this.getWidth() <= 0 || this.getHeight() <= 0) {
			return;
		}
		if (bufferImage == null
				|| bufferImage.getWidth() != this.getWidth()
				|| bufferImage.getHeight() != this.getHeight()) {
			bufferImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
			Graphics2D bufferGraphics = bufferImage.createGraphics();
			bufferGraphics.setColor(this.getBackground());
			bufferGraphics.fillRect(0, 0, this.getWidth(), this.getHeight());
			bufferGraphics.dispose();
		}
	}
	void finishRectangularShape(int x, int y) {
		this.currentShape.setLocation1(x, y);

		Graphics2D bufferGraphics = bufferImage.createGraphics();
		bufferGraphics.setColor(this.getBackground());
		bufferGraphics.fillRect(0, 0, this.getWidth(), this.getHeight());
		bufferGraphics.setColor(Color.BLACK);
		for (GShape shape : this.shapes) {
			shape.draw(bufferGraphics);
		}
		this.currentShape.draw(bufferGraphics);
		bufferGraphics.dispose();

		Graphics2D panelGraphics = (Graphics2D) this.getGraphics();
		if (panelGraphics != null) {
			panelGraphics.drawImage(bufferImage, 0, 0, null);
			Toolkit.getDefaultToolkit().sync();
			panelGraphics.dispose();
		}
	}
	public void setCurrentShapeType(GShape.EShapeType shapeType) {
		this.currentShapeType = shapeType;
	}

	void addShape() {
		this.shapes.add(this.currentShape);
		this.currentShape = null;
	}


	public class GMouseHandler implements MouseListener, MouseMotionListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == 1) { // left button
				if (e.getClickCount() == 1) { // single click
					mouseLButton1Clicked(e);
				} else if (e.getClickCount() == 2) { // double click
					mouseLButton2Clicked(e);
				}
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			if (eDrawingState == EDrawingState.eDrawing) {
				finishRectangularShape(e.getX(), e.getY());
			}
		}
		private void mouseLButton1Clicked(MouseEvent e) {
			if (eDrawingState == EDrawingState.eIdle) {
				startRectangularShape(e.getX(), e.getY());
				eDrawingState = EDrawingState.eDrawing;
			}
		}
		private void mouseLButton2Clicked(MouseEvent e) {
			if (eDrawingState == GDrawingPanel.EDrawingState.eDrawing) {
				addShape();
				eDrawingState = GDrawingPanel.EDrawingState.eIdle;
			}

		}
		@Override
		public void mousePressed(MouseEvent e) {
			if (eDrawingState == EDrawingState.eIdle) {
				startRectangularShape(e.getX(), e.getY());
				eDrawingState = EDrawingState.eDrawing;
			}
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			if (eDrawingState == EDrawingState.eDrawing) {
				finishRectangularShape(e.getX(), e.getY());
			}
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			if (eDrawingState == GDrawingPanel.EDrawingState.eDrawing) {
				addShape();
				eDrawingState = GDrawingPanel.EDrawingState.eIdle;
			}
		}


		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}

	}

}
