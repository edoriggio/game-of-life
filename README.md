# The Game of Life

### PF2 Final Java project

Authors:  Michele Cattaneo & Edoardo Riggio

For our final project we decided to create an interactive java program to simulate the famous John Horton Conway's Game of Life.

The game is a cellular automata which rules can be condensed the following way:

- Any live cell with 2 or 3 live neighbours survives the next step ( starvation )
- Any dead cell with 3 live neighbours becomes a live cell in the next step( birth )
- All other live cells die in the next step. All other dead cells stay dead.

This cellular automata is represented by a two-dimensional grid of cells that at each step gets updated to its new state. The game considers as neighbours of a cell, all 8 surrounding cells.

For our implementation we made our grid to actually be a Torus, meaning that the first row of cells is ideally connected to the last row and the same for the first and last column.

By our implementation is however easy to modify those constraints into different ones, by implementing different sub-classes of the superclasses Neighbourhood ( define which cells are considered as neighbours or a given cell) and BorderRule ( define how the extremas of the grid are handled ).

What the user can do:

- Visualise a game with cells randomly populated with dead and alive cells.
- Stop the execution of the game and continue it at any time
- Select between 10 different speeds of execution ( from 1 step each 100ms to 1 step each 1000ms)
- Clear the current grid
- Add a bunch of predefined interesting patterns of live cells that behave in a specific manner according to the rules, at any position in the grid. The pattern will only fail to be inserted if the whole pattern can not fit the current grid or the given position is not valid. It is however possible to insert a pattern close to the extremes of the grid, the parts that do not fit will simply be redirected to the positions defined by the current BorderRule that the game is using.


