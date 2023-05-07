package pages.apkScreens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;

public class PreferenceScreen {
    public PreferenceScreen()  {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver(), Duration.ofSeconds(15)), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='8. Headers']")
    public MobileElement headers;

    @AndroidFindBy(xpath = "(//android.widget.Switch)[1]")
    public MobileElement switch1;

    @AndroidFindBy(xpath = "(//android.widget.Switch)[2]")
    public MobileElement switch2;

    @AndroidFindBy(id = "android:id/checkbox")
    public MobileElement checkbox;


}
