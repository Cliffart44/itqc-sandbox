*** Settings ***
Documentation    UI autotest example for ITQC sandbox
Library          SeleniumLibrary


*** Test Cases ***
Check Visibility And Relevance Of Address Suggestions
    [Documentation]    Basic checks for Dadata service.

    Open Browser                     https://sandy.pandemonium.itqc.ru
    Title Should Be                  Pandemonium Demo VTB
    Input Text                       prodname    Тест
    Click Button                     Оформить заказ
    Wait Until Element Is Visible    address-query
    Sleep                            2 s    Waiting for suggestions availability
    Input Text                       address-query    Влади
    Wait Until Element Is Visible    //ul[contains(@class, "address-suggestions")]
    Page Should Contain              Владимир
    Page Should Contain              Владикавказ
