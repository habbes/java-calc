import java.util.*;

class Main {
  public static void main(String[] args) {
    //"1 + 2 + 5 - 4";
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
    while (true) {
        System.out.print("> ");
        String input = console.nextLine();

        if (input.equals("exit")) {
            System.out.println("bye!");
            break;
        }

        Expression expression = parse(input);
        // System.out.println(expr);
        System.out.println(expression.getValue());

        
    }
  }

  public static void printValue(Expression expr)
  {
      System.out.println(expr.getValue());
  }

  public static Expression parse(String code) {
    String[] tokens = code.split(" ");
    int pos = 0;
    // "1 + 2 - 3";
    Expression root = null;
    
    while (pos < tokens.length)
    {
      String curToken = tokens[pos];
      if (curToken.equals("+") || curToken.equals("-")
      || curToken.equals("*") || curToken.equals("/")) {
        ++pos;
        String nextToken = tokens[pos];
        Expression rightChild = ExpressionFactory.createNumber(nextToken);

        // new Exp(+, 1, 2)
        // new Exp(-, new Exp(+ 1, 2), 3)
        Expression operatorExp = ExpressionFactory.createBinary(curToken, root, rightChild);
        root = operatorExp;
        pos++;
      }
      else if (root == null){
        root = ExpressionFactory.createNumber(curToken);
        pos++;
      }
      else {
        System.out.println("Invalid token " + curToken);
        pos++;
      }

      
    }
    
    return root;
  }
}