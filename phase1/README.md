## CSC207 Project Phase 1
Navigate your social conference easily with our text-based communication software.

## Features
- Fully functional login system
- Interactive event functionalities
- Displayed conference events sortable by title, time, and speaker
- Intricate and easy-to-use messaging system

## How to use?

###1. Opening and running the main class
Open up the program and locate and open the folder labelled src. Locate the class called main and right click it and then click run Main.main().  
**PLEASE NOTE: Every item in the main is CASE SENSITIVE and will be changed for Phase 2**

###2. Using the program on startup
When run, the user will be prompted to enter a username followed by a password. 
For simplicity purposes, we have already encoded 3 different accounts for the
user to run. 
* For an Organizer, please enter the following account:  
(Username: Group0384O, Password: CSC207).
* For a Speaker, please enter the following account:  
(Username: Group0384S, Password: CSC207).
* For an Attendee, please enter the following account:  
(Username: Group0384A, Password: CSC207).
    
####2.1 - Using the program as an Organizer
After opening up the program as an organizer, you will see a dropdown menu with the following options:  
- messages
- sign out
- close program
- events
- organize event
- create user

#####2.1.1 - messages
When calling messages, the organizer will get the following dropdown:  
- Back
- Display all messages
- Message all speakers
- Message a specific speaker
- Message all attendees
- Message a specific attendee

######2.1.1.1 - Back
Going back to the previous screen will return you to the dropdown shown in 2.1

######2.1.1.2 - Display all messages
This function will display all the messages that have been sent to the user as well as the ID of the message 
being received followed by returning you to the previous the dropdown shown in 2.1.

######2.1.1.3 - Message all speakers
This function will send a message to every user that is registered as a speaker.
Upon entering the function, you will be prompted to enter the content of the message to all speakers.
After writing your message, click the enter key, the message will be sent and you will be returned to the main menu
that is displayed in 2.1.

######2.1.1.3 - Message a specific speaker
This function will send a message to a specific user that is registered as a speaker.
Upon entering the function, you will be prompted to enter the username of the speaker you are trying to contact.
Next, you will be asked to enter the ID of the message you're replying to. If it is a new message, enter '-1' otherwise,
enter the ID of the message you are replying to. Finally, you will be promted to enter the content of the mesage
that you are sending to the speaker. Once you click the enter key for the final time, the message will be sent and you will be returned to the main menu
that is displayed in 2.1. 

######2.1.1.4 - Message all attendees
This function works similarly to 2.1.1.3, however instead of sending a message to all speakers, you will
send a message to all attendees.

######2.1.1.5 - Message a specific attendee
This function works similarly to 2.1.1.4, however instead of sending a message to all speakers, you will
send a message to a specific attendee.

#####2.1.2 - sign out
This function will allow the user to sign out and will return the user to the screen that they see
in chapter 2, which will once again prompt them for a username and password.  

**PLEASE NOTE: In order for the information to be saved to the txt files, the user will need to sign into any account
and use the close program function.**

#####2.1.3 - close program
This function will end the program and save all of the data that was created/edited/deleted into their respective txt files.

#####2.1.4 - events
This function will allow the user to view all of the events by 3 categories.
Firstly, they will have to choose if they want the events to be sorted by their title, the time, or the speaker of the event.
After choosing one of those options, they will then get a further dropdown that shows them all the event. If they are 
currently attending the event, there will be text notifying them that they are attending the event already. following 
the text, there is also a dropdown with 3 options:
- signup
- cancel signup
- main menu

######2.1.4.1 - signup
This function will allow the user to sign up for an event provided there is space in the event 
and they are not registered for that event/an event at the same time as this event or if they are the
organizer that organized the event.  
In order to sign up for the event, the user must input the ID of the event. If they are succeful, they will
be notified that the sign up was successful, otherwise they will be notified that the signup failed.
Either way, afterwards, the user will return to the main dropdown in 2.1

######2.1.4.2 - cancel signup
This function will allow the user to cancel their spot for an event.
In order to cancel their spot for the event, the user must input the ID of the event. If they are succeful, they will
be notified that the cancellation was successful, otherwise they will be notified that the cancellation failed.
Either way, afterwards, the user will return to the main dropdown in 2.1

######2.1.4.3 - main menu
Going back to the main menu will return you to the dropdown shown in 2.1

#####2.1.5 - organize event
This function will allow the organizer to create a new event after providing some information.  
Firstly, the user must provide the title of the new event.  
Then, the user must enter the Date and Time of the event in the format (dd-MMM-yyyy: HH:mm:ss). 
For example, November 20th 2020 at 6:35:05PM will be written as 20-Nov-2020 18:35:05.  
Next, the user must enter the room that the event is taking place in.
Finally, the user must enter the username of the speaker of the event. In the event that the user made it 
all this way and then realised that there was no speaker available or created, they have the option to type 'end' 
and the event will not be created. If the user provides a correct username, the event will be created and the user will 
be returned to the main screen showed in 2.1.

