package ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;

public class ManageDeliveryBoy {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageDeliveryBoy(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']/li[16]/a")
	WebElement managadeliveryboytab;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy'][@class='btn btn-rounded btn-warning']")
	WebElement resetbtn3;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[7]/div/a\r\n")
	WebElement tooltipele;
	


	@FindBy(xpath = "	//table[@class='table table-bordered table-hover table-sm']/tbody/tr[2]/td/div/div")
	WebElement element1;

	@FindBy(id = "ut")
	WebElement emailid;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary'][@href='javascript:void(0)']")
	WebElement searchbtn;

	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']\r\n")
	WebElement searchbtn2;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[6]/a/span\r\n")
	WebElement activestatus;
	
	

	public String managadeliveryboytab() {

		String bgclr = gu.stylePropertyValidation(resetbtn3, "background-color");
		return (bgclr);
	}

	public String tooltipVal() {
		String tooltip = gu.toolTip(tooltipele);
		return (tooltip);
	}

	public boolean clicktooltip() throws InterruptedException {
		gu.clickElement(tooltipele);
		gu.mediumDelay();
		boolean value = gu.elementDisplayed(element1);
		return (value);
	}

	public void managadeliveryboytabselection() {
		gu.clickElement(managadeliveryboytab);
	}

	public String searchemail() throws InterruptedException {
		gu.clickElement(searchbtn);
		gu.mediumDelay();
		gu.sendKeysFunc(emailid, "abc@gmail.com");
		gu.clickElement(searchbtn2);
		String status = gu.getElementText(activestatus);
		return (status);

	}

}