package simstation;
import mvc.*;

public class StatsCommand extends Command {
    public StatsCommand(Model model) {

        super(model);
    }

    @Override
    public void execute() {
        Simulation sim = (Simulation)model;
        sim.stats();
    }
}
