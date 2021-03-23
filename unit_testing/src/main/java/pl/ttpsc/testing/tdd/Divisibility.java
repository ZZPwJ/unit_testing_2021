package pl.ttpsc.testing.tdd;

public class Divisibility {

    public boolean isDivisible(int numerator, int denominator) throws CantByZeroException {

        if(denominator == 0) {
            throw new CantByZeroException("Can't by zero!");
        }

        return ((numerator%denominator) == 0);
    }
}

class CantByZeroException extends Exception {

    public CantByZeroException(String message) {
        super(message);
    }
}

