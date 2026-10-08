class InvalidAccountNumberException extends Exception {
    public InvalidAccountNumberException(String message) {
        super(message);
    }
}

class EmptyFieldException extends Exception {
    public EmptyFieldException(String message) {
        super(message);
    }
}

class ZeroAmountException extends Exception {
    public ZeroAmountException (String message) {
        super(message);
    }
}

class NegativeAmountException extends Exception {
    public NegativeAmountException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}