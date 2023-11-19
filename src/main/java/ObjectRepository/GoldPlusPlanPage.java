package ObjectRepository;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import GenericUtility.WebDriverUtility;

public class GoldPlusPlanPage {

	@FindBy(xpath="")private WebElement TotalWalletBalence;
	
	@FindBy(xpath="//select[@formcontrolname='amount']")private WebElement AmountDrpDwn;
    
    @FindBy(xpath="//select[@placeholder='Months']")private WebElement MonthsDrpDwn;
    
    @FindBy(xpath="//p[.='Use Booking Account']/../..//div/input[@type='checkbox']")private WebElement UseBookingAccountCheckBox;
    
    @FindBy(xpath="//input[@placeholder='Enter amount']")private WebElement EnterAmountEdt;
    
    @FindBy(xpath="//input[@placeholder='Enter coupon code']")private WebElement CouponCodeEdt;
    
    @FindBy(xpath="//input[@formcontrolname='agree']")private WebElement TermsAndConditionsCheckBox;
    
    @FindBy(xpath="//span[.=' Coupon List ']")private WebElement CouponListBtn;
    
    @FindBy(xpath="//div[@class='card d-block mt-4 mb-4 ng-star-inserted']/descendant::div/descendant::table/descendant::td[.='rBqmLEuL']")private WebElement InsideCouponCodeList;
    
    @FindBy(xpath="//button[.='Apply']")private WebElement ApplyBtn;
    
    @FindBy(xpath="//input[@placeholder='Enter Referral Code']")private WebElement ReferralCodeEdt;
    
    @FindBy(xpath="//div[@class='coupon-text2']/following-sibling::div/button[@type='submit']")private WebElement StartSubscriptionBtn;
    
    @FindBy(xpath="//iframe[@class='razorpay-checkout-frame']")private WebElement AfterClickOnStartSubscriptionBtnFrame;
    
    @FindBy(xpath="//input[@id='contact']")private WebElement MobileNumberEdt;
    
    @FindBy(xpath="//button[.='Proceed']")private WebElement ProceedBtn;
    //button[@class='svelte-s8db8t']  both are proceed button scripts
    //div[@class='cta-container has-tooltip svelte-s8db8t reduce-amount-size no-shadow']
    
    @FindBy(xpath="//div[text()='Wallet - PhonePe']")private WebElement PhonepeLnk;
    
    //
    @FindBy(xpath="//div[.='Card']")private WebElement CardLnk;
    
    @FindBy(xpath="//input[@id='card_number']")private WebElement CardNoEdt;
    
    @FindBy(xpath="//input[@id='card_expiry']")private WebElement CardExpiryEdt;
    
    @FindBy(xpath="//input[@id='card_name']")private WebElement CardHolderNameEdt;
    
    @FindBy(xpath="//input[@id='card_cvv']")private WebElement CardCvvEdt;
    
    @FindBy(xpath="//span[@class='checkbox svelte-1b61qmd']")private WebElement SaveCardChckBox;
    
    @FindBy(xpath="//div[@class='redesign-v15-cta-wrapper svelte-s8db8t']//button[@class='svelte-s8db8t']")private WebElement CardPayNowBtn;
    
    @FindBy(xpath="//button[.='Success']")private WebElement CardWindowSuccesBtn;
    //success popup
    @FindBy(xpath="//button[.='Failure']")private WebElement CardWindowFailureBtn;
    //failure popup
    @FindBy(xpath="//button[.='Pay and Save Card']")private WebElement PayAndSaveCardBtn;
    
    @FindBy(xpath="//button[.='Pay without Saving Card']")private WebElement PayWithoutSavingBtn;
    
    @FindBy(xpath="//button[.='Pay With PayPal']")private WebElement PayWithPayPalBtn;
    
    @FindBy(xpath="//span[.='Cancel']")private WebElement CancelBtn;
    //
    
    @FindBy(xpath="//div[.='UPI / QR']")private WebElement UpiLnk;
   
    //
    @FindBy(xpath="//div[.='Netbanking']")private WebElement NetBankingLnk;
        
    @FindBy(xpath="//div[.='ICICI']]")private WebElement IciciBankLnk;
    
    @FindBy(xpath="//div[.='Axis']")private WebElement AxisBankLnk;
    
    @FindBy(xpath="//label[@for='bank-radio-HDFC']")private WebElement HdfcBankLnk;
    
