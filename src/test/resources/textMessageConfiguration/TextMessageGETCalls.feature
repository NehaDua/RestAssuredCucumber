Feature: TextMessage API Testing - GET
@test
  Scenario: Get_Access_TOKEN
  
    Given Create Access_Token_Request with header and parameters using BaseURl("https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV/oauth2") 
     When POST method is sent with "token"
    Then it should provide status code "200"
    And  "token_type" should be "Bearer"
  
@test
 Scenario: Get_Session_Token
  
   Given Create Session_Token_Request with access Token in header and parameters "https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV"
    When POST method is sent with "api/startSession"
    Then  it should provide status code "200"
    And "error_code" should be "0"
    And "error_description" should be "OK"
     And "message" should be "Sucess"  
@test
  Scenario: Get_TextMessage_Status
  
   Given Create GetText_Request with access Token and session token in header and parameters"https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV/api"
    When GET method is sent with "textmessages"
    Then  it should provide status code "200"
    And "count" should be greater than or equal to Integer "0"