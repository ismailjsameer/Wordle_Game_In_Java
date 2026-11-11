# Offbrand Wordle

A simple command-line Wordle game written in Java.

## Requirements

- Java Development Kit (JDK)
- `solutions.txt` and `nonsolutions.txt` in the same directory as the program

The word files must contain one lowercase, five-letter word per line:

```text
cigar
rebut
sissy
```

`solutions.txt` supplies possible answers. `nonsolutions.txt` supplies additional valid guesses.

## Run the game

From this directory, compile the program:

```bash
javac WordleGame.java
```

Then start it with:

```bash
java WordleGame
```

To run the duplicate-letter scoring checks:

```bash
javac WordleGame.java WordleGameTest.java
java WordleGameTest
```

## How to play

- Enter a valid five-letter word when prompted.
- You have five guesses.
- `🟩` means a letter is in the correct position.
- `🟨` means a letter is in the answer but in the wrong position.
- `⬛` means a letter is not in the answer.
- Enter `giveanswer` to reveal the current answer.
- After a round, enter `y` or `yes` to play again; enter anything else to quit.

## Project files

- `WordleGame.java` - game logic and command-line interface
- `WordleGameTest.java` - duplicate-letter scoring checks
- `solutions.txt` - possible answer words
- `nonsolutions.txt` - additional accepted guesses
