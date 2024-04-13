package randomwalk;

import mvc.Utilities;
import simstation.Agent;
import simstation.Heading;
import simstation.Simulation;

class Drunk extends Agent {

	public Drunk(Simulation manager) {
		super(manager);
		heading = new Heading();
	}

	public void update() {
		heading = Heading.random();
		int steps = Utilities.rng.nextInt(10) + 1;
		move(steps);
	}

}