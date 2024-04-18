package plague;

import mvc.Model;
import mvc.View;
import simstation.SimulationFactory;

class PlagueFactory extends SimulationFactory {
	@Override
	public Model makeModel() {
		return new PlagueSimulation();
	}
	@Override
	public View makeView(Model model) {
		return new PlagueView(model);
	}
	@Override
	public String getTitle() {
		return "Plague";
	}
	
}