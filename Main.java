import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    System.out.println("Welcome to our calculator:");
    Calculator calc = new Calculator();
    
    while (true) {
        System.out.print("> ");
        String input = console.nextLine();

        if (input.equals("exit")) {
            System.out.println("bye!");
            break;
        }
        
        int value = calc.evaluate(input);
        
        System.out.println(value);
    }
  }
}