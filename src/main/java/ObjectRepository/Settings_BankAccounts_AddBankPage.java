package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Settings_BankAccounts_AddBankPage {

    @FindBy(xpath="//input[@placeholder='Full name as per bank details']")private WebElement FullNameEdt;
	
	@FindBy(xpath="//input[@placeholder='Enter Account Number']")private WebElement AccountNoEdt;
	
	@FindBy(xpath="//input[@placeholder='Enter Bank Name']")private WebElement BankNameEdt;
	
	@FindBy(xpath="//input[@placeholder='Enter Branch Name']")private WebElement BranchNameEdt;
    
    @FindBy(xpath="//input[@placeholder='Enter IFSC Code']")private WebElement IfscCodeEdt;
    
    @FindBy(xpath="//div[.='Submit']")private WebElement SubmitBtn;
    
	public Settings_BankAccounts_AddBankPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFullNameEdt() {
		return FullNameEdt;
	}

	public WebElement getAccountNoEdt() {
		return AccountNoEdt;
	}

	public WebElement getBankNameEdt() {
		return BankNameEdt;
	}

	public WebElement getBranchNameEdt() {
		return BranchNameEdt;
	}

	public WebElement getIfscCodeEdt() {
		return IfscCodeEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	
	
	
}
