  package openweathermap.pages;
  
  import auto.utility.Services;
  import org.openqa.selenium.WebDriver;
  
  public class WeatherSearchPage extends Services {
  
    private String xpathResult = "//div[@id='forecast_list_ul']";
  
    public WeatherSearchPage(WebDriver driver) {
      super(driver);
    }
  
    public void verifySearchResult(String expected) {
      waitForElement(xpathResult);
      assertElementPresentByXpath("//*[contains(text(),'" + expected + "')]");
    }
  
  }
