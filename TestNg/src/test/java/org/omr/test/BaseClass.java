package org.omr.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
    public static WebDriver driver;
	Select select;
	Actions actions;

	// 1.Chrome Browser Launch
	public static void chromeBrowserLaunch() {
		driver = new ChromeDriver();
	}

	// 2.Firefox Browser Launch
	public void fireFoxBrowserLaunch() {
		driver = new FirefoxDriver();
	}

	// 3.IE Browser Launch
	public void ieBrowserLaunch() {
		driver = new InternetExplorerDriver();
	}

	// 4.Edge Browser Launch
	public void edgeBrowserLaunch() {
		driver = new EdgeDriver();
	}

	// 5.Enter URL
	public static void enterApplnUrl(String url) {
		driver.get(url);
	}

	// 6.Maximize Window
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	// 7.Insert Value in Textbox
	public void elementSendKeys(WebElement element, String data) {
		visibilityOfElement(element);
		
		element.sendKeys(data);
		
	}

	// 8.Click Button
	public void elementClick(WebElement element) {
		visibilityOfElement(element);
		if(elementIsDisplayed(element)&&elementIsEnabled(element))
		{
		element.click();
		}
	}

	// 9.Click ok in Alert
	public void alertClickOk() {
		driver.switchTo().alert().accept();
	}

	// 10.Click cancel in Alert
	public void alertClickCancel() {
		driver.switchTo().alert().dismiss();
	}

	// 11.Get the Text from Webpage
	public String elementGetText(WebElement element) {
		visibilityOfElement(element);
	    String text = element.getText();
		return text;
	}

	// 12.Get the Value from Textbox
	public String elementGetAttributeValue(WebElement element) {
		visibilityOfElement(element);
		String attribute=null;
		if(elementIsDisplayed(element)&&elementIsEnabled(element))
		{
	    attribute = element.getAttribute("value");
		}
		return attribute;
	}

	public String elementGetAttributeValue(WebElement element, String attributeName) {
		visibilityOfElement(element);
		String attribute = null;
		if(elementIsDisplayed(element)&&elementIsEnabled(element))
		{
		attribute = element.getAttribute(attributeName);
		}
		return attribute;
	}

	// 13.Close Window
	public static void closeBrowser() {
		driver.close();
	}

	// 14.Get the Title
	public String getApplnTitle() {
		String title = driver.getTitle();
		return title;
	}

	// 15.Get the Current URL
	public String getApplnCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	// 16.Select Dropdown Option by Text
	public void elementSelectByText(WebElement element, String txt) {
		visibilityOfElement(element);
		if(elementIsDisplayed(element))
		{
		select=new Select(element);	
		select.selectByVisibleText(txt);
		}
	}

	// 17.Select Dropdown Option by Attribute
	public void elementSelectByValue(WebElement element, String attributeValue) {
		visibilityOfElement(element);
		if(elementIsDisplayed(element))
		{
	    select = new Select(element);
		select.selectByValue(attributeValue);
		}
	}

	// 18.Select Dropdown Option by Index
	public void elementSelectByIndex(WebElement element, int index) {
		visibilityOfElement(element);
		if(elementIsDisplayed(element))
		{
	    select = new Select(element);
		select.selectByIndex(index);
		}
	}

	// 19.Insert value in textbox by Javascript
	public void elementInsertByJs(WebElement element, String data) {
		visibilityOfElement(element);
		if(elementIsDisplayed(element)&&elementIsEnabled(element))
		{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
		}
	}

	// 20.Click button by Javascript
	public void elementClickByJs(WebElement element) {
		visibilityOfElement(element);
		if(elementIsDisplayed(element)&&elementIsEnabled(element))
		{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
		}
	}

	// 21.Switch to Child window
	public void switchToWindow(String id) {
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String window : windowHandles) {
			if (!windowHandle.equals(window)) {
				driver.switchTo().window(window);
			}
		}

	}

	// 22.Switch to Frame by Index
	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	// 23.Switch to Frame by Id/Name
	public void switchToFrameById(String frameid) {
		driver.switchTo().frame(frameid);
	}

	// 24.Switch to Frame by WebElement
	public void switchToFrameByElement(WebElement element) {
		visibilityOfElement(element);
		if(elementIsDisplayed(element))
		{
		driver.switchTo().frame(element);
		}
	}

	// 25.Find Locator by Id
	public WebElement findLocatorById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}

	// 26.Find Locator by Name
	public WebElement findLocatorByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}

	// 27.Find Locator by ClassName
	public WebElement findLocatorByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}

	// 28.Find Locator by Xpath
	public WebElement findLocatorByXpath(String exp) {
		WebElement element = driver.findElement(By.xpath(exp));
		return element;
	}

	// 29.Get all Dropdown options As Text
	public List<String> getAllOptionsAsText(WebElement element) {
		visibilityOfElement(element);
		List<String> res = new ArrayList<String>();
		if(elementIsDisplayed(element)&&elementIsEnabled(element))
		{
		select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		for (WebElement webElement : allSelectedOptions) {
			res.add(webElement.getText());
		}
		}
		return res;
	}

	// 30.Get all Dropdown options As Value
	public List<String> getAllOptionsAsValue(WebElement element) {
		visibilityOfElement(element);
		List<String> res = new ArrayList<String>();
		if(elementIsDisplayed(element)&&elementIsEnabled(element))
		{
		select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		for (WebElement webElement : allSelectedOptions) {
			res.add(webElement.getAttribute("value"));
		}
		}
		return res;
	}
	
	public List<String> getAllOptionsAsValue(WebElement element, String attributeValue) {
		visibilityOfElement(element);
		List<String> res = new ArrayList<String>();
		if(elementIsDisplayed(element)&&elementIsEnabled(element))
		{
		select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		for (WebElement webElement : allSelectedOptions) {
			res.add(webElement.getAttribute(attributeValue));
		}
		}
		return res;
	}

	// 31.Get the First Selected Option
	public String getFirstSelectedOption(WebElement element) {
		visibilityOfElement(element);
		String text = null;
		if(elementIsDisplayed(element)&&elementIsEnabled(element))
		{
		select = new Select(element);
		WebElement element2 = select.getFirstSelectedOption();
	    text = element2.getText();
		}
		return text;
	}

	// 32.Verify Dropdown is Multi select option
	public boolean elementIsMultiselect(WebElement element) {
		visibilityOfElement(element);
		boolean multiple = false;
		if(elementIsDisplayed(element)&&elementIsEnabled(element))
		{
	    select = new Select(element);
	    multiple = select.isMultiple();
		}
		return multiple;
	}

	// 33.Implicit Wait
	public static void implicitWait(int secs) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

	}
	// 34.Explicit Wait
	public void visibilityOfElement(WebElement element) {

		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}
		

	// 35.Fluent Wait

	// 36.isDisplayed
	public boolean elementIsDisplayed(WebElement element) {
		//visibilityOfElement(element);
	    boolean displayed = element.isDisplayed();
		return displayed;
	}

	// 37.isEnabled
	public boolean elementIsEnabled(WebElement element) {
		visibilityOfElement(element);
        boolean enabled = element.isEnabled();
	    return enabled;
	}

	// 38.isSelected
	public boolean elementIsSelected(WebElement element) {
		visibilityOfElement(element);
		boolean selected = false;
		if(elementIsDisplayed(element))
		{
	    selected = element.isSelected();
		}
		return selected;
	}

	// 39.De-select Option by Index in Dropdown
	public void deselectByIndex(WebElement element, int index) {
		visibilityOfElement(element);
		if(elementIsDisplayed(element)&&elementIsEnabled(element))
		{
		select = new Select(element);
		select.deselectByIndex(index);
		}
	}

	// 40.De-select Option by Text in Dropdown
	public void deselectByText(WebElement element, String txt) {
		visibilityOfElement(element);
		if(elementIsDisplayed(element)&&elementIsEnabled(element))
		{
		select = new Select(element);
		select.deselectByValue(txt);
		}
	}

	// 41.De-select Option by Value in Dropdown
	public void deselectByValue(WebElement element, String value) {
		visibilityOfElement(element);
		if(elementIsDisplayed(element)&&elementIsEnabled(element))
		{
	    select = new Select(element);
		select.deselectByValue(value);
		}
	}

	// 42.De-select All Options in Dropdown
	public void deselectAll(WebElement element) {
		visibilityOfElement(element);
		if(elementIsDisplayed(element)&&elementIsEnabled(element))
		{
	    select = new Select(element);
		select.deselectAll();
		}
	}

	// 43.clear all Values in textbox
	public void clearValues(WebElement element) {
		visibilityOfElement(element);
		if(elementIsDisplayed(element)&&elementIsEnabled(element))
		{
		element.clear();
		}
	}

	// 44.TakeScreenshot
	public void screenshot(String filName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs,
				new File("C:\\Users\\new\\eclipse-workspace\\FrameworkDay4\\Screenshot" + filName + ".png"));
	}

	// 45.TakeScreenshot for Element
	public void screenshotElement(String filName, WebElement element) throws IOException {
		visibilityOfElement(element);
		if(elementIsDisplayed(element))
		{
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs,
				new File("C:\\Users\\new\\eclipse-workspace\\FrameworkDay4\\Screenshot" + filName + ".png"));
		}
	}

	// 46.MouseOverAction
	public void elementMoveToElement(WebElement element) {
		visibilityOfElement(element);
		if(elementIsDisplayed(element))
		{
	    actions = new Actions(driver);
		actions.moveToElement(element);
		}

	}

	// 47.DragAndDrop
	public void elementDragAndDrop(WebElement source, WebElement destination) {
		visibilityOfElement(source);
		visibilityOfElement(destination);
		if(elementIsDisplayed(source)&&elementIsDisplayed(destination))
		{
	    actions = new Actions(driver);
		actions.dragAndDrop(source, destination).perform();
		}

	}

	// 48.RightClick
	public void elementRightClick(WebElement element) {
		visibilityOfElement(element);
		if(elementIsDisplayed(element))
		{
	    actions = new Actions(driver);
		actions.contextClick(element).perform();
		}

	}

	// 49.DoubleClick
	public void elementDoubleClick(WebElement element) {
		visibilityOfElement(element);
		if(elementIsDisplayed(element))
		{
	    actions = new Actions(driver);
		actions.doubleClick(element).perform();
		}

	}

	// 50.Insert Value in Textbox and Enter
	public void elementSendKeysAndEnter(WebElement element, String data) {
		visibilityOfElement(element);
		if(elementIsDisplayed(element)&&elementIsEnabled(element))
		{
		element.sendKeys(data, Keys.ENTER);
		}
	}

	// 51.Navigation Commands
	public void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public void navigateForward() {
		driver.navigate().forward();
	}

	public void navigateBackward() {
		driver.navigate().back();
	}

	public void navigateRefresh() {
		driver.navigate().refresh();
	}

	// 52.Page Scroll Down/Up
	public void elementScrollDown(WebElement element) {
		visibilityOfElement(element);
		if(elementIsDisplayed(element))
		{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		}

	}

	public void elementScrollUp(WebElement element) {
		visibilityOfElement(element);
		if(elementIsDisplayed(element))
		{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
		}
	}
	//Read Values From Excel
	public static String getCellData(String sheetName, int rownum, int cellnum) throws IOException {
		String res = null;

		File file = new File("C:\\Users\\new\\eclipse-workspace\\POMClass\\Excel Sheet\\OmrAddToCartProject.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			res = cell.getStringCellValue();

			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
				res = dateFormat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long round = Math.round(numericCellValue);
				if (numericCellValue == round) {
					res = String.valueOf(round);
				} else {
					res = String.valueOf(numericCellValue);
				}
			}

			break;

		default:
			break;
		}
		return res;
	}
	
	//Update Cell Value in Excel
	public void updateCellData(String sheetName, int rownum, int cellnum, String oldData, String newData)
			throws IOException {

		File file = new File("C:\\Users\\new\\eclipse-workspace\\POMClass\\Excel Sheet\\OmrAddToCartProject.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();

		if (value.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);

	}
	
	//Create Cell and Insert Value in Excel
	public void createCellAndSetCellData(String sheetName, int rownum, int cellnum, String data) throws IOException {
		File file = new File("C:\\Users\\new\\eclipse-workspace\\POMClass\\Excel Sheet\\OmrAddToCartProject.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
	}



}
