package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HmcPage {
    public HmcPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[.='Log in']")
    public WebElement birinciLoginButton;

    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement usernameTextbox;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement ikinciLoginButton;

    @FindBy(xpath = "//*[text()='Hotel Management']")
    public WebElement hotelManagementButton;

    @FindBy(xpath = "//a[@href='/admin/HotelAdmin']")
    public WebElement hotelListLink;

    @FindBy(xpath = "//*[text()='Add Hotel ']")
    public WebElement addHotelButton;

    @FindBy(xpath = "//input[@id='Code']")
    public WebElement codeText;

    @FindBy(xpath = "//select[@id='IDGroup']")
    public WebElement idGroupDdm;

    @FindBy(xpath = "//button[@id='btnSubmit']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement alertSonucText;

    @FindBy(xpath = "//*[text()='OK']")
    public WebElement alertOkButton;

    @FindBy(xpath = "//a[@href='/admin/HotelRoomAdmin']")
    public WebElement hotelRoomsButton;

    @FindBy(xpath = "//*[text()='Add Hotelroom ']")
    public WebElement addHotelRoomButton;

    @FindBy(xpath = "//select[@id='IDHotel']")
    public WebElement idHotelDdm;

    @FindBy(xpath = "//select[@id='IDGroupRoomType']")
    public WebElement roomTypeDdm;

    @FindBy(xpath = "//input[@id='IsAvailable']")
    public WebElement approvedCheckbox;

    @FindBy(xpath = "//textarea[@title='Rich Text Editor, Description']")
    public WebElement descriptionTextarea;

    @FindBy(xpath = "//input[@title='Price']")
    public WebElement priceText;

    @FindBy(xpath = "//div[@class='caption']")
    public WebElement listOfHotelRooms;

}
