package pages.apkScreens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;

public class DragDropScreen {
    public DragDropScreen()  {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver(), Duration.ofSeconds(15)), this);
    }

    @AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_1")
    public MobileElement ball_1;
    @AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_3")
    public MobileElement ball_3;


}
