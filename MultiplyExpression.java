/**
 * Represents an expression that multiplies its operands
 */
public class MultiplyExpression extends BinaryExpression {
    public MultiplyExpression(Expression left, Expression right) {
        super(left, right);
    }

    public int operate(int left, int right) {
        return left * right;
    }

    public String getLabel() {
        return "*";
    }
}