@suite

Feature: CTM-Journeys for comparing supplier's prices for Electricity and Gas

  As a customer
  I need to be able to enter the energy details and compare the market
  So that I will be able to see all suppliers and their price offers

  Scenario Outline: Journey 1 - Price results for electricity - have bill handy
    Given I launch compare the market home page
    Then  I see page title is Energy - Compare Gas and Electricity Suppliers | Compare The Market
    When  I enter valid postcode PE26YS and click on Find postcode
    And   I click Yes to Do you have your bill handy
    And   I click Electricity for What do you want to compare
    And   I select current supplier <suppliername> for electricity
    And   I click next button on supplier details page
    Then  I will be presented with the energy details page
    When  I select tariff type <tariffindex>
    And   I click No to Do you have an Economy 7 meter
    When  I select payment type <paymentindex>
    And   I click Yes to Is electricity your main source of heating
    And   I click kWh for What is your current electricity usage
    And   I enter current <usage> in kWh
    And   I select payment frequency <frequencyindex>
    And   I select payment date
    And   I click next button on energy details page
    Then  I will be presented with the preferences details page
    And   I select Fixed tariff for What tariff are you interested in
    And   I select Monthly direct debit for What payment type are you interested in
    And   I enter my contact details email abc@xyz.com
    And   I click yes to keep me up to date via email
    And   I click yes to accept terms and conditions
    And   I click on go to prices button
    Then  I will be presented with the energy results page

    Examples:
      |suppliername|tariffindex|paymentindex|usage|frequencyindex|
      |British Gas |1          |1           |50   |1             |

  Scenario Outline: Journey 2 - Price results for gas - no bill
    Given I launch compare the market home page
    Then  I see page title is Energy - Compare Gas and Electricity Suppliers | Compare The Market
    When  I enter valid postcode PE26YS and click on Find postcode
    And   I click No to Do you have your bill handy
    And   I click Gas for What do you want to compare
    And   I click I don’t know for Who supplies your gas
    And   I click next button on supplier details page
    Then  I will be presented with the energy no bill page
    And   I enter current gas <usage> in pounds
    And   I select gas payment frequency <frequencyindex>
    And   I click next button on energy details page
    Then  I will be presented with the preferences details page
    And   I select Variable tariff for What tariff are you interested in
    And   I select All payment types for What payment type are you interested in
    And   I enter my contact details email abc@xyz.com
    And   I click yes to accept terms and conditions
    And   I click on go to prices button
    Then  I will be presented with the energy results page

    Examples:
      |usage|frequencyindex|
      |50   | 1            |
      |100  | 1            |

  Scenario Outline: Journey 3 - Price results for gas and electricity - same supplier and default options
    Given I launch compare the market home page
    Then  I see page title is Energy - Compare Gas and Electricity Suppliers | Compare The Market
    When  I enter valid postcode PE26YS and click on Find postcode
    And   I click Yes to Do you have your bill handy
    And   I click GasAndElectricity for What do you want to compare
    And   I click Yes for Is your gas and electricity from the same supplier
    And   I select current supplier <suppliername> for both
    And   I click next button on supplier details page
    Then  I will be presented with the energy details page
    And   I click kWh for What is your current electricity usage
    And   I enter current <usage> in kWh
    And   I click next button on energy details page
    Then  I will be presented with the energy details page
    And   I click kWh for What is your current gas usage
    And   I enter current gas <usagegas> in kwh
    And   I click next button on energy details page
    Then  I will be presented with the preferences details page
    And   I select Variable tariff for What tariff are you interested in
    And   I select All payment types for What payment type are you interested in
    And   I enter my contact details email abc@xyz.com
    And   I click yes to keep me up to date via email
    And   I click yes to accept terms and conditions
    And   I click on go to prices button
    Then  I will be presented with the energy results page

    Examples:
      |suppliername|usage|usagegas|
      |British Gas |500  |40      |

  Scenario Outline: Journey 4 - Price results for gas and electricity - different supplier
    Given I launch compare the market home page
    Then  I see page title is Energy - Compare Gas and Electricity Suppliers | Compare The Market
    When  I enter valid postcode PE26YS and click on Find postcode
    And   I click No for Is your gas and electricity from the same supplier
    And   I click next button on supplier details page
    And   I enter current <usage> in kWh
    And   I click next button on energy details page
    Then  I will be presented with the energy details page
    And   I enter current gas <usagegas> in kwh
    And   I click next button on energy details page
    Then  I will be presented with the preferences details page
    And   I select Fixed tariff for What tariff are you interested in
    And   I select Monthly direct debit for What payment type are you interested in
    And   I enter my contact details email abc@xyz.com
    And   I click yes to keep me up to date via email
    And   I click yes to accept terms and conditions
    And   I click on go to prices button
    Then  I will be presented with the energy results page
    Examples:
      |usage|usagegas|
      |200  |300     |