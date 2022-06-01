package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class CreateRoom {
    @Test
    public void createRoomTest() {
        HmcPage hmcPage = new HmcPage();
        //1. Tests packagenin altına class olusturun: D18_HotelRoomCreation
        //2. Bir metod olusturun: RoomCreateTest()
        //3. https://www.hotelmycamp.com adresine gidin.
        //4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
        //a. Username : manager b. Password : Manager1!
        //5. Login butonuna tıklayın.
        Methods.managerLogin(hmcPage);

        //6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        hmcPage.hotelManagementButton.click();
        hmcPage.hotelRoomsButton.click();
        hmcPage.addHotelRoomButton.click();

        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Select select = new Select(hmcPage.idHotelDdm);
        select.selectByVisibleText(ConfigReader.getProperty("hmcName"));
        Actions actions = new Actions(Driver.getDriver());
        actions.click(hmcPage.codeText)
                .sendKeys(ConfigReader.getProperty("hmcRoomCode"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("hmcRoomName"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("hmcRoomLocation"))
                .sendKeys(Keys.TAB)
                .perform();
        hmcPage.descriptionTextarea.sendKeys(ConfigReader.getProperty("hmcRoomDescription"));
        hmcPage.priceText.sendKeys(ConfigReader.getProperty("hmcRoomPrice"));

        select = new Select(hmcPage.roomTypeDdm);
        select.selectByVisibleText(ConfigReader.getProperty("hmcRoomType"));
        actions.sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("hmcRoomMaxAdult"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("hmcRoomMaxChildren"))
                .perform();
        hmcPage.approvedCheckbox.click();

        //8. Save butonuna basin.
        hmcPage.saveButton.click();
        hmcPage.alertSonucText.click();

        //9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
        String expectedText = "HotelRoom was inserted successfully";
        String actualText = hmcPage.alertSonucText.getText();
        Assert.assertEquals(actualText, expectedText);

        //10. OK butonuna tıklayın.
        hmcPage.alertOkButton.click();
        //11. Hotel rooms linkine tıklayın.
        hmcPage.body.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        hmcPage.hotelRoomsButton.click();

        //12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın.
        Assert.assertTrue(hmcPage.listOfHotelRooms.isDisplayed());
    }
}
