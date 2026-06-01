package junit.whitebox.v2.framework;

import java.lang.reflect.Method;

public abstract class TestCase {

    public static final String METHOD_NAME_START = "test";

    public final void run() {
        Method[] methods = this.getClass().getMethods();
        for (Method method : methods) {
            if (isTestMethod(method)) {
                try {
                    before();
                    method.invoke(this);
                    System.out.println("[OK] " + method.getName());
                } catch (Exception e) {
                    Throwable cause = e.getCause(); // unwrap
                    System.out.println("[FAIL] " + method.getName() + ": " + (cause != null ? cause.getMessage() : e.getMessage()));
                } finally {
                    after();
                }
            }
        }
    }

    private boolean isTestMethod(Method method) {
        return method.getName().startsWith(METHOD_NAME_START) &&
                method.getParameterCount() == 0 &&
                method.getReturnType().equals(void.class);
    }

    protected void before() {
    }

    protected void after() {
    }
}