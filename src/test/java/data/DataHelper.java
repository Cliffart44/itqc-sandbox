package data;

import java.util.function.Predicate;

import org.openqa.selenium.WebElement;

public class DataHelper {
    private DataHelper() {
    }

    private static final String baseUrl = "https://sandy.pandemonium.itqc.ru/";

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getParcelName() {
        return "Тест";
    }

    public static String getSuggestionInput() {
        return "Влади";
    }

    public static String getFirstSuggestion() {
        return getSuggestionInput() + "мир";
    }

    public static String getSecondSuggestion() {
        return getSuggestionInput() + "кавказ";
    }

    public static Predicate<WebElement> getFirstSuggestionPredicate() {
        return e -> e.getText().contains(getFirstSuggestion());
    }

    public static Predicate<WebElement> getSecondSuggestionPredicate() {
        return e -> e.getText().contains(getSecondSuggestion());
    }
}
