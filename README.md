# Astronaut Daily Schedule Organizer & Design Patterns Demonstration

Table of Contents

Problem Statements
Exercise 1: Design Patterns Implementation

Behavioral Design Patterns

Creational Design Patterns

Structural Design Patterns

Exercise 2: Astronaut Daily Schedule Organizer

Features
Design Patterns Used

How to Run the Code

Conclusion

Problem Statements
Exercise 1: Design Patterns Demonstration
Demonstrate six different design patterns in a creative way by coding the following:

Two Behavioral Design Patterns
Two Creational Design Patterns
Two Structural Design Patterns
Exercise 2: Astronaut Daily Schedule Organizer
Design a console-based application to help astronauts organize their daily schedules. The application allows users to add, remove, and view tasks. Each task has a description, start and end times, and a priority level. The application ensures tasks do not overlap and allows sorting by priority or start time.

Exercise 1: Design Patterns Implementation
1. Behavioral Design Patterns
1.1 Observer Pattern
Purpose: Notifies multiple objects when the state of one object changes.
Implementation:
A TaskManager holds tasks, and a User class is notified when there's a task conflict.
When a new task is added, the TaskManager checks for conflicts and notifies all users.
1.2 Strategy Pattern
Purpose: Allows choosing different algorithms at runtime.
Implementation:
An interface SortStrategy with a sort() method.
Two strategies: SortByPriority and SortByStartTime, allowing users to choose how to sort tasks.
2. Creational Design Patterns
2.1 Singleton Pattern
Purpose: Ensures only one instance of a class is created.
Implementation:
A ScheduleManager class that ensures only one instance manages all tasks.
2.2 Factory Pattern
Purpose: Provides a way to create objects without specifying the exact class.
Implementation:
A TaskFactory class to create different types of tasks based on user input.
3. Structural Design Patterns
3.1 Adapter Pattern
Purpose: Converts one interface into another.
Implementation:
A TaskAdapter allows the task system to accept tasks in various formats (like JSON or XML).
3.2 Decorator Pattern
Purpose: Dynamically adds behavior to an object.
Implementation:
A TaskDecorator adds new features (e.g., marking tasks as completed) without modifying the task’s core structure.

Exercise 2: Astronaut Daily Schedule Organizer
Features
Add Tasks: Each task has a description, start time, end time, and priority level (High, Medium, Low).
Remove Tasks: Users can remove existing tasks by description.
View Tasks: Tasks can be viewed, sorted by start time.
Conflict Detection: The system prevents tasks from overlapping.
Sorting: Tasks can be sorted by priority or start time.
Design Patterns Used:
Singleton Pattern: The ScheduleManager ensures only one instance of the task manager exists.
Factory Pattern: The TaskFactory creates different types of tasks.
Observer Pattern: The system notifies users if a new task conflicts with an existing one.
How to Run the Code
Prerequisites
Java Development Kit (JDK): Ensure you have Java installed. You can download it from here.
Git: Install Git to clone the repository and manage version control.
Steps to Run
Clone the Repository:

bash
Copy code
git clone https://github.com/your-username/your-repository-name.git
Navigate to the Project Folder:

bash
Copy code
cd your-repository-name
Compile the Code:

Use the following command to compile the Java files:
bash
Copy code
javac *.java
Run the Program:

To run the Astronaut Daily Schedule Organizer (Exercise 2), execute the following command:
bash
Copy code
java Main
Interact with the Console:

You will see a menu with options to add, remove, and view tasks.
Conclusion
This project demonstrates a practical implementation of design patterns in both a creative setup and a real-world application (Astronaut Daily Schedule Organizer). By applying behavioral, creational, and structural patterns, the system is both modular and maintainable. The project showcases the use of Observer, Strategy, Singleton, Factory, Adapter, and Decorator patterns.

For more details, refer to the code and design choices in each exercise. Feel free to modify and extend the system for additional features like editing tasks or filtering by priority.

Repository URL: https://github.com/faisalali1234567/Astronaut-Daily-Schedule-Organizer-Design-Patterns-Demonstration/edit/main/README.md
