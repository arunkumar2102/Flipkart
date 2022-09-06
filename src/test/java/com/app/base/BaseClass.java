package com.app.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;
	public static Select s;
	public static Actions ac;
	public static JavascriptExecutor js;
	@BeforeClass
	public static void browserLaunch() {
		System.setProperty("webdriver.chrome.driver", "E:\\MavenWorkspace\\Flipkart\\Drivers\\chromedriver.exe");
		driver= new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
	}
	public static void CurrentUrl()
	{
		try {
		String currentUrl=driver.getCurrentUrl();
		driver.get(currentUrl);
		}
		catch (Exception e) {
		}
	}
	public static void launchUrl(String Url)
	{
		try {
		driver.get(Url);
		}
		catch (Exception e) {
		}
	}
	public static void dataSend(WebElement element, String data)
	{
		try {
		element.sendKeys(data);
		}
		catch (Exception e) {
		}
	}
	public static void clickElement(WebElement element)
	{
		try {
		element.click();
		}
		catch (Exception e) {
		}
	}
	public static void clearElement(WebElement element)
	{
		try {
		element.clear();
		}
		catch (Exception e) {
		}
	}
	public static WebElement findElementbyId(String id)
	{
		return driver.findElement(By.id(id));
	}
	public static WebElement findElementbyname(String name)
	{
		return driver.findElement(By.name(name));
	}
	public static WebElement findElementbyxpath(String xpath)
	{
		return driver.findElement(By.xpath(xpath));
	}
	public static WebElement findElementbylinkText(String value)
	{
		return driver.findElement(By.linkText(value));
	}
	public static String getAttributeValue(WebElement element)
	{
		String text= null;
		try {
		text=element.getAttribute("value");
		}
		catch (Exception e) {
		}
		return text;
	}
	public static void getText(List<WebElement> list)
	{
		try {
		String text=((WebElement) list).getText();
		System.out.println(text);
		}
		catch (Exception e) {
		}
	}
	// Abstract method
	public static WebElement findbyAbstract(By by) 
	{
		return driver.findElement(by);
			
	}
	public static void select(WebElement element,int index)
	{
		try {
			s=new Select(element);
			s.selectByIndex(index);
		}
		catch (Exception e) {
		}
	}
	public static void javaSc()
	{
		try {
			js= (JavascriptExecutor)driver;
			//js.executeScript("arguments[0].click()", element);
			js.executeScript("window.scrollBy('0','3000')");
		}
		catch (Exception e) {
		}
	}
	public static void moveToEle(WebElement element)
	{
		try {
			ac=new Actions(driver);
			ac.moveToElement(element).build().perform();
		}
		catch (Exception e) {
		}
	}
	public static void moveToEleClick(WebElement element)
	{
		try {
			ac=new Actions(driver);
			ac.moveToElement(element).click().build().perform();
		}
		catch (Exception e) {
		}
	}
public static String excelReadReuseable(int rowdata , int celldata) {
		
		String value = null;
		try {
			// locate
			File f = new File("E:\\MavenWorkspace\\SampleProject\\src\\test\\resources\\TestData\\AugProject.xlsx");
			// read
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Sheet1");
			Row row = sheet.getRow(rowdata);
			Cell cell = row.getCell(celldata);
			int cellType = cell.getCellType();
			// 1 string
			if (cellType == 1) {
				value = cell.getStringCellValue();
				System.out.println(value);
				// 0 number and date
			} else if (cellType == 0) {
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat sc = new SimpleDateFormat("dd/MM/yyyy");
					value = sc.format(dateCellValue);
					System.out.println(value);
				} else {
					double numericCellValue = cell.getNumericCellValue();
					long l = (long) numericCellValue;
					value= String.valueOf(l);
					System.out.println(value);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	public static void excelWriteReusable(int row,int cell,String value) {
	try {
		// locate
		File f = new File("E:\\MavenWorkspace\\SampleProject\\src\\test\\resources\\TestData\\AugProject.xlsx");
		// read
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.createSheet("OrderValue");
		Row createRow = sheet.createRow(row);
		Cell createCell = createRow.createCell(cell);
		createCell.setCellValue(value);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		wb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
