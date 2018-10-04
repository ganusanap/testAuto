  package openweathermap.testcases;
  
  import auto.utility.Init;
import openweathermap.pages.WeatherSearchPage;
import openweathermap.pages.WelcomePage;
import org.testng.annotations.Test;
  
  public class TestWeatherSearch extends Init {
  
    @Test(enabled = true, groups = {"Functional"})
    public void testInvalidCityResult() {
      WelcomePage welcomePage = new WelcomePage(driver);
      welcomePage.enterCityName("XYZ").clickSearch();
  
      WeatherSearchPage searchResult = new WeatherSearchPage(driver);
    searchResult.verifySearchResult("Not found");
  }
  
    @Test(enabled = true, groups = {"Functional", "Regression"})
    public void testValidCityResult() {
      WelcomePage welcomePage = new WelcomePage(driver);
      welcomePage.enterCityName("Seattle").clickSearch();
  
      WeatherSearchPage searchResult = new WeatherSearchPage(driver);
      searchResult.verifySearchResult("Seattle");
    }
  
  }
