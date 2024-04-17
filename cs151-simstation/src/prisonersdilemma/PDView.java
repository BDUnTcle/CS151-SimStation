package prisonersdilemma;
import mvc.*;
import simstation.*;
import java.util.*;
import java.awt.*;

public class PDView extends SimulationView {
    private static final Map<Integer, Color> colorMap = Map.of(0, Color.RED, 1, Color.GREEN, 2, Color.YELLOW, 3, Color.BLUE);

    public PDView (Model model) {
        super(model);
    }

    //@Override
    protected Color getAgentColor(Agent agent) {
        return colorMap.get(((Prisoner)agent).getStratAsInt());
    }
}