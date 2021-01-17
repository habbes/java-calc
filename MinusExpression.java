/**
 * Represents an expression that subtracts its operands
 */
public class MinusExpression extends BinaryExpression {
    public MinusExpression(Expression left, Expression right) {
        super(left, right);
    }

    public int operate(int left, int right) {
        return left - right;
    }

    public String getLabel() {
        return "-";
    }
}