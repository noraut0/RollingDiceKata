package src;


public class Roll {

    public enum RollType {
        NORMAL,
        ADVANTAGE,
        DISADVANTAGE
    }

    // Attributes

    public Roll(String formula) {


        int d = formula.indexOf("d");
        String nbRoll = formula.substring(0,d);
        int nbRoll2 = Integer.parseInt(nbRoll);

        String diceValue = formula.substring(d+1,d+2);
        int diceValue2 = Integer.parseInt(diceValue);

        String modifier = formula.substring(d+2,d+4);
        int modifier2 = Integer.parseInt(modifier);

        System.out.println(nbRoll2);
        System.out.println(diceValue2);
        System.out.println(modifier2);

        Roll r = new Roll(diceValue2, nbRoll2, modifier2);



    }

    public Roll(int diceValue, int nbRoll, int modifier) {
        // TODO
    }

    public int makeRoll(RollType rollType) {
        // TODO
        return 0;
    }

}
