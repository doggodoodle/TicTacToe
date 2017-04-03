# TicTacToe
Simple command line TicTacToe game, which supports changing "win" conditions by accepting a custom Evaluator interface.

Java Version: 1.8

Main class: TicTacToe.java

JAR: TicTacToe-1.0.jar (under TicTacToe/build/libs/)

The default TicTacToe program has two players X and O, playing on a 3X3 matrix.
Players alternate turns, and standard TicTacToe win conditions apply.

To enter Input: Enter space separated x and y coordinates, where the coordinates begin with 1 1. (Example: 1 1 for top left corner of the grid)

To alternate win conditions, a custom Evaluator that implements the Evaluator interface can be passed to one of the TicTacToe constructors. The overriden method evaluateResult(...) of the passed evaluator is then used for checking win conditions. 




