package PDtournament;
import java.io.Serializable;
import java.util.*;

public class Tit4TatStrategy extends Strategy implements Serializable {

    @Override
    public boolean decide(HashMap<Prisoner, Boolean> grudges, Prisoner partner) {
        return !grudges.containsKey(partner) || !grudges.get(partner);
    }
}