Feature: Email API Testing - GET
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
  Scenario: Get_Email_Status
  
   Given Create GetEmail_Request with access Token and session token in header and parameters"https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV/api"
    When GET method is sent with "emails"
    Then  it should provide status code "200"
    And "count" should be greater than or equal to Integer "0"
@test
  Scenario: Get_Access_TOKEN
  
   Given Create Access_Token_Request with header and parameters using BaseURl("https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV/oauth2") 
     When POST method is sent with "token"
    Then it should provide status code "200"
    And  "token_type" should be "Bearer"
@test
  Scenario: Get_Invalid_Session_Token
  
   Given Create Invalid_Session_Token_Request with access Token in header and parameters "https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV"
    When POST method is sent with "api/startSession"
    Then  it should provide status code "200"
    And "error_code" should be "0"
    And "error_description" should be "OK"
     And "message" should be "Sucess"
@test
  Scenario: Get_Email_Status
  
   Given Create GetEmail_Request with access Token and session token in header and parameters"https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV/api"
    When GET method is sent with "emails"
    Then  it should provide status code "400"
@test
  Scenario: Get_Access_TOKEN
  
   Given Create Access_Token_Request with header and parameters using BaseURl("https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV/oauth2") 
     When POST method is sent with "token"
    Then it should provide status code "200"
    And  "token_type" should be "Bearer"
@test
  Scenario: Get_Invalid_Session_Token_With_No_SubjectId_SubjectType
  
   Given Create Invalid_Session_Token_Request with no subjectId and subjectType "https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV"
    When POST method is sent with "api/startSession"
    Then  it should provide status code "200"
    And "error_code" should be "0"
    And "error_description" should be "OK"
     And "message" should be "Sucess"
@test
  Scenario: Get_Email_Status
  
   Given Create GetEmail_Request with access Token and session token in header and parameters and no srcSystemName"https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV/api"
    When GET method is sent with "emails"
    Then  it should provide status code "400"