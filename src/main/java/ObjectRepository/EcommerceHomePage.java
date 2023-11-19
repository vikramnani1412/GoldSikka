package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EcommerceHomePage {

	@FindBy(xpath="//img[@src='../../../assets/imgs/power (2) 1.png']")private WebElement PowerBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Heart.png']")private WebElement WishlistBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Buy.png']")private WebElement CartBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Notification.png']")private WebElement NotificationBtn;

	@FindBy(xpath="//input[@placeholder='Search...']")private WebElement SearchBar;
	
	@FindBy(xpath="//p[.='necklace']")private WebElement NecklaceCategoryLnk;
	
	@FindBy(xpath="//p[.='Wedding']")private WebElement WeddingCategoryLnk;
	
	@FindBy(xpath="//p[.='Chains']")private WebElement ChainCategoryLnk;
	
	@FindBy(xpath="//p[.='Bangles']")private WebElement BangleCategoryLnk;
	
	@FindBy(xpath="//p[.='Nose Pins']")private WebElement NosepinCategoryLnk;
	
	@FindBy(xpath="//p[.='Ear Rings']")private WebElement EarRingCategoryLnk;
	
	@FindBy(xpath="//p[.='Rings']")private WebElement RingsCategoryLnk;
	
	public EcommerceHomePage(WebDriver driver)
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

	public WebElement getSearchBar() {
		return SearchBar;
	}

	public WebElement getNecklaceCategoryLnk() {
		return NecklaceCategoryLnk;
	}

	public WebElement getWeddingCategoryLnk() {
		return WeddingCategoryLnk;
	}

	public WebElement getChainCategoryLnk() {
		return ChainCategoryLnk;
	}

	public WebElement getBangleCategoryLnk() {
		return BangleCategoryLnk;
	}

	public WebElement getNosepinCategoryLnk() {
		return NosepinCategoryLnk;
	}

	public WebElement getEarRingCategoryLnk() {
		return EarRingCategoryLnk;
	}

	public WebElement getRingsCategoryLnk() {
		return RingsCategoryLnk;
	}
	
	
	
	
	
}
