package PDtournament;
import simstation.*;

import java.util.*;

public class PDSimulation extends Simulation {
    public static double COMMUNITYSIZE = 40;
    public static int MAX_VINDICTIVENESS = 10;
    public static int PUNISH_THRESHOLD = 7;

    @Override
    public void populate() {
        for (int i = 0; i < COMMUNITYSIZE; i++) {
            Strategy strategy = initialize(i);
            Prisoner new_prisoner = new Prisoner(this,strategy, i % 4);
            strategy.setPrisoner(new_prisoner);
            addAgent(new_prisoner);
        }
    }

    public Strategy initialize(int strategy) {
        if (strategy % 4 == 0) {
            return new CheatStrategy();
        }
        if (strategy % 4 == 1) {
            return new CooperateStrategy();
        }
        if (strategy % 4 == 2) {
            return new RandomlyCooperateStrategy();
        }
        if (strategy % 4 == 3) {
            return new Tit4TatStrategy();
        }
        return null;
    }

    @Override
    public String[] getStatus() {
        double[] fitness = new double[4];
        double[] gains = new double[4];
        Iterator<Agent> agentIterator = agentIterator();

        while (agentIterator.hasNext()) {
            Prisoner p = (Prisoner) agentIterator.next();
            fitness[p.getStratAsInt()] = fitness[p.getStratAsInt()] + p.getFitness();
            gains[p.getStratAsInt()] = gains[p.getStratAsInt()] + p.getGains();
        }

        String[] stats = new String[4];
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < stats.length; i++) {
            builder.append("Average Fitness of Strategies [");
            if (i == 0) {
                builder.append("Cheat Strategy");
            }
            else if (i == 1) {
                builder.append("Cooperate Strategy");
            }
            else if (i == 2) {
                builder.append("Randomly Cooperate Strategy");
            }
            else if (i == 3) {
                builder.append("Tit4Tat Strategy");
            }
            builder.append("] = ");
            builder.append(fitness[i] / (COMMUNITYSIZE / 4));
            builder.append(" | Average Fitness Gained: ");
            builder.append(gains[i] / (COMMUNITYSIZE/ 4));
            stats[i] = builder.toString();
            builder.setLength(0);
        }
        return stats;
    }

    private Iterator<Agent> agentIterator() {
        return getAgents().iterator();
}

	public static void main (String[] args) {
        SimulationPanel panel = new SimulationPanel(new PDFactory());
        panel.display();
    }
}