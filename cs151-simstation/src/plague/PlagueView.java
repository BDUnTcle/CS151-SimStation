package plague;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import mvc.Model;
import simstation.Agent;
import simstation.Simulation;
import simstation.SimulationView;
import java.awt.*;

public class PlagueView extends SimulationView {

	public PlagueView(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
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
			if (((Host)a).getInfected()) {
				g2.setColor(Color.RED);
			} else {
				g2.setColor(Color.GREEN);
			}
			g2.fill(rectangle);
		}
	}

}
