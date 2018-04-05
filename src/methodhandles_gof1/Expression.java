package methodhandles_gof1;

import java.lang.invoke.*;

public abstract class Expression {
  private final MethodHandle visitMethod;
  private static final MethodHandle defaultVisitMethod;

  {
    try {
      visitMethod = MethodHandles.publicLookup().findVirtual(
          getVisitorClass(), "visit", MethodType.methodType(void.class,
              getClass())
      );
    } catch (ReflectiveOperationException e) {
      throw new Error(e);
    }
  }

  static {
    try {
      defaultVisitMethod = MethodHandles.publicLookup().findVirtual(
          Visitor.class, "visit", MethodType.methodType(void.class,
              Expression.class)
      );
    } catch (ReflectiveOperationException e) {
      throw new Error(e);
    }
  }

  protected Class<? extends Visitor> getVisitorClass() {
    return Visitor.class;
  }

  public void accept(Visitor v) {
    try {
      if (getVisitorClass().isAssignableFrom(v.getClass())) {
        visitMethod.invoke(v, this);
      } else {
        defaultVisitMethod.invoke(v, this);
      }
    } catch (RuntimeException | Error unchecked) {
      throw unchecked;
    } catch (Throwable throwable) {
      throw new AssertionError(throwable);
    }
  }
}