    @FindBy(xpath="//div[.='Kotak']")private WebElement KotakBankLnk;
    
    @FindBy(xpath="//div[.='Yes Bank']")private WebElement YesBankLnk;
    
    @FindBy(xpath="//div[.='BOB']")private WebElement BOBBankLnk;
  
    @FindBy(xpath="//div[@class='svelte-3qevvl']")private WebElement BankServerIssueLnk;
    
    @FindBy(xpath="//button[@class='cta-btn svelte-n4r70l']")private WebElement BankServerIssueContinueBtn;
    
   	@FindBy(xpath="//div[@class='redesign-v15-cta-wrapper svelte-s8db8t']")private WebElement PayNowBtn;
   	
   	@FindBy(xpath="//button[.='Success']")private WebElement WindowSuccessBtn;
    
   	//
   	@FindBy(xpath="//div[.='Wallet']")private WebElement WalletLnk;
   	
   	@FindBy(xpath="//span[.='PhonePe']")private WebElement WPhonepeLnk;
   	
   	@FindBy(xpath="//span[.='Amazon Pay']")private WebElement AmazonPayLnk;
   	
   	@FindBy(xpath="//span[.='Bajaj Pay']")private WebElement BajajPayLnk;
   	
   	@FindBy(xpath="//span[.='Mobikwik']")private WebElement MobikwikLnk;
   	
   	@FindBy(xpath="//span[.='Freecharge']")private WebElement FreechargeLnk;
   	
   	@FindBy(xpath="//span[.='Airtel Payments Bank']")private WebElement AirtelPaymentLnk;
   	
   	@FindBy(xpath="//span[.='//span[.='Ola Money (Postpaid + Wallet)']']")private WebElement OlaPaymentLnk;
   	
   	@FindBy(xpath="//span[.='JioMoney']")private WebElement JioMneyLnk;
   	
   	@FindBy(xpath="//span[.='PayPal']")private WebElement PaypalLnk;
   	   	
	public GoldPlusPlanPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}



	public WebElement getAmountDrpDwn() {
		return AmountDrpDwn;
	}



	public WebElement getMonthsDrpDwn() {
		return MonthsDrpDwn;
	}



	public WebElement getUseBookingAccountCheckBox() {
		return UseBookingAccountCheckBox;
	}



	public WebElement getEnterAmountEdt() {
		return EnterAmountEdt;
	}



	public WebElement getTermsAndConditionsCheckBox() {
		return TermsAndConditionsCheckBox;
	}



	public WebElement getCouponCodeEdt() {
		return CouponCodeEdt;
	}



	public WebElement getCouponCodeListButton() {
		return CouponListBtn;
	}



	public WebElement getApplyBtn() {
		return ApplyBtn;
	}



	public WebElement getReferralCodeEdt() {
		return ReferralCodeEdt;
	}



	public WebElement getStartSubscriptionBtn() {
		return StartSubscriptionBtn;
	}
	
	
    
	public WebElement getAfterClickOnStartSubscriptionBtnFrame() {
		return AfterClickOnStartSubscriptionBtnFrame;
	}



	public WebElement getMobileNumberEdt() {
		return MobileNumberEdt;
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



	public WebElement getAxisBankLnk() {
		return AxisBankLnk;
	}



	public WebElement getHdfcBankLnk() {
		return HdfcBankLnk;
	}



	public WebElement getKotakBankLnk() {
		return KotakBankLnk;
	}



	public WebElement getYesBankLnk() {
		return YesBankLnk;
	}



	public WebElement getBOBBankLnk() {
		return BOBBankLnk;
	}



	public WebElement getBankServerIssueLnk() {
		return BankServerIssueLnk;
	}



	public WebElement getBankServerIssueContinueBtn() {
		return BankServerIssueContinueBtn;
	}



	public WebElement getPayNowBtn() {
		return PayNowBtn;
	}



	public WebElement getWindowSuccessBtn() {
		return WindowSuccessBtn;
	}

    
	public void goldPlusPlanPage(WebDriver driver,  String SelectAmount, String Months, String EnterAmount , String MobileNumber) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		UseBookingAccountCheckBox.click();
		EnterAmountEdt.sendKeys(EnterAmount);
		Thread.sleep(5000);
		TermsAndConditionsCheckBox.click();
		Thread.sleep(5000);
		
		Robot r = new Robot();
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		wait.until(ExpectedConditions.visibilityOf(AfterClickOnStartSubscriptionBtnFrame));
		
		driver.switchTo().frame(AfterClickOnStartSubscriptionBtnFrame);
		
		MobileNumberEdt.sendKeys(MobileNumber);
		Thread.sleep(1000);
		ProceedBtn.click();
		
		while(true)
		{
			try {
				wait.until(ExpectedConditions.visibilityOf(NetBankingLnk));
				NetBankingLnk.click();
				break;
			} catch (Exception e) {
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
				r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			}
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(HdfcBankLnk)).click();
		String ParentWin = driver.getWindowHandle();
		Thread.sleep(3000);
		PayNowBtn.click();
		Set<String> ChildWin = driver.getWindowHandles();
		
		for(String Child : ChildWin)
		{
			if(!ParentWin.equals(Child))
			{
			   driver.switchTo().window(Child);
			}
		}
		String SuccessMsg = WindowSuccessBtn.getText();
		System.out.println("Subscribed "+SuccessMsg+"fully");
		WindowSuccessBtn.click();
		
		driver.switchTo().window(ParentWin);
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);
        
        
      
		
		
        		
	}
	
