package prisonersdilemma;
import java.io.Serializable;
import java.util.*;

public class CooperateStrategy implements Strategy, Serializable {

    @Override
    public boolean decide(HashMap<Prisoner, Boolean> grudges, Prisoner partner) {
        return true;
    }
}