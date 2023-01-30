package Testcases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.LoginPage;
import ElementRepository.MobileSliderTab;
import Utilities.ExplitWait;
import Utilities.GeneralUtilities;

public class MobileSliderTestcase extends BaseClass {
	ExplitWait ew;
	MobileSliderTab mst;
	LoginPage lp;
	GeneralUtilities gu = new GeneralUtilities();

	@Test
	public void titlevalidation() {
		mst = new MobileSliderTab(driver);
		lp = new LoginPage(driver);
		lp.presteps();
		mst.clickManagesliderTab();

		String actual = mst.getTitle();
		String expected = "List Mobile Sliders";
		Assert.assertEquals(actual, expected, "Tilte missmatch");

	}

	@Test
	public void elementDisplay() {
		mst = new MobileSliderTab(driver);
		lp = new LoginPage(driver);
		lp.presteps();
		mst.clickManagesliderTab();

		boolean actual = mst.ListSliderDisplay();
	
		boolean expected = true;
		Assert.assertEquals(actual, expected);

	}

	@Test
	public void getStatus() {
		mst = new MobileSliderTab(driver);
		lp = new LoginPage(driver);
		lp.presteps();
		mst.clickManagesliderTab();
		String statusactual = mst.getstatus();
		String statusexpected = "Active";
		Assert.assertEquals(statusactual, statusexpected, "The image is not active");

	}

	@Test
	public void getbgclr() {
		mst = new MobileSliderTab(driver);
		lp = new LoginPage(driver);
		lp.presteps();
		mst.clickManagesliderTab();
		String statusactual = mst.getbgclr();
		String statusexpected = "rgba(40, 167, 69, 1)";
		Assert.assertEquals(statusactual, statusexpected, "The image inot active");

	}
	
	
	
}