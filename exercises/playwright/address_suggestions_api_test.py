from typing import Generator

import pytest
from playwright.sync_api import APIRequestContext, Playwright

base_url = "https://sandy.pandemonium.itqc.ru/"
suggestion_url = "ms1/suggest-address"
suggestion_input = "Влади"
suggestions_key = "suggestions"


@pytest.fixture(scope="session")
def api_request_context(
    playwright: Playwright,
) -> Generator[APIRequestContext, None, None]:
    request_context = playwright.request.new_context(base_url=base_url)
    yield request_context
    request_context.dispose()


def test_relevance_of_address_suggestions(
    api_request_context: APIRequestContext,
) -> None:
    response = api_request_context.get(
        suggestion_url,
        params={"address": suggestion_input},
    )
    assert response.ok
    assert (suggestions := response.json().get(suggestions_key))
    assert any(f"г {suggestion_input}мир" in suggestion for suggestion in suggestions)
    assert any(f"{suggestion_input}кавказ" in suggestion for suggestion in suggestions)
