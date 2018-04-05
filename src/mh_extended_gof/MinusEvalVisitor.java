package mh_extended_gof;


import methodhandles_gof1.*;

public class MinusEvalVisitor extends EvalVisitor implements MinusVisitor {
  public void visit(Minus m) {
    push(-pop() + pop());
  }
}
