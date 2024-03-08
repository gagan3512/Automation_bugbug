public class TestReport {
    public static void report(String testName, boolean result) {
        String status = result ? "PASS" : "FAIL";
        System.out.println("Test: " + testName + ", Status: " + status);
        // You can implement additional reporting mechanisms here, such as writing to a file or database
    }
}
