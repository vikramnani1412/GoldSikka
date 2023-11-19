package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Settings_AddressPage {

    @FindBy(xpath="//img[@src='../../../assets/imgs/power (2) 1.png']")private WebElement PowerBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Heart.png']")private WebElement WishlistBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Buy.png']")private WebElement CartBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Notification.png']")private WebElement NotificationBtn;
    
    @FindBy(xpath="//a[@routerlink='./add']")private WebElement AddNewAddressBtn;
    
    @FindBy(xpath="//a[@href='/settings/addresses/642/edit']")private WebElement FatherNameEdt;
    
	public Settings_AddressPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	

}
