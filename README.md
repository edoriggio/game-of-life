# The Game of Life

## PF2 Final Java project

Authors:  Michele Cattaneo & Edoardo Riggio

For our final project we decided to create an interactive java program to simulate the famous John Horton Conway's Game of Life.

The game is a cellular automata which rules can be condensed the following way:

- Any live cell with 2 or 3 live neighbours survives the next step (starvation)
- Any dead cell with 3 live neighbours becomes a live cell in the next step (birth)
- All other live cells die in the next step. All other dead cells stay dead.

This cellular automata is represented by a two-dimensional grid of cells that at each step gets updated to its new state. The game considers as neighbours of a cell, all 8 surrounding cells.

For our implementation we made our grid to actually be a Torus, meaning that the first row of cells is ideally connected to the last row and the same for the first and last column.

By our implementation is however easy to modify those constraints into different ones, by implementing different sub-classes of the superclasses Neighbourhood define which cells are considered as neighbours or a given cell) and BorderRule (define how the extremas of the grid are handled).

### Screenshots

![screen#1](/imgs/screen#1.png)
![screen#2](/imgs/screen#2.gif)

### What the user can do

- Visualise a game with cells randomly populated with dead and alive cells.
- Stop the execution of the game and continue it at any time
- Select between 10 different speeds of execution (from 1 step each 100ms to 1 step each 1000ms)
- Clear the current grid
- Add a bunch of predefined interesting patterns of live cells that behave in a specific manner according to the rules, at any position in the grid. The pattern will only fail to be inserted if the whole pattern can not fit the current grid or the given position is not valid. It is however possible to insert a pattern close to the extremes of the grid, the parts that do not fit will simply be redirected to the positions defined by the current BorderRule that the game is using.

#### How to run it

Go to the folder containing the compiled files (.class):

```shell
cd target/classes
```

Run the Main class giving inputs in that order: **number of rows, number of columns, cell size**.

```shell
java src.main.java.Main 50 50 10
```

This will result in a new frame of the Game of Life popping up with 50 rows, 50 columns and the cell size of 10 pixels

Alternatively you can also not give any inputs like so:

```shell
java src.main.java.Main
```

There will be a message showing in the terminal asking to provide the inputs, which you can give in a single row or one by one.

If the number of inputs is not 3 or the inputs are invalid, the game will have some default values for the number of row, columns and the size of the pixel.
