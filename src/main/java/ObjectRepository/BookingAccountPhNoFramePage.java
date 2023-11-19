package ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingAccountPhNoFramePage {

	String ParentWindow;
	
	@FindBy(xpath="//input[@name='contact']")private WebElement PhoneNumberEdt;
	
	@FindBy(xpath="//div[.='Proceed']")private WebElement ProceedBtn;
	
	@FindBy(xpath="//div[.='Netbanking']")private WebElement NetBankingLnk;
	
//	@FindBy(xpath="//div[contains(@id,'bank-item-"+BankName+"')]")private WebElement BankNameDynamicLnk;
	
    @FindBy(xpath="//div[.='HDFC']")private WebElement HDFCBankLnk;
	
	@FindBy(xpath="//div[.='ICICI']")private WebElement IciciBankLnk;
	
	@FindBy(xpath="//div[.='Axis']")private WebElement AxisBankLnk;
	
	@FindBy(xpath="//div[.='Kotak']")private WebElement KotakBankLnk;
	
	@FindBy(xpath="//div[.='Yes Bank']")private WebElement YesBankLnk;
	
	@FindBy(xpath="//div[.='BOB']")private WebElement BOBBankLnk;
	
	@FindBy(xpath="//button[.='Pay Now']")private WebElement PayNowBtn;

	
	public BookingAccountPhNoFramePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPhoneNumberEdt() {
		return PhoneNumberEdt;
	}

	public WebElement getProceedBtn() {
		return ProceedBtn;
	}

	
	public WebElement getNetBankingLnk() {
		return NetBankingLnk;
	}

	public WebElement getIciciBankLnk() {
		return IciciBankLnk;
	}

	public WebElement getPayNowBtn() {
		return PayNowBtn;
	}
    //Data Provider
	public void enterPhoneNumberAndClickOnProceed(WebDriver driver) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PhoneNumberEdt.sendKeys("8686184458");
		ProceedBtn.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(NetBankingLnk));
		NetBankingLnk.click();
//		IciciBankLnk.click();
	
	}
	
	public void enterPhoneNumberAndHdfcBankBtnClickOnProceed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PhoneNumberEdt.sendKeys("8686184458");
		ProceedBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(NetBankingLnk));
		NetBankingLnk.click();
		HDFCBankLnk.click();
	}
	
	public void enterPhoneNumberAndIciciBankBtnClickOnProceed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PhoneNumberEdt.sendKeys("8686184458");
		ProceedBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(NetBankingLnk));
		NetBankingLnk.click();
		IciciBankLnk.click();
	}
	
	public void enterPhoneNumberAndAxisBankBtnClickOnProceed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PhoneNumberEdt.sendKeys("8686184458");
		ProceedBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(NetBankingLnk));
		NetBankingLnk.click();
		AxisBankLnk.click();
	}
	
	public void enterPhoneNumberAndKotakBankBtnClickOnProceed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PhoneNumberEdt.sendKeys("8686184458");
		ProceedBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(NetBankingLnk));
		NetBankingLnk.click();
		KotakBankLnk.click();
	}
	
	public void enterPhoneNumberAndYesBankBtnClickOnProceed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PhoneNumberEdt.sendKeys("8686184458");
		ProceedBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(NetBankingLnk));
		NetBankingLnk.click();
		YesBankLnk.click();
	}
	
	public void enterPhoneNumberAndBOBBankBtnClickOnProceed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PhoneNumberEdt.sendKeys("8686184458");
		ProceedBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(NetBankingLnk));
		NetBankingLnk.click();
		BOBBankLnk.click();
	}
	
	
	
}
