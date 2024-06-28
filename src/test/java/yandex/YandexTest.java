package yandex;

import yandex.base.YandexWrapper;

import org.junit.Test;
import org.junit.Ignore;

public class YandexTest extends YandexWrapper {

    @Test
    public void yandexTest() {
        pageManager.getMainYandexPage()
                .checkOpenPage()
                .clickOnCatalog()
                .moveToCategory("Все для гейминга")
                .moveToSubcategoryAndClickMenuItem("Xbox", "Игровые приставки")
                .logProducts()
                .rememberFirstProduct()
                .addToFavorites()
                .verifyAddToFavoritesSuccess()
                .goToFavorites()
                .verifyAddedProductInFavorites()
                .removeFromFavorites()
                .verifyRemovedFromFavorites()
                .verifyLoginMessage();
    }
}
