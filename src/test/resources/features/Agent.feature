@test
@agentfeature
Feature: Agent Front End
 
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
    |title               | email 			 				  | password | 
    | Login - PHPTRAVELS | agent@email.com 				|  demo    |  
  
Scenario Outline: valid login 
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters valid email '<email>'
And user enters valid password '<password>'
And user click on Login button
Then user navigate to the dashboard
And user dashboard url should be 'https://www.phptravels.net/account/dashboard'
Examples: 
      |title               | email 			 				| password | 
      | Login - PHPTRAVELS| agent@phptravels.com | demoagent |  
     
Scenario Outline: My Bookings
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters valid email '<email>'
And user enters valid password '<password>'
And user click on Login button
Then user navigate to the dashboard
When user click on MyBookings
Then user navigate to the bookings page with url should be 'https://www.phptravels.net/account/bookings'

 Examples: 
      |title               | email 			 				| password | 
      | Login - PHPTRAVELS| agent@phptravels.com | demoagent |  
    

Scenario Outline: Add Funds
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters valid email '<email>'
And user enters valid password '<password>'
And user click on Login button
Then user navigate to the dashboard
When user click on Add Funds
Then user navigate to the funds page with url should be 'https://www.phptravels.net/account/add_funds' 

Examples: 
      |title               | email 			 				| password | 
      | Login - PHPTRAVELS| agent@phptravels.com | demoagent |       

Scenario Outline: My Profile
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters valid email '<email>'
And user enters valid password '<password>'
And user click on Login button
Then user navigate to the dashboard
When user click on My Profile
Then user navigate to the profile page with url should be 'https://www.phptravels.net/account/profile'
 
Examples: 
      |title               | email 			 				| password | 
      | Login - PHPTRAVELS| agent@phptravels.com | demoagent |      
  
Scenario Outline: Logout
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters valid email '<email>'
And user enters valid password '<password>'
And user click on Login button
Then user navigate to the dashboard
When user click on Logout button
Then user navigate to the login page with url should be 'https://www.phptravels.net/login'

  Examples: 
      |title               | email 			 				| password | 
      | Login - PHPTRAVELS| agent@phptravels.com | demoagent |  
   
    
Scenario Outline: Home Link
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters valid email '<email>'
And user enters valid password '<password>'
#And user click on Login button
When user click on Login 
Then user navigate to the dashboard
When user click on Home '<link>' 
Then user navigate to the Home page with url should be 'https://www.phptravels.net/'
 Examples: 
       |title                | email 			 				| password | link|
       | Login - PHPTRAVELS | agent@phptravels.com | demoagent |Home|
  
Scenario Outline: Hotel Link
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters valid email '<email>'
And user enters valid password '<password>'
And user click on Login button
Then user navigate to the dashboard
When user click on Hotel '<link>'
Then user navigate to the Hotel page with url should be 'https://www.phptravels.net/hotels'
  Examples: 
     |title                | email 			 				| password | link|
     | Login - PHPTRAVELS | agent@phptravels.com | demoagent |Hotel|

Scenario Outline: Flights Link
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters valid email '<email>'
And user enters valid password '<password>'
And   user click on Login button
Then  user navigate to the dashboard
When user click on Flights '<link>' 
Then user navigate to the Flights page with url should be 'https://www.phptravels.net/flights'
 Examples: 
          |title                | email 			 				| password | link|
         | Login - PHPTRAVELS  | agent@phptravels.com | demoagent |Flights|
     
Scenario Outline: Tours Link
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters valid email '<email>'
And user enters valid password '<password>'
And user click on Login button
Then user navigate to the dashboard
When user click on Tours '<link>' 
Then user navigate to the Tours page with url should be 'https://www.phptravels.net/tours'
 Examples: 
            |title                | email 			 				| password | link|
            | Login - PHPTRAVELS | agent@phptravels.com | demoagent |Tours|

Scenario Outline: Visa Link
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters valid email '<email>'
And user enters valid password '<password>'
And user click on Login button
Then user navigate to the dashboard
When user click on Visa '<link>' 
Then user navigate to the Visa page with url should be 'https://www.phptravels.net/visa'
 Examples: 
        |title             | email 			 				| password | link|
        |Login - PHPTRAVELS| agent@phptravels.com | demoagent |Visa|
       
Scenario Outline: Blog Link
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters valid email '<email>'
And user enters valid password '<password>'
And user click on Login button
Then user navigate to the dashboard
When user click on Blog '<link>' 
Then user navigate to the Blog page with url should be 'https://www.phptravels.net/blog'
 Examples: 
       |title              | email 			 				| password | link|
       |Login - PHPTRAVELS | agent@phptravels.com | demoagent |Blog|
       
Scenario Outline: Offers Link
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters valid email '<email>'
And user enters valid password '<password>'
And user click on Login button
Then user navigate to the dashboard
When user click on Offers '<link>' 
Then user navigate to the Offers page with url should be 'https://www.phptravels.net/offers'
 Examples: 
        |title             | email 			 				  | password | link|
        |Login - PHPTRAVELS| agent@phptravels.com | demoagent |Offers|
              
Scenario Outline:  Dropdown currency
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters valid email '<email>'
And user enters valid password '<password>'
And user click on Login button
Then user navigate to the dashboard
When user click on Hotel '<link>'
And user click on USD and select INR '<option>'
Then user can see currency dispalyed is change to 'INR'
 Examples: 
        |title             | email 			 				| password  | link|option|
        |Login - PHPTRAVELS| agent@phptravels.com | demoagent |Hotel|INR|       
     
Scenario Outline: Back to Home page
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters valid email '<email>'
And user enters valid password '<password>'
And user click on Login button
Then user navigate to the dashboard
When user click on Hotel '<link>'
When user click on Accounts and select Dashboard 'Dashboard'
Then user navigate to the dashboard page with url should be 'https://www.phptravels.net/account/dashboard'
 Examples: 
      |title 							 | email 			 				| password  |link|
      |Login - PHPTRAVELS  | agent@phptravels.com | demoagent |Hotel|

Scenario Outline: Hotel search by city
Given  user is on login page with Login - PHPTRAVELS '<title>'
When user enters valid email '<email>'
And user enters valid password '<password>'
And user click on Login button
Then user navigate to the dashboard
When user click on Hotel '<link>' 
And user enter and select the city name '<city>'
Then navigate to the page with title of should contain city name '<city>'
 Examples: 
       |title             | email 	            | password  | link |city|
       |Login - PHPTRAVELS|agent@phptravels.com | demoagent |Hotel| new |             
       
       