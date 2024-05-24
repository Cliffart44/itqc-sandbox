package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.anyMatch;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OrderPage {
    private static final SelenideElement mainHeader = $(".request-id");
    private static final SelenideElement barcodeHeader = $("[for='barcode']");
    private static final SelenideElement addressHeader = $("[for='address-query']");
    private static final SelenideElement expectedDateHeader = $("[for='expected-delivery-date']");
    private static final SelenideElement barcodeInputField = $("#barcode");
    private static final SelenideElement addressInputField = $("#address-query");
    private static final SelenideElement expectedDateInputField = $("#expected-delivery-date");
    private static final SelenideElement addressSuggestionsBlock = $(".address-suggestions");
    private static final ElementsCollection addressSuggestions = $$(".suggestion-item");

    public OrderPage() {
        mainHeader.shouldBe(visible).shouldHave(ownText("Заполнение данных #"));
        barcodeHeader.shouldBe(visible);
        addressHeader.shouldBe(visible);
        addressInputField.shouldBe(visible);
        expectedDateHeader.shouldBe(visible);
    }

    public void checkAddressSuggestions() {
        addressInputField.setValue(DataHelper.getSuggestionInput());
        if (!addressSuggestionsBlock.is(visible, Duration.ofSeconds(4))) {
            addressInputField.clear();
            addressInputField.setValue(DataHelper.getSuggestionInput());
        }
        addressSuggestionsBlock.shouldBe(visible);
        addressSuggestions.shouldHave(
                anyMatch("'Владимир' suggestion checking", DataHelper.getFirstSuggestionPredicate()));
        addressSuggestions.shouldHave(
                anyMatch("'Владикавказ' suggestion checking", DataHelper.getSecondSuggestionPredicate()));
    }
}
