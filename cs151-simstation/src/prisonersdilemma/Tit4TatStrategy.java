package prisonersdilemma;
import java.io.Serializable;
import java.util.*;

public class Tit4TatStrategy implements Strategy, Serializable {
    @Override
    public boolean decide(HashMap<Prisoner, Boolean> grudges, Prisoner partner) {
        return !grudges.containsKey(partner) || !grudges.get(partner);
    }
}