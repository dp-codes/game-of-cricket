package cricket;

import java.util.Random;

public class PlayCricketShot implements PlayShot {
    @Override
    public int hitShot() {
        Random rand=new Random();
        return rand.nextInt(8);
    }
}
