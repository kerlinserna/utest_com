Feature: User registration on utest.com

  Scenario: The user can register on the page with utest
    Given I am on the website
    When the user fills in the data of the first form
      | firstname | lastname | emailaddress   | dateofbirthmouth | dateofbirthday | dateofbirthyear |
      | xxxx      | yyyy     | zzzz@gmail.com | May              |             14 |            1996 |
    And the user fills in the data of the second form
      | cityfield | ziporpostalcodefield | country  |
      | Medellín  |               001121 | Colombia |
    And the user fills in the data of the third form
      | computer | versionfield | languagefield |
      | Linux    | Ubuntu       | Spanish       |
