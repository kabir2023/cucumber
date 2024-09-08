package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPages {

	WebDriver driver;

	public LoginPages(WebDriver driver) {

		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "user_name")
	WebElement UserName;

	@FindBy(how = How.ID, using = "password")
	WebElement Password;

	@FindBy(how = How.ID, using = "login_submit")
	WebElement SignInButton;

	
	public void enterUserName(String userName) {
		UserName.sendKeys(userName);
	}

	public void enterPassword(String password) {
		Password.sendKeys(password);
	}

	public void clickSignInButton() {
		SignInButton.click();
	}

	public String getPageTitle() {
		return driver.getTitle();

	}
	
}