// Gold Plus Plan With NetBanking Starts
	
	
	public void goldPlusPlanPageHdfc1000(WebDriver driver,  String SelectAmount, String Months, String EnterAmount , String MobileNumber) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		TermsAndConditionsCheckBox.click();
		
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(AfterClickOnStartSubscriptionBtnFrame));
		
		driver.switchTo().frame(AfterClickOnStartSubscriptionBtnFrame);
		
		MobileNumberEdt.sendKeys(MobileNumber);
		ProceedBtn.click();
		
		while(true)
		{
			try {
				NetBankingLnk.click();
				break;
			} catch (Exception e) {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
				r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			}
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(HdfcBankLnk)).click();
		String ParentWin = driver.getWindowHandle();
		Thread.sleep(2000);
		PayNowBtn.click();
		Set<String> ChildWin = driver.getWindowHandles();
		
		for(String Child : ChildWin)
		{
			if(!ParentWin.equals(Child))
			{
			   driver.switchTo().window(Child);
			}
		}
		String SuccessMsg = WindowSuccessBtn.getText();
		System.out.println("Subscribed "+SuccessMsg+"fully");
		WindowSuccessBtn.click();
		
		driver.switchTo().window(ParentWin);
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);
        		
	}
	
	public void goldPlusPlanPageIcici1500(WebDriver driver,  String SelectAmount, String Months, String EnterAmount , String MobileNumber) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		TermsAndConditionsCheckBox.click();
		
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(AfterClickOnStartSubscriptionBtnFrame));
		
		driver.switchTo().frame(AfterClickOnStartSubscriptionBtnFrame);
		
		MobileNumberEdt.sendKeys(MobileNumber);
		ProceedBtn.click();
		
		while(true)
		{
			try {
				NetBankingLnk.click();
				break;
			} catch (Exception e) {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
				r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			}
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(IciciBankLnk)).click();
		String ParentWin = driver.getWindowHandle();
		PayNowBtn.click();
		Set<String> ChildWin = driver.getWindowHandles();
		
		for(String Child : ChildWin)
		{
			if(!ParentWin.equals(Child))
			{
			   driver.switchTo().window(Child);
			}
		}
		String SuccessMsg = WindowSuccessBtn.getText();
		System.out.println("Subscribed "+SuccessMsg+"fully");
		WindowSuccessBtn.click();
		
		driver.switchTo().window(ParentWin);
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);
        		
	}
	
	public void goldPlusPlanPageAxis2000(WebDriver driver,  String SelectAmount, String Months, String EnterAmount , String MobileNumber) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		TermsAndConditionsCheckBox.click();
		
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(AfterClickOnStartSubscriptionBtnFrame));
		
		driver.switchTo().frame(AfterClickOnStartSubscriptionBtnFrame);
		
		MobileNumberEdt.sendKeys(MobileNumber);
		ProceedBtn.click();
		
		while(true)
		{
			try {
				NetBankingLnk.click();
				break;
			} catch (Exception e) {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
				r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			}
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(AxisBankLnk)).click();
		String ParentWin = driver.getWindowHandle();
		PayNowBtn.click();
		Set<String> ChildWin = driver.getWindowHandles();
		
		for(String Child : ChildWin)
		{
			if(!ParentWin.equals(Child))
			{
			   driver.switchTo().window(Child);
			}
		}
		String SuccessMsg = WindowSuccessBtn.getText();
		System.out.println("Subscribed "+SuccessMsg+"fully");
		WindowSuccessBtn.click();
		
		driver.switchTo().window(ParentWin);
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);
		
	}
	
	public void goldPlusPlanPageKotak2500(WebDriver driver,  String SelectAmount, String Months, String EnterAmount , String MobileNumber) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		TermsAndConditionsCheckBox.click();
		
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(AfterClickOnStartSubscriptionBtnFrame));
		
		driver.switchTo().frame(AfterClickOnStartSubscriptionBtnFrame);
		
		MobileNumberEdt.sendKeys(MobileNumber);
		ProceedBtn.click();
		
		while(true)
		{
			try {
				NetBankingLnk.click();
				break;
			} catch (Exception e) {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
				r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			}
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(KotakBankLnk)).click();
		String ParentWin = driver.getWindowHandle();
		PayNowBtn.click();
		Set<String> ChildWin = driver.getWindowHandles();
		
		for(String Child : ChildWin)
		{
			if(!ParentWin.equals(Child))
			{
			   driver.switchTo().window(Child);
			}
		}
		String SuccessMsg = WindowSuccessBtn.getText();
		System.out.println("Subscribed "+SuccessMsg+"fully");
		WindowSuccessBtn.click();
		
		driver.switchTo().window(ParentWin);
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);
        		
	}
	
	public void goldPlusPlanPageYes3000(WebDriver driver,  String SelectAmount, String Months, String EnterAmount , String MobileNumber) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		TermsAndConditionsCheckBox.click();
		
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(AfterClickOnStartSubscriptionBtnFrame));
		
		driver.switchTo().frame(AfterClickOnStartSubscriptionBtnFrame);
		
		MobileNumberEdt.sendKeys(MobileNumber);
		ProceedBtn.click();
		
		while(true)
		{
			try {
				NetBankingLnk.click();
				break;
			} catch (Exception e) {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
				r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			}
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(YesBankLnk)).click();
		String ParentWin = driver.getWindowHandle();
		PayNowBtn.click();
		Set<String> ChildWin = driver.getWindowHandles();
		
		for(String Child : ChildWin)
		{
			if(!ParentWin.equals(Child))
			{
			   driver.switchTo().window(Child);
			}
		}
		String SuccessMsg = WindowSuccessBtn.getText();
		System.out.println("Subscribed "+SuccessMsg+"fully");
		WindowSuccessBtn.click();
		
		driver.switchTo().window(ParentWin);
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);
        		
	}
	
	public void goldPlusPlanPageBOB3500(WebDriver driver,  String SelectAmount, String Months, String EnterAmount , String MobileNumber) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		TermsAndConditionsCheckBox.click();
		
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(AfterClickOnStartSubscriptionBtnFrame));
		
		driver.switchTo().frame(AfterClickOnStartSubscriptionBtnFrame);
		
		MobileNumberEdt.sendKeys(MobileNumber);
		ProceedBtn.click();
		
		while(true)
		{
			try {
				NetBankingLnk.click();
				break;
			} catch (Exception e) {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
				r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			}
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(BOBBankLnk)).click();
		String ParentWin = driver.getWindowHandle();
		PayNowBtn.click();
		Set<String> ChildWin = driver.getWindowHandles();
		
		for(String Child : ChildWin)
		{
			if(!ParentWin.equals(Child))
			{
			   driver.switchTo().window(Child);
			}
		}
		String SuccessMsg = WindowSuccessBtn.getText();
		System.out.println("Subscribed "+SuccessMsg+"fully");
		WindowSuccessBtn.click();
		
		driver.switchTo().window(ParentWin);
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);
        		
	}
	
	
	
