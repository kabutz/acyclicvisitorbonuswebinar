package acyclic1;

public abstract class Expression {
  public abstract void accept(Visitor v);
}
