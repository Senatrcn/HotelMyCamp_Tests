package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class CreateHotel {
    @Test
    public void createHotelTest() {
        HmcPage hmcPage = new HmcPage();
        //1. Tests packagenin altına class olusturun: D18_HotelRoomCreation
        //2. Bir metod olusturun: RoomCreateTest()
        //3. https://www.hotelmycamp.com adresine gidin.
        //4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
        //a. Username : manager b. Password : Manager1!
        //5. Login butonuna tıklayın.
        Methods.managerLogin(hmcPage);

        //6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(hmcPage.hotelManagementButton));
        hmcPage.hotelManagementButton.click();
        wait.until(ExpectedConditions.visibilityOf(hmcPage.hotelListLink));
        hmcPage.hotelListLink.click();
        hmcPage.addHotelButton.click();

        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        wait.until(ExpectedConditions.visibilityOf(hmcPage.codeText));
        Actions actions = new Actions(Driver.getDriver());
        actions.click(hmcPage.codeText)
                .sendKeys(ConfigReader.getProperty("hmcCode"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("hmcName"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("hmcAddress"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("hmcPhone"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("hmcEmail"))
                .perform();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        Select select = new Select(hmcPage.idGroupDdm);
        select.selectByValue("1");

        //8. Save butonuna tıklayın.
        //wait.until(ExpectedConditions.visibilityOf(hmcPage.saveButton));
        hmcPage.saveButton.click();
        hmcPage.alertSonucText.click();


        //9. “Hotel was inserted successfully” textinin göründüğünü test edin.
        //wait.until(ExpectedConditions.visibilityOf(hmcPage.alertSonucText));
        System.out.println(hmcPage.alertSonucText.isDisplayed());

        String expectedText = "Hotel was inserted successfully";
        String actualText = hmcPage.alertSonucText.getText();
        Assert.assertEquals(actualText, expectedText);
        ////10. OK butonuna tıklayın.
        hmcPage.alertOkButton.click();
    }
}
