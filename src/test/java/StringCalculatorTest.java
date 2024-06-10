import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    public void setup(){
        stringCalculator = new StringCalculator();
    }

    @Test
    public void parseTest(){
        Assertions.assertEquals(3, stringCalculator.add("3"));
    }


    @Test
    public void parseDefaultDelimeterTest(){
        Assertions.assertEquals(3, stringCalculator.add("1:2"));


    }

    @Test
    public void customDelimeterTest(){
        Assertions.assertEquals(5, stringCalculator.add("//;\n1;2;2"));
    }


    @Test
    public void addNullOrEmptyTest(){
        Assertions.assertEquals(0, stringCalculator.add(" "));
        Assertions.assertEquals(0, stringCalculator.add(null));
    }

    @Test
    public void addNegativeNumTest(){
        Assertions.assertThrows(RuntimeException.class, ()-> stringCalculator.add("-1:1"));
    }

}