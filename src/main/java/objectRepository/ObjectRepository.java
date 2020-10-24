package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjectRepository {

		WebDriver driver;
		
		@FindBy(xpath = "//Input[@title='Search']")
		public WebElement searchInputBox;
		
		@FindBy(xpath = "(//Input[@name='btnK'])[2]")
		public WebElement googleSearchButton;
		
		@FindBy(xpath = "//img[@alt='Google']")
		public WebElement googleImg;
		
		@FindBy(xpath = "//h3/span")
		public WebElement firstLink;
		
		@FindBy(xpath = "//*[@id='header-search-input']")
		public WebElement yahooSearchInputBox;
		
		public ObjectRepository(WebDriver driver) {
			// TODO Auto-generated constructor stub
			//this.driver=driver;
			PageFactory.initElements(driver, this);
		}
}
