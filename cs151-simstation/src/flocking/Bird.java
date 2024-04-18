package flocking;

import mvc.Utilities;
import simstation.Agent;
import simstation.Heading;
import simstation.Simulation;

public class Bird extends Agent {
    public static int RADIUS = 10;
    public static int SPEED_LIMIT=5;

    private int speed;
    public int getSpeed() {
        return speed;
    }


    public Bird(Simulation manager) {
        super(manager);
        heading = new Heading();
        speed = Utilities.rng.nextInt(SPEED_LIMIT)+1;
    }

    @Override
    public void update() {
        Bird neighbor = (Bird) getSimulation().getNeighbor(this,RADIUS);
        if(neighbor!= null) {
            speed = neighbor.getSpeed();
            heading = neighbor.getHeading();
        }
        else {
            speed = Utilities.rng.nextInt(SPEED_LIMIT)+1;
            heading = new Heading();
        }
        move(speed);
    }
}
