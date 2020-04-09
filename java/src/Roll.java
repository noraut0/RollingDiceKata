package src;


/*
    Rules : A launch have this form <NumberLaunch>d<ValueLaunch>+<Modifier>
    A launch cannot be negative (except when the formula is illegal)
    A launch can be done in advantage or disadvantage (first take the highest of 2 roll, the other the lowest)
    A bad formula leads to a return of value -1
    The modifier is optional
    If a negative value is put for the nbRoll or the dice value, the request is incorrect and thus return -1
 */
public class Roll {

    public enum RollType {
        NORMAL,
        ADVANTAGE,
        DISADVANTAGE
    }

    // Attributes

    public Roll(String formula) {
        // TODO
    }

    public Roll(int diceValue, int nbRoll, int modifier) {
        // TODO
    }

    public int makeRoll(RollType rollType) {
        // TODO
        return 0;
    }

}
