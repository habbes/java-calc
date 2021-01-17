import java.util.*;

public class DefaultSymbolTable implements SymbolTable {
    Map<String, Integer> symbols = new HashMap<>();

    public int getValue(String varName) {
        return symbols.get(varName);
    }

    public void setVariable(String varName, int value) {
        symbols.put(varName, value);
    }
}