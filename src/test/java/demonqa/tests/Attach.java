package demonqa.tests;

public class Attach extends WebHelper {
    public static void addAttachments() {
        takeScreenShot();
        addPageSource();
        addVideo();
        browserConsoleLog();
    }
}
