// this is the "glue" class that puts
// all our main components together
// and exposes the entire functionality
// of our calculator through a very simple
// interface: the evaluate() method
// simply takes input statement as a string and returns its value

public class Calculator {
    Parser parser = new Parser();
    SymbolTable symbols = new DefaultSymbolTable();

    public int evaluate(String input) {
        Expression expr = parser.parse(input);
        int value = expr.getValue(symbols);
        return value;
    }
}