// Gold Plus Plan With NetBanking Ends
	
	
	
	
	
	
	
//Gold Plus Plan With Booking Account Starts
	
	
	
	public void goldPlusPlanPageBookingAccount1000(WebDriver driver,  String SelectAmount, String Months, String TotalPayableAmount) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		UseBookingAccountCheckBox.click();
		EnterAmountEdt.sendKeys(TotalPayableAmount);
		Thread.sleep(5000);
		TermsAndConditionsCheckBox.click();
		Thread.sleep(5000);
		
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);
		
		
	}
	
	
	public void goldPlusPlanPageBookingAccount1500(WebDriver driver,  String SelectAmount, String Months, String TotalPayableAmount) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		UseBookingAccountCheckBox.click();
		EnterAmountEdt.sendKeys(TotalPayableAmount);
		Thread.sleep(5000);
		TermsAndConditionsCheckBox.click();
		Thread.sleep(5000);
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);

        		
	}
	
	public void goldPlusPlanPageBookingAccount2000(WebDriver driver,  String SelectAmount, String Months, String TotalPayableAmount) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		UseBookingAccountCheckBox.click();
		EnterAmountEdt.sendKeys(TotalPayableAmount);
		Thread.sleep(5000);
		TermsAndConditionsCheckBox.click();
		Thread.sleep(5000);
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);

		
        		
	}
	
	public void goldPlusPlanPageBookingAccount2500(WebDriver driver,  String SelectAmount, String Months, String TotalPayableAmount) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		UseBookingAccountCheckBox.click();
		EnterAmountEdt.sendKeys(TotalPayableAmount);
		Thread.sleep(5000);
		TermsAndConditionsCheckBox.click();
		Thread.sleep(5000);
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);

		
        		
	}
	
	public void goldPlusPlanPageBookingAccount3000(WebDriver driver,  String SelectAmount, String Months, String TotalPayableAmount) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		UseBookingAccountCheckBox.click();
		EnterAmountEdt.sendKeys(TotalPayableAmount);
		Thread.sleep(5000);
		TermsAndConditionsCheckBox.click();
		Thread.sleep(5000);
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);

		
        		
	}
	
	public void goldPlusPlanPageBookingAccount3500(WebDriver driver,  String SelectAmount, String Months, String TotalPayableAmount) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		UseBookingAccountCheckBox.click();
		EnterAmountEdt.sendKeys(TotalPayableAmount);
		Thread.sleep(5000);
		TermsAndConditionsCheckBox.click();
		Thread.sleep(5000);
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);

		
        		
	}
	
	
	public void goldPlusPlanPageBookingAccount4000(WebDriver driver,  String SelectAmount, String Months, String TotalPayableAmount) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		UseBookingAccountCheckBox.click();
		EnterAmountEdt.sendKeys(TotalPayableAmount);
		Thread.sleep(5000);
		TermsAndConditionsCheckBox.click();
		Thread.sleep(5000);
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);

		
        		
	}
	
	public void goldPlusPlanPageBookingAccount4500(WebDriver driver,  String SelectAmount, String Months, String TotalPayableAmount) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		UseBookingAccountCheckBox.click();
		EnterAmountEdt.sendKeys(TotalPayableAmount);
		Thread.sleep(5000);
		TermsAndConditionsCheckBox.click();
		Thread.sleep(5000);
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);

		
        		
	}
	
	public void goldPlusPlanPageBookingAccount5000(WebDriver driver,  String SelectAmount, String Months, String TotalPayableAmount) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		UseBookingAccountCheckBox.click();
		EnterAmountEdt.sendKeys(TotalPayableAmount);
		Thread.sleep(5000);
		TermsAndConditionsCheckBox.click();
		Thread.sleep(5000);
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);

		
        		
	}
	public void goldPlusPlanPageBookingAccount5500(WebDriver driver,  String SelectAmount, String Months, String TotalPayableAmount) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		UseBookingAccountCheckBox.click();
		EnterAmountEdt.sendKeys(TotalPayableAmount);
		Thread.sleep(5000);
		TermsAndConditionsCheckBox.click();
		Thread.sleep(5000);
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);

		
        		
	}
	
	public void goldPlusPlanPageBookingAccount6000(WebDriver driver,  String SelectAmount, String Months, String TotalPayableAmount) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		UseBookingAccountCheckBox.click();
		EnterAmountEdt.sendKeys(TotalPayableAmount);
		Thread.sleep(5000);
		TermsAndConditionsCheckBox.click();
		Thread.sleep(5000);
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);

		
        		
	}
	
	public void goldPlusPlanPageBookingAccount6500(WebDriver driver,  String SelectAmount, String Months, String TotalPayableAmount) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		UseBookingAccountCheckBox.click();
		EnterAmountEdt.sendKeys(TotalPayableAmount);
		Thread.sleep(5000);
		TermsAndConditionsCheckBox.click();
		Thread.sleep(5000);
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);
		
        		
	}
	
	public void goldPlusPlanPageBookingAccount7000(WebDriver driver,  String SelectAmount, String Months, String TotalPayableAmount) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		UseBookingAccountCheckBox.click();
		EnterAmountEdt.sendKeys(TotalPayableAmount);
		Thread.sleep(5000);
		TermsAndConditionsCheckBox.click();
		Thread.sleep(5000);
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);

		
        		
	}
	
	public void goldPlusPlanPageBookingAccount7500(WebDriver driver,  String SelectAmount, String Months, String TotalPayableAmount) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		UseBookingAccountCheckBox.click();
		EnterAmountEdt.sendKeys(TotalPayableAmount);
		Thread.sleep(5000);
		TermsAndConditionsCheckBox.click();
		Thread.sleep(5000);
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);

		
        		
	}
	
	public void goldPlusPlanPageBookingAccount8000(WebDriver driver,  String SelectAmount, String Months, String TotalPayableAmount) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		UseBookingAccountCheckBox.click();
		EnterAmountEdt.sendKeys(TotalPayableAmount);
		Thread.sleep(5000);
		TermsAndConditionsCheckBox.click();
		Thread.sleep(5000);
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);

		
        		
	}
	
	public void goldPlusPlanPageBookingAccount8500(WebDriver driver,  String SelectAmount, String Months, String TotalPayableAmount) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		UseBookingAccountCheckBox.click();
		EnterAmountEdt.sendKeys(TotalPayableAmount);
		Thread.sleep(5000);
		TermsAndConditionsCheckBox.click();
		Thread.sleep(5000);
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);
		
        		
	}
	
	public void goldPlusPlanPageBookingAccount9000(WebDriver driver,  String SelectAmount, String Months, String TotalPayableAmount) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		UseBookingAccountCheckBox.click();
		EnterAmountEdt.sendKeys(TotalPayableAmount);
		Thread.sleep(5000);
		TermsAndConditionsCheckBox.click();
		Thread.sleep(5000);
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);
  		
	}
	
	public void goldPlusPlanPageBookingAccount9500(WebDriver driver,  String SelectAmount, String Months, String TotalPayableAmount) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		UseBookingAccountCheckBox.click();
		EnterAmountEdt.sendKeys(TotalPayableAmount);
		Thread.sleep(5000);
		TermsAndConditionsCheckBox.click();
		Thread.sleep(5000);
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);

		
        		
	}
	
	
