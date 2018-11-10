package info.beta3z.tdd;

public class Money {
    protected int amount;

    public boolean equals(Object object){
        Money money = (Money) object;

        return amount == money.amount
                && getClass().equals(money.getClass());
    }

    public static Money dollar(int amount){
        return new Dollar(amount);
    }

    public static Franc franc(int amount){
        return new Franc(amount);
    }

    public Money times(int multiplier){
        Money money = null;

        try {
            money = getClass().getConstructor(int.class).newInstance(this.amount * multiplier);
        } catch(Throwable e) {
            System.out.println(e.getMessage());
        }

        return money;
    }
}
