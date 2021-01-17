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

    public static Expression createNumber(String numStr) {
        return new NumberExpression(Integer.parseInt(numStr));
    }
}