from http import HTTPStatus

from make_requests import make_get_request

suggestion_url = "ms1/suggest-address"
suggestion_input = "Влади"
suggestions_key = "suggestions"


class TestClass:
    """API autotest example for ITQC sandbox."""

    def test_relevance_of_address_suggestions(self):
        """Basic checks for Dadata service."""
        response = make_get_request(suggestion_url, f"address={suggestion_input}")
        assert response.status_code == HTTPStatus.OK
        assert (suggestions := response.json().get(suggestions_key))
        assert any(f"{suggestion_input}мир" in suggestion for suggestion in suggestions)
        assert any(
            f"{suggestion_input}кавказ" in suggestion for suggestion in suggestions
        )
