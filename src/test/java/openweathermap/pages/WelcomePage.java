  package openweathermap.pages;
  
  import org.openqa.selenium.By;
  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.WebElement;
  import auto.utility.Services;
  import static org.testng.Assert.assertEquals;
  
  public class WelcomePage extends Services {
  
    final static String TITLE = "Сurrent weather and forecast - OpenWeatherMap";
    final static String MESSAGE = "We Deliver 2 Billion Forecasts Per Day";
    WebDriver driver;
    private String xpathMsg = "//*[@id='main-slideshow']//h2";
    private String xpathLink = "//ul/li/a[text()='**link**']";
    private String xpathCityName = "//input[@id='q' and @placeholder='Your city name']";
    private String xpathSearch = "//form[@id='searchform']/button[@type='submit']";
    private String xpathNavItems = "//li[starts-with(@class, 'nav__item')]";
    private String[] navMenus = {"Weather", "Maps", "API", "Price", "Partners", "Stations", "Widgets", "Blog"};
    private String xpathNavSearch = "//a[@id='nav-search']";
    private String xpathNavSignIn = "//a[@href = '//home.openweathermap.org/users/sign_in' and @class = 'pull-right']";
    private String xpathNavSignUp = "//a[@href = '//home.openweathermap.org/users/sign_up' and @class = 'pull-right']";
  
  
    public WelcomePage(WebDriver driver) {
      super(driver);
      this.driver = driver;
    }
  
    public WelcomePage verifyWelcomePageTitle() {
      String actualTitle = driver.getTitle().trim();
      assertEquals(actualTitle, TITLE,
          "Actual title - " + actualTitle + ", should be same as expected " + TITLE);
      return this;
    }
  
    public WelcomePage verifyWelcomePageMessage() {
      WebElement headerEle = driver.findElement(By.xpath(xpathMsg));
      String actualHeading = headerEle.getText();
      assertEquals(actualHeading, MESSAGE,
          "Actual heading '" + actualHeading + "' should be same as expected '" + MESSAGE + "'.");
      return this;
    }
  
    public WelcomePage enterCityName(String city) {
      waitForElement(xpathCityName);
      assertAndType(xpathCityName, city);
      return this;
    }
  
    public WelcomePage clickSearch() {
      assertAndClick(xpathSearch);
      return this;
    }
  
    public void verifyNavItems() {
      for (int i = 1; i <= driver.findElements(By.xpath(xpathNavItems)).size(); i++) {
        String actual = driver.findElement(By.xpath(xpathNavItems + "[" + i + "]/a")).getText();
        String expected = navMenus[i - 1];
        assertEquals(actual, expected,
            "Actual Menu '" + actual + "' should be same as expected '" + expected + "'.");
      }
    }
  
    public void verifyMiniNavItems() {
      assertElementVisible(xpathNavSearch, true);
      assertElementVisible(xpathNavSignIn, true);
      assertElementVisible(xpathNavSignUp, true);
    }
  
    public void verifySearchOptions() {
      assertElementPresentByXpath(xpathCityName);
      assertElementPresentByXpath(xpathSearch);
    }
  
    public void clickOnLinkViaLinkText(String link) {
      driver.findElement(By.linkText(link)).click();
    }
  
    public void clickOnLinkViaPartialText(String link) {
      driver.findElement(By.partialLinkText(link)).click();
    }
  
    public Object clickOnLink(String link) {
      xpathLink = xpathLink.replace("**link**", link);
      driver.findElement(By.xpath(xpathLink)).click();
      return this;
    }
  }
