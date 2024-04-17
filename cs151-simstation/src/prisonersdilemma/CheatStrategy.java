package prisonersdilemma;
import java.io.Serializable;
import java.util.*;

public class CheatStrategy implements Strategy, Serializable {
    @Override
    public boolean decide(HashMap<Prisoner, Boolean> grudges, Prisoner partner) {
        return false;
    }
}