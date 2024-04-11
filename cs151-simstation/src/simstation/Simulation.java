package simstation;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import mvc.Model;

public class Simulation extends Model {

	transient private Timer timer; // timers aren't serializable
	private List<Agent> agents;
	private int clock;
	private int state;

	public Simulation() {
		agents = new ArrayList<Agent>();
		clock = 0;
		state = 0;
	}

	public void start() {
		populate();
		//startTimer();
		for (Agent a : agents) {
			Thread thread = new Thread(a);
			a.start();
		}
		state = 1;
	}

	public void suspend() {
		for (Agent a : agents) {
			a.suspend();
		}
	}

	public void resume() {
		for (Agent a : agents) {
			a.resume();
		}
	}

	public void stop() {
		for (Agent a : agents) {
			a.stop();
		}
	}

	public Agent getNeighbor(Agent a, double radius) {

		return null;
	}

	public void stats() {

	}

	private void startTimer() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
	}

	// empty. specified in subclass
	public void populate() {

	}

	public void addAgent(Agent a) {
		agents.add(a);
		a.setSimulation(this);
	}

	private class ClockUpdater extends TimerTask {
		public void run() {
			clock++;
		}
	}
}
