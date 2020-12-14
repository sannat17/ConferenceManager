## CSC207 Project Phase 2
Navigate your social conference easily with our text-based communication software.

Features:
- Fully functional login system
- Interactive event functionalities
- Displayed conference events sortable by title, time, and speaker
- Intricate and easy-to-use messaging system

<br>

<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
  </ol>
</details>

## How to use?

###1. Opening and running the main class
All program source code should be in a phase2 folder. Inside this folder are two folders server and src. The 
client-side application has its entrypoint in src/Main.java. Running the main function in this file will start the 
program.

###2. Using the program on startup
Starting the program will bring you to the login screen. For simplicity purposes, we have already encoded 3 different 
accounts for the user to run.
* For an Organizer, please enter (Username: Group0384O, Password: CSC207).
* For a Speaker, please enter (Username: Group0384S, Password: CSC207).
* For an Attendee, please enter the (Username: Group0384A, Password: CSC207).
    
##3. Using the program as an Organizer
After opening up the program as an organizer, you will see a home page with a dropdown menu for the following options:  
- Messages
- Events
- Create a new user account
- Additional Requests
- Change Additional Request

###3.1 - Messages
When calling messages, the organizer will get the following dropdown:  
- Display all messages
- Message all speakers
- Message a speaker
- Message an attendee
- Message all attendees
- Message all attendees of an event

#####3.1.1 - Display all messages
...

#####3.1.2 - Message all speakers
This feature will send a message to all speakers in this conference. Upon sending, you will be returned to the previous
screen.

#####3.1.3 - Message a specific speaker
This feature will send a message to a specific speaker. From the dropdown menu, select the speaker you want to message.
Upon sending, you will be returned to the previous screen.

#####3.1.4 - Message an attendees
This feature will send a message to a specific attendee. From the dropdown menu, select the attendee you want to 
message. Upon sending, you will be returned to the previous screen.

#####3.1.5 - Message all attendees
This feature will send a message to all attendees in this conference. Upon sending, you will be returned to the 
previous screen.

#####3.1.6 - Message all attendees of an event
This feature will send a message to all attendees in this conference. From the dropdown menu, select the event that you 
want to message. Upon sending, you will be returned to the previous screen.

###3.2 - Events
When calling messages, the organizer will get the following dropdown:  
- View Your Events
- Print Events
- Sign up for an event
- Cancel sign up for an event
- Organize event
- Cancel an event

#####3.2.1 - View your events
From the dropdown menu, select a sorting. After pressing confirm, all of your events will be printed, ordered in the
sorting that you specified.

#####3.2.2 - Print events (Optional Extension #3)
This feature will generate a webpage containing a schedule for this conference. Upon pressing Print Schedule, you'll
immediately be redirected to this webpage. 

#####3.2.3 - Sign up for an event
Select an event from the dropdown menu. Pressing sign up will add you to the attendance of this event, and bring you
back to the previous page.

#####3.2.4 - Cancel sign up for an event
If you decide you no longer wish to attend an event, select the event from the dropdown menu. Upon pressing cancel
sign up, you will be removed from this event. Then you'll be taken back to the previous page.

#####3.2.5 - Organize event
...

#####3.2.6 - Cancel an event
...

###3.3 Create a new user account
...

###3.4 Additional requests
...

###3.5 Change additional requests
...

##4. Using the program as a Speaker
After opening up the program as an organizer, you will see a home page with a dropdown menu for the following options:  
- Messages
- Events

###4.1 - Messages
When calling messages, the organizer will get the following dropdown:  
- Display all messages
- Message all attendees of the talk

#####4.1.1 - Display all messages
...

#####4.1.2 - Message all attendees of the talk
This feature will send a message to all attendees in the talk that this speaker is giving. Upon sending, you will be 
returned to the previous screen.

###4.2 - Events
When calling messages, the organizer will get the following dropdown:  
- View Your Events
- Print Events

#####4.2.1 - View your events
From the dropdown menu, select a sorting. After pressing confirm, all of your events will be printed, ordered in the
sorting that you specified.

#####4.2.2 - Print events (Optional Extension #3)
This feature will generate a webpage containing a schedule for this conference. Upon pressing Print Schedule, you'll
immediately be redirected to this webpage. 

##5. Using the program as an Attendee
After opening up the program as an organizer, you will see a home page with a dropdown menu for the following options:  
- Messages
- Events

###5.1 - Messages
When calling messages, the organizer will get the following dropdown:  
- Display all messages
- Message all attendees of the talk

#####5.1.1 - Display all messages
...

#####5.1.2 - Message an attendee
This feature will send a message to all attendees in the talk that this speaker is giving. Upon sending, you will be 
returned to the previous screen.

#####5.1.3 - Message a speaker
This feature will send a message to a specific speaker. From the dropdown menu, select the speaker you want to message.
Upon sending, you will be returned to the previous screen.

###5.2 - Events
When calling messages, the organizer will get the following dropdown:  
- View Your Events
- Print Events

#####5.2.1 - View your events
From the dropdown menu, select a sorting. After pressing confirm, all of your events will be printed, ordered in the
sorting that you specified.

#####5.2.2 - Print events (Optional Extension #3)
This feature will generate a webpage containing a schedule for this conference. Upon pressing Print Schedule, you'll
immediately be redirected to this webpage. 

#####5.2.3 - Sign up for an event
Select an event from the dropdown menu. Pressing sign up will add you to the attendance of this event, and bring you
back to the previous page.

#####5.2.4 - Cancel sign up for an event
If you decide you no longer wish to attend an event, select the event from the dropdown menu. Upon pressing cancel
sign up, you will be removed from this event. Then you'll be taken back to the previous page.

## Credits
- Ananya Jha: ananya.jha@mail.utoronto.ca
- Divij Sanjanwala: divij.sanjanwala@mail.utoronto.ca
- Hayden Wolff: hayden.wolff@mail.utoronto.ca
- Marko Bachvarovski: marko.bachvarovski@mail.utoronto.ca
- Roger Lam: roge.lam@mail.utoronto.ca
- Sannat Bhasin: sannat.bhasin@mail.utoronto.ca
- Shiven Taneja: shiven.taneja@mail.utoronto.ca
- Wayne Zhu: waynez.zhu@mail.utoronto.ca