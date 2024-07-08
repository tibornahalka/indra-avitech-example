## Description
The code introduces a Producer-Consumer pattern to process commands from a First-In-First-Out (FIFO) queue. Added implementations for Add, PrintAll, and DeleteAll commands, as well as, database operations such as addUser, getAllUsers, and deleteAllUsers.
#### Functionality is demonstrated in Main.java main method and there are also 2 unit tests for Add command and DeleteAll command.

## Commands
Supported commands are the following:
   - Add - adds a user into a database
   - PrintAll – prints all users into standard output
   - DeleteAll – deletes all users from database

## Database
User is defined as database table SUSERS with columns (USER_ID, USER_GUID, USER_NAME)