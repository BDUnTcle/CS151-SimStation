package prisonersdilemma;
import mvc.*;
import java.io.Serializable;
import java.util.*;

public class RandomlyCooperateStrategy implements Strategy, Serializable {

    @Override
    public boolean decide(HashMap<Prisoner, Boolean> grudges, Prisoner partner) {
        return Utilities.rng.nextInt(100) % 2 == 0;
    }
}