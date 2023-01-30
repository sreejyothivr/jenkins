package ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;

public class MobileSliderTab {
	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();

	public MobileSliderTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	LoginPage lp;

	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']/li[11]/a")
	WebElement mobileslidertab;

	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	public WebElement title;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	WebElement firstclm;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[2]/a/span")
	WebElement status;

	public void clickManagesliderTab() {
		gu.clickElement(mobileslidertab);

	}

	public boolean ListSliderDisplay() {
		return gu.elementDisplayed(firstclm);
	}

	public String getTitle() {
		return (gu.getElementText(title));
	}

	public String getstatus() {
		return (gu.getElementText(status));
	}

	public String getbgclr() {
		return (gu.stylePropertyValidation(status, "background-color"));
	}

}