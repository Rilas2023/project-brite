@login

Feature:  Brite ERP login feature

  User Story:
  As a user, I should be able to login with correct credentials to different accounts. And dashboard should be displayed.
  Accounts are: Sales Manager, POS manager, CRM Manager, Inventory Manager, Expenses Manger.

  Background: User is already in the log in page
    Given the user is on the login page

  @wip1
  Scenario Outline: Verify login with different user types
    Given the user enters valid "<manager type>" credentials

    Then dashboard should be displayed
    Examples:
      | manager type      |
      | posmanager        |
      | crm manager       |
      | sales manager     |
      | inventory manager |
      | expenses manager  |

  @wip2
  Scenario Outline: Verify login with different user types
    Given the user enters valid "<account type>"
    Then the user enters valid manager's "<username>" and "<password>"
    Then dashboard should be displayed

    Examples:
      | account type      | username                   | password                   |
      | posmanager        | posmanager_username        | posmanager_password        |
      | crm manager       | crm_manager_username       | crm_manager_password       |
      | sales manager     | sales_manager_username     | sales_manager_password     |
      | inventory manager | inventory_manager_username | inventory_manager_password |
      | expenses manager  | expenses_manager_username  | expenses_manager_password  |