# Simple Calculator

#### DESCRIPTION

Calculator program for basic Mathematical equations

### Updates on this branch
- changed (EquationSplitter) splitMultDiv and splitAddSub to look for next operands, instead of going
through every character(instead of looping, just recursion)
- split big (Operations) doOperation function into doAddSub and doMultDiv functions
- simplified some if statements
- simplified assertions in Validation Tests
- 

##### Run
run with maven or Main Class

##### Supported Features
- Command Line input
- Addition(+), Subtraction(-), Multiplication(*), Division(/) on all integers and decimals
- Nested operations
- Allowed characters >> + - / * ( ) .
- The output will be rounded to the 5th decimal or less

##### Examples
- "1+2" >>> 3
- "4*10/2" >>> 20
- "-5+-8--11*2" >>> 9
- "-.32   /.5" >>> -0.64
- "2+-+-4" >>> Syntax Error
- "89 + word" >>> Invalid Input
- "((3*.5))*(-2+2)" >> 0
- "((((3*2)))" >> Syntax Error


##### Utilizing
 - Maven
 - Java JDK 1.8
 - JUnit
