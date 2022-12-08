package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;
    private By Hamburger_Menu = By.id("nav-hamburger-menu");
    private By Tv_Appliances = By.xpath("//div[normalize-space()='TV, Appliances, Electronics']");
    private By Television = By.xpath("//a[normalize-space()='Televisions']");
    private By TodayDealBtn = By.partialLinkText("Today's Deals");
    private By PageHeader = By.xpath("//h1[@class='a-size-extra-large a-spacing-micro']");
    private By CartCount = By.id("nav-cart-count-container");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    @Step("Clicking on Ham menu")
    public void ClickOnHamburgerMenu() {
        driver.findElement(Hamburger_Menu).click();
    }
    @Step("Selecting Tv Appliances from Menu")
    public void SelectTvAppliances(){
        ScrollIntoView(Tv_Appliances);
        WaitUntilVisibility(Tv_Appliances);
        driver.findElement(Tv_Appliances).click();
        WaitUntilVisibility(Television);

    }
    @Step("Selecting Television Section")
    public Televisions SelectTelevisions() {
//        WaitUntilVisibility(Television);
        driver.findElement(Television).click();
        return new Televisions(driver);
    }

    public void ScrollIntoView(By element){
        js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
    }

    public void WaitUntilVisibility(By element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
    }
    @Step("Open Today's Deal Page")
    public void OpenTodayDeal(){
        driver.findElement(TodayDealBtn).click();
    }
    @Step("Getting page header")
    public String GetPageHeader(){
       return driver.findElement(PageHeader).getText();
    }
    @Step("Getting item count in the cart")
    public int GetCartCount(){
       return Integer.parseInt(driver.findElement(CartCount).getText())  ;
    }

}

