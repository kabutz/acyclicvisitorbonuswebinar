package scratch.remitest;

import java.util.*;

public class EvalVisitor implements Visitor {
  private final Deque<Integer> stack = new ArrayDeque<>();

  protected int pop() {
    return stack.pop();
  }

  protected void push(int value) {
    stack.push(value);
  }

  public void visit(scratch.remitest.Number number) {
    push(number.getValue());
  }

  public void visit(Plus plus) {
    push(pop() + pop());
  }

  public int getValue() {
    if (stack.size() != 1) throw new AssertionError();
    return stack.getLast();
  }
}
