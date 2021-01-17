// since BinaryExpression does not implement the getValue() abstract
// method declared in Expression class
// BinaryExpression also has to be an abstract class itself,
// You cannot do new BinaryExpression

/**
 * represents an operation that has two operands
 */
abstract public class BinaryExpression extends Expression {
    public BinaryExpression(Expression left, Expression right) {
        super(left, right);
    }


    public Expression getLeft() {
        return children.get(0);
    }

    public Expression getRight() {
        return children.get(1);
    }
}