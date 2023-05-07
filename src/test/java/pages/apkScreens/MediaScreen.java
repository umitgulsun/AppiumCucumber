package pages.apkScreens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class MediaScreen {
    public MediaScreen()  {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver(), Duration.ofSeconds(15)), this);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Play Video from Local File']")
    public MobileElement MesajLink;

    @AndroidFindBy(id = "io.appium.android.apis:id/surface")
    public List<MobileElement> sayfa;



}
