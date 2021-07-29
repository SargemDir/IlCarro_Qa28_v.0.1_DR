package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper userHelper;
    CarHelper carHelper;
    SearchHelper search;

public void init(){
    wd= new ChromeDriver();
    wd.manage().window().maximize();
    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wd.navigate().to("https://ilcarro.xyz/search");
    userHelper = new UserHelper(wd);
    carHelper= new CarHelper(wd);
    search = new SearchHelper(wd);

}

public void stop(){
    wd.quit();
}

  public UserHelper userHelper() {
       return userHelper;
   }

    public CarHelper carHelper() {
        return carHelper;
    }

    public SearchHelper search() {
        return search;
    }
}
