package junit.whitebox.v1.usuario;

import junit.whitebox.v1.framework.TestCase;
import junit.whitebox.v1.framework.TestRunner;

public class Main {
    public static void main(String[] args) {
        var tests = new TestCase[]
                {
                        new TestUno(),
                        new TestDos()
                };
        TestRunner.executeAll(tests);
    }
}
