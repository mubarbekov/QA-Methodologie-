import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CanDriveTest { 

    @Test
    void testUnderAge(){
        assertFalse(Driving.canDrive(15), "15 is not legal age");
    }

    @Test
    void testMinimumAge(){
        assertTrue(Driving.canDrive(16), "16 is legal age");
    }

     @Test
    void testAdultAge(){
        assertTrue(Driving.canDrive(22), "22 is legal age");
    }

    @Test
    void testZeroAge(){
        assertTrue(Driving.canDrive(0), "0 is not legal age");
    }

     @Test
    void testMinusAge(){
        assertTrue(Driving.canDrive(-12), "-12 is not legal age");
    }
    

   
