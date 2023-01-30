package Testcases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.LoginPage;

import ElementRepository.ManageProductTab;
import Utilities.ExplitWait;
import Utilities.GeneralUtilities;
import constants.Constant;
import constants.Constantmain;

public class ManageProducttest extends BaseClass {
	ExplitWait ew;
	ManageProductTab mp;
	LoginPage lp;
	GeneralUtilities gu = new GeneralUtilities();

	@Test
	public void fileupload() throws InterruptedException, AWTException {
		mp = new ManageProductTab(driver);

		lp = new LoginPage(driver);
		lp.presteps();
		mp.clickManageproductTab();
		mp.newButnClick();

		gu.scrollDownOperation(driver);
		gu.mediumDelay();

		mp.clickfileuploadbtn(System.getProperty("user.dir") + "\\src\\main\\resources\\Images\\image.png");

		mp.saveClick();
		gu.alertHandlingaccept(driver);

	}

	@Test
	public void verifyEneterPricefield() throws InterruptedException {
		mp = new ManageProductTab(driver);

		lp = new LoginPage(driver);
		lp.presteps();
		mp.clickManageproductTab();
		mp.newButnClick();
		gu.scrollDownOperation(driver);
		mp.waitForButn();
		mp.saveClick();
		String actual = gu.alerttext(driver);
		gu.alertHandlingaccept(driver);

		String expected = Constant.weightalert;
		Assert.assertEquals(actual, expected, Constantmain.prize);
	}

	@Test(groups = { "Showstopper" })
	public void alertValidation() {

		mp = new ManageProductTab(driver);

		lp = new LoginPage(driver);
		lp.presteps();
		mp.clickManageproductTab();
		mp.deleteFirstProduct();
		String actual = gu.alerttext(driver);
		mp.alertMsg();

		String expected = Constant.delqry;
		Assert.assertEquals(actual, expected, Constantmain.alertmsg);

	}

	@Test
	public void columnvalidation() throws InterruptedException {
		mp = new ManageProductTab(driver);

		lp = new LoginPage(driver);
		lp.presteps();
		mp.clickManageproductTab();
		int countrow_Actual = mp.elementFilter();
		int expRowCount = 20;
		Assert.assertEquals(countrow_Actual, expRowCount);

	}
}