package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoldSuvidhaBuyGoldPage {
	
	@FindBy(xpath="//ul[@class='user-nav ng-tns-c39-0']/li/following-sibling::li//span[.='admin']")private WebElement AdminLnk;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/power (2) 1.png']")private WebElement PowerBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Heart.png']")private WebElement WishlistBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Buy.png']")private WebElement CartBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Notification.png']")private WebElement NotificationBtn;
	
    @FindBy(xpath="//input[@placeholder='Enter Amount']")private WebElement EnterAmountTxt;
    
    @FindBy(xpath="//input[@placeholder='Enter grams']")private WebElement EnterGramsTxt;
    
    @FindBy(xpath="//input[@type='checkbox']")private WebElement UseBookingAccCheckBox;
    
    @FindBy(xpath="//input[@placeholder='Enter  Account amount']")private WebElement BookingAccAmtTxt;
    
    @FindBy(xpath="//input[@placeholder='Enter coupon code']")private WebElement EnterCouponCodeTxt;
    
    @FindBy(xpath="//button[@nztype='primary']")private WebElement CouponListBtn;
    
    @FindBy(xpath="//button[.='Apply']")private WebElement CouponApplyBtn;
    
    @FindBy(xpath="//input[@placeholder='Enter Referral Code']")private WebElement EnterReferalCodeTxt;
    
    @FindBy(xpath="//button[@class='proceed-btn']")private WebElement ProceedToPayBtn;
    
    //Upto Proceed To Pay Done
    
	public GoldSuvidhaBuyGoldPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getEnterAmountTxt() {
		return EnterAmountTxt;
	}

	public WebElement getEnterGramsTxt() {
		return EnterGramsTxt;
	}

	public WebElement getUseBookingAccCheckBox() {
		return UseBookingAccCheckBox;
	}

	public WebElement getBookingAccAmtTxt() {
		return BookingAccAmtTxt;
	}

	public WebElement getEnterCouponCodeTxt() {
		return EnterCouponCodeTxt;
	}

	public WebElement getCouponListBtn() {
		return CouponListBtn;
	}

	public WebElement getCouponApplyBtn() {
		return CouponApplyBtn;
	}

	public WebElement getEnterReferalCodeTxt() {
		return EnterReferalCodeTxt;
	}

	public WebElement getProceedToPayBtn() {
		return ProceedToPayBtn;
	}

	public WebElement getAdminLnk() {
		return AdminLnk;
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
	
	
	
	
	
	
}
