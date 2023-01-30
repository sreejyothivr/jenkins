package ElementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExplitWait;
import Utilities.GeneralUtilities;

public class PushNotifications {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplitWait ew;

	public PushNotifications(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	LoginPage lp = new LoginPage(driver);

	@FindBy(xpath = "//p[contains(text(),'Push Notifications')]")
	WebElement pushtabtab;

	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	WebElement tabname;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement sendButton;

	//// table[@class='table table-bordered table-hover table-sm']//thead//tr//th

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//thead//tr//th")
	WebElement tableFieldValues;

	@FindBy(id = "title")
	WebElement titlte;

	@FindBy(id = "description")
	WebElement description;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement elemenettext;

	public String displayTabName() {
		return (gu.getElementText(tabname));

	}

	public void clickpushnotifications() {
		pushtabtab.click();
	}

	public String displaycolor() {
		String color = (gu.stylePropertyValidation(sendButton, "background-color"));
		return (color);
	}

	public String getAlertText(String x, String y) throws InterruptedException {
		titlte.sendKeys(x);
		description.sendKeys(y);
		submit.click();

		String textAlert = gu.getElementText(elemenettext);

		return (textAlert);
	}

}
