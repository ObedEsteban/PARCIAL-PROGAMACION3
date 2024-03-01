// EJEMPLO UNITARIAS



import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCalculadora {
    @Test
    public void testSuma() {
        Calculadora calc = new Calculadora();
        assertEquals(5, calc.sumar(2, 3));
    }

    @Test
    public void testResta() {
        Calculadora calc = new Calculadora();
        assertEquals(2, calc.restar(5, 3));
    }
}

class Calculadora {
    public int sumar(int a, int b) {
        return a + b;
    }

    public int restar(int a, int b) {
        return a - b;
    }
}
