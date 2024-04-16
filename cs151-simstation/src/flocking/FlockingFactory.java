package flocking;

import mvc.Model;
import randomwalk.RandomWalkSimulation;
import simstation.SimulationFactory;

public class FlockingFactory extends SimulationFactory {
    public Model makeModel() {
        return new FlockingSimulation();
    }
    public String getTitle() {
        return "Flocking";
    }
}
