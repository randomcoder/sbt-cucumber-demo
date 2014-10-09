@internal
Feature: Cucumber tests should be able to be run from the main launcher application
  In order to run cucumber tests easily
  As a SyBard team member
  I want to be able to run cucumber tests by using the application launcher

  Scenario: A simple test can be run when the application launcher is used
    Given a simple test that will log 'I am running'
    When the test is launched using the application launcher with the arguments '--cucumber @internal'
    Then the test will log the phrase 'I am running'
