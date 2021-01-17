public class NumberExpression extends Expression {
    int value;

    public NumberExpression(int value) {
        super();
        this.value = value;
    }

    public int getValue(SymbolTable symbols) {
        return value;
    }

    public String toString() {
        return Integer.toString(value);
    }
}