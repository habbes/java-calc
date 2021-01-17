public class MultiplyExpression extends BinaryExpression {
    public MultiplyExpression(Expression left, Expression right) {
        super(left, right);
    }

    public int getValue(SymbolTable symbols) {
        return getLeft().getValue(symbols) * getRight().getValue(symbols);
    }

    public String toString() {
        return getLeft().toString() + " * " + getRight().toString();
    }
}