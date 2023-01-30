package ElementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelRead;
import Utilities.GeneralUtilities;

public class LoginPage {

	GeneralUtilities utility = new GeneralUtilities();
	WebDriver driver;
	ExcelRead excelUtility;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<String> getLoginData() {
		List<String> excelList = excelUtility.readDataFromExcel("Sheet1");
		return excelList;
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement userName;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signin;

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement profileName;

	@FindBy(xpath = "//label[contains(text(),'Remember Me')]")
	WebElement rememberCheckBox;

	@FindBy(xpath = "//input[@id='remember']")
	WebElement verificationOfRememberCheckBox;

	public void getUserName(String userName1) {
		userName.sendKeys(userName1);
	}

	public void getPassWord(String password1) {
		password.sendKeys(password1);
	}

	public void clickSignin() {
		utility.clickElement(signin);
		// signin.click();
	}

	public void performLogin() {

	}

	public String profileVerification() {
		return utility.getElementText(profileName);
	}

	public String loginButnTxt() {
		return utility.getElementText(signin);
	}

	public List<String> getLoginDetails() {
		excelUtility = new ExcelRead();
		List<String> excelList = excelUtility.readDataFromExcel("Sheet1");
		return excelList;
	}

	public void presteps() {
		getUserName("admin");
		getPassWord("admin");
		clickSignin();
	}

}
