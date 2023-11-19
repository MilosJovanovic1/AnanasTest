package test;

import helper.ListManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;

import java.util.List;

public class TvSortTest {
    @Test
    public void CheckSortBy(){
        ChromeDriver driver = new ChromeDriver();

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.openPage();

        productsPage.clickCookie();
        productsPage.selectSortBy("Opadajućoj ceni");
        List<Double> price = productsPage.returnPrice();

        Assert.assertEquals(ListManager.isListSortedAsc(price), true, "Prices are not sort as expected");

        //productsPage.closePage();
    }


}
