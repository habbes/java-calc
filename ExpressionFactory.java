/**
 * Contains helper methods for creating
 * different kinds of expressions
 */
public class ExpressionFactory {

    public static Expression createBinary(String symbol, Expression left, Expression right) {
        if (symbol.equals("+")) {
            return new PlusExpression(left, right);
        } else if (symbol.equals("-")) {
            return new MinusExpression(left, right);
        }
        else if (symbol.equals("*")) {
            return new MultiplyExpression(left, right);
        }
        else if (symbol.equals("/")) {
            return new DivideExpression(left, right);
        }

        throw new IllegalArgumentException("Unknown expression symbol " + symbol);
    }

    public static Expression createAssignment(String varName, Expression value) {
        return new AssignmentExpression(varName, value);
    }

    public static Expression createSingleValue(String valueStr) {
        try {
            return createNumber(valueStr);
        }
        catch (Exception ex) {
            return createVariable(valueStr);
        }
    }

    public static Expression createNumber(String numStr) {
        return new NumberExpression(Integer.parseInt(numStr));
    }

    public static Expression createVariable(String name) {
        return new VariableExpression(name);
    }
}