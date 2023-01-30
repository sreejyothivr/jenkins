package Testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.LoginPage;

public class LoginTestcases extends BaseClass {
	LoginPage lp;
	List<String> loginList;

	public void presteps() {
		lp = new LoginPage(driver);
		lp.getUserName("admin");
		lp.getPassWord("admin");
	}

	@Test
	public void verifyLoggedUsers() {
		lp = new LoginPage(driver);
		loginList = lp.getLoginDetails();
		System.out.println(loginList);
		lp.getUserName(loginList.get(0));
		lp.getPassWord(loginList.get(1));
		/*
		 * lp.enterUserName("admin"); lp.enterPassWord("admin");
		 */
		lp.clickSignin();
		String actual = lp.profileVerification();
		String expected = "admin";
		Assert.assertEquals(expected, actual, "Admin Name is not as we expected");

	}

}
