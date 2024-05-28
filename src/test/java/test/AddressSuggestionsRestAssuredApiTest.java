package test;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.Matchers.*;


public class AddressSuggestionsRestAssuredApiTest {
    private static final String base_url = "https://sandy.pandemonium.itqc.ru/";
    private static final String suggestion_url = "ms1/suggest-address";
    private static final String suggestion_input = "Влади";
    private static final String suggestions_key = "suggestions";


    @Test
    public void shouldCheckRelevanceOfAddressSuggestions() {
        given()
                .baseUri(base_url)
                .queryParam("address", suggestion_input)
                .when()
                .get(suggestion_url)
                .then()
                .statusCode(HTTP_OK)
                .contentType(ContentType.JSON)
                .body(suggestions_key, hasItem(containsString(suggestion_input + "мир")))
                .body(suggestions_key, hasItem(containsString(suggestion_input + "кавказ")))
        ;
    }
}