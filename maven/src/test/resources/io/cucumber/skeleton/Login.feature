Feature: Adding new address

  Scenario Outline: User tries to add new address
    Given The browser is open
    And User is on the login page
    When User inputs mail "scccejzxcovslfjqmf@ytnhy.com"
    And User inputs password "testowe"
    And User presses Sign In button
    And User presses the addresses Tab
    And user presses create new address
    And User inserts "<alias>" as alias
    And User inserts "<address>" as address
    And User inserts "<city>" as city
    And User inserts "<zip>" as zip
    And User inserts "<country>" as country
    And User inserts "<phone>" as phone
    And User presses button Save
    Then Address data is correctly displayed
      | alias  | address      | city    | zip    | country             | phone        |
      | Dom    | ul. Kwiatowa | miasto  | 30-001 | United Kingdom      | 123456789    |
    Examples:
      | alias  | address      | city    | zip    | country             | phone        |
      | Dom    | ul. Kwiatowa | miasto  | 30-001 | United Kingdom      | 123456789    |



