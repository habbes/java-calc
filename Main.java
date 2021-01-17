import java.util.*;

class Main {
  public static void main(String[] args) {
    //"1 + 2 + 5 - 4";
    //l = new ArrayList<>();
    //l.add(1);
    //l.add(2);

    // Expression expr = new Expression("-",
    //   new Expression("+",
    //     new Expression("+",
    //       new Expression("1"),
    //       new Expression("2")),
    //     new Expression("5")),
    //   new Expression("4")
    // );

    // System.out.println(expr);
    // int value = expr.getValue();
    // System.out.println(value);
    Scanner console = new Scanner(System.in);
    System.out.println("Welcome to our calculator:");
    while (true) {
        System.out.print("> ");
        String input = console.nextLine();

        if (input.equals("exit")) {
            System.out.println("bye!");
            break;
        }

        Expression expr = parse(input);
        // System.out.println(expr);
        System.out.println(expr.getValue());

        
    }
  }

  public static Expression parse(String code) {
    String[] tokens = code.split(" ");
    int pos = 0;
    // "1 + 2 - 3";
    Expression root = null;
    while (pos < tokens.length)
    {
      String curToken = tokens[pos];
      if (curToken.equals("+") || curToken.equals("-")) {
        ++pos;
        String nextToken = tokens[pos];
        Expression rightChild = new Expression(nextToken);

        // new Exp(+, 1, 2)
        // new Exp(-, new Exp(+ 1, 2), 3)
        Expression operatorExp = new Expression(curToken, 
          root, rightChild);
        
        root = operatorExp;
        pos++;
      }
      else if (root == null){
        root = new Expression(curToken);
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