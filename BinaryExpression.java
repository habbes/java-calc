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

    public int getValue(SymbolTable symbols) {
        // all binary operations have a left and right children,
        // they all evaluate the children then apply the
        // operation to the values of the children.
        // Since this is common for all binary operations,
        // it's implemented here in base class to avoid
        // duplicating code
        int left = getLeft().getValue(symbols);
        int right = getRight().getValue(symbols);

        // this will call the operate method implemented
        // by the child class, e.g. PlusExpression.operate(left, right)
        return operate(left, right);
    }

    public String toString() {
        return getLeft().toString() + " " + getLabel() + " " + getRight().toString();
    }
    
    // The following abstract methods should
    // be implemented by the child classes
    // e.g. PlusOperation's operate() will implement
    // a simple addition of the two operands

    /**
     * computes the binary operation with the
     * given operands
     * @param left
     * @param right
     * @return
     */
    abstract int operate(int left, int right);

    /**
     * Returns the sign symbol of this operation
     * for display purposes, e.g. '+', '-'
     * @return
     */
    abstract String getLabel();
}