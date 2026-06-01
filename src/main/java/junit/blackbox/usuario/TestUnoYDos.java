package junit.blackbox.usuario;

import junit.blackbox.framework.After;
import junit.blackbox.framework.Before;
import junit.blackbox.framework.TestUnitario;

import java.util.ArrayList;

import static junit.blackbox.framework.MyAssert.assertEquals;

public class TestUnoYDos {
    private ArrayList<String> list;

    @Before
    public void before() {
        list = new ArrayList<>();
    }

    @TestUnitario
    public void unTest() throws Exception {
        list.add("Hola");
        list.add("Mundo");
        assertEquals(2, list.size());
    }

    @TestUnitario
    public void otroTest() throws Exception {
        list.add("Hola");
        assertEquals("Hello", list.get(0));
    }

    @After
    public void after() {
        list = new ArrayList<>();
    }
}

