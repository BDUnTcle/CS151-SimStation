package PDtournament;
import java.io.Serializable;
import java.util.*;

public class CooperateStrategy extends Strategy implements Serializable {


    @Override
    public boolean decide(HashMap<Prisoner, Boolean> grudges, Prisoner partner) {
        return true;
    }
}