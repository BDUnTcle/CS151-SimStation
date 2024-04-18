package PDtournament;
import mvc.*;
import java.io.Serializable;
import java.util.*;

public class RandomlyCooperateStrategy extends Strategy implements Serializable {


    @Override
    public boolean decide(HashMap<Prisoner, Boolean> grudges, Prisoner partner) {
        return Utilities.rng.nextInt(100) % 2 == 0;
    }
}