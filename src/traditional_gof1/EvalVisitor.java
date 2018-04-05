package traditional_gof1;

import java.util.*;

public class EvalVisitor implements Visitor {
  private final Deque<Integer> stack = new ArrayDeque<>();

  protected int pop() {
    return stack.pop();
  }

  protected void push(int number) {
    stack.push(number);
  }

  public void visit(Number n) {
    push(n.getValue());
  }

  public void visit(Plus p) {
      push(pop() + pop());
  }

  public int getValue() {
    assert stack.size() == 1;
    return stack.getLast();
  }
}
