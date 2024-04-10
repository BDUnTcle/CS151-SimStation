package simstation;

import mvc.*;

public class StartCommand extends Command {
    public StartCommand(Model model) {

        super(model);
    }

    @Override
    public void execute() {
        Simstation sim = (Simstation)model;
        sim.start();
    }
}
