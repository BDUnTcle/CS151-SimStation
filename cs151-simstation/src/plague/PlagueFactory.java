package plague;

import mvc.Model;
import mvc.View;
import simstation.SimulationFactory;

class PlagueFactory extends SimulationFactory {
	public Model makeModel() {
		return new PlagueSimulation();
	}
	public String getTitle() {
		return "Plague";
	}
	
	public String[] getStats() {
		return getStats();
	}
}