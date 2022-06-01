package tests;

import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Methods {
    public static void managerLogin(HmcPage hmcPage){
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCampUrl"));
        hmcPage.birinciLoginButton.click();
        hmcPage.usernameTextbox.sendKeys(ConfigReader.getProperty("hmcUsername"));
        hmcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("hmcPassword"));
        hmcPage.ikinciLoginButton.click();
    }
}
