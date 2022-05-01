# MWTechChallenge - Specs

## Background

"Our pretended company" manufactures calculators. A new calculator is being developed and below is the
image of the prototype.

![Calculator](https://user-images.githubusercontent.com/22916910/166126645-56824a77-229e-4d61-82ba-074a2c0bff68.png)

The team adopted XP development methodology and the firmware will be written in Java.

The final product will be able to support more complex operations such as trigonometric functions (sine, cosine, tangent and their reciprocals), calculus (integrals and derivatives) as well as logarithmic functions.

## Your Task

In this iteration (the first iteration), you are going to implement some basic arithmetic operations in the calculator firmware. To allow QA team to test the calculator, you need to write a command line Java program to take the inputs as arguments.

Here are the details:
1. Operations
   - Addition
   - Subtraction
   - Multiplication
   - Division
   - Operation ::= '+' | '-' | '\*' | '\/'
2. Operands
   - Operand ::= [0-9]+[.]?[0-9]*
   - No thousands separator (i.e. ,)
3. Inputs
   - Input ::= Operand ' ' Operation ' ' Operand
4. Outputs 
   - No thousands separators required
   - Print the result to console


All work must be done using a TDD approach.

Stories to build sine and cosine functions are scheduled in the next iteration.

## CircleCI / GitHub integration

The project has been integrated with CircleCI for continuous development.
Each push to origin triggers a build on CircleCI that starts a docker container and runs the tests.

Github has also been setup to allow commits to master only through PRs, and PRs can only be merged if the build on CircleCI passes. This guarantees that whatever is pushed into master passes tests.

## Overly verbose commits

I committed every time i wrote a failing test and the related code changes to make them pass into different commits. This is to show you the TDD approach in a verifiable manner.

## Releases

Releases (PRs from feature branch to master) have been separated in logical chuncks. Each chunk provided a working functionality usable by the 'client' and it can be divided into 5 different releases:

- Addition feature;
- Subtraction;
- Multiplication;
- Division;
- Refactoring (added modularity)

Each one of these releases went through GitHub Checks integrated with CircleCI.
