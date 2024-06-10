import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator cal;

    @BeforeEach
    public void setup(){
        cal = new Calculator();
    }


    @Test
    public void add(){
        Assertions.assertEquals(9, cal.add(3, 6));
    }
    @Test
    public void subtract(){
        Assertions.assertEquals(3, cal.add(6, 3));
    }
    @AfterEach
    public void teardown(){
        System.out.println("teardown");
    }
}
