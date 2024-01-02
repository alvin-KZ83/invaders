# README for Invaders API
## Introduction
The Invaders API is a powerful tool designed to assist developers in creating a space-themed shoot 'em up game. It offers a range of customization options to tailor the gaming experience. From setting player and enemy images to configuring game levels and bullet types, this API provides the flexibility and functionality required to build a dynamic and engaging game.

## Features
Customization: Methods for customizing player and enemy attributes, including images, lives, bullet types, and more.
Level Control: Options to set the level size, background, delay times for player and enemy actions, and scoring system.
Game Text Customization: Ability to set text and color for game over messages and score displays.

## API Usage
### setPlayerImage(String imgLocation)
#### Description: Sets the image for the player's ship.
Parameters: imgLocation - Name of the image file (e.g., "image.png").
Usage: Image must be in the images folder.
### setPlayerImageURL(String url)
#### Description: Sets the image for the player's ship using a web URL.
Parameters: url - URL for the image (e.g., "https://media.com/image.jpg").
### setPlayerLives(int lives)
#### Description: Sets the number of lives for the player.
Parameters: lives - Number of lives.
### setPlayerBullet(String type)
#### Description: Sets the type of the player's bullet.
Parameters: type - Bullet type ("normal" or "pierce").
Details:
Normal: Destroyed upon impact.
Pierce: Not destroyed upon impact.
Default: Normal bullet.
### setEnemyAmount(int amount)
#### Description: Sets the max number of enemies in a level.
Parameters: amount - Number of enemies (0 for infinite spawn).
### setEnemyDelay(double delay)
#### Description: Sets the time between enemy spawns.
Parameters: delay - Time in seconds.
### setEnemyImage(String imgLocation)
#### Description: Sets the image for the enemy's ship.
Parameters: imgLocation - Name of the image file.
### setEnemyImageURL(String url)
#### Description: Sets the enemy ship image using a web URL.
Parameters: url - URL for the image.
### setEnemyLives(int lives)
#### Description: Sets the number of lives for the enemy.
Parameters: lives - Number of lives.
### setEnemyPoints(int points)
#### Description: Sets points for destroying an enemy.
Parameters: points - Number of points.
### setSeekerDelay(double delay)
#### Description: Sets the time between seeker bullet spawns.
Parameters: delay - Time in seconds.
### setSeekerPoints(int points)
#### Description: Sets points for destroying a seeker bullet.
Parameters: points - Number of points.
### setBackground(String imgLocation)
#### Description: Sets the background image for the level.
Parameters: imgLocation - Name of the image file.
### setBackgroundURL(String url)
#### Description: Sets the level background using a web URL.
Parameters: url - URL for the image.
### setLevelSize(double width, double height)
#### Description: Sets the size of the level.
Parameters: width, height - Dimensions of the level.
### setLevelDelay(double delay)
#### Description: Sets the delay for shooting actions.
Parameters: delay - Time in seconds.
### setScoreColor(Color color)
#### Description: Sets the color of the score text.
Parameters: color - Desired color.
### setHighscoreColor(Color color)
#### Description: Sets the color of the high score text.
Parameters: color - Desired color.
### setGameTextColor(Color color)
#### Description: Sets the color of the game over text.
Parameters: color - Desired color.
### setGameText(String text)
#### Description: Sets the text displayed when the player dies.
Parameters: text - Desired text.

## Packages
Template: Contains a template file and an example program demonstrating the API's use.
# Note: Only the Template package should be altered.
For a detailed description of all the methods and their usage, refer to the full API documentation. This README provides just an overview of the API's capabilities and is meant to get you started on integrating it into your game development project.
