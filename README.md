# Simple Calculator

Simple Calculator/Interpreter in Java to demonstrate basic OOP principles and program design.

## How to run:

Clone the repo, and run the command:
```
./run.sh
```

This will compile and run the program:
```
Welcome to the calculator. Enter an expression and press Return at the prompt:
> let x = 10 + 4
14
> let y = x * 2
28
> 200 + y - x
214
> exit
Bye!
```

## Features and limitations:

- Supports basic arithmetic operations like: `3 * 500 / 20 + 10`
- Supports variables assignment:`let x = 10 * 2` and use: `3 + x / 2`
- Strict syntax that requires a single space between each pair of tokens (e.g. `3+ 2` is **invalid syntax**)
- Operations are evaluated left to right with **no regard for operator precedence** (i.e. `3 + 2 * 3` will return 15 instead 9)
- No robust error handling