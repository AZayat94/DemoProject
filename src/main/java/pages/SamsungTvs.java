package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SamsungTvs {
    private  WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

    private By Sort_List = By.xpath("//select[@id='s-result-sort-select']");
    private By All_Available_Tvs = By.xpath("//*[@class='s-main-slot s-result-list s-search-results sg-row']//span[@class='a-price']");

    public SamsungTvs(WebDriver driver){
        this.driver = driver;
    }

    private Select findDropDownElement(){
        return new Select(driver.findElement(Sort_List));
    }
    public void selectFromDropDown(String option) {
        findDropDownElement().selectByVisibleText(option);
    }

    @Step("Sorting from High to Low")
    public void SortHighToLow(String option) {
        WaitUntilPageLoads();
        selectFromDropDown(option);
        }
    @Step("Select the second highest priced Tv")
    public SecondHighestPricedTv GetAllAvailableTvs(){
        List<WebElement> AvailableTvs = driver.findElements(All_Available_Tvs);
        AvailableTvs.get(1).click();
        Switch_Tabs();
        return new SecondHighestPricedTv(driver);
    }

    public void WaitUntilPageLoads(){
        js = (JavascriptExecutor) this.driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(driver -> (js.executeScript("return document.readyState").equals("complete")));
    }
    public void Switch_Tabs(){
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
    }

}
