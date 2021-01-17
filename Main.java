import java.util.*;

class Main {
  public static void main(String[] args) {
    System.out.println("Welcome to the calculator. "
        + "Enter an expression and press Return at the prompt:");

    Scanner console = new Scanner(System.in);
    Calculator calculator = new Calculator();
    
    while (true) {
        System.out.print("> ");
        String input = console.nextLine();

        if (input.equals("exit")) {
            System.out.println("Bye!");
            break;
        }
        
        try {
          int value = calculator.evaluate(input);
          System.out.println(value);
        }
        catch (Exception e) {
          System.out.println("Error occurred: " + e.getMessage());
        }
    }

    console.close();
  }
}