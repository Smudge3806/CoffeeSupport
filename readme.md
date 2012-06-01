## CoffeeSupport ##

@author Chris Smith chris@cj-dev.co.uk
@author Ian Richards user:HardCode37

@version 1 - BASH Client

### Overview ###

* @version 1 provides a BASH client for Admin users.
* Provides a Watch Command which watches the MySql Database for activity.
* @version 2 - _will_ provide a gui client for this application

### Functionality ###

* Login to User
  * Authenticated Users are type(Admin)
  * Passwords - Are held as MD5 hashes...

* User
  * Create new user
  * Edit Existing user
  * Promote to Administrator(Authenticates on Admin User Password)
  * Change Department Enrollment
  * Reset Password - Resets currently to 696d29e0940a4957748fe3fc9efd22a3

* Department - Fully CRUD
  * Delete must authenticate on admin password.

* Support Request
  * Show All
  * Show all "open" (Not Closed)
  * Show all for user logged in
  * Show # Request
  * Add Note to Request

* Training Events
  * Show All
  * Show all by user
  * Show # Event
  * Add Note to Event
  * Cancel Event (Password Authenticate)

* Moodle Pages
  * Show All
  * Show all by department
  * Show # Page
  * Delete Page (Password Authenticate)

### Syntax ###

Structure of commands should be as follows:

* Show Commands
  * ``` Verb Quantity Nown [Addition Parameters]```
  * ``` show -all users ```
  * ``` show -all users --d "Learning Technologies Unit" ``` - Show all users in Learning Technologies Unit

* Edit Commands
  * ``` Verb Nown id ```
  * ``` edit user 88 ```

* Delete Commands
  * ``` Verb Nown id ```
  * ``` remove page 246 ```
    * Also consider ``` Nown id verb|abreviation ```
    * ``` page 246 -rm ```
  * Should prompt to authenticate
    * ``` Please Authenticate this action: <password> ```

# More To Come #
