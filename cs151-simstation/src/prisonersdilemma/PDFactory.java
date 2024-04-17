package prisonersdilemma;
import mvc.*;
import simstation.*;
import java.util.*;

public class PDFactory extends SimulationFactory {

    @Override
    public Model makeModel() {
        return new PDSimulation();
    }

    @Override
    public View makeView(Model m) {
        return new PDView((PDSimulation)m);
    }

    @Override
    public String getTitle() {
        return "Prisoner's Dilemma Tournament";
    }

    
    @Override
    public String[] getHelp() {
        return new String[] {  "Red Agents: Can only cheat",
                "Green Agents: Can only cooperate",
                "Yellow Agents: Randomly cheat or cooperate",
                "Blue Agents: Cheat if the previous partner cheated",
                
                "Start: Begins the program.",
        		"Suspend: Temporarily pauses the program.",
                "Resume: Continues the program from where it stopped.",
                "Stop: Ends the program immediately.",
                "Stats: Displays the time and number of agents.",
                };
    }

}