package simstation;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import mvc.Model;
import mvc.View;

public class SimulationView extends View {
	public SimulationView(Model model) {
		super(model);
		setBackground(Color.gray);
	}

	public void paintComponent(Graphics gc) {
		super.paintComponent(gc);
		Simulation simulation = (Simulation)model;
		simulation.setViewWidth(getWidth());
		simulation.setViewHeight(getHeight());
		ArrayList<Agent> agentList = simulation.getAgents();

		Graphics2D g2 = (Graphics2D) gc;
		for(Agent a : agentList)
		{
			Rectangle2D rectangle = new Rectangle2D.Double(a.getCoord().x, a.getCoord().y, a.getRadius(), a.getRadius());
			g2.draw(rectangle);
			g2.setColor(Color.WHITE);
			g2.fill(rectangle);
		}

	}
}
