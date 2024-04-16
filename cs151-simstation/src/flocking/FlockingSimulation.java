package flocking;

import mvc.AppPanel;
import simstation.Agent;
import simstation.Simulation;
import simstation.SimulationPanel;

public class FlockingSimulation extends Simulation {
    @Override
    public void populate() {
        super.populate();
        for (int i=0;i<50;i++)
        {
            addAgent(new Bird(this));
        }
    }
    @Override
    public String[] getStatus()
    {
        String[] flocking_status = new String[Bird.SPEED_LIMIT];
        int[] speeds = new int[Bird.SPEED_LIMIT];
        for(Agent a:getAgents())
        {

            switch (((Bird)a).getSpeed())
            {
                case 1:
                {
                    speeds[0]++;
                    break;
                }
                case 2:
                {
                    speeds[1]++;
                    break;
                }
                case 3:
                {
                    speeds[2]++;
                    break;
                }
                case 4:
                {
                    speeds[3]++;
                    break;
                }
                case 5:
                {
                    speeds[4]++;
                    break;
                }
            }
        }
        for(int i=0;i<Bird.SPEED_LIMIT;i++)
        {
            flocking_status[0]="#birds @ speed 1 = "+ speeds[0];
            flocking_status[1]="#birds @ speed 2 = "+ speeds[1];
            flocking_status[2]="#birds @ speed 3 = "+ speeds[2];
            flocking_status[3]="#birds @ speed 4 = "+ speeds[3];
            flocking_status[4]="#birds @ speed 5 = "+ speeds[4];
        }
        return flocking_status;
    }
    public static void main(String[] args)
    {
        AppPanel panel = new SimulationPanel(new FlockingFactory());
        panel.display();
    }
}
