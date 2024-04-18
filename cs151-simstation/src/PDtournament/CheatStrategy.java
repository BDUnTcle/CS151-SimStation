package PDtournament;
import java.io.Serializable;
import java.util.*;

public class CheatStrategy extends Strategy implements Serializable {

    @Override
    public boolean decide(HashMap<Prisoner, Boolean> grudges, Prisoner partner) {
        return false;
    }
}