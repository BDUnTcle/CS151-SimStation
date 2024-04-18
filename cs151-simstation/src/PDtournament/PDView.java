package PDtournament;
import mvc.*;
import simstation.*;

import java.awt.geom.Rectangle2D;
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
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Simulation simulation = (Simulation)model;
        simulation.setViewWidth(getWidth());
        simulation.setViewHeight(getHeight());
        ArrayList<Agent> agentList = simulation.getAgents();

        Graphics2D g2 = (Graphics2D) gc;
        for(Agent a : agentList)
        {
            Rectangle2D rectangle = new Rectangle2D.Double(a.getCoord().x, a.getCoord().y, a.getRadius(), a.getRadius());
            g2.draw(rectangle);
            g2.setColor(colorMap.get(((Prisoner)a).getStratAsInt()));
            g2.fill(rectangle);
        }

    }
}