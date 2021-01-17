import java.util.*;

public interface SymbolTable {
    int getValue(String name);
    void setVariable(String name, int value); 
}
