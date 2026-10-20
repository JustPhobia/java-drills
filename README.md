# java-drills

A grab-bag of small Java exercises from the fundamentals stage of learning —
grouped by topic. Most files have their own `main` and run independently.

> Built within my first ~4–5 months of learning Java (a coding course). Kept as a record of progress, not as polished production code.

## Contents
- `src/Module1/Arrays` — array exercises (sum, average, reverse, dedupe, sort…)
- `src/Module1/Strings` — string exercises (Roman numerals, pig latin,
  StringBuilder…)
- `src/Module1/BasicJava` — basics (BMI, factorial, Fibonacci, FizzBuzz,
  hangman, quadratic…)
- `src/Module2/GenericLearning` — Java generics (`Box`, utilities)
- `src/Module3/InputOutput/Exercises` — file I/O drills
- `src/Module3/InputOutput/PracticeActivities` — a small bank-persistence
  **library** (no `main`; `schema.sql` included)
- `src/Module3/InputOutput/Projects/VirtualPetShelter` — an unfinished **stub**
- `src/JumpStatementsDemo.java` — break / continue / return teaching demo

## Run (example)
```bash
find src -name '*.java' | xargs javac -d out
java -cp out Module1.BasicJava.FizzBuzz_LoopsExe
```

## Flags
`PracticeActivities` is a library (no entry point) and `VirtualPetShelter` is a
one-class stub — both compile but are not finished programs.
