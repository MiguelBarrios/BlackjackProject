# BlackjackProject

## Description
Simple terminal-based Blackjack program. At the start of the game, both the dealer and player are dealt two cards, if either the player or the dealer has a hand with the value of 21 the game ends with a blackjack win. If not the player can choose whether to hit or stand, so long as the value of his hand is less than 21. After the player finishes his turn, the dealer plays in accordance with the rules for the dealer. After each round, the user is prompted if they would like to play another game.

## Technologies and Libraries
Java: Java is the only programming language used in this project.

Scanner: the scanner library is used to get input from the user.

List: ArrayLists are used to model the deck and cards each player has at the current time.

Collections: the shuffle method is used to randomize the order of the cards deck.



# Lessons learned 

- Method Overriding: Overriding methods in child classes can allow us to make methods more specific to the child class

- Enums: Enums allow us to predefine variables that are constant and are commonly used throughout the program. 

- Exception Handling: Try catch statements can allow our program to continue running even when a user inputs a invalid value.

- Abstraction and Inheritance: Abstraction and Inheritance allow us to create parent classes that contain variables and methods that are generic and can be utilized in applications of various domains. Inheritance gives us the ability to access all the variables and functions of the parent class and add new methods and variables to make it more specific to our application. In this application, the Hand class is the parent class and is modeled after a hand of cards, in this case, the BlackjackHand class extends this class and provides additional methods needed to model a game of blackjack. 

- OOP Design: OOP Design forces us to think about what classes are needed as well as what functionality each class should possess. Which helps us better model our application and how its classes interact with each other. 