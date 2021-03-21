package src;


import Random.RNG;


public class Roll {

    public enum RollType {
        NORMAL,
        ADVANTAGE,
        DISADVANTAGE
    }

    public int validFormula = 1;
    public int diceValues;
    public int nbRolls;
    public int modifiers;
    public int value = 0;


    public Roll(String formula) {

        // variables returned with default value
        int int_modifier = 0, int_nbRoll = 1, int_diceValue = 6;

        //separators
        int d = formula.indexOf("d");
        int add_less = (formula.indexOf("-") != -1 ? formula.indexOf("-") : formula.indexOf("+") != -1 ? formula.indexOf("+") : -1 );

        //testing nb roll <= 0 and if there is no character
        if(d > 0){

            if( IsNumeric(formula.substring(0,d)) ){

                String s_nbRoll = formula.substring(0,d);
                int_nbRoll = Integer.parseInt(s_nbRoll);

            }else validFormula = 0;

        } else if(d == -1) validFormula = 0;



        //testing if there modifier then verify if string is totally numeric and not empty
        if (add_less != -1) {

            //check if string != "" and if add_less that we find is not before d
            if (d+1 < add_less && IsNumeric(formula.substring(d + 1, add_less))) {

                String s_diceValue = formula.substring(d + 1, add_less);
                int_diceValue = Integer.parseInt(s_diceValue);

            } else validFormula = 0;
        } else {
            if (IsNumeric(formula.substring(d + 1))) {

                String s_diceValue = formula.substring(d + 1);
                int_diceValue = Integer.parseInt(s_diceValue);

            } else validFormula = 0;
        }

        // testing if modifier exist and then check if modifier is numeric
        if(  add_less != -1  ) {

            if( IsNumeric(formula.substring( add_less + 1 )) ){

                String s_modifier = formula.substring(add_less);
                int_modifier = Integer.parseInt(s_modifier);

            }else validFormula = 0;

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

    // function that check if every chars of a string are numbers
    public boolean IsNumeric( String value){

        for( int i = 0 ; i < value.length() ; i++){

            int character = value.charAt(i);

            if(character < 48 || character > 58){
                return false;

            }
        }
        return true;
    }

    public int makeRoll(RollType rollType) {

        //if the formula isn't valid return -1
        if(validFormula == 0){
            return -1;
        }

        // check if rolls and dice value aren't negative
        if(nbRolls <= 0 || diceValues <= 0){
            return -1;
        }

        // roll the dice n time and add the result to value
        for( int i = 0 ; i < nbRolls ; i++){

            int val1;
            int val2;

            //if roll type is normal
            if( rollType == RollType.NORMAL) value += RNG.random( diceValues );

            //if roll type is advantage
            if( rollType == RollType.ADVANTAGE){


                val1 = RNG.random( diceValues );
                val2 = RNG.random( diceValues );
                value = (val1 <= val2 ? val2 : val1);

            }

            //if roll type is disadvantage
            if( rollType == RollType.DISADVANTAGE){

                val1 = RNG.random( diceValues );
                val2 = RNG.random( diceValues );
                value = (val1 >= val2 ? val2 : val1);
            }

        }

        // add modifier to result
        value += modifiers;

        //if result isn't positive then result become 0
        if( value < 0){

            value = 0;
        }

        return value;
    }

}
