@test
@adminfeature
Feature: Admin Back End

  
  Scenario: verify Admin login Page title
    Given admin is on the login page title Administator Login 'Administator Login'
    Then check admin login page url should be 'https://www.phptravels.net/api/admin'

  
  Scenario: verify Admin invalid login without credential
    Given admin is on the login page title Administator Login 'Administator Login'
    When admin click on Login
    Then admin gets the first error message should be 'The Email field is required.'
    And admin gets the second error message should be 'The Password field is required.'

  
  Scenario Outline: Admin invalid login
    Given admin is on the login page title Administator Login 'Administator Login'
    When admin enter an invalid password '<password>'
    And admin click on Login
    Then admin gets the email error message should be 'The Email field is required.'

    Examples: 
      | password |
      | demo     |

  
  Scenario Outline: Admin invalid login with invalid credential
    Given admin is on the login page title Administator Login 'Administator Login'
    When admin enters the invalid email id '<email_id>'
    And admin enter an invalid password '<password>'
    When admin click on Login
    Then admin gets the  error message should be 'The Email field must contain a valid email address.'

    Examples: 
      | email_id | password |
      | demo     | test |

  
  Scenario Outline: Admin invalid login with invalid password
    Given admin is on the login page title Administator Login 'Administator Login'
    When admin enters the valid email id '<email_id>'
    And admin enter an invalid password '<password>'
    When admin click on Login
    Then admin gets the  error message should be 'Invalid Login Credentials'

    Examples: 
      | email_id             | password |
      | admin@phptravels.com | demo     |

  
  Scenario Outline: Admin valid login
    Given admin is on the login page title Administator Login 'Administator Login'
    When admin enters the valid email id '<email_id>'
    And admin enter a valid password '<password>'
    When admin click on Login
    Then admin should redirect to the admin dashboard
    And admin dashboard url should be 'https://www.phptravels.net/api/admin'

    Examples: 
      | email_id             | password  |
      | admin@phptravels.com | demoadmin |

  
  Scenario Outline: Website link
    Given admin is on the login page title Administator Login 'Administator Login'
    When admin enters the valid email id '<email_id>'
    And admin enter a valid password '<password>'
    When admin click on Login
    Then admin should redirect to the admin dashboard
    When admin click on Website
    #Then admin should redirect to the PHPTRAVELS page 'PHPTRAVELS | Travel Technology Partner - PHPTRAVELS'
    Then admin should redirect to the PHPTRAVELS page
    And the page title PHPTRAVELS page should be 'PHPTRAVELS | Travel Technology Partner - PHPTRAVELS'

  
    Examples: 
      | email_id             | password  |
      | admin@phptravels.com | demoadmin |

  
  Scenario Outline: Bookings link
    Given admin is on the login page title Administator Login 'Administator Login'
    When admin enters the valid email id '<email_id>'
    And admin enter a valid password '<password>'
    When admin click on Login
    Then admin should redirect to the admin dashboard
    When admin click on Bookings
    Then admin should redirect to the All bookings view page
    And the All bookings page title should be 'All Bookings View'

    Examples: 
      | email_id             | password  |
      | admin@phptravels.com | demoadmin |

  
  Scenario Outline: Booking status
    Given admin is on the login page title Administator Login 'Administator Login'
    When admin enters the valid email id '<email_id>'
    And admin enter a valid password '<password>'
    When admin click on Login
    Then admin should redirect to the admin dashboard
    When admin click on Bookings
    Then admin should redirect to the All bookings view page
    When the admin change the booking from pending to confirmed
    Then the count on booking status pending is less by one compare with previous count

    Examples: 
      | email_id             | password  |
      | admin@phptravels.com | demoadmin |

  
  Scenario Outline: Successful Payment
    Given admin is on the login page title Administator Login 'Administator Login'
    When admin enters the valid email id '<email_id>'
    And admin enter a valid password '<password>'
    When admin click on Login
    Then admin should redirect to the admin dashboard
    When admin click on Bookings
    Then admin should redirect to the All bookings view page
    Then check  the booking status with confirmed and the payment status with paid for successful payment

    Examples: 
      | email_id             | password  |
      | admin@phptravels.com | demoadmin |

  
  Scenario Outline: Delete Bookings With Booking Status Cancelled
    Given admin is on the login page title Administator Login 'Administator Login'
    When admin enters the valid email id '<email_id>'
    And admin enter a valid password '<password>'
    When admin click on Login
    Then admin should redirect to the admin dashboard
    When admin click on Bookings
    Then admin should redirect to the All bookings view page
    #And the page title should be 'All Bookings View'
    When admin click on delete button with booking status '<status>'
    Then an alert is open

    Examples: 
      | email_id             | password  | status    |
      | admin@phptravels.com | demoadmin | cancelled |
