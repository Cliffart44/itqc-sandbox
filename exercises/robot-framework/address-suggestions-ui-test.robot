*** Settings ***
Documentation       UI autotest example for ITQC sandbox.

Library             SeleniumLibrary

Suite Setup         Open Browser    ${SUT_URL}
Suite Teardown      Close All Browsers
Test Setup          Open Target Page


*** Variables ***
${SUT_URL}                      https://sandy.pandemonium.itqc.ru
${SUGGESTION_INPUT}             Влади
${SUGGESTION_INPUT_LOCATOR}     address-query
${SUGGESTIONS_LOCATOR}          //ul[contains(@class, "address-suggestions")]


*** Test Cases ***
Check Visibility And Relevance Of Address Suggestions
    [Documentation]    Basic checks for Dadata service.

    Wait Until Keyword Succeeds    4x    0    Get Address Suggestions
    Page Should Contain    ${SUGGESTION_INPUT}мир
    Page Should Contain    ${SUGGESTION_INPUT}кавказ


*** Keywords ***
Open Target Page
    [Documentation]    Preparing web-page for receiving suggestions.

    Input Text    locator=prodname    text=Тест
    Click Button    Оформить заказ
    Wait Until Element Is Visible    ${SUGGESTION_INPUT_LOCATOR}
    Title Should Be    Редактировать заказ

Get Address Suggestions
    [Documentation]    Input text for receiving suggestions.

    Input Text    ${SUGGESTION_INPUT_LOCATOR}    ${SUGGESTION_INPUT}
    Wait Until Element Is Visible    ${SUGGESTIONS_LOCATOR}
