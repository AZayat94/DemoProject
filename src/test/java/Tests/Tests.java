package Tests;

import Base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import listeners.TestAllureListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Tests extends BaseTests {
    String Option = "Price: High to Low";

    @Test(priority = 1, description = "Verifying About item description for Samsung Tv")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verifying About item description for Samsung Tv")
    @Story("Story Name : Samsung Television" )

    public void TestCase1() {
        HomePage.ClickOnHamburgerMenu();
        HomePage.SelectTvAppliances();
        pages.Televisions Televisions = HomePage.SelectTelevisions();
        pages.SamsungTvs SamsungTvs = Televisions.Filter_With_Samsung_Brand();
        SamsungTvs.SortHighToLow(Option);
        pages.SecondHighestPricedTv SecondTv = SamsungTvs.GetAllAvailableTvs();
        Assert.assertTrue(SecondTv.AboutThisItemSection().isDisplayed());
        Assert.assertTrue(SecondTv.GetSectionInfoText().contains("About this item"));
        System.out.println(SecondTv.GetSectionInfoText());
    }

    @Test(priority = 2, description = "Verifying Today's deals title is shown in today's deals page")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifying Today's deals title is shown in today's deals page")
    @Story("Story Name : Page Header" )
    public void TestCase2(){
        HomePage.OpenTodayDeal();
        String Header =  HomePage.GetPageHeader();
        assertEquals(Header,"Today's Deals");
    }

    @Test(priority = 3, description = "Verifying Cart Count is not equal zero")
    @Severity(SeverityLevel.MINOR)
    @Description("Verifying Cart Count is not equal zero")
    @Story("Story Name : Cart Count")
    public void TestCase3(){
        int CartCount =  HomePage.GetCartCount();
        assertEquals(CartCount, 2);
    }

}