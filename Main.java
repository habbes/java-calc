import java.util.*;

class Main {
  public static void main(String[] args) {
    //"1 + 2 + 5 - 4";

    // "> let a = 10"
    // > a + 3
    // -> 13
    // "let b = 10 + a"
    // b + 3
    // -> 23
    // let a = a + 1;
    // a -> 11

    //l = new ArrayList<>();
    //l.add(1);
    //l.add(2);

    // Expression expr = new MinusExpression(
    //   new PlusExpression(
    //     new PlusExpression(
    //       new NumberExpression(1),
    //       new NumberExpression(2)),
    //     new NumberExpression(5)),
    //   new NumberExpression(4)
    // );

    // System.out.println(expr);
    // int value = expr.getValue();
    // System.out.println(value);
    
    // polymorphism
    // Expression expr = new MinusExpression(
    //     new NumberExpression(10),
    //     new NumberExpression(20));
    // System.out.println(expr);
    // System.out.println(expr.getValue());
    // Expression expr2 = expr;
    // PlusExpression expr3 = (PlusExpression) expr;

    // List<Integer> myList = new ArrayList<>();
    // List<Integer> otherList = new LinkedList<>();
    

    Scanner console = new Scanner(System.in);
    System.out.println("Welcome to our calculator:");
    Parser parser = new Parser();
    SymbolTable symbols = new DefaultSymbolTable();
    while (true) {
        System.out.print("> ");
        String input = console.nextLine();

        if (input.equals("exit")) {
            System.out.println("bye!");
            break;
        }
        
        Expression expression = parser.parse(input);
        // System.out.println(expr);
        System.out.println(expression.getValue(symbols));
        
    }
  }
}