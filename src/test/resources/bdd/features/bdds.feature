Feature: API BDDs

  @FirstScenario
  Scenario: Receive single arrival
    Given Arrival rest endpoint is up
    When User gets one arrival by id 1
    Then Returned JSON object is not null

  Scenario: Receive single departure
    Given Departure rest endpoint is up
    When User gets one departure by id 1
    Then Returned JSON object is not null

  Scenario: Receive single flight
    Given Flight rest endpoint is up
    When User gets one flight by id 1
    Then Returned JSON object is not null

  Scenario: Receive single user
    Given Users rest endpoint is up
    When User gets one user by id 1
    Then Returned JSON object is not null