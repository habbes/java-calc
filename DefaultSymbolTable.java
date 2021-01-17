import java.util.*;

/**
 * Default implementation of a SymbolTable
 */
public class DefaultSymbolTable implements SymbolTable {
    Map<String, Integer> symbols = new HashMap<>();

    public int getValue(String varName) {
        if (!symbols.containsKey(varName)) {
            throw new RuntimeException("Undefined variable '" + varName + "'!");
        }
        return symbols.get(varName);
    }

    public void setVariable(String varName, int value) {
        symbols.put(varName, value);
    }
}