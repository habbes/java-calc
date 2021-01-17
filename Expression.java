import java.util.*;


public class Expression {
  String label;
  List<Expression> children = new ArrayList<>();

  public Expression(String label) {
    this.label = label;
  }

  public Expression(String label, Expression... children) {
    this.label = label;
    for (Expression child: children) {
      this.children.add(child);
    }
  }

  public int getValue() {
    if (label.equals("-")) {
      Expression left =  children.get(0);
      Expression right = children.get(1);
      return left.getValue() - right.getValue();
    }
    if (label.equals("+")) {
      Expression left =  children.get(0);
      Expression right = children.get(1);
      return left.getValue() + right.getValue();
    }

    // if neither + nor -, we assume label
    // contans an integer number
    int value = Integer.parseInt(label);
    return value;
  }

  public String toString() {
    String s = label;
    if (children.size() > 0) {
      s += "( ";
      for (Expression child: children) {
        s += child.toString() + " ";
      }
      s += ")";
    }

    return s;
  }
}