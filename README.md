# Java Console Pacman

This is a simple console based Pacman game made in Java. It is designed to practice basic object oriented programming, grid based movement, and simple game loop logic.

## Game Features

* A 10x10 grid based board using a 2D array
* Player moves using W, A, S, D keys
* Game entities:
    * P (Pacman): controlled by the player
    * G (Ghost): moves randomly
    * F (Food): Food to collect for score
* Win condition: collect all 3 food items
* Lose condition: if ghost catches Pacman

## Project Classes

* Game.java: main file that runs the game loop
* GameBoard.java: handles the grid and displays the board
* Pacman.java: controls player position and movement
* Ghost.java: controls random movement of ghost
* Food.java: stores food positions and checks if collected

## How to Run

1. Open the project in IntelliJ
2. Go to the src folder
3. Run Game.java
4. Use W, A, S, D to move and press Enter after each input

## Current Status

* Movement is input based
* Ghost moves randomly to make the game challenging
* Basic win and lose conditions are implemented
