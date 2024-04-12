package simstation;

import java.awt.Graphics;

import mvc.Model;
import mvc.View;

public class SimulationView extends View {
	public SimulationView(Model model) {
		super(model);
	}

	public void update() {
		repaint();
	}

	public void paintComponent(Graphics gc) {
		// draw a filled in circle for each agent
	}
}
