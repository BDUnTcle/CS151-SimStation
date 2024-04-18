package plague;

import mvc.AppPanel;
import mvc.Utilities;
import simstation.Agent;
import simstation.Simulation;
import simstation.SimulationPanel;

public class PlagueSimulation extends Simulation {
	public static int VIRULENCE = 50; // % chance of infection
	public static int RESISTANCE = 2; // % chance of resisting infection
	public static int AGENTS = 50;
	public void populate() {
		for (int i = 0; i < AGENTS; i++)
			addAgent(new Host(this));
	}

	@Override
    public String[] getStatus()
    {
		String []stats = new String[3];
		double i = 0;
        for (Agent a : getAgents()) {
        	if (((Host)a).getInfected()) {
        		i++;
        	}
        }
        double infected = (i / AGENTS) * 100;
        stats[0] = "#Agents = " + AGENTS;
        stats[1] = "clock = " + getClock();
        stats[2] = "% infected " + infected;
        return stats;
    }
	
	public static void main(String[] args) {
		AppPanel panel = new SimulationPanel(new PlagueFactory());
		panel.display();
	}

}

