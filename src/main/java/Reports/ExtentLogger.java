package Reports;

public final class ExtentLogger {

    public static void pass(String message){
        ExtentTestManager.getExtentTest().pass(message);
    }

    public static void fail(String message){
        ExtentTestManager.getExtentTest().fail(message);
    }

    public static void info(String message){
        ExtentTestManager.getExtentTest().info(message);
    }

    public static void skip(String message){
        ExtentTestManager.getExtentTest().skip(message);
    }

}
