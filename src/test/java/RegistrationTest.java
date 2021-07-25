import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{
    @BeforeMethod
    public void precondition(){
        if(!app.userHelper().isLogged()){
            app.userHelper().logout();
        }
    }

    @Test
    public void registrationTest(){
        int i =(int) ((System.currentTimeMillis()/1000)%3600);
        User user = new User()
                .withName("Kolya")
                .withLastName("Nikolaev")
                .withEmail("kolya"+i+"@gmail.com")
                .withPassword("Qq12345$");

app.userHelper().openRegistrationForm();
app.userHelper().fillRegistrationForm(user);
app.userHelper().checkPolicy();
app.userHelper().submitForm();
app.userHelper().pause(5000);
        String regS=app.userHelper().getText(By.xpath("//div[@class='dialog-container']//h2"));
        Assert.assertTrue(regS.contains("success"));



    }
}
