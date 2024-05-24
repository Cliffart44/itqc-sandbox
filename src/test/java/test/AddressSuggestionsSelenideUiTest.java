package test;

import data.DataHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import page.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.closeWindow;

public class AddressSuggestionsSelenideUiTest {

    @BeforeEach
    void setUp() {
        open(DataHelper.getBaseUrl());
    }

    @AfterEach
    void tearDown() {
        closeWindow();
    }

    @Test
    void shouldReceiveAddressSuggestions() {
        new
                MainPage().
                placeOrder().
                checkAddressSuggestions();
    }
}
