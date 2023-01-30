package Testcases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.Test;
import org.testng.Assert;
import ElementRepository.LoginPage;
import ElementRepository.ManageExpense;
import ElementRepository.ManageOrders;
import Utilities.GeneralUtilities;
import constants.Constant;

public class ManageExpenseTestcase extends BaseClass {

	ManageExpense me;
	LoginPage lp;
	GeneralUtilities go = new GeneralUtilities();

	@Test

	public void Manageorders_search_btn_size() throws InterruptedException {
		me = new ManageExpense(driver);
		lp = new LoginPage(driver);
		lp.presteps();
		me.clickManagaexpensetab();
		me.clickManagExpensesub();

		String actualfont_search = me.font_search();
		String expectedfont_search =Constant.fontSize;
		Assert.assertEquals(actualfont_search, expectedfont_search, Constant.fontErrorMessage);

	}

	@Test

	public void ManageordersResetButtonClrVaildation() throws InterruptedException {
		me = new ManageExpense(driver);
		lp = new LoginPage(driver);
		lp.presteps();
		me.clickManagaexpensetab();
		me.clickManagExpensesub();
		String actualFontReset = me.fontReset();
		String expectedFontReset = Constant.fontSize;
		Assert.assertEquals(actualFontReset, expectedFontReset, Constant.fontErrorMessage);

	}

	@Test

	public void backGroundSearchrVaildation() throws InterruptedException {
		me = new ManageExpense(driver);
		lp = new LoginPage(driver);
		lp.presteps();
		me.clickManagaexpensetab();
		me.clickManagExpensesub();
		String ExpectedbgSearch = Constant.bgclr1;
		String actualbgSearch = me.backGroundSearch();
		Assert.assertEquals(actualbgSearch, ExpectedbgSearch, Constant.bgColorErrorMessage);

	}
	
	
	@Test

	public void calenderfunction() throws InterruptedException {
		me = new ManageExpense(driver);
		lp = new LoginPage(driver);
		lp.presteps();
		me.clickManagaexpensetab();
		me.clickManagExpensesub();
		me.datepicker();
	}
	
	public static void testBasic() throws IOException {
		prop = new Properties();
		FileInputStream fileIO = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\Config.properties");
		
		prop.load(fileIO);
	}
	
	@Test 
	public void imagevalidation() throws AWTException, IOException, InterruptedException
	{
		
		testBasic();
	String image=System.getProperty("user.dir") + prop.getProperty("imagefile");

		me = new ManageExpense(driver);
		lp = new LoginPage(driver);
		lp.presteps();
		me.clickManagaexpensetab();
		me.clickManagExpensesub();
		me.imageupload(image);
	}
	

}