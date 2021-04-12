Feature: TextMessage API Testing - POST
@test
  Scenario: Get_Access_TOKEN
  
     Given Create Access_Token_Request with header and parameters using BaseURl("https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV/oauth2") 
     When POST method is sent with "token"
    Then it should provide status code "200"
     And "token_type" should be "Bearer"
    
 @test
 Scenario: Get_Session_Token
  
   Given Create Session_Token_Request with access Token in header and parameters "https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV"
    When POST method is sent with "api/startSession"
    Then  it should provide status code "200"
    And "error_code" should be "0"
    And "error_description" should be "OK"
     And "message" should be "Sucess"  

 @test 
    Scenario: Service_Send_TextMessage_With_TH_(1-1)
  
   Given Create SendRequest with access Token in header and json file in body "textJson/InputBody_PostTextMessage(1-1).json"
   When POST method is sent with "textmessages"
   Then it should provide status code "200"
    And "description" should be "Messages have been processed successfully."
    And "failedCount" should be equal to Integer "0"

@test 
    Scenario: Service_Send_TextMessage_With_TH_(1-N)
  
   Given Create SendRequest with access Token in header and json file in body "textJson/InputBody_PostTextMessage(1-N).json"
   When POST method is sent with "textmessages"
   Then it should provide status code "200"
    And "description" should be "Messages have been processed successfully."
    And "failedCount" should be equal to Integer "0"
 
 @test 
    Scenario: Service_Send_TextMessage_Without_TH_(1-1)
  
   Given Create SendRequest with access Token in header and json file in body "textJson/InputBody_PostTextMessage_WithoutTH(1-1).json"
   When POST method is sent with "textmessages"
   Then it should provide status code "200"
    And "description" should be "Messages have been processed successfully."
    And "failedCount" should be equal to Integer "0"
 
 @test 
    Scenario: Service_Send_TextMessage_Without_TH_(1-N)
  
   Given Create SendRequest with access Token in header and json file in body "textJson/InputBody_PostTextMessage_WithoutTH(1-N).json"
   When POST method is sent with "textmessages"
   Then it should provide status code "200"
    And "description" should be "Messages have been processed successfully."
    And "failedCount" should be equal to Integer "0"
    
 @test 
    Scenario: Service_Send_TextMessage_With_TH_With_No_ConfigurationId
  
   Given Create SendRequest with access Token in header and json file in body "textJson/InputBody_PostTextMessageWithNoConfigurationId.json"
   When POST method is sent with "textmessages"
   Then it should provide status code "400"
 
 @test
  Scenario: Get_Access_TOKEN
  
     Given Create Access_Token_Request with header and parameters using BaseURl("https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV/oauth2") 
     When POST method is sent with "token"
    Then it should provide status code "200"
     And "token_type" should be "Bearer"
    
 @test
 Scenario: Get_Session_Token
  
   Given Create Session_Token_Request with access Token in header and parameters "https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV"
    When POST method is sent with "api/startSession"
    Then  it should provide status code "200"
    And "error_code" should be "0"
    And "error_description" should be "OK"
     And "message" should be "Sucess"
     
 @test 
    Scenario: Service_Send_TextMessage_With_TH_With_No_CompositionCd
  
   Given Create SendRequest with access Token in header and json file in body "textJson/InputBody_PostTextMessageWithNoCompositionCd.json"
   When POST method is sent with "textmessages"
   Then it should provide status code "400"

 @test
  Scenario: Get_Access_TOKEN
  
     Given Create Access_Token_Request with header and parameters using BaseURl("https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV/oauth2") 
     When POST method is sent with "token"
    Then it should provide status code "200"
     And "token_type" should be "Bearer"
    
 @test
 Scenario: Get_Session_Token
  
   Given Create Session_Token_Request with access Token in header and parameters "https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV"
    When POST method is sent with "api/startSession"
    Then  it should provide status code "200"
    And "error_code" should be "0"
    And "error_description" should be "OK"
     And "message" should be "Sucess"
        
 @test
  Scenario: Service_Send_TextMessage_With_No_IdMapping

   Given Create SendRequest with access Token in header and json file in body "textJson/InputBody_PostTextMessageWithNoIdMapping.json"
   When POST method is sent with "textmessages"
   Then it should provide status code "400"
 
  @test
  Scenario: Get_Access_TOKEN
  
     Given Create Access_Token_Request with header and parameters using BaseURl("https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV/oauth2") 
     When POST method is sent with "token"
    Then it should provide status code "200"
     And "token_type" should be "Bearer"
    
 @test
 Scenario: Get_Session_Token
  
   Given Create Session_Token_Request with access Token in header and parameters "https://bitlb02.asvc.hewitt.com/AHServiceGatewayDV"
    When POST method is sent with "api/startSession"
    Then  it should provide status code "200"
    And "error_code" should be "0"
    And "error_description" should be "OK"
     And "message" should be "Sucess"
        
 @test
  Scenario: Service_Send_TextMessage_With_Invalid_Deliverables

   Given Create SendRequest with access Token in header and json file in body "textJson/InputBody_PostTextMessageWithInvalidDeliverable.json"
   When POST method is sent with "textmessages"
   Then it should provide status code "400"