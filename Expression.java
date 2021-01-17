import java.util.*;

/*

An abstract class cannot be instantiated, i.e.
you cannot do new Expression()
An abstract class contains some common functionality
that is inherited by other child classes (like NumberExpression,
PlusExpression, etc.)

But it lacks the implementation of some methods (e.g. getValue())
which should be implemented by each "concrete" child class

*/

/**
 * represents an expression tree
 */
abstract public class Expression {
  List<Expression> children = new ArrayList<>();

  public Expression(Expression... children) {
    for (Expression child: children) {
      this.children.add(child);
    }
  }

  
  /*
    The getValue() method below is marked abstract
    and does not have a method body/implementation.

    This is because we don't know what getValue() should do,
    it depends on the actual type of expression we're dealing with.
    So each concrete child class of Expression will provide its
    own implementation for this method.
  */

  /**
   * computes and returns the value of this expression
   */
  abstract public int getValue();
}