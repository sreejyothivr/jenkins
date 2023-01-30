package ElementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;

public class ManageOfferCode {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageOfferCode(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	LoginPage lp = new LoginPage(driver);

	@FindBy(xpath = "//a[@class='small-box-footer'][@href='https://groceryapp.uniqassosiates.com/admin/list-offercode']")
	WebElement manageOfferCodetab;

	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	WebElement tabname;

	@FindBy(xpath = "//a[@href='javascript:void(0)']")
	WebElement Searchbtn;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement Searchbtn2;

	@FindBy(xpath = "//input[@type='text']")
	WebElement textarea;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[5]/a/span")
	WebElement status;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Offercode/add']")
	WebElement newbtn;

	@FindBy(id = "offer_code")
	WebElement offerTextArea;

	@FindBy(xpath = "//input[@value='no']")
	WebElement firstOrdercheckbox;

	@FindBy(id = "offer_per")
	WebElement percentage;

	@FindBy(id = "offer_price")
	WebElement Amount;

	public String displayTabName() {
		return (gu.getElementText(tabname));

	}

	public void clickmanageOfferCodetab() {
		manageOfferCodetab.click();
	}

	public String search(String value) {
		gu.clickElement(Searchbtn);
		gu.sendKeysFunc(textarea, value);
		gu.clickElement(Searchbtn2);

		return (gu.getElementText(status));

	}

	public void newOrder(String x, String y, String z) {
		gu.clickElement(newbtn);
		gu.sendKeysFunc(offerTextArea, x);
		gu.clickElement(firstOrdercheckbox);
		gu.sendKeysFunc(percentage, y);
		gu.sendKeysFunc(Amount, z);

	}
}
