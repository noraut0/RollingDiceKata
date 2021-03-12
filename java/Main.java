import Random.RNG;
import Random.RNGImpl;
import src.Roll;

public class Main {

    public static void main(String[] args) {
        RNG.setImpl(new RNGImpl());

        Roll r_formula = new Roll("2d6");
        System.out.println(r_formula.makeRoll(Roll.RollType.NORMAL));


        /*Roll r_normal = new Roll(6,2,2);
        System.out.println(r_normal.makeRoll(Roll.RollType.NORMAL));*/





    }
}
