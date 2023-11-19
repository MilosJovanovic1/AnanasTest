package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage {

    public ChromeDriver driver;

    public ProductsPage(ChromeDriver driver){
        this.driver = driver;
    }

    public void openPage(){
        driver.get("https://ananas.rs/kategorije/tv-audio-i-video/tv/televizori");
    }

    public void clickOnTv(){

         driver.findElement(By.xpath("//a[@class='TV']")).click();
    }
    public void clickCookie(){

        driver.findElement(By.xpath("//button[@class='sc-1rhklln-0 gIUtAK']")).click();
    }


    public void selectSortBy(String sortValue){
        WebElement select = driver.findElement(By.xpath("//button[@class='sc-1rhklln-0 sc-14xb1qa-3 iKGKKh dQEdXQ']"));
        select.click();

        WebElement selectSort =driver.findElement(By.xpath("//select[@class='sc-c16oy5-0 gEIaoZ sc-e3waok-1 fhETuI']"));
        selectSort.click();

        List<WebElement> options = selectSort.findElements(By.xpath(".//option[@value='prod_merchant_inventories_sr_price_desc']"));

        for (int i = 0; i < options.size(); i++){
            if (options.get(i).getText().equals(sortValue)){
                options.get(i).click();
                break;


            }

        }
        driver.findElement(By.xpath("//button[@class='sc-1rhklln-0 hXRuOM']")).click();

    }

    public List<Double> returnPrice(){
        List<Double> returnPriceItems = new ArrayList<>();
        WebElement inventoryList = driver.findElement(By.xpath("//ul[@class='ais-Hits-list']"));

        List<WebElement> inventoryItems = inventoryList.findElements(By.xpath("//li[@class='ais-Hits-item']"));
        for (int i = 0; i < inventoryItems.size(); i++){
            WebElement price = inventoryItems.get(i).findElement(By.xpath(".//span[@class='sc-1arj7wv-2 iWtCrL']"));
            String priceValue = price.getText();
            Double priceValueDouble = Double.parseDouble(priceValue);
            returnPriceItems.add(priceValueDouble);

        }
        return returnPriceItems;

    }


    public void closePage(){
        driver.quit();
    }





}

