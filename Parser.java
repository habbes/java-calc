/**
 * Parses an input string into an expression tree
 */
public class Parser {
    /**
     * Constructs an expression tree
     * corresponding to the given input string
     * @param input expression source code e.g. "3 + 2 + x"
     * @return the constructed expression tree
     */
    public Expression parse(String input) {
        if (input.startsWith("let")) {
            return parseAssignment(input);
        }

        return parseCalculation(input);
    }

    /**
     * Parses an expression like "let x = 10 * 2"
     */
    private Expression parseAssignment(String input) {
        // let x = 10 + 20;
        // let y = x + 1;

        // split into left and right of = symbol:
        // "let x " " 10 + 20"
        String[] parts = input.split("=");
        String leftHandSide = parts[0].trim(); // "let x"
        String rightHandSide = parts[1].trim(); // "10 + 20"
        
        // extract variable name
        String[] leftParts = leftHandSide.split(" "); // ["let", "x"]
        String varName = leftParts[1];

        // parse "10 + 20" into an expression tree
        Expression value = parseCalculation(rightHandSide);

        return ExpressionFactory.createAssignment(varName, value);
    }

    /**
     * Parses an expression like "3 + a * x / 2"
     * @param input
     * @return
     */
    private Expression parseCalculation(String input) {
        String[] tokens = input.split(" ");
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
                Expression rightChild = ExpressionFactory.createSingleValue(nextToken);

                // new Exp(+, 1, 2)
                // new Exp(-, new Exp(+ 1, 2), 3)
                Expression operatorExp = ExpressionFactory.createBinary(curToken, root, rightChild);
                root = operatorExp;
                pos++;
            }
            else if (root == null){
                root = ExpressionFactory.createSingleValue(curToken);
                pos++;
            }
            else {
                // TODO we should throw an exception here
                System.out.println("Invalid token " + curToken);
                pos++;
            }

        
        }
        
        return root;
    }
}
