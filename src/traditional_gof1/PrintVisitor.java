package traditional_gof1;

import java.util.*;

public class PrintVisitor implements Visitor {
  private final StringBuilder sb = new StringBuilder();

  public void visit(Number n) {
    sb.append(n.getValue()).append(' ');
  }

  public void visit(Plus p) {
    sb.append("+ ");
  }

  public void visit(Expression expression) {
    sb.append("? ");
  }

  public String toString() {
    return sb.toString().trim();
  }
}
