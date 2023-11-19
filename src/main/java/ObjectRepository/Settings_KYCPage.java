package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Settings_KYCPage {

    @FindBy(xpath="//img[@src='../../../assets/imgs/power (2) 1.png']")private WebElement PowerBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Heart.png']")private WebElement WishlistBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Buy.png']")private WebElement CartBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Notification.png']")private WebElement NotificationBtn;
    
    @FindBy(xpath="//button[.=' Update Kyc ']")private WebElement UpdateKyc;
    
    @FindBy(xpath="//input[@placeholder='Enter Father Name']")private WebElement FatherNameEdt;
    
    @FindBy(xpath="//input[@placeholder='Enter Spouse Name']")private WebElement SpouseNameEdt;
    
    @FindBy(xpath="//input[@placeholder='Enter Alternate Phone No']")private WebElement AlternatePhoneEdt;
    
    @FindBy(xpath="//input[@placeholder='Enter PAN No']")private WebElement PanCardEdt;
    
    @FindBy(xpath="//input[@placeholder='Enter Aadhaar No']")private WebElement AadhaarCardEdt;
    
    @FindBy(xpath="//input[@value='M']")private WebElement MaleRadioBtn;
    
    @FindBy(xpath="//input[@value='F']")private WebElement FemaleRadioBtn;
    
    @FindBy(xpath="//button[.='Submit']")private WebElement SubmitBtn;
    
    
	public Settings_KYCPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
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


	public WebElement getUpdateKyc() {
		return UpdateKyc;
	}


	public WebElement getFatherNameEdt() {
		return FatherNameEdt;
	}


	public WebElement getSpouseNameEdt() {
		return SpouseNameEdt;
	}


	public WebElement getAlternatePhoneEdt() {
		return AlternatePhoneEdt;
	}


	public WebElement getPanCardEdt() {
		return PanCardEdt;
	}


	public WebElement getAadhaarCardEdt() {
		return AadhaarCardEdt;
	}


	public WebElement getMaleRadioBtn() {
		return MaleRadioBtn;
	}


	public WebElement getFemaleRadioBtn() {
		return FemaleRadioBtn;
	}


	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	
	
	

}
