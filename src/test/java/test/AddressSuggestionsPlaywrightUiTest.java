package test;

import java.util.regex.Pattern;

import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@UsePlaywright
public class AddressSuggestionsPlaywrightUiTest {

    private static final String sut_url = "https://sandy.pandemonium.itqc.ru/";

    private static final Pattern main_page_title = Pattern.compile("Pandemonium Demo.+");
    private static final String order_page_title = "Редактировать заказ";
    private static final String address_query_field_placeholder = "Поиск адреса";
    private static final String address_query_field_locator = "#address-query";
    private static final String address_suggestions_locator = ".address-suggestions";
    private static final String parcel_name_field_locator = ".product-name";
    private static final String submit_order_button_locator = ".btn-request";
    private static final String suggestion_item_locator = ".suggestion-item";
    private static final String suggestion_input = "Влади";

    static Playwright playwright;
    static Browser browser;

    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(true));
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @Test
    void shouldReceiveAddressSuggestions() {
        page.navigate(sut_url);
        assertThat(page).hasURL(sut_url);
        assertThat(page).hasTitle(main_page_title);
        page.locator(parcel_name_field_locator).fill(suggestion_input);
        page.locator(submit_order_button_locator).click();
        assertThat(page).hasTitle(order_page_title);
        page.getByPlaceholder(address_query_field_placeholder).fill(suggestion_input);
        try {
            assertThat(page.locator(address_suggestions_locator)).isVisible();
        } catch (AssertionError e) {
            page.locator(address_query_field_locator).clear();
            page.locator(address_query_field_locator).fill(suggestion_input);
        }
        assertThat(page.locator(address_suggestions_locator)).isVisible();
        assertThat(
                page.locator(suggestion_item_locator).getByText(Pattern.compile(suggestion_input + "мир$"))
        ).isVisible();
        assertThat(
                page.locator(suggestion_item_locator).getByText(suggestion_input + "кавказ")
        ).isVisible();
    }
}