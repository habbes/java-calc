public class Calculator {
    Parser parser = new Parser();
    SymbolTable symbols = new DefaultSymbolTable();

    public int evaluate(String input) {
        Expression expr = parser.parse(input);
        int value = expr.getValue(symbols);
        return value;
    }
}