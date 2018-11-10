package info.beta3z.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class InterCurrencyOperationsTest {
    @Test
    public void testEquality(){
        assertFalse(new Franc(5).equals(new Dollar(5)));
    }
}
