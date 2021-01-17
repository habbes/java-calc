public class Parser {

    public Expression parse(String input) {
        if (input.startsWith("let")) {
            return parseAssignment(input);
        }

        return parseCalculation(input);
    }

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
            System.out.println("Invalid token " + curToken);
            pos++;
        }

        
        }
        
        return root;
    }
}
