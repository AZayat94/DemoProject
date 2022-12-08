package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Televisions {
    private  WebDriver driver;
    JavascriptExecutor js;
    private By Samsung_Brand = By.xpath("//*[@class='a-size-base a-color-base'][normalize-space()='Samsung']");

    public Televisions(WebDriver driver){
        this.driver = driver;
    }

    @Step("Filtering with Samsung brand Tv")
    public SamsungTvs Filter_With_Samsung_Brand(){
        ScrollIntoView(Samsung_Brand);
        driver.findElement(Samsung_Brand).click();
        return new SamsungTvs(driver);
    }
    public void ScrollIntoView(By element){
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
    }
}
