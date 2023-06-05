import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    @Test
    public void moveToNewPositionTestCase1() { //Rover 1
        String initPositionLine = "1 2 N";
        String commandPositionLine = "LMLMLMLMM";

        assertEquals("1 3 N", Parser.moveToNewPosition(initPositionLine, commandPositionLine));
    }

    @Test
    public void moveToNewPositionTestCase2() {//Rover 2
        String initPositionLine = "3 3 E";
        String commandPositionLine = "MMRMMRMRRM";
        assertEquals("5 1 E", Parser.moveToNewPosition(initPositionLine, commandPositionLine));
    }
}
