package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CouponsPage {

    @FindBy(xpath="//img[@src='../../../assets/imgs/power (2) 1.png']")private WebElement PowerBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Heart.png']")private WebElement WishlistBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Buy.png']")private WebElement CartBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Notification.png']")private WebElement NotificationBtn;
	
	//With the help of coupon code expiring date and apply button
//	@FindBy(xpath="//td[.='bIrMzTzL']/following-sibling::td[.='Sep 29,2023']/following-sibling::td[@class='buttons']")private WebElement ParticularCouponApplyBtn;
	
	//With the help of coupon code expiring date and apply button
	@FindBy(xpath="//td[.='bIrMzTzL']/following-sibling::td[@class='buttons']")private WebElement ParticularCouponApplyBtn;
	
	@FindBy(xpath="//li[@class='pagination-previous disabled ng-star-inserted']")private WebElement PreviousBtn;
	
	@FindBy(xpath="//a[@aria-label='Next page']")private WebElement NextBtn;
	
	public CouponsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
