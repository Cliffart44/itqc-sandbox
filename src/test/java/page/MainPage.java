package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

import data.DataHelper;

public class MainPage {
    private static final SelenideElement mainHeader = $("h1");
    private static final SelenideElement itemName = $(".item-name");
    private static final SelenideElement inputField = $(".product-name");
    private static final SelenideElement placeOrderButton = $(".btn-request");

    public MainPage() {
        mainHeader.shouldBe(visible).shouldHave(exactOwnText("Создание заявки"));
        itemName.shouldBe(visible).shouldHave(exactOwnText("Введите название посылки"));
        inputField.shouldBe(visible);
        placeOrderButton.shouldBe(visible).shouldBe(clickable).shouldHave(exactOwnText("Оформить заказ"));
    }

    public OrderPage placeOrder() {
        inputField.setValue(DataHelper.getParcelName());
        placeOrderButton.click();
        return new OrderPage();
    }
}
