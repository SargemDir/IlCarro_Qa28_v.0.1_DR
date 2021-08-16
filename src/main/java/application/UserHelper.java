package application;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[.=' Log in ']"));
    }
    public void fillLoginForm(String email, String password){
        type(By.id("email"),email);
        type(By.id("password"),password);
    }
    public void fillLoginForm(User user){
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }
    public void submitForm(){
        click(By.xpath("//*[@type='submit']"));
    }

    public void clickOkButton() {
        click(By.xpath("//button[.='Ok']"));
    }

    public boolean isLogged() {
        return wd.findElements(By.xpath("//a[.=' Log in ']")).size()>0;
    }

    public void logout() {
        click(By.xpath("//a[.=' Logout ']"));
    }

    public void openRegistrationForm() {
        click(By.xpath("//a[.=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void checkPolicy() {
//        click(By.xpath("//*[@for='terms-of-use']/.."));
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click();");
    }

    public void waitUntilClickable(By locator) {
        new WebDriverWait(wd, 40).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void deleteAccount() {
        waitUntilClickable(By.xpath("//*[.='Delete account']"));
        click(By.xpath("//*[.='Delete account']"));
        waitUntilClickable(By.xpath("//button[.='Delete']"));
        click(By.xpath("//button[.='Delete']"));
    }
}
