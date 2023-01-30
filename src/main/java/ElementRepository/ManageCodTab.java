package ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;

public class ManageCodTab {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageCodTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@role='menu']/li[15]/a")
	WebElement managaCodtab;

	@FindBy(xpath = "//input[@value='yes']")
	WebElement yesbtn;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	public WebElement resetbtn;

	public void clickManagaCodTab() {
		gu.clickElement(managaCodtab);

	}

	public boolean isRadioButtonSelected() {
		return gu.checkCheckBoxSelected(yesbtn);
	}
}
