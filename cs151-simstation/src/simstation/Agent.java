package simstation;

import mvc.Utilities;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.Serializable;

public abstract class Agent implements Serializable, Runnable {
	private static int RADIUS = 10;
	private String name;
	public Heading heading;
	private Point m_coord;
	private int m_radius = RADIUS;
	private boolean suspended, stopped;
	transient protected Thread myThread;
	private Simulation world;

	public Agent(Simulation manager) {
		world = manager;
		heading = new Heading();
		suspended = false;
		stopped = false;
		myThread = null;
		m_coord = new Point(Utilities.rng.nextInt(world.getViewWidth()),Utilities.rng.nextInt(world.getViewHeight()));
	}
	public int getRadius(){return m_radius;}
	public void setName(String name) {
		this.name = name;
	}
	public Point getCoord(){return m_coord;}
	@Override
	public void run() {
		myThread = Thread.currentThread();
		onStart();
		while (!stopped) {
			try {
				this.update();
                Thread.sleep(20);
				checkSuspended();
            } catch (InterruptedException e) {
				Utilities.error(e);
            }
        }
		onExit();
	}

	public void start() {
		//world.populate();
	}
	private synchronized void checkSuspended() {
		try {
			while(!stopped && suspended) {
				wait();
				suspended = false;
			}
		} catch (InterruptedException e) {
			Utilities.error(e);
		}
	}
	public synchronized void suspend() {
		suspended = true;
		onInterrupted();
	}
	public synchronized boolean isSuspended()
	{
		return suspended;
	}
	public synchronized void resume() {
		notify();
	}

	public void stop() {
		stopped = true;
	}
	public synchronized boolean isStopped()
	{
		return stopped;
	}
	public synchronized void join() throws InterruptedException {
		try {
			if (myThread != null) myThread.join();
		} catch(InterruptedException e) {
			throw e;
		}
	}
	public abstract void update();

	public void onStart() {
		//overrode in subclass if needed
	}

	public void onInterrupted() {
		//overrode in subclass if needed
	}

	public void onExit() {
		//overrode in subclass if needed
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
				if(m_coord.y < 0)
				{
					m_coord.y = world.getViewHeight()+m_coord.y;
				}
				break;
			}
			case SOUTH:
			{
				m_coord.y += steps;
				if(m_coord.y > world.getViewHeight())
				{
					m_coord.y -= world.getViewHeight();
				}
				break;
			}
			case EAST:
			{
				m_coord.x += steps;
				if(m_coord.x > world.getViewWidth())
				{
					m_coord.x -= world.getViewWidth();
				}
				break;
			}
			case WEST:
			{
				m_coord.x -= steps;
				if(m_coord.x < 0)
				{
					m_coord.x = world.getViewWidth()+m_coord.x;
				}
				break;
			}
		}
		world.changed(old_point,m_coord);

	}

}
