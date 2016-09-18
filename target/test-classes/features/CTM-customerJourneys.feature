@suite

Feature: EC-Journey1

  As a customer
  I need to be able to enter the details and compare the market
  So that I will be able to see all suppliers

  Scenario Outline: Journey 1 - Price results for electricity
    Given I launch compare the market home page
    When  I enter valid postcode <PE26YS>
    And   I click Yes to Do you have your bill handy
    And   I click Electricity for What do you want to compare
    And   I select current supplier <suppliername>
    And   I click on next button
    Then  I will be presented with the energy details page
    When  I select electricity details <tarifftype> <paymentmethod>
    And   I click No to Do you have an Economy 7 meter
    And   I click Yes to Is electricity your main source of heating
    And   I click kWh for What is your current electricity usage
    And   I enter current usage in kWh
    And   I select payment <frequency>
    And   I select payment <date>
    And   I click on next button
    Then  I will be presented with the preferences details page
    And   I select Fixed Tariff for What tariff are you interested in
    And   I select Monthly direct debit for What payment type are you interested in
    And   I enter my contact details email <abc@xyz.com>
    And   I click yes to keep me up to date via email
    And   I click yes to accept terms and conditions
    And   I click on go to prices button
    Then  I will be presented with the energy results page

    Examples:
      |suppliername|tarifftype|paymentmethod|frequency|date|
      |PE26YS  |

  Scenario Outline: Journey 2 - Price results for gas - other supplier
    Given I launch compare the market home page
    When  I enter valid <postcode>
    And   I click No to Do you have your bill handy
    And   I click Gas for What do you want to compare
    And   I select current supplier <suppliername>
    And   I click on next button
    Then  I will be presented with the energy details page
    And   I enter current gas usage in pounds
    And   I select payment <frequency>
    And   I click on next button
    Then  I will be presented with the preferences details page
    And   I click variable Tariff to What tariff are you interested in
    And   I click All payment types to What payment type are you interested in
    And   I enter my contact details email <abc@xyz.com>
    And   I click yes to accept terms and conditions
    And   I click on go to prices button
    Then  I will be presented with the energy results page

    Examples:
      |suppliername|tarifftype|paymentmethod|frequency|date|
      |PE26YS  |

  Scenario Outline: Journey 3 - Price results for gas and electricity - same supplier
    Given I launch compare the market home page
    When  I enter valid <postcode>
    And   I click No to Do you have your bill handy
    And   I click GasAndElectricity for What do you want to compare
    And   I click Yes for Is your gas and electricity from the same supplier
    And   I select current supplier <suppliername>
    And   I click on next button
    Then  I will be presented with the energy details page
    When  I select electricity details <tarifftype> <paymentmethod>
    And   I click No to Do you have an Economy 7 meter
    And   I click Yes to Is electricity your main source of heating
    And   I click kWh for What is your current electricity usage
    And   I enter current usage in kWh
    And   I select payment <frequency>
    And   I select payment <date>
    And   I click on next button
    And   I enter current gas usage in pounds
    And   I select payment <frequency>
    When  I enter electricity details
    And   I enter gas details
    And   I click on next button
    Then  I will be presented with the preferences details page
    And   I click variable Tariff for What tariff are you interested in
    And   I enter my contact details
    And   I click yes to accept terms and conditions
    And   I click on go to prices button
    Then  I will be presented with the estimated results page

    Examples:
      |samesupplier|suppliername|
      |No          |Britishgas  |

  Scenario Outline: Journey 4 - Price results for gas and electricity - different supplier
    Given I launch compare the market home page
    When  I enter valid <postcode>

    Examples:
      |samesupplier|suppliername|
      |No          |Britishgas  |