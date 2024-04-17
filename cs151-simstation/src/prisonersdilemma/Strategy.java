package prisonersdilemma;
import simstation.*;
import mvc.*;
import java.util.*;

public interface Strategy {
    public boolean decide(HashMap<Prisoner, Boolean> grudges, Prisoner partner);
}