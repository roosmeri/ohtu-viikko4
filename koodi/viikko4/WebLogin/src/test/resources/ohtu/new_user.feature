Feature: A new user account can be created if a proper unused username and a proper password are given

  Scenario: creation succesful with correct username and password
    Given new user is selected
    When username "pekka", password "salainen1" and password confirmation "salainen1" are given
    Then a new user is created succesfully

  Scenario: creation fails with too short username and valid passord
    Given new user is selected
    When a too short username "pa", password "salainen1" and password confirmation "salainen1" are given
    Then user is not created and error "username should have at least 3 characters" is reported

  Scenario: creation fails with correct username and too short password
    Given new user is selected
    When username "hallusi", a too short password "naatio" and password confirmation "naatio" are given
    Then user is not created and error "password should have at least 8 characters" is reported

  Scenario: creation fails with correct username and password consisting of letters
    Given new user is selected
    When username "pink", an only-letters password "pantherr" and password confirmation "pantherr"are given
    Then user is not created and error "password can not contain only letters" is reported

  Scenario: creation fails with already taken username and valid pasword
    Given new user is selected
    When a taken username "jukka", password "panther2" and password confirmation "panther2"
    Then user is not created and error "username is already taken" is reported

  Scenario: creation fails when password and password confirmation do not match
    Given new user is selected
    When username "something", password "sala1nen" and a different password confirmation "salainen1" are given
    Then user is not created and error "password and password confirmation do not match" is reported