/**
 * The base interface for a symbol table
 */
public interface SymbolTable {
    /**
     * Returns the value of the specified variable
     * @param name
     * @return
     */
    int getValue(String name);
    /**
     * Sets the value of the specified variable.
     * If the variable does not exist, it is created.
     * If it already exists, its value is updated.
     * @param name name of the variable
     * @param value value to set the variable to
     */
    void setVariable(String name, int value); 
}