//Gold Plus Plan With Booking Account Ends
	
	
// Gold Plus Plan With Card Starts
	
	public void goldPlusPlanPageBOB(WebDriver driver,  String SelectAmount, String Months, String EnterAmount , String MobileNumber) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue(SelectAmount);
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText(Months);
		Thread.sleep(1000);
		UseBookingAccountCheckBox.click();
		EnterAmountEdt.sendKeys(EnterAmount);
		TermsAndConditionsCheckBox.click();
		
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(AfterClickOnStartSubscriptionBtnFrame));
		
		driver.switchTo().frame(AfterClickOnStartSubscriptionBtnFrame);
		
		MobileNumberEdt.sendKeys(MobileNumber);
		ProceedBtn.click();
		
		while(true)
		{
			try {
				NetBankingLnk.click();
				break;
			} catch (Exception e) {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
				r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			}
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(BOBBankLnk)).click();
		String ParentWin = driver.getWindowHandle();
		PayNowBtn.click();
		Set<String> ChildWin = driver.getWindowHandles();
		
		for(String Child : ChildWin)
		{
			if(!ParentWin.equals(Child))
			{
			   driver.switchTo().window(Child);
			}
		}
		String SuccessMsg = WindowSuccessBtn.getText();
		System.out.println("Subscribed "+SuccessMsg+"fully");
		WindowSuccessBtn.click();
		
		driver.switchTo().window(ParentWin);
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);
        		
	}	
	
