public class AssignmentExpression extends Expression {
    String varName;
    
    public AssignmentExpression(String varName, Expression value) {
        super(value);
        this.varName = varName;
    }

    public int getValue(SymbolTable symbols) {
        int value = children.get(0).getValue(symbols);
        symbols.setVariable(varName, value);
        return value;
    }

    public String toString() {
        return varName + " = " + children.get(0).toString();
    }
}