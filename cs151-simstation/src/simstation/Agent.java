package simstation;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.Serializable;

public abstract class Agent implements Serializable, Runnable {
	private String name;
	public Heading heading;
	private Point m_coord;
	private boolean suspended, stopped;
	transient protected Thread myThread;
	private Simulation world;

	public Agent(Simulation manager) {
		world = manager;
		heading = new Heading();
		suspended = false;
		stopped = false;
		myThread = new Thread(this);
		m_coord = new Point(0,0);
	}

	public void setName(String name) {
		this.name = name;
	}
	public Point getCoord(){return m_coord;}
	@Override
	public void run() {
		while (!(suspended || stopped)) {
			this.update();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
	}

	public void start() {
		//world.populate();
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
		Point old_point = m_coord;
		switch (heading.getHeading())
		{
			case NORTH:
			{
				m_coord.y -= steps;
				break;
			}
			case SOUTH:
			{
				m_coord.y += steps;
				break;
			}
			case EAST:
			{
				m_coord.x += steps;
				break;
			}
			case WEST:
			{
				m_coord.x -= steps;
				break;
			}
		}
		world.changed(old_point,m_coord);

	}

}
