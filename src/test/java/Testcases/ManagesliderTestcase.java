package Testcases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.LoginPage;
import ElementRepository.ManageCodTab;
import ElementRepository.ManageSliderTab;
import ElementRepository.MobileSliderTab;
import Utilities.GeneralUtilities;
import constants.Constant;

public class ManagesliderTestcase extends BaseClass {
	ManageSliderTab ms;
	LoginPage lp;
	GeneralUtilities go = new GeneralUtilities();

/*	@Test
	public void titleValidation() {
		ms = new ManageSliderTab(driver);
		lp = new LoginPage(driver);
		lp.presteps();
		ms.clickManagesliderTab();

		String actual = ms.getTabname();
		String expected = Constant.listexp;
		System.out.println(actual);
		Assert.assertEquals(actual, expected, Constant.titleqry);
	}

	@Test
	public void verifyimagepresent() throws InterruptedException {
		ms = new ManageSliderTab(driver);
		lp = new LoginPage(driver);
		lp.presteps();
		ms.clickManagesliderTab();
		boolean actual = ms.imageDisplay();
		Assert.assertTrue(actual, Constant.imgnotdis);

	}*/
	
	@Test
	public void fileupload() throws AWTException, InterruptedException {
		ms = new ManageSliderTab(driver);
		lp = new LoginPage(driver);
		lp.presteps();
		ms.clickManagesliderTab();
		//boolean actual= true;
		//System.getProperty("user.dir") + "src\\main\\resources\\Images\\image.png"
		//boolean expected=ms.imageupload("C:\\Users\\sreejyothy\\eclipse-workspace\\Workarea2\\src\\main\\resources\\Images");

ms.imageupload();
	}

}