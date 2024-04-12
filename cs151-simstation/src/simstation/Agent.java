package simstation;

import java.io.Serializable;

public abstract class Agent implements Serializable, Runnable {
	private String name;
	public Heading heading;
	private int xc, yc;
	private boolean suspended, stopped;
	transient protected Thread myThread;
	private Simulation world;

	public Agent() {
		world = new Simulation();
		suspended = false;
		stopped = false;
		myThread = null;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		while (!(suspended || stopped)) {
			this.update();
		}
	}

	public void start() {
		world.populate();

	}

	public void suspend() {

	}

	public void resume() {

	}

	public void stop() {

	}

	public abstract void update();

	// override in subclass?
	public void onStart() {

	}

	// override in subclass?
	public void onInterrupted() {

	}

	// override in subclass?
	public void onExit() {

	}

	// Followed example from agentLab
	// Maybe not be needed
	public void setSimulation(Simulation world) {
		this.world = world;
	}

	public void move(int steps) {
		world.changed();

	}

}
