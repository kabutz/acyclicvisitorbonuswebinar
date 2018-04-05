package acyclic_extended;

import acyclic1.*;

public class MinusEvalVisitor extends EvalVisitor implements MinusVisitor {
  public void visit(Minus m) {
    push(-pop() + pop());
  }
}
