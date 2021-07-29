import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{
    @AfterMethod
    public void back(){
        app.search().click(By.xpath("//a[@href='/']"));
    }

    @Test
    public void positiveTestSendKey(){
        //with concatenate string
        app.search().typeSearchCurrentMonth("Haifa","07/29/2021","07/30/2021");
        app.userHelper().submitForm();
        app.carHelper().pause(2000);
        Assert.assertTrue(app.search().isListOfCarAppeared());
    }
    @Test
    public void negativeTestSendKey(){
        //with concatenate string
        app.search().typeSearchCurrentMonth("Haifa","06/26/2021","06/30/2021");

        app.carHelper().pause(2000);
        Assert.assertTrue(app.search().isDataInPath());
        Assert.assertTrue(app.search().buttonYallaInactive());
    }

    @Test
    public void selectPeriodCurrentMouth(){
        app.search().fillSearchFormCurrentMonth("Haifa","07/29/2021","07/30/2021");
        app.userHelper().submitForm();
        app.carHelper().pause(2000);
        Assert.assertTrue(app.search().isListOfCarAppeared());


    }

    @Test
    public void selectPeriodInFuture(){
        app.search().fillSearchFormInFuture("Haifa","07/29/2021","07/30/2021");
        app.userHelper().submitForm();
        app.carHelper().pause(3000);
        Assert.assertTrue(app.search().isListOfCarAppeared());
    }
}