#####2.1.6 - create user
This function will allow the organizer to create a new user after providing some information about the user.  
Firstly, the organizer must provide a unique username for the user being created.  
Next, the organizer must provide a password for the new user.  
Then, the organizer must provide the Name for the user being created.  
Finally, the organizer must provide the type of the user (organizer, speaker, attendee). The organizer will then be returned 
to the main screen showed in 2.1.  
**PLEASE NOTE: In the event the username is not unique, the code will run, however the user will not be created.**

####2.2 - Using the program as a Speaker
After opening up the program as an speaker, you will see a dropdown menu with the following options:  
- messages
- sign out
- close program
- view events

#####2.2.1 - messages
When calling messages, the organizer will get the following dropdown:  
- Back
- Display all messages
- Message all attendees of the talk
- Respond to an attendee

######2.2.1.1 - Back
Going back to the previous screen will return you to the dropdown shown in 2.2

######2.2.1.2 - Display all messages
This function will display all the messages that have been sent to the user as well as the ID of the message 
being received followed by returning you to the previous the dropdown shown in 2.2.

######2.2.1.3 - Message all attendees of the talk
This function will allow the speaker to message all the attendees of a talk.
Firstly, the speaker must enter the title of the talk that they want to send a message to.  
Then they will be required to enter the content that they want to be in the message.
Regardless of if the information is correct or not, the user will then return to the screen in 2.2.  
**PLEASE NOTE: If the message goes to an event that does not exist, it will not be sent at all.**

######2.2.1.4 - Respond to an attendee
This function works also if the user is starting a conversation with an attendee.
Upon entering the function, you will be prompted to enter the username of the attendee you are trying to contact.
Next, you will be asked to enter the ID of the message you're replying to. If it is a new message, enter '-1' otherwise,
enter the ID of the message you are replying to. Finally, you will be prompted to enter the content of the message
that you are sending to the speaker. Once you click the enter key for the final time, the message will be sent, 
and you will be returned to the main menu that is displayed in 2.2. 

#####2.2.2 - sign out
This function works the exact same way as 2.1.2

#####2.2.3 - close program
This function works the exact same way as 2.1.3

#####2.2.4 - view events
This function works the exact same way as 2.1.4

######2.2.4.1 - signup
This function works the exact same way as 2.1.4.1 except the user will be return to the main menu in 2.2.

######2.2.4.2 - cancel signup
This function works the exact same way as 2.1.4.2 except the user will be return to the main menu in 2.2.

######2.2.4.3 - main menu
This function works the exact same way as 2.1.4.3 except the user will be return to the main menu in 2.2.

####2.3 - Using the program as a Speaker
After opening up the program as an speaker, you will see a dropdown menu with the following options:  
- messages
- sign out
- close program
- view events

#####2.3.1 - messages
When calling messages, the organizer will get the following dropdown:  
- Back
- Display all messages
- Message an attendee
- Message a speaker

######2.3.1.1 - Back
Going back to the previous screen will return you to the dropdown shown in 2.3

######2.3.1.2 - Display all messages
This function will display all the messages that have been sent to the user as well as the ID of the message 
being received followed by returning you to the previous the dropdown shown in 2.3.

######2.3.1.3 - Message an attendee
This function will allow the speaker to message all the attendees of a talk.
Firstly, the speaker must enter the title of the talk that they want to send a message to.  
Then they will be required to enter the content that they want to be in the message.
Regardless of if the information is correct or not, the user will then return to the screen in 2.2.  
**PLEASE NOTE: If the message goes to an event that does not exist, it will not be sent at all.**

######2.3.1.4 - Message a speaker
This function works also if the user is starting a conversation with an attendee.
Upon entering the function, you will be prompted to enter the username of the attendee you are trying to contact.
Next, you will be asked to enter the ID of the message you're replying to. If it is a new message, enter '-1' otherwise,
enter the ID of the message you are replying to. Finally, you will be prompted to enter the content of the message
that you are sending to the speaker. Once you click the enter key for the final time, the message will be sent, 
and you will be returned to the main menu that is displayed in 2.2. 

#####2.3.2 - sign out
This function works the exact same way as 2.1.2

#####2.3.3 - close program
This function works the exact same way as 2.1.3

#####2.3.4 - events
This function works the exact same way as 2.1.4

######2.3.4.1 - signup
This function works the exact same way as 2.1.4.1 except the user will be return to the main menu in 2.3.

######2.3.4.2 - cancel signup
This function works the exact same way as 2.1.4.2 except the user will be return to the main menu in 2.3.

######2.3.4.3 - main menu
This function works the exact same way as 2.1.4.3 except the user will be return to the main menu in 2.3.



## Credits
- Ananya Jha: ananya.jha@mail.utoronto.ca
- Divij Sanjanwala: divij.sanjanwala@mail.utoronto.ca
- Hayden Wolff: hayden.wolff@mail.utoronto.ca
- Marko Bachvarovski: marko.bachvarovski@mail.utoronto.ca
- Roger Lam: roge.lam@mail.utoronto.ca
- Sannat Bhasin: sannat.bhasin@mail.utoronto.ca
- Shiven Taneja: shiven.taneja@mail.utoronto.ca
- Wayne Zhu: waynez.zhu@mail.utoronto.ca