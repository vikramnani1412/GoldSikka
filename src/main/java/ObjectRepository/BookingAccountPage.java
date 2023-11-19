package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class BookingAccountPage {

	    @FindBy(xpath="//img[@src='../../../assets/imgs/power (2) 1.png']")private WebElement PowerBtn;
		
		@FindBy(xpath="//img[@src='../../../assets/imgs/Heart.png']")private WebElement WishlistBtn;
		
		@FindBy(xpath="//img[@src='../../../assets/imgs/Buy.png']")private WebElement CartBtn;
		
		@FindBy(xpath="//img[@src='../../../assets/imgs/Notification.png']")private WebElement NotificationBtn;
		
		@FindBy(xpath="//input[@placeholder='Enter Amount']")private WebElement AmountTxt;
		
		@FindBy(xpath="//button[@type='submit']")private WebElement SubmitBtn;
		
//		@FindBy(xpath="//input[@id='country-code']/following-sibling::label[.='Phone Number']")private WebElement PhoneNoEdt;
		
//		@FindBy(xpath="//div[.='Netbanking']")private WebElement NetBankingLnk;
		
//		@FindBy(xpath="//div[.='ICICI']")private WebElement IciciBankLnk;
		
//		@FindBy(xpath="//button[.='Pay Now']")private WebElement PayNowBtn;
		
		@FindBy(xpath="//button[.='Withdraw']")private WebElement WithdrawBtn;
		
		@FindBy(xpath="//table[@class='table']")private WebElement TransactionsTable;
		
		@FindBy(xpath="//li[@class='pagination-previous disabled ng-star-inserted']")private WebElement PreviousBtn;

		@FindBy(xpath="//a[@aria-label='Next page']")private WebElement NextPageBtn;
		
		public BookingAccountPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}

		public WebElement getPowerBtn() {
			return PowerBtn;
		}

		public WebElement getWishlistBtn() {
			return WishlistBtn;
		}

		public WebElement getCartBtn() {
			return CartBtn;
		}

		public WebElement getNotificationBtn() {
			return NotificationBtn;
		}

		public WebElement getAmountTxt() {
			return AmountTxt;
		}

		public WebElement getSubmitBtn() {
			return SubmitBtn;
		}

		public WebElement getWithdrawBtn() {
			return WithdrawBtn;
		}

		public WebElement getTransactionsTable() {
			return TransactionsTable;
		}

		public WebElement getPreviousBtn() {
			return PreviousBtn;
		}

		public WebElement getNextPageBtn() {
			return NextPageBtn;
		}
		
//		public WebElement getPhoneNoEdt() {
//			return PhoneNoEdt;
//		}
//
//		public WebElement getNetBankingLnk() {
//			return NetBankingLnk;
//		}
//
//		public WebElement getIciciBankLnk() {
//			return IciciBankLnk;
//		}
//
//		public WebElement getPayNowBtn() {
//			return PayNowBtn;
//		}

		//Business Library
		public void depositMoneyInBookingAccount(WebDriver driver) throws InterruptedException
		{
			Thread.sleep(2000);
			AmountTxt.sendKeys("100000");
			SubmitBtn.click();	
		}
		
		
		
}
