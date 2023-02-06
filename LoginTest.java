package newtest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import testbase.WebTestBase;

public class LoginTest extends WebTestBase {

    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;


    LoginTest(){
        super();
    }
    @BeforeMethod
public void beforemethod(){
        initialization();
        homePage = new HomePage(driver);
        loginPage= new LoginPage(driver);
        myAccountPage=new MyAccountPage(driver);
}

@Test
    public void verifyLoginWithValidData(){
    SoftAssert softAssert = new SoftAssert();
    homePage.advtsCloseBtnClick();
   // homePage.closePopupClick();
    homePage.closeStayUpdatedPopUpClick();
    homePage. loginClick();
    loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    softAssert.assertEquals(myAccountPage.getTextOfMyAccount(), "MY ACCOUNT","Text should be MY ACCOUNT");
    softAssert.assertAll();
    }

    @AfterMethod
    public void aftermethod(){
driver.close();
    }
    //sumit made changes
}
