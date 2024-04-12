package simstation;

import mvc.*;

public class StartCommand extends Command {
    public StartCommand(Model model) {

        super(model);
    }

    @Override
    public void execute() {
        Simulation sim = (Simulation)model;
        sim.start();
    }
}
