package plague;

import mvc.Utilities;
import simstation.Agent;
import simstation.Heading;
import simstation.Simulation;

public class Host extends Agent {
	private static final int RADIUS = 10;
	private boolean isInfected;
	private int virulence;
	private int resistence;
	public Host(Simulation manager) {
		super(manager);
		heading = Heading.random();
		virulence = ((PlagueSimulation)getWorld()).getVIRULENCE();
		resistence = ((PlagueSimulation)getWorld()).getRESISTANCE();
		isInfected = Utilities.rng.nextBoolean();
	}
	
	public boolean getInfected() {
		return isInfected;
	}

	public void update() {
		heading = Heading.random();
		if (!isInfected) {
			Host neighbor = (Host) getSimulation().getNeighbor(this, RADIUS);
	        if(neighbor!=null) {
				boolean neighInfected = neighbor.getInfected();
				// infection
				if (neighInfected) {
					if ((Math.random() > virulence / 100.0)
							&& (Math.random() > resistence / 100.0)) {
						isInfected = true;
					}
				}
			}
		}
        move(RADIUS);
	}

}