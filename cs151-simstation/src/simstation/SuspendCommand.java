package simstation;
import mvc.*;

public class SuspendCommand extends Command {
    public SuspendCommand(Model model) {

        super(model);
    }

    @Override
    public void execute() {
        Simulation sim = (Simulation)model;
        sim.suspend();
    }
}