//Gold Plus Plan With Card Ends
    
	public void goldPlusPlanPage(WebDriver driver) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue("1000");
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText("12 Months");
		Thread.sleep(1000);
		UseBookingAccountCheckBox.click();
		EnterAmountEdt.sendKeys("1000");
		TermsAndConditionsCheckBox.click();
		
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(AfterClickOnStartSubscriptionBtnFrame));
		
		driver.switchTo().frame(AfterClickOnStartSubscriptionBtnFrame);
		
		MobileNumberEdt.sendKeys("8686184458");
		ProceedBtn.click();
		
		while(true)
		{
			try {
				NetBankingLnk.click();
				break;
			} catch (Exception e) {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
				r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			}
		}
		IciciBankLnk.click();
		String ParentWin = driver.getWindowHandle();
		PayNowBtn.click();
		Set<String> ChildWin = driver.getWindowHandles();
		
		for(String Child : ChildWin)
		{
			if(!ParentWin.equals(Child))
			{
			   driver.switchTo().window(Child);
			}
		}
		String SuccessMsg = WindowSuccessBtn.getText();
		System.out.println("Subscribed "+SuccessMsg+"fully");
		WindowSuccessBtn.click();
		
		driver.switchTo().window(ParentWin);
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);
        		
	}

	public void goldPlusPlanWithCoupons(WebDriver driver) throws Exception
	{
		
		Select s = new Select(AmountDrpDwn);
		s.selectByValue("1000");
		Select ss = new Select(MonthsDrpDwn);
		ss.selectByVisibleText("12 Months");
		Thread.sleep(1000);
		UseBookingAccountCheckBox.click();
		EnterAmountEdt.sendKeys("1000");
		TermsAndConditionsCheckBox.click();
		CouponListBtn.click();
//		WebElement frame = driver.findElement(By.xpath("//iframe[@id='ssIFrame_google']"));
//		driver.switchTo().frame(frame);
//		
//		WebElement clickEle = driver.findElement(By.xpath("(//td[.='150.00']/../following-sibling::tr/td[.='100.00']/following-sibling::td/following-sibling::td//following-sibling::td[.='11-11-2023']/following-sibling::td/button[@type='button'])[1]"));
//		for(;;)
//		{                                             //     To go coupon list page
//		try 
//		{
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
//			wait.until(ExpectedConditions.elementToBeClickable(clickEle)).click();     //.click();
//			break;
//		}
//		catch(Exception e)
//		{
//			Robot r = new Robot();
//			r.keyPress(KeyEvent.VK_PAGE_DOWN);
//		}}
		
		while(true)
		{
			try 
			{
				WebDriverUtility wUtil = new WebDriverUtility();
				wUtil.waitForElementToBeVisible(driver, StartSubscriptionBtn);
				StartSubscriptionBtn.click();
			    break;
			} 
			catch (Exception e) 
			{
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(AfterClickOnStartSubscriptionBtnFrame));
		
		driver.switchTo().frame(AfterClickOnStartSubscriptionBtnFrame);
		
		MobileNumberEdt.sendKeys("8686184458");
		ProceedBtn.click();
		
		while(true)
		{
			try {
				NetBankingLnk.click();
				break;
			} catch (Exception e) {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
				r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			}
		}
		IciciBankLnk.click();
		String ParentWin = driver.getWindowHandle();
		PayNowBtn.click();
		Set<String> ChildWin = driver.getWindowHandles();
		
		for(String Child : ChildWin)
		{
			if(!ParentWin.equals(Child))
			{
			   driver.switchTo().window(Child);
			}
		}
		String SuccessMsg = WindowSuccessBtn.getText();
		System.out.println("Subscribed "+SuccessMsg+"fully");
		WindowSuccessBtn.click();
		
		driver.switchTo().window(ParentWin);
		
		wait.until(ExpectedConditions.alertIsPresent());
		String AlertMsg = driver.switchTo().alert().getText();
        System.out.println(AlertMsg);
        driver.switchTo().alert().accept();
		
//        WebElement withoutGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h5[.='Feedback']/../following-sibling::div//button[.=' X ']"));
//        withoutGivingFeedbackCancelBtn.click();
        
        driver.findElement(By.xpath("//textarea[@placeholder='Help us to improve*']")).sendKeys("Good Scheme");
        
        driver.findElement(By.xpath("//label[@for='4-star']")).click();
        
        driver.findElement(By.xpath("//button[.=' submit ']")).click();
        
        WebElement AfterGivingFeedbackCancelBtn = driver.findElement(By.xpath("//h3[.=' Thank for your Feedback']/../following-sibling::div//button[.=' X ']"));
        AfterGivingFeedbackCancelBtn.click();
        
        String SchemeSubscriptionSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(SchemeSubscriptionSuccessMsg);
        		
	}
	
	
	
}
