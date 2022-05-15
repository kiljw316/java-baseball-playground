package mini;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calTest() throws Exception {
        Calculator calculator = new Calculator();
        Integer sum = calculator.sum(1, 2);
        System.out.println("sum = " + sum);
    }
}