package simstation;
import mvc.*;

public class SuspendCommand extends Command {
    public SuspendCommand(Model model) {

        super(model);
    }

    @Override
    public void execute() {
        Simstation sim = (Simstation)model;
        sim.suspend();
    }
}
