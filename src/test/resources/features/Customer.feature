@test
@customerfeature
Feature: Customer Front End
 
Scenario Outline: front Login page title
Given  user is on login page with Login - PHPTRAVELS '<title>'
Then the login page url should be 'https://www.phptravels.net/login'
 
Examples: 
      | title	 				    |             
      | Login - PHPTRAVELS|	
      
Scenario Outline: invalid login
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters inavlid '<email>'
And user enters invalid password '<password>'
When user click on Login button
Then user get the url of login failed should be 'https://www.phptravels.net/login/failed'

Examples: 
    |title               | email			 	  | password | 
    | Login - PHPTRAVELS | user@email.com | demo    |  
    

Scenario Outline: valid login 
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters valid email '<email>'
And user enters valid password '<password>'
When user click on Login button
Then user navigate to the dashboard
And user dashboard url should be 'https://www.phptravels.net/account/dashboard'
Examples: 
     
      |title               | email 			 			| password | 
      | Login - PHPTRAVELS| user@phptravels.com | demouser |  

     
Scenario Outline: My Bookings
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters valid email '<email>'
And user enters valid password '<password>'
When user click on Login button
Then user navigate to the dashboard
When user click on MyBookings
Then user navigate to the bookings page with url should be 'https://www.phptravels.net/account/bookings'

 Examples: 
    
      |title               | email 			 			| password | 
      | Login - PHPTRAVELS| user@phptravels.com | demouser |    
    
Scenario Outline: Add Funds
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters valid email '<email>'
And user enters valid password '<password>'
When user click on Login button
Then user navigate to the dashboard
When user click on Add Funds
Then user navigate to the funds page with url should be 'https://www.phptravels.net/account/add_funds' 

 Examples: 
      |title               | email 			 			| password | 
      | Login - PHPTRAVELS| user@phptravels.com | demouser |  

Scenario Outline: My Profile
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters valid email '<email>'
And user enters valid password '<password>'
When user click on Login button
Then user navigate to the dashboard
When user click on My Profile
Then user navigate to the profile page with url should be 'https://www.phptravels.net/account/profile'
 
 Examples: 
      |title               | email 			 			| password | 
      | Login - PHPTRAVELS| user@phptravels.com | demouser |      
  
Scenario Outline: Logout
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters valid email '<email>'
And user enters valid password '<password>'
When user click on Login button
Then user navigate to the dashboard
When user click on Logout button
Then user navigate to the login page with url should be 'https://www.phptravels.net/login'

  Examples: 
      |title               | email 			 			| password | 
      | Login - PHPTRAVELS| user@phptravels.com | demouser |  
   
        
Scenario Outline: View Voucher
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters valid email '<email>'
And user enters valid password '<password>'
When user click on Login button
Then user navigate to the dashboard
When user click on MyBookings
Then user navigate to the bookings page with url should be 'https://www.phptravels.net/account/bookings'   
When user click on a View Voucher '<voucher>'  
Then user navigate to the invoice page with title should be 'Hotel Invoice - PHPTRAVELS'
 
 Examples: 
      |title               | email 			 			| password | voucher|
      | Login - PHPTRAVELS| user@phptravels.com | demouser |Hotel Invoice - PHPTRAVELS | 
@Test1234 
Scenario Outline: Payment
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters valid email '<email>'
And user enters valid password '<password>'
When user click on Login button
Then user navigate to the dashboard
When user click on Add Funds
Then user navigate to the funds page with url should be 'https://www.phptravels.net/account/add_funds'
When user select payment method and click on PayNow
Then user navigate to the paypalpage with url should be 'https://www.phptravels.net/payment/paypal' 
When user click on Back to Invoice
Then user navigate to the add funds page with url should be 'https://www.phptravels.net/account/add_funds' 

Examples: 
      |title               | email 			 			| password | 
      | Login - PHPTRAVELS| user@phptravels.com | demouser |  
        
Scenario Outline: Address field update in profile
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters valid email '<email>'
And user enters valid password '<password>'
When user click on Login button
Then user navigate to the dashboard
When user click on My Profile
Then user navigate to the profile page with url should be 'https://www.phptravels.net/account/profile'
When user get data from address filed and enter data to address field '<Address>'
And user click on update profle
Then user get a message 'Profile updated successfully.'
 Examples: 
    
      |title               | email 			 			| password | Address|
      | Login - PHPTRAVELS| user@phptravels.com | demouser |R5, Avenue du Maroc|
       