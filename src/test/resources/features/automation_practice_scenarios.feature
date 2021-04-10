Feature: Automate Practice scenarios
  
  Scenario: Order T-Shirt
    Given User launches the Application
    And do the SignIn
    When user adds tShirt into the cart
    And checkout the order
    Then verify order is present in order history

  Scenario: Update Personal Information in My Account
    Given User launches the Application
    And do the SignIn
    When user clicks my personal information
    And update the first name
    And update password
    Then verify personal information has successfully updated message