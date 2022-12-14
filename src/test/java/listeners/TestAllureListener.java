package listeners;

import Base.BaseTests;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;


public class TestAllureListener implements ITestListener {
    // Text attachments for Allure

    @Override
    public void onTestFailure(ITestResult Result) {
        try {
            saveScreenshotPNG();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        saveTextLog(Result.getMethod().getConstructorOrMethod().getName() + "Screenshot Saved.");
    }
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    // Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() throws IOException {
        return ((TakesScreenshot) BaseTests.getDriver()).getScreenshotAs(OutputType.BYTES);
    }


    }