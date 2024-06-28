package mospolytech;

import mospolytech.base.ScheduleWrapper;
import org.junit.Ignore;
import org.junit.Test;

public class MospolytechTest extends ScheduleWrapper {

    @Test
    public void mospolytechTest() {
        pageManager.getMainMospolytechPage()
                .checkTitle("Московский Политех")
                .clickLeftMenuButton("Расписание")
                .checkTitle("Расписания")
                .clickOpenSiteButton()
                .checkTitle()
                .insertGroupID("234")
                .selectGroup("234-221") // Единственное рабочее расписание
                .checkGroupSelected()
                .checkDayColored();
    }
}
