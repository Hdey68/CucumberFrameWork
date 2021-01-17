package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class PersonalDetailsPage extends CommonMethods {

    @FindBy(xpath = "//h1[text() = 'Personal Details']")
    public WebElement personalDetail;

    @FindBy (xpath = "//*[@id=\"personal_txtEmployeeId\"]")
    public WebElement employeeIDtxt;

    @FindBy (id = "personal_txtEmpFirstName")
    public WebElement firstNameText;

    @FindBy (id = "personal_txtEmpMiddleName")
    public WebElement middleNameText;

    @FindBy (id = "personal_txtEmpLastName")
    public WebElement lastNameText;

    public PersonalDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    }

