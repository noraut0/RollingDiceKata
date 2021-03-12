package src;


import Random.RNG;

public class Roll {

    public enum RollType {
        NORMAL,
        ADVANTAGE,
        DISADVANTAGE
    }

    public int diceValues;
    public int nbRolls = 1;
    public int modifiers = 0;
    public int value = 0;

    // Attributes

    public Roll(String formula) {
        int int_modifier = 0, int_nbRoll = 1, int_diceValue;

        int d = formula.indexOf("d");

        if(formula.charAt(d) == 0){

            String s_nbRoll = formula.substring(0,d);
            int_nbRoll = Integer.parseInt(s_nbRoll);

        }



        String s_diceValue = formula.substring(d+1,d+2);
        int_diceValue = Integer.parseInt(s_diceValue);

        if( formula.substring(d + 2) == null) {
            System.out.println(int_nbRoll);

            String s_modifier = formula.substring(d + 2);
            int_modifier = Integer.parseInt(s_modifier);
        }

        System.out.println(int_nbRoll);
        System.out.println(int_diceValue);
        System.out.println(int_modifier);

        diceValues = int_diceValue;
        nbRolls = int_nbRoll;
        modifiers = int_modifier;

    }


    public Roll(int diceValue, int nbRoll, int modifier) {

        diceValues = diceValue;
        nbRolls = nbRoll;
        modifiers = modifier;


    }

    public int makeRoll(RollType rollType) {


        int i;

        if(nbRolls <= 0 || diceValues <= 0){
            return -1;
        }

        for( i = 0 ; i < nbRolls ; i++){

            int val1 = 0;
            int val2 = 0;

            if( rollType == RollType.NORMAL){


                value += RNG.random( diceValues );
            }


            if( rollType == RollType.ADVANTAGE){


                val1 = RNG.random( diceValues );
                val2 = RNG.random( diceValues );
                value = (val1 <= val2 ? val2 : val1);

            }

            if( rollType == RollType.DISADVANTAGE){

                val1 = RNG.random( diceValues );
                val2 = RNG.random( diceValues );
                value = (val1 >= val2 ? val2 : val1);
            }

        }
        value += modifiers;

        if( value < 0){

            value = 0;
        }

        return value;
    }

}
