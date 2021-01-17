package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EmployeeListPage extends CommonMethods {

    @FindBy(id = "empsearch_id")
    public WebElement idEmployee;

    @FindBy(id = "searchBtn")
    public WebElement searchBtn;

    @FindBy(xpath = "//*[@id=\"resultTable\"]/tbody/tr/td[2]/a")
    public WebElement clickID;

    public EmployeeListPage () {
        PageFactory.initElements ( driver, this );
    }

    public void employeeID (String employeeId) {
        sendText ( idEmployee,employeeId );
    }

    public void searchButton(){
        click (searchBtn );
    }


}
    

