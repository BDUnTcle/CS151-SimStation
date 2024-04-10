package simstation;
import mvc.*;

public class SimstationFactory implements AppFactory {
    @Override
    public Model makeModel() { return new Simstation(); }

    @Override
    public View makeView(Model m) {
        return new SimstationView((Simstation)m);
    }

    @Override
    public String[] getEditCommands() { return new String[] {"Start", "Suspend", "Resume", "Stop", "Stats"}; }

    // source added 3/15 to support text fields
    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        return switch (type) {
            case "Start" -> new StartCommand(model);
            case "Suspend" -> new SuspendCommand(model);
            case "Resume" -> new ResumeCommand(model);
            case "Stop" -> new StopCommand(model);
            case "Stats" -> new StatsCommand(model);
            default -> null;
        };
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
