public class MultiplyExpression extends BinaryExpression {
    public MultiplyExpression(Expression left, Expression right) {
        super(left, right);
    }

    public int getValue() {
        return getLeft().getValue() * getRight().getValue();
    }

    public String toString() {
        return getLeft().toString() + " * " + getRight().toString();
    }
}