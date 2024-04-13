package simstation;
import mvc.*;

public abstract class SimulationFactory implements AppFactory {
    @Override
    public abstract Model makeModel();

    @Override
    public View makeView(Model m) {
        return new SimulationView((Simulation)m);
    }

    @Override
    public String[] getEditCommands() { return new String[] {"Start", "Suspend", "Resume", "Stop", "Stats"}; }

    // source added 3/15 to support text fields
    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        switch (type) {
            case "Start" :
                return new StartCommand(model);
            case "Suspend":
                return new SuspendCommand(model);
            case "Resume":
                return new ResumeCommand(model);
            case "Stop":
                return new StopCommand(model);
            case "Stats":
                return new StatsCommand(model);
            default:
                return null;
        }
    }

    @Override
    public String getTitle() { return "SimStation"; }

    @Override
    public String[] getHelp() {
        return new String[] {"Start: Begins the program.\n" +
                "\n" +
                "Suspend: Temporarily pauses the program.\n" +
                "\n" +
                "Resume: Continues the program from where it stopped.\n" +
                "\n" +
                "Stop: Ends the program immediately.\n" +
                "\n" +
                "Stats: Displays the time and number of agents."};
    }

    @Override
    public String about() {
        return "SimStation version 1.0. Copyright 2024 by Andrew Pun, Jiahao Tang, Ynha Nguyen";
    }
}
