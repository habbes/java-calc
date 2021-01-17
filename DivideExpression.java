public class DivideExpression extends BinaryExpression {
    public DivideExpression(Expression left, Expression right) {
        super(left, right);
    }

    public int getValue() {
        return getLeft().getValue() / getRight().getValue();
    }

    public String toString() {
        return getLeft().toString() + " / " + getRight().toString();
    }
}