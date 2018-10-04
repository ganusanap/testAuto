package openweathermap.testcases;
/**
 * Created by: Ganesh Sanap Date: 30-Sep-18
 */

import auto.utility.Init;
import openweathermap.pages.WelcomePage;
import org.testng.annotations.Test;

public class TestWelcomePage extends Init {

  @Test(enabled = true, groups = {"Smoke Test"})
  public void testWelcomePage() {
    System.out.println("Test - Welcome Page");
    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle();
  }

  @Test(enabled = true, groups = {"Functional", "Regression"})
  public void testWelcomePageNavItems() {
    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyNavItems();
    welcomePage.verifyMiniNavItems();
  }

  @Test(enabled = true, groups = {"Functional", "Regression"})
  public void testWelcomeSearchOptions() {
    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifySearchOptions();
  }
}
