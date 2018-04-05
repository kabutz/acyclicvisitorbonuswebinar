package extended_gof;

import traditional_gof1.*;

public class MinusEvalVisitor extends EvalVisitor implements MinusVisitor {
  public void visit(Minus m) {
    push(-pop() + pop());
  }
}
