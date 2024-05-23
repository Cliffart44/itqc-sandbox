import pytest
from selenium.common.exceptions import TimeoutException
from selenium.webdriver import Firefox
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as ec
from selenium.webdriver.support.wait import WebDriverWait

sut_url = "https://sandy.pandemonium.itqc.ru/"

address_query_field_locator = "address-query"
address_suggestions_locator = ".address-suggestions"
parcel_name_field_locator = "prodname"
submit_order_button_locator = "btn-request"
suggestion_input = "Влади"


class TestClass:
    """UI autotest example for ITQC sandbox."""

    @pytest.fixture
    def driver(self):
        """Firefox driver handling."""
        driver = Firefox()
        yield driver
        driver.quit()

    def test_relevance_of_address_suggestions(self, driver):
        """Basic checks for Dadata service."""
        wait = WebDriverWait(driver, timeout=5)
        driver.get(sut_url)
        wait.until(ec.presence_of_element_located((By.NAME, parcel_name_field_locator)))
        driver.find_element(By.NAME, parcel_name_field_locator).send_keys(
            suggestion_input
        )
        driver.find_element(By.CLASS_NAME, submit_order_button_locator).click()
        wait.until(ec.presence_of_element_located((By.ID, address_query_field_locator)))
        driver.find_element(By.ID, address_query_field_locator).send_keys(
            suggestion_input
        )
        try:
            wait.until(
                ec.visibility_of_element_located(
                    (By.CSS_SELECTOR, address_suggestions_locator)
                )
            )
        except TimeoutException:
            driver.find_element(value=address_query_field_locator).clear()
            driver.find_element(value=address_query_field_locator).send_keys(
                suggestion_input
            )
            wait.until(
                ec.visibility_of_element_located(
                    (By.CSS_SELECTOR, address_suggestions_locator)
                )
            )
        assert wait.until(
            lambda _: driver.find_element(
                By.XPATH, f"//*[contains(text(), '{suggestion_input}мир')]"
            ).is_displayed()
        )
        assert wait.until(
            lambda _: driver.find_element(
                By.XPATH, f"//*[contains(text(), '{suggestion_input}кавказ')]"
            ).is_displayed()
        )
