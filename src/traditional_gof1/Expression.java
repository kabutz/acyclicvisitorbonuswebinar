package traditional_gof1;

public abstract class Expression {
  public abstract void accept(Visitor v);
}
