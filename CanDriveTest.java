public class CanDriveTest { // public name

    public static void main(String[] args) { // the main method that running the code 
        // Run all code one by one
        testAgeBelowDriving();
        testExactDrivingAge();
        testAgeAboveDriving();
        testZeroAge();
        testNegativeAge();
    }

    public static void testAgeBelowDriving() { // the function with age 15
        if (!CanDrive.canDrive(15)) {
            System.out.println("testAgeBelowDriving: PASSED");
        } else {
            System.out.println("testAgeBelowDriving: FAILED");
        }
    }

    public static void testExactDrivingAge() {
        if (CanDrive.canDrive(16)) {
            System.out.println("testExactDrivingAge: PASSED");
        } else {
            System.out.println("testExactDrivingAge: FAILED");
        }
    }

    public static void testAgeAboveDriving() {
        if (CanDrive.canDrive(20)) {
            System.out.println("testAgeAboveDriving: PASSED");
        } else {
            System.out.println("testAgeAboveDriving: FAILED");
        }
    }

    public static void testZeroAge() {
        if (!CanDrive.canDrive(0)) {
            System.out.println("testZeroAge: PASSED");
        } else {
            System.out.println("testZeroAge: FAILED");
        }
    }

    public static void testNegativeAge() {
        if (!CanDrive.canDrive(-10)) {
            System.out.println("testNegativeAge: PASSED");
        } else {
            System.out.println("testNegativeAge: FAILED");
        }
    }
}
