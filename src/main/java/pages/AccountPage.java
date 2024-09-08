package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPage {


	WebDriver driver;

	public AccountPage(WebDriver driver) {

		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//span[normalize-space()='List Accounts']")
	WebElement ListAccount;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Add Account']")
	WebElement AddAccount;

	@FindBy(how = How.XPATH, using = "//input[@id='account_name']")
	WebElement account_name;

	@FindBy(how = How.XPATH, using = "//*[@id=\"description\"]")
	WebElement description;

	@FindBy(how = How.XPATH, using = "//input[@id='balance']")
	WebElement balance;

	@FindBy(how = How.XPATH, using = "//input[@id='account_number']")
	WebElement Account_number;

	@FindBy(how = How.XPATH, using = "//input[@id='contact_person']")
	WebElement contact_person;

	@FindBy(how = How.XPATH, using = "//button[@id='accountSave']")
	WebElement save;


	public void ClickListAccount() {
		ListAccount.click();
	}

	public void ClickAddAccount() {
		AddAccount.click();
	}

	public void Enteraccountname(String Account_name) {
		account_name.sendKeys(Account_name);
	}

	public void Enterdescription(String desc) {
		description.sendKeys(desc);
	}

	public void Enterbalance(String Account_balance) {
		balance.sendKeys(Account_balance);
	}

	public void Enteraccountnumber(String account_number) {
		Account_number.sendKeys(account_number);
	}

	public void Entercontactperson(String Contact_person) {
		contact_person.sendKeys(Contact_person);
	}

	public void ClickSaveAccount() {
		save.click();
	}
}
