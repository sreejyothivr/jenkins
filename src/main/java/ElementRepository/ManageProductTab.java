package ElementRepository;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExplitWait;
import Utilities.GeneralUtilities;

public class ManageProductTab {

	WebDriver driver;
	ExplitWait ew = new ExplitWait();
	GeneralUtilities gu = new GeneralUtilities();

	public ManageProductTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='nav-item']//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order']")
	WebElement managaeorderstab;

	@FindBy(xpath = "//input[@id='main_imgs']")
	WebElement chosefilebtn;

	@FindBy(linkText = "Manage Product")
	WebElement manageProductTab;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[9]/a[2]")
	WebElement deleteButtton;
	@FindBy(xpath = "//h5[contains(text(),' Alert!')]")
	WebElement alertMsg;

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newButn;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtn;

	public void clickManageproductTab() {
		gu.clickElement(manageProductTab);

	}

	public void deleteFirstProduct() {
		gu.clickElement(deleteButtton);
	}

	public void alertMsg() {
		gu.alertHandlingaccept(driver);
	}

	public String alertText() {
		return gu.getElementText(alertMsg);

	}

	public void newButnClick() {
		gu.clickElement(newButn);
	}

	public void saveClick() throws InterruptedException {
		gu.scrollDownOperation(driver);
		gu.mediumDelay();
		gu.clickElement(saveBtn);
	}

	public void waitForButn() {
		ew.clickElement(driver, "//button[@type='submit']");
	}

	public void clickfileuploadbtn(String path) throws AWTException {

		gu.fileUpload(path, chosefilebtn, driver);
	}

	public int elementFilter() {
		List<WebElement> element = driver
				.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[5]"));
		int size = element.size();
		List<String> arraylist67;
		arraylist67 = gu.getElementTextlist(element, size);
		String exp;
		exp = "2 kg - 10 kg\r\n" + "Stock: 100 nos";
		int count = 0;
		int o = 0;
		for (int j = 0; j < size; j++) {

			count++;

		}
		System.out.println(count);
		return count;

	}
}
