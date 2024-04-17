package plague;

import mvc.Utilities;
import simstation.Agent;
import simstation.Heading;
import simstation.Simulation;

public class Host extends Agent {
	private boolean isInfected;
	private int radius;
	private int virulence;
	private int resistence;
	public Host(Simulation manager) {
		super(manager);
		heading = Heading.random();
		radius = 10;
		virulence = ((PlagueSimulation) manager).VIRULENCE;
		resistence = ((PlagueSimulation) manager).RESISTANCE;
		int i = Utilities.rng.nextInt(2);
		if (i == 0) {
			isInfected = true;
		} else {
			isInfected = false;
		}
		
	}
	
	public boolean getInfected() {
		return isInfected;
	}

	public void update() {
		heading = Heading.random();
		if (!isInfected) {
			Host neighbor = (Host) getSimulation().getNeighbor(this, radius);
	        boolean neighInfected = neighbor.getInfected();
	        // infection
	        if (neighInfected) {
	        	if ((Math.random() > virulence / 100.0) 
	        			&& (Math.random() > resistence / 100.0) ) {
	        		isInfected = true;
	        	}
	        }
		}
        move(radius);
	}

}