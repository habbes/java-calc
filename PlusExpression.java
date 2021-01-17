public class PlusExpression extends BinaryExpression {
    public PlusExpression(Expression left, Expression right) {
        super(left, right);
    }

    public int operate(int left, int right) {
        return left + right;
    }

    public String getLabel() {
        return "+";
    }
}