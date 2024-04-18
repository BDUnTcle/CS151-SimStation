package simstation;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import mvc.Model;
import mvc.Utilities;

public class Simulation extends Model {
	public enum STATE{
		READY,RUNNING,STOPPED,SUSPENDED
	}
	transient private Timer timer; // timers aren't serializable
	private List<Agent> agents;
	private int clock;
	private STATE state;
	private int view_width;
	private int view_height;
	public Simulation() {
		agents = new ArrayList<Agent>();
		clock = 0;
		state = STATE.READY;
	}
	public ArrayList<Agent> getAgents()
	{
		return (ArrayList<Agent>)agents;
	}
	public void setViewWidth(int width){
		view_width = width;
	}

	public void setViewHeight(int height) {
		view_height = height;
	}
	public int getViewWidth(){return view_width;}
	public int getViewHeight(){return view_height;}
	public void start() {
		populate();
		startTimer();
		for (Agent a : agents) {
			Thread thread = new Thread(a);
			thread.start();
		}
		state = STATE.RUNNING;
	}

	public void suspend() {
		state = STATE.SUSPENDED;
		for (Agent a : agents) {
			a.suspend();
		}
	}

	public void resume() {
		state = STATE.RUNNING;
		for (Agent a : agents) {
			a.resume();
		}
	}
	
	public int getClock() {
		return clock;
	}

	public void stop() {
		state = STATE.READY;
		for (Agent a : agents) {
				a.stop();
		}
		agents.clear();
		stopTimer();
		changed();
	}

	public Agent getNeighbor(Agent a, double radius) {
		for(Agent agent:agents)
		{
			if(a==agent) continue;
			double distance = agent.getCoord().distance(a.getCoord());
			if( distance <= radius)
			{
				return agent;
			}
		}
		return null;
	}
	public String[] getStatus()
	{
		String[] status = new String[2];
		status[0] = "#agents = "+agents.size();
		status[1] = "clock = " + clock;
		return status;
	}
	public STATE getState()
	{
		return state;
	}
	private void startTimer() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
	}
	private void stopTimer() {
		timer.cancel();
		timer.purge();
	}
	public void populate() {
		// empty. specified in subclass
	}

	public void addAgent(Agent a) {
		agents.add(a);
	}
	public synchronized void changed(Point old_point, Point new_point)
	{
		changed();
	}
	private class ClockUpdater extends TimerTask {
		public void run() {
			clock++;
		}
	}
}
