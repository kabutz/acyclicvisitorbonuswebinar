package scratch.mariofusco;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class LambdaVisitorDouble implements ToDoubleFunction<Object> {
  private Map<Class<?>, ToDoubleFunction<Object>> fMap = new ConcurrentHashMap<>();

  public <B> Acceptor<B> on(Class<B> clazz) {
    return new Acceptor(this, clazz);
  }

  @Override
  public double applyAsDouble(Object o) {
    return fMap.get(o.getClass()).applyAsDouble(o);
  }

  static class Acceptor<B> {
    private final LambdaVisitorDouble visitor;
    private final Class<B> clazz;

    public Acceptor(LambdaVisitorDouble visitor, Class<B> clazz) {
      this.visitor = visitor;
      this.clazz = clazz;
    }

    public LambdaVisitorDouble then(ToDoubleFunction<B> f) {
      @SuppressWarnings("unchecked")
      ToDoubleFunction<Object> fobj = (ToDoubleFunction<Object>) f;
      visitor.fMap.put(clazz, fobj);
      return visitor;
    }
  }
}
