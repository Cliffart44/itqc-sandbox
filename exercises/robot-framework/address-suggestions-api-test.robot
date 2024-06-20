*** Settings ***
Documentation       API autotest example for ITQC sandbox.

Library             Collections
Library             JSONLibrary
Library             RequestsLibrary

Suite Setup         Create Session    alias=test_session    url=${BASE_URL}    verify=${True}
Suite Teardown      Delete All Sessions


*** Variables ***
${BASE_URL}                 https://sandy.pandemonium.itqc.ru
${SUGGESTION_URL}           /ms1/suggest-address
${SUGGESTION_INPUT}         Влади
${SUGGESTIONS_JSON_PATH}    $..suggestions


*** Test Cases ***
Check Relevance Of Address Suggestions
    [Documentation]    Basic checks for Dadata service.

    ${suggestions}    Get List Of Suggestions    test_session
    Should Contain Match    ${suggestions}    *${SUGGESTION_INPUT}мир
    Should Contain Match    ${suggestions}    *${SUGGESTION_INPUT}кавказ


*** Keywords ***
Get List Of Suggestions
    [Documentation]    Auxiliary steps for receiving suggestions.
    [Arguments]    ${alias}

    ${response}    GET On Session    ${alias}    ${SUGGESTION_URL}    params=address=${SUGGESTION_INPUT}
    @{suggestions}    Get Value From Json    ${response.json()}    ${SUGGESTIONS_JSON_PATH}    fail_on_empty=${True}
    RETURN    ${suggestions}[0]
