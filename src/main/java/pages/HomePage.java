package pages;

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

    public void ClickOnHamburgerMenu() {
        driver.findElement(Hamburger_Menu).click();
    }

    public void SelectTvAppliances(){
        ScrollIntoView(Tv_Appliances);
        driver.findElement(Tv_Appliances).click();
    }

    public Televisions SelectTelevisions() {
        WaitUntilVisibility(Television);
        driver.findElement(Television).click();
        return new Televisions(driver);
    }

    public void ScrollIntoView(By element){
        js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
    }

    public void WaitUntilVisibility(By element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public void OpenTodayDeal(){
        driver.findElement(TodayDealBtn).click();
    }
    public String GetPageHeader(){
       return driver.findElement(PageHeader).getText();
    }
    public int GetCartCount(){
       return Integer.parseInt(driver.findElement(CartCount).getText())  ;
    }

}

