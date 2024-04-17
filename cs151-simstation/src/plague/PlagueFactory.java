package plague;

import mvc.Model;
import mvc.View;
import simstation.SimulationFactory;

class PlagueFactory extends SimulationFactory {
	public Model makeModel() {
		return new PlagueSimulation();
	}
	public View makeView(Model model) {
		return new PlagueView(model);
	}
	public String getTitle() {
		return "Plague";
	}
	
	public String[] getStats() {
		return getStats();
	}
}