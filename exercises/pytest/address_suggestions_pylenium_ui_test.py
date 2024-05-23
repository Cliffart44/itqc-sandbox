sut_url = "https://sandy.pandemonium.itqc.ru/"

address_query_field_locator = "#address-query"
address_suggestions_locator = ".address-suggestions"
parcel_name_field_locator = ".product-name"
submit_order_button_locator = ".btn-request"
suggestion_input = "Влади"


class TestClass:
    """UI autotest example for ITQC sandbox."""

    def test_relevance_of_address_suggestions(self, py):
        """Basic checks for Dadata service."""
        py.visit(sut_url)
        py.get(parcel_name_field_locator).type(suggestion_input)
        py.get(submit_order_button_locator).click()
        py.get(address_query_field_locator).type(suggestion_input)
        try:
            py.get(address_suggestions_locator).should().be_visible()
        except AssertionError:
            py.get(address_query_field_locator).clear().type(suggestion_input)
            py.get(address_suggestions_locator).should().be_visible()
        assert py.contains(f"{suggestion_input}мир")
        assert py.contains(f"{suggestion_input}кавказ")
