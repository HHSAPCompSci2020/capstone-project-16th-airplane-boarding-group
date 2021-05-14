# capstone-project-16th-airplane-boarding-group
Boarding Simulation
Authors: Aryan Keskar, Joshua Choi, Vamsee Krishna Vusuwandla
Revision: 4/23/2021

Courtesy for CGP Grey: Youtube
Introduction: 
What does your program do?
Our program can arrange the lines when boarding the plane and time the efficiency of what different arrangements can bring systematically and mathematically.
What problem does it solve? Why did you write it?
It solves the problem of people having to wait for 30-40 or sometimes even an hour to even get on the airplane. I(Josh) was watching a youtube video saying that most airlines use one of the most inefficient ways to board a plane and we can drastically reduce the time if people are lined up in a certain manner.

What is the story? 
I stumbled upon a youtube video that showcased a much more efficient way of and lining up for airplane boarding, I thought we could use 2d arrays that we learnt in the unit and it was very unique. In the game, you are the airline in charge and you can change the line how much you can. 

What are the rules? What is the goal?
The player’s goal is to ensure that they board the plane with passengers in the most efficient way with their time. The rules would be set up as we would have very basic sets of simple orders that the user(the person manipulating the lines) : completely randomly generated seats, window to aisle, front to back, back to front. 

Who would want to use your program?
Airlines that clearly don’t use the better boarding systems due to economic incentives and logistic issues like having to separate families. The program can be used for educational purposes, by students or by aviation enthusiasts and can also bring awareness to the public about the wasteful techniques airlines employ in order to turn a profit.

What are the primary features of your program?
I think the interaction feature is that you can move the arrangement to change the orders to change the outcome of the time.
The assignment of seats to passengers that can be intuitive
Menu where you can choose from  the most basic arrangements of lines.
The nature of the game is very time sensitive, so some precise measurement of the time and a way to save the time to make the game more competitive and allow for something like a “speedrun”

Instructions:

Which keyboard keys will do what? 
The keys required for the program would be for typed in seating, where the user must assign the passengers through the use of typing in the correlating code on the seat to move the next passenger in line. For example, typing “A1 or C5” would move a passenger to seat “A1 or C5” and vice versa for the rest of the passengers and seats.

Where will you need to click? 
Menu
	- Selecting the basic line configuration you want to build on from
	- Creating leaderboard/a system where we can store time
	- Settings changes like changing the velocity of people’s movement or the time for passengers to stow their carriers?
Moving passengers
Changing the order of the line
Seating the passengers

Will you have menus that need to be navigated? What will they look like? 
The menu for the game would require options for starting the simulation and choosing how the passengers would be seated, either front to back or back to front. The menu would also require a menu to start or end the simulation, once completed.

Do actions need to be taken in a certain order?
The choosing of which order passengers should be placed in must be decided upon before the user can begin the simulation. The timer must be retaken for each test, but must as well be stored, to compare the methods of boarding passengers.

Features List (THE ONLY SECTION THAT CANNOT CHANGE LATER):
Must-have Features:
[These are features that we agree you will definitely have by the project due date. A good final project would have all of these completed. At least 5 are required. Each feature should be fully described (at least a few full sentences for each)]
 Time tracking system - Our main objective is to find the most time efficient method to board an airplane, so having time tracking system is crucial. Or at the very least we need a system that can compare 
 Interactive ways to change up individuals lining up - We believe that a game is a game when the user can actively interact with the graphic user interface the game has set up, the most important feature of that would be lining up individual passengers through something like drag and drop or keyboard input.
 Two Preset Boarding Options: The system of how the plane is boarded, from either front to back or back to front. These two options will come into play when directly compared with one another. Other options could be embedded in the options as well such as simple random, window to aisle.
 A graphical user interface that represents airplane seats. This would be a grid system, something that could be structured by 2d arrays or some form of array that could be “filled” “empty” or in the “waiting status” ( the exact status of an array to be determined)
 A set velocity (likely adjustable in the settings), time of stowing bags and the time difference taken if you decide to seat close to a window when there is a person in the same row in the aisle compared to noone interfering entering your seat(hint: it takes longer)

Want-to-have Features:
[These are features that you would like to have by the project due date, but you’re unsure whether you’ll hit all of them. A good final project would have perhaps half of these completed. At least 5 are required. Again, fully describe each.]
Increase the total number of seats 
Different dimensions of row and column see how that affects each method(different from the first bullet point as this doesn’t increase the overall seats)
 Airline classes - The traditional three travel classes on commercial planes: First Class, Business Class, and Economy Class.
 Chart that contains the time scores for each attempt made
 Find the best way to group families together while still trying to optimize time
 The exit - If you board on an airplane, you have to exit as well right? 

Stretch Features:
[These are features that we agree a fully complete version of this program would have, but that you probably will not have time to implement. A good final project does not necessarily need to have any of these completed at all. At least 3 are required. Again, fully describe each.]
Luggage time - Due to the luxuries of being varying in airline classes, some classes, such as First Class, will take longer to board due to their expensive luggage, while others like Economy, would rather have little to place on board.
Two planes - In replacement of the two options presented in the menu, the player must simultaneously run both options at the same time, on two planes, which will have the two different seating orders to test on.
Time Limit - In replacement of the timer, the user must board the plane in a certain amount of time before the flight leaves on it’s scheduled departure, with the rest of the passengers being counted as “late” for their flight. 
Seat The Passenger - When a passenger boards the plane, it is the job of the user to help these travellers reach their seats manually, as you must type the seat of which the passenger marked must go to, rather than just allow the process to go automatically.


Class List:
[This section lists the Java classes that make up the program and very briefly describes what each represents. It’s totally fine to put this section in list format and not to use full sentences.]
*Subject to change as the project progresses
Main - the main method of the whole program
Drawing Surface- responsible for GUI, interactive inputs with the user
Aircraft - class represents the airplane of the class, it's responsible for drawing the seats
Passengers - The individuals found in the boarding group
Timer - A class designed to track the time spent in boarding the groups
Seats - The setup of how the seating phase of the simulation is portrayed
Screen - The superclass that acts as level states in the program
MainScreen - The primary screen showcasing the aircraft and options able to be transversed
CreateBoardingGroupScreen - The listed options of starting the simulation to choosing the boarding pattern
QueueScreen - The set up screen for the options listed
Play - The level state of actual simulation for the program


Credits:
[Gives credit for project components. This includes both internal credit (your group members) and external credit (other people, websites, libraries). To do this:
List the group members and describe how each member contributed to the completion of the final program. This could be classes written, art assets created, leadership/organizational skills exercises, or other tasks. Initially, this is how you plan on splitting the work.

Joshua Choi: Project Idea, README, Aircraft, Drawing Surface, Seats,

Vamsee Krishna Vusuwandla: README, Drawing Surface, Timer, Passangers,  UML, Graphics art

Aryan Keskar: Drawing surface, GUI Interactive , Main, html documentation, UML, Aircraft, Passangers,  Screen (+ subclasses)

Equal share with array algorithms and the logistics of programming a boarding system as this takes up most of the project.

** subject to change


Give credit to all outside resources used. This includes downloaded images or sounds, external java libraries, parent/tutor/student coding help, etc.]
	Project idea from CGP Grey Youtube: https://www.youtube.com/watch?v=oAHbLRjF0vo
	** Subject to change as project progresses

