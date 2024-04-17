package prisonersdilemma;
import mvc.*;
import simstation.*;
import java.util.*;

public class Prisoner extends Agent {
    private static final int RADIUS = 20;
    private static final int MOVE_AMT = 10;
    private int fitness = 0;
    private int gains = 0;
    private int vindictiveness;
    private boolean cheated = false;
    private HashMap<Prisoner, Boolean> grudges;
    private Strategy strat;
    private int stratAsInt;
    
    public Prisoner(Strategy strat, int i) {
        super();
        this.strat = strat;
        this.stratAsInt = i;
        this.vindictiveness = Utilities.rng.nextInt(PDSimulation.MAX_VINDICTIVENESS);
        grudges = new HashMap<>();
    }

    public boolean cooperate(Prisoner partner) {
        return strat.decide(grudges, partner);
    }

    public void update() {
        Prisoner partner = (Prisoner)world.getNeighbor(this, RADIUS);
        boolean decision = cooperate(partner);
        boolean partnerDescision;
        if (partner != null && partner.strat != null) {
            partnerDescision = partner.cooperate(this);
            if (decision && partnerDescision) {
                updateFitness(3);
                updateGains(3);
                partner.updateFitness(3);
                partner.updateGains(3);
                cheated = false;
                partner.cheated = false;
                grudges.put(partner,false);
            } else if (!decision && !partnerDescision) {
                updateFitness(1);
                updateGains(1);
                partner.updateFitness(1);
                partner.updateGains(1);
                cheated = true;
                partner.cheated = true;
                grudges.put(partner,true);
            } else if (decision) {  
                updateFitness(0);
                updateGains(0);
                partner.updateFitness(5);
                partner.updateGains(5);
                cheated = true;
                partner.cheated = false;
                grudges.put(partner,true);
            } else {    
                updateFitness(5);
                updateGains(5);
                partner.updateFitness(0);
                partner.updateGains(0);
                cheated = false;
                partner.cheated = true;
                grudges.put(partner,false);
            }
            
            if (cheated && stratAsInt != 0 && fitness >= 3 && vindictiveness > 0) {
                int punishment = Utilities.rng.nextInt(vindictiveness);
                if (punishment >= PDSimulation.PUNISH_THRESHOLD) {//
                    updateFitness(-3);
                    partner.updateFitness(-10);
                }
            }
        }
       
        for (int i=0; i<MOVE_AMT; i++) {
            heading = Heading.random();
            move(1);
        }
    }

    private void updateFitness(int amt) {
        fitness = fitness + amt;
    }

    public int getFitness() { 
    	return fitness; 
    }

    public int getStratAsInt() {
    	return stratAsInt; 
    }
    
    public void updateGains(int amt) {
        gains = amt;
    }

    public int getGains() { 
    	return gains; 	
    }
}