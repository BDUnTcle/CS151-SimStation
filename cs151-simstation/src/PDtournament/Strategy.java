package PDtournament;
import java.util.*;

public abstract class Strategy {
    private Prisoner myPrisoner;
    public Strategy()
    {
        myPrisoner = null;
    }
    public void setPrisoner(Prisoner p)
    {
        myPrisoner = p;
    }
    abstract public boolean decide(HashMap<Prisoner, Boolean> grudges, Prisoner partner);
}