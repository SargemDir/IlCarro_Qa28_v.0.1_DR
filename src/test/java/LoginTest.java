import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

@BeforeMethod
public void precondition(){
    if(app.userHelper().isLogged()){
        app.userHelper().logout();
    }
}
    @Test
    public void loginTestPositive(){

        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("noa@gmail.com","Nnoa12345$");
        app.userHelper().submitForm();
        app.userHelper().pause(3000);
        String loginS=app.userHelper().getText(By.xpath("//div[@class='dialog-container']//h2"));
        app.userHelper().clickOkButton();
        Assert.assertEquals(loginS,"Logged in success");

    }




    @Test
    public void loginTestPositiveDto(){
        User user=new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");

        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().submitForm();
        app.userHelper().pause(3000);
        String loginS=app.userHelper().getText(By.xpath("//div[@class='dialog-container']//h2"));
        app.userHelper().clickOkButton();
        Assert.assertEquals(loginS,"Logged in success");

    }


}
