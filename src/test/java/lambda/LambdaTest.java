package lambda;

import lambda.base.LambdaWrapper;
import org.junit.Ignore;
import org.junit.Test;

public class LambdaTest extends LambdaWrapper {

    @Ignore
    public void lambdaTest() {
        pageManager.getLambdaPage()
                .checkTitle()
                .checkRemainingCount(5, 5);
        for (int i = 1; i <= 5; i++) {
            pageManager.getLambdaPage()
                    .checkItemNotCrossed(i)
                    .clickItemCheckbox(i);
        }
        pageManager.getLambdaPage()
                .createItem()
                .checkItemVisibility(6)
                .checkItemNotCrossed(6)
                .clickItemCheckbox(6);
    }
}
