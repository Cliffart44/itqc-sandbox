package test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.RequestOptions;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AddressSuggestionsPlaywrightApiTest {
    private static final String base_url = "https://sandy.pandemonium.itqc.ru/";
    private static final String suggestion_url = "ms1/suggest-address";
    private static final String suggestion_input = "Влади";
    private static final String suggestions_key = "suggestions";

    private Playwright playwright;
    private APIRequestContext request;

    @BeforeAll
    void beforeAll() {
        playwright = Playwright.create();
        request = playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL(base_url)
        );
    }

    @AfterAll
    void afterAll() {
        if (request != null) {
            request.dispose();
            request = null;
        }
        if (playwright != null) {
            playwright.close();
            playwright = null;
        }
    }

    @Test
    void shouldCheckRelevanceOfAddressSuggestions() {
        APIResponse suggestionsResponse = request.get(
                suggestion_url,
                RequestOptions.create().setQueryParam("address", suggestion_input)
        );
        assertTrue(suggestionsResponse.ok());
        JsonObject suggestionsJson = new Gson().fromJson(suggestionsResponse.text(), JsonObject.class);
        assertTrue(suggestionsJson.has(suggestions_key));
        String suggestionsStr = suggestionsJson.get(suggestions_key).toString();
        assertTrue(suggestionsStr.contains("г " + suggestion_input + "мир"));
        assertTrue(suggestionsStr.contains(suggestion_input + "кавказ"));
    }
}
