package ObjectRepository;




import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

	//Rule-2:Identify the elements using annotations
    @FindBy(xpath="//img[@src='../../../assets/imgs/power (2) 1.png']")private WebElement PowerBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Heart.png']")private WebElement WishlistBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Buy.png']")private WebElement CartBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Notification.png']")private WebElement NotificationBtn;
	
	@FindBy(xpath="//span[.='Dashboard']")private WebElement DashboardLnk;
	
	@FindBy(xpath="//span[.='Schemes']")private WebElement SchemesLnk;
	
	@FindBy(xpath="//span[.='Gold Suvidha']")private WebElement GoldSuvidhaLnk;
	
	@FindBy(xpath="//span[.='Booking Account']")private WebElement BookingAccountLnk;
	
	@FindBy(xpath="//div[@class='text-center']/following-sibling::div[contains(.,'₹ ')]")private WebElement TotalWalletBalence;
	
	@FindBy(xpath="//span[.='Passbook']")private WebElement PassbookLnk;
	
	@FindBy(xpath="//span[.='Ecommerce']")private WebElement EcommerceLnk;
	
	@FindBy(xpath="//img[@src='assets/imgs/calendar-star 1.png']/following-sibling::span[.='Events']")private WebElement EventsLnk;
	
	@FindBy(xpath="//span[.='Referrals']")private WebElement ReferralsLnk;
	
	@FindBy(xpath="//span[.='Coupons']")private WebElement CouponsLnk;
	
	@FindBy(xpath="//span[.='Business']")private WebElement BusinessLnk;
	
	@FindBy(xpath="//span[.='Feed Back']")private WebElement FeedbackLnk;
	
	@FindBy(xpath="Tickets")private WebElement TicketsLnk;

	@FindBy(xpath="Settings")private WebElement SettingsLnk;
	
//	@FindBy(xpath="//span[.='Goldcannons']")private WebElement goldcannonsLnk;
//	
//	@FindBy(xpath="//span[.='Campaign']")private WebElement campaignLnk;
//	
//	@FindBy(xpath="//span[.='Partners']")private WebElement partnersLnk;
//	
//	@FindBy(xpath="//span[.='Banners']")private WebElement bannerssLnk;
//	
//	@FindBy(xpath="//span[.='Pop Ads']")private WebElement popAdsLnk;
//	
//	@FindBy(xpath="//span[.='coupons']")private WebElement couponssLnk;
//	
//	@FindBy(xpath="//span[.='GoldSikka']")private WebElement goldsikkaLnk;
//	
//	@FindBy(xpath="//span[.='Sales']")private WebElement salessLnk;
//	
//	@FindBy(xpath="//span[.='Directories']")private WebElement directoriesLnk;
	
	
	//Rule-3:Create a constructor to initilise these elements
	
	public LandingPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Rule-4:Provide getters to access these variable

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

	public WebElement getDashboardLnk() {
		return DashboardLnk;
	}

	public WebElement getSchemesLnk() {
		return SchemesLnk;
	}

	public WebElement getGoldSuvidhaLnk() {
		return GoldSuvidhaLnk;
	}

	public WebElement getBookingAccountLnk() {
		return BookingAccountLnk;
	}

	public WebElement getTotalWalletBalence() {
		return TotalWalletBalence;
	}

	public WebElement getPassbookLnk() {
		return PassbookLnk;
	}

	public WebElement getEcommerceLnk() {
		return EcommerceLnk;
	}

	public WebElement getEventsLnk() {
		return EventsLnk;
	}

	public WebElement getReferralsLnk() {
		return ReferralsLnk;
	}

	public WebElement getCouponsLnk() {
		return CouponsLnk;
	}

	public WebElement getBusinessLnk() {
		return BusinessLnk;
	}

	public WebElement getFeedbackLnk() {
		return FeedbackLnk;
	}

	public WebElement getTicketsLnk() {
		return TicketsLnk;
	}

	public WebElement getSettingsLnk() {
		return SettingsLnk;
	}
	
	//Business Library - To optimize the test script
	public void powerBtn()
	{
		PowerBtn.click();
	}
	
	public void wishlistBtn()
	{
		WishlistBtn.click();
	}
	
	public void cartBtn()
	{
		CartBtn.click();
	}
	
	public void notificationBtn()
	{
		NotificationBtn.click();
	}
	
	public void clickOnDashboardLnk()
	{
		DashboardLnk.click();
	}
	
	public void clickOnSchemesLnk(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(SchemesLnk)).click();
	}
	
	public void clickOnGoldSuvidhaLnk()
	{
		GoldSuvidhaLnk.click();
	}
	
	public void clickOnBookingAccountLnk(WebDriver driver)
	{
		BookingAccountLnk.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(TotalWalletBalence));
		String TotalBal = TotalWalletBalence.getText();
		System.out.println(TotalBal);
	}
	
	
//	public void viewBookingAccountBalance(WebDriver driver)
//	{
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.elementToBeClickable(TotalWalletBalence));
//		String TotalBal = TotalWalletBalence.getText();
//		System.out.println(TotalBal);
//		
//	}
	
	public void clickOnPassbookLnk()
	{
		PassbookLnk.click();
	}
	
	public void clickOnEcommerceLnk()
	{
		EcommerceLnk.click();
	}
	
	public void clickOnEventsLnk()
	{
		EventsLnk.click();
	}
	
	public void clickOnReferralsLnk()
	{
		ReferralsLnk.click();
	}
	
	public void clickOnCouponsLnk()
	{
		CouponsLnk.click();
	}
	
	public void clickOnBusinessLnk()
	{
		BusinessLnk.click();
	}
	
	public void clickOnFeedbackLnk()
	{
		FeedbackLnk.click();
	}
	
	public void clickOnTicketsLnk()
	{
		TicketsLnk.click();
	}
	
	public void clickOnSettingsLnk()
	{
		SettingsLnk.click();
	}
	
	
}
