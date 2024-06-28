package lambda.base;

import com.nemopss.managers.DriverManager;
import com.nemopss.managers.InitManager;
import com.nemopss.managers.PageManager;
import com.nemopss.managers.TestPropertiesManager;
import com.nemopss.utils.Constants;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class LambdaWrapper {
    private final DriverManager driverManager = DriverManager.getInstance();
    private final TestPropertiesManager propManager = TestPropertiesManager.getInstance();
    protected PageManager pageManager = PageManager.getInstance();

    @BeforeClass
    public static void beforeClass() {
        InitManager.initFramework();
    }

    @Before
    public void before() {
        System.out.println("--------------------------");
        System.out.println("TESTING LambdaSampleApp...");
        System.out.println("--------------------------");
        driverManager.getDriver().get(propManager.getProperty(Constants.LAMBDA_URL));
    }

    @AfterClass
    public static void after() {
        System.out.println("--------------------------");
        System.out.println("END TESTING LambdaSampleApp...");
        System.out.println("--------------------------");
        InitManager.quitFramework();
    }
}
