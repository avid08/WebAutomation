
package test.java.com.pack.base;




import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;


public class TestBaseSetup {

      private WebDriver driver;
      static String  driverPath = "C:\\Users\\aislam\\Desktop\\AutomatoinWorkSpace\\WebAutomation\\chromedriver.exe";




      public WebDriver getDriver() {

            return driver;
      }

       private void setDriver(String browserType,String appURL){

            switch (browserType){
                  case "chrome":
                        driver = initChromeDriver(appURL);
                        break;

                 /* case "Iexplorer":

                        driver = initInternetExplorerDriver (appURL);
*/
                  default:
                        System.out.println("browser : " + browserType
                                + " found chrome browser");
                        driver = initChromeDriver(appURL);
            }

            }

      private WebDriver initInternetExplorerDriver(String appURL) {

            System.out.println("Launching Firefox browser..");
            WebDriver driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
            driver.navigate().to(appURL);

            return driver;


      }

      private WebDriver initChromeDriver(String appURL) {


            System.out.println("Launching google chrome with new profile..");
            System.setProperty("webdriver.chrome.driver", driverPath );
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.navigate().to(appURL);

            return driver;
      }

      @Parameters({ "browserType", "appURL" })
      @BeforeClass
      public void initializeTestBaseSetup(String browserType, String appURL) {
            try {
                  setDriver(browserType, appURL);

            } catch (Exception e) {
                  System.out.println("Error....." + e.getStackTrace());
            }
      }

     /* @AfterClass()
      public void tearDown() {
            driver.quit();
      }*/

}

