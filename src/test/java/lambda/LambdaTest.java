package lambda;

import lambda.base.BaseTests;
import org.junit.Ignore;
import org.junit.Test;

public class LambdaTest extends BaseTests {

    @Test
    public void lambdaTest() {
        pageManager.getMainLambdaPage()
                .checkTitle()
                .checkRemainingText(5, 5);
        for (int i = 1; i <= 5; i++) {
            pageManager.getMainLambdaPage()
                    .checkItem(i)
                    .clickItem(i);
        }
        pageManager.getMainLambdaPage()
                .createItem()
                .checkDisplayedItem(6)
                .checkItem(6)
                .clickItem(6);
    }
}
