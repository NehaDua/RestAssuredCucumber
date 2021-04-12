Feature: CreateAndDeliver API Testing - POST

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
  Scenario: Service_Send_Email with TH (1-1)
  
   Given Create SendRequest with json file in body "CnDJson/CnD_RealMode_JSON.json"
   When POST method is sent with "createandeliverdocuments"
   Then it should provide status code "200"
    And "description" should be "Message has been processed successfully .."
    And "failedCount" should be equal to Integer 0
    And "jobValid" should be "true"

 @test 
    Scenario: Service_Send_Json_With_Invalid_KitIdMapping
  
   Given Create SendRequest with invalid json file with KitID null in body "CnDJson/CnD_Invalid_KitId_JSON.json"
   When POST method is sent with "createandeliverdocuments"
   Then it should provide status code "400"
    And "description" should be "Messages have not been processed."
    And "failedCount" should be equal to Integer 1
    And "jobValid" should be "false"
   
   
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
   Scenario: Service_Send_Json_With_Invalid_DataMapping
  
   Given Create SendRequest with invalid json data in body "CnDJson/CnD_Invalid_data_JSON.json"
   When POST method is sent with "createandeliverdocuments"
   Then it should provide statusCode "400"
    And "description" should be "Messages have not been processed."
    And "failedCount" should be equal to Integer 1
   
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
    Scenario: Service_Send_BatchMode_With_JsonData
  
   Given Create SendRequest with batchMode json data in body "CnDJson/CnD_BatchMode_JSON.json"
   When POST method is sent with "createandeliverdocuments"
   Then it should provide statusCode "200"
    And "description" should be "Message posted Successfully on BSP Queue"
    And "failedCount" should be equal to Integer 0
    And "jobValid" should be "true"
    
    @test 
    Scenario: Service_Send_BatchMode_Without_JobId
  
   Given Create SendRequest with batchMode without JobId in body "CnDJson/CnD_BatchMode_Without_JobId_JSON.json"
   When POST method is sent with "createandeliverdocuments"
   Then it should provide statusCode "200"
    And "description" should be "Required manadatory field Job Id is missing"
    And "failedCount" should be equal to Integer 0
    And "jobValid" should be "true"
   
      @test 
    Scenario: Service_Send_BatchMode_With_wrong_batchId
  
   Given Create SendRequest with batchMode with wrong BatchId in body "CnDJson/CnD_BatchMode_Failed_Batch_JSON.json"
   When POST method is sent with "createandeliverdocuments"
   Then it should provide statusCode "200"
    And "description" should be "Batch is not complete, job can not be processed further. Please complete the batch to process the job"
    And "failedCount" should be equal to Integer 0
    And "jobValid" should be "true"
   