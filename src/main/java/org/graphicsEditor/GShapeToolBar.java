package org.graphicsEditor;

import javax.swing.*;
import java.awt.event.ActionListener;

public class GShapeToolBar extends JToolBar {
	public GShapeToolBar(ActionListener handler) {
		JRadioButton rectangleButton = new JRadioButton("rectangle");
		rectangleButton.setActionCommand(GShape.EShapeType.eRectangle.name());
		rectangleButton.addActionListener(handler);
		this.add(rectangleButton);

		JRadioButton circleButton = new JRadioButton("circle");
		circleButton.setActionCommand(GShape.EShapeType.eCircle.name());
		circleButton.addActionListener(handler);
		this.add(circleButton);

		JRadioButton ellipseButton = new JRadioButton("ellipse");
		ellipseButton.setActionCommand(GShape.EShapeType.eEllipse.name());
		ellipseButton.addActionListener(handler);
		this.add(ellipseButton);
	}
}
