import re

from playwright.sync_api import Page, expect

sut_url = "https://sandy.pandemonium.itqc.ru/"

main_page_title = "Pandemonium Demo"
order_page_title = "Редактировать заказ"
address_query_field_placeholder = "Поиск адреса"
address_query_field_locator = "#address-query"
address_suggestions_locator = ".address-suggestions"
suggestion_item_locator = ".suggestion-item"
suggestion_input = "Влади"


def test_computer_tables(page: Page):
    page.goto(sut_url)
    expect(page).to_have_title(re.compile(main_page_title))
    page.get_by_role("textbox").type(suggestion_input)
    page.get_by_role("button").click()
    expect(page).to_have_title(order_page_title)
    page.get_by_placeholder(address_query_field_placeholder).type(suggestion_input)
    try:
        expect(page.locator(address_suggestions_locator)).to_be_visible()
    except AssertionError:
        page.locator(address_query_field_locator).clear()
        page.locator(address_query_field_locator).type(suggestion_input)
        expect(page.locator(address_suggestions_locator)).to_be_visible()
    expect(
        page.locator(suggestion_item_locator).get_by_text(f"г {suggestion_input}мир")
    ).to_be_visible()
    expect(
        page.locator(suggestion_item_locator).get_by_text(f"{suggestion_input}кавказ")
    ).to_be_visible()
