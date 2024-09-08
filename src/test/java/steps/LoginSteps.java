package steps;

import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.en.*;
import pages.AccountPage;
import pages.LoginPages;
import pages.TestBase;

import java.io.IOException;

import org.junit.Assert;

public class LoginSteps extends TestBase {

    LoginPages loginPage;
    AccountPage accountpage;

    @Given("User is on the codefios login page")
    public void user_is_on_the_codefios_login_page() {
        initDriver();
        driver.get("https://codefios.com/ebilling"); 
        loginPage = PageFactory.initElements(driver, LoginPages.class);
        accountpage =  PageFactory.initElements(driver, AccountPage.class);
        
    }

    @When("User enters the {string} in the {string} field")
    public void user_enters_the_in_the_field(String value, String field) throws IOException {
        if (field.equalsIgnoreCase("username")) {
            loginPage.enterUserName(value);
        } else if (field.equalsIgnoreCase("password")) {
            loginPage.enterPassword(value);
        }
        captureScreenshot("LoginPage_Loaded");
    }

    @When("User clicks on {string}")
    public void user_clicks_on(String button) throws IOException {
        if (button.equalsIgnoreCase("login")) {
            loginPage.clickSignInButton();
        } else if (button.equalsIgnoreCase("listAccounts")) {
        	accountpage.ClickListAccount();
        	captureScreenshot("List Account");
        } else if (button.equalsIgnoreCase("addAccount")) {
        	accountpage.ClickAddAccount();
        } else if (button.equalsIgnoreCase("Save")) {
        	accountpage.ClickSaveAccount();
          
        }
    }

    @When("User enters {string} in the {string} field in accounts page")
    public void user_enters_in_the_field_in_accounts_page(String value, String field) {
        if (field.equalsIgnoreCase("accountName")) {
        	accountpage.Enteraccountname(value);
        } else if (field.equalsIgnoreCase("description")) {
        	accountpage.Enterdescription(value);
        } else if (field.equalsIgnoreCase("initialBalance")) {
        	accountpage.Enterbalance(value);
        } else if (field.equalsIgnoreCase("accountNumber")) {
        	accountpage.Enteraccountnumber(value);
        } else if (field.equalsIgnoreCase("contactPerson")) {
        	accountpage.Entercontactperson(value);
        }
    }
    
    @Then("User should land on Dashboard page")
    public void user_should_land_on_dashboard_page() throws IOException {
    	  String expectedTitle = "Codefios";
          String actualTitle = loginPage.getPageTitle();
          Assert.assertEquals("Dashboard page not found !", expectedTitle, actualTitle);
          
          captureScreenshot("Dashboard_page");

    }


    @Then("User should be able to validate account created successfully")
    public void user_should_be_able_to_validate_account_created_successfully() throws IOException {
  
    	String expectedTitle = "Manage Account";
        String actualTitle = loginPage.getPageTitle();
        Assert.assertEquals("Account creation faild ! !", expectedTitle, actualTitle);
        
        captureScreenshot("Account creation");
    }
}
