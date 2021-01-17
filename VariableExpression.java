/**
 * An expression containing a variable.
 */
class VariableExpression extends Expression {
    String name;

    public VariableExpression(String name) {
        this.name = name;
    }

    public int getValue(SymbolTable symbols) {
        return symbols.getValue(name);
    }

    public String toString() {
        return name;
    }
}