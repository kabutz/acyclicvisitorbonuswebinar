package methodhandles_gof1;

import java.lang.invoke.*;
import java.util.*;
import java.util.concurrent.*;

public abstract class Expression {
  private final static Map<Class<? extends Expression>, MethodHandle> methodHandleCache =
      new ConcurrentHashMap<>();
  private final MethodHandle visitMethod =
      methodHandleCache.computeIfAbsent(getClass(), this::getVisitMethodHandle);

  private MethodHandle getVisitMethodHandle(Class<? extends Expression> expClass) {
    try {
      System.out.println("Looking for visit() method handle for " + expClass);
      return MethodHandles.publicLookup().findVirtual(
          getVisitorClass(), "visit", MethodType.methodType(void.class,
              expClass)
      );
    } catch (ReflectiveOperationException e) {
      throw new Error(e);
    }
  }

  private static final MethodHandle defaultVisitMethod;

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
