package flocking;

import mvc.Utilities;
import simstation.Agent;
import simstation.Heading;
import simstation.Simulation;

public class Bird extends Agent {
    public static int RADIUS = 10;
    public static int SPEED_LIMIT=5;

    private int speed;
    private int m_radius;
    public int getSpeed() {
        return speed;
    }


    public Bird(Simulation manager) {
        super(manager);
        heading = new Heading();
        speed = Utilities.rng.nextInt(SPEED_LIMIT)+1;
        m_radius = RADIUS;
    }

    @Override
    public void update() {
        Bird neighbor = (Bird) getSimulation().getNeighbor(this,m_radius);
        speed = neighbor.getSpeed();
        heading = neighbor.getHeading();
        move(speed);
    }
}
