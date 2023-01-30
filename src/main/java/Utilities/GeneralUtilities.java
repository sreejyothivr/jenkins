package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public List<String> getElementTextlist(List<WebElement> element, int size) {
		String listtext;
		List<String> list9 = new ArrayList();
		for (int p = 0; p < size; p++) {

			listtext = element.get(p).getText();
			addList(listtext);
			list9 = addList(listtext);

		}
		return (list9);

	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public String stylePropertyValidation(WebElement element, String propertyType) {
		return element.getCssValue(propertyType);
	}

	public List<String> listOfWebElemenToListOfString(WebDriver driver, String locatorType) {
		List<WebElement> listOfHeaderElements = driver.findElements(By.xpath(locatorType));
		List<String> listOfStringHeader = new ArrayList<String>();
		for (int i = 0; i < listOfHeaderElements.size(); i++) {

			listOfStringHeader.add(listOfHeaderElements.get(i).getText());

		}

		return listOfStringHeader;

	}

	public void sendKeysFunc(WebElement element, String textToEnter) {
		element.sendKeys(textToEnter);
	}

	public void selectFuncbyindex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}

	public void selectFuncbyValue(WebElement element, String value) {
		Select select1 = new Select(element);
		select1.selectByValue(value);

	}

	public String selectFuncbyVisibletext(WebElement element, String visisbletext) {
		Select select = new Select(element);
		select.selectByVisibleText(visisbletext);
		WebElement selectedValue = select.getFirstSelectedOption();
		return (selectedValue.getText());

	}

	public String FirstSelectedOption(WebElement element) {
		Select select1 = new Select(element);
		String firstoption = select1.getFirstSelectedOption().getText();
		return (firstoption);
	}

	public void alertHandlingaccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public String alerttext(WebDriver driver) {
		return (driver.switchTo().alert().getText());
	}

	public void scrollDownOperation(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2500)");
	}

	public void mediumDelay() throws InterruptedException {
		Thread.sleep(3000);
	}

	public void fileUpload(String path, WebElement element, WebDriver driver) throws AWTException {
		Robot rob = new Robot();

		Actions a = new Actions(driver);
		a.moveToElement(element).click().perform();

		StringSelection ss = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rob.delay(250);

		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.delay(250);
		rob.keyRelease(KeyEvent.VK_ENTER);
	}

	public boolean checkCheckBoxSelected(WebElement element) {
		boolean select = element.isSelected();
		return select;

	}

	public boolean elementDisplayed(WebElement element) {
		boolean textDisplay = element.isDisplayed();
		return textDisplay;
	}

	public String toolTip(WebElement element) {

		return (element.getAttribute("title"));
	}

	public void dragandDrop(WebElement source, WebElement destination, WebDriver driver) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, destination).perform();
	}

	List<String> list1 = new ArrayList();

	public List<String> addList(String values)

	{

		list1.add(values);
		return (list1);
	}

	public boolean getElementTextList(List<WebElement> actuallist, String element) {

		boolean value = true;
		for (int i = 0; i < actuallist.size(); i++) {

			String text = actuallist.get(i).getText();

			if (!text.equals(element))

			{
				value = false;

			}
		}

		return value;
	}

	public boolean compareLists(List<String> actuallist, List<String> expectedlist) {
		boolean value = true;
		for (int i = 0; i < actuallist.size(); i++) {
			if (!actuallist.get(i).equals(expectedlist.get(i))) {
				value = false;

			}
		}

		return value;
	}

	public boolean statusDropdownValidation(List<String> list, WebElement element) throws InterruptedException {
		boolean value = true;

		for (int i = 0; i < list.size(); i++) {
			selectFuncbyindex(element, i);
			mediumDelay();

			String firstSelopt = FirstSelectedOption(element);

			if (!list.get(i).equals(firstSelopt)) {
				value = false;
				int ig = 1;
				System.out.println(ig);

			}
		}

		// System.out.println(value);
		return (value);
	}

}
