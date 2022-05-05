@test
@supplierfeature 
Feature: Supplier Back End

Scenario Outline: Supplier login Page title
Given supplier is on the login page with title Supplier Login 'Supplier Login' 
Then check supplier login page title should be 'Supplier Login'
 
 Examples: 
      | title         |
      |Supplier Login | 
     
Scenario: Supplier invalid login without data
Given supplier is on the login page with title Supplier Login 'Supplier Login' 
When supplier click on the Login
Then supplier gets the first error message should be 'The Email field is required.'
And supplier gets the second error message should be 'The Password field is required.'


Scenario Outline: Supplier invalid login with password only
Given supplier is on the login page with title Supplier Login 'Supplier Login' 
When supplier enter an invalid password '<password>'
And supplier click on the Login
Then supplier gets the email error message should be 'The Email field is required.'
 Examples: 
      | password |
      | password | 
     
Scenario Outline: Supplier invalid login with invalid credential
Given supplier is on the login page with title Supplier Login 'Supplier Login' 
When supplier enters the invalid email id '<email_id>' 
And supplier enter an invalid password '<password>'
When supplier click on the Login 
Then supplier gets the  error message should be 'The Email field must contain a valid email address.'
Examples: 
   
   | email_id| password |
   | demo   | password | 

Scenario Outline: Supplier invalid login with invalid password
Given supplier is on the login page with title Supplier Login 'Supplier Login' 
When a supplier enters the valid email id '<email_id>'  
And supplier enter an invalid password '<password>'
When supplier click on the Login 
Then supplier gets the  error message should be 'Invalid Login Credentials'
Examples: 
   
   | email_id              | password |
   | supplier@phptravels.com  | password | 


Scenario Outline: Supplier valid login 
Given supplier is on the login page with title Supplier Login 'Supplier Login' 
When a supplier enters the valid email id '<email_id>' 
And supplier enter a valid password '<password>'
When supplier click on the Login 
Then supplier should redirect to the supplier dashboard
And supplier dashboard url should be 'https://www.phptravels.net/api/supplier'
Examples: 
   
   | email_id                 | password |
   | supplier@phptravels.com  | demosupplier | 

Scenario Outline: Sales overview & summary 
Given supplier is on the login page with title Supplier Login 'Supplier Login' 
When a supplier enters the valid email id '<email_id>' 
And supplier enter a valid password '<password>'
When supplier click on the Login 
And supplier dashboard  should contain Sales overview & summary '<Text>'
Examples: 
   
   | email_id                 | password |Text|
   | supplier@phptravels.com  | demosupplier | Revenue Breakdown|

Scenario Outline: Revenue Breakdown 
Given supplier is on the login page with title Supplier Login 'Supplier Login' 
When a supplier enters the valid email id '<email_id>' 
And supplier enter a valid password '<password>'
When supplier click on the Login 
#Then supplier should redirect to the supplier dashboard
And supplier dashboard  should contain Revenue Breakdown '<Text>'
Examples: 
   
   | email_id                 | password |  Text|
   | supplier@phptravels.com  | demosupplier | Revenue Breakdown|

Scenario Outline: Manage Tours
Given supplier is on the login page with title Supplier Login 'Supplier Login' 
When a supplier enters the valid email id '<email_id>' 
And supplier enter a valid password '<password>'
When supplier click on the Login 
When supplier click on Tours, view tours links
When supplier click on Manage Tours '<link>'
Then supplier should redirect to the  Manage Tours page with title 'Tours Management'
Examples: 
   
   | email_id                 | password |  link|
   | supplier@phptravels.com  | demosupplier | Manage Tours|

Scenario Outline: Extras 
Given supplier is on the login page with title Supplier Login 'Supplier Login' 
When a supplier enters the valid email id '<email_id>' 
And supplier enter a valid password '<password>'
When supplier click on the Login 
When supplier click on Tours, view tours links
When supplier click on Extras '<link>'
Then supplier should redirect to the Extras page with title 'Extras Management'
Examples: 
   
   | email_id                 | password |link|
   | supplier@phptravels.com  | demosupplier |Extras| 

Scenario Outline: Bookings
Given supplier is on the login page with title Supplier Login 'Supplier Login' 
When a supplier enters the valid email id '<email_id>' 
And supplier enter a valid password '<password>'
When supplier click on the Login 
When supplier click on Bookings
Then supplier should redirect to the Bookings page with url 'https://www.phptravels.net/api/supplier/bookings'
Examples: 
   
   | email_id                 | password |
   | supplier@phptravels.com  | demosupplier | 
