# JavaRPN
A Reverse Polish Notation (RPN) calculator. As of now it is only usable through the Command Line Interface. Radians is the default setting. Arbitrary precision, so don't forget to set it!
## Syntax
Since this is an RPN calculator, the syntax for `(5 + 3) / (5 * 8)` would be `5 3 + 5 8 * /`. If you would like to know more about RPN, I recommend you read this [wikipedia][1] or this [tutorial][2] article.
## Installation
Just download the RPN.jar under releases and run it with `java -jar [location of jar]`. If you want to run this program as a command, go to your .bash_profile (if using Bash) or .zprofile (if using Zsh), and write:

```alias calculator='java -jar [location of jar]```

Afterwards, this program will run as any other command when you type in `calculator`.

## Commands
| command | function          |
| :-----: | :---------------- |
| exit    | exit the program  |
| p       | peek top of stack |
| c       | clear             |
| pop     | pop top of stack  |
| swap    | swap stack Y and X|
| roll    | roll stack 1 element down |
| pall    | print entire stack. First element is the Head of the stack, and last is the tail. |
| radix   | sets the calculator's radix to the value of stack X |
| prec    | sets the calculator's precision to the value of stack X |
| +       | add stack X and Y |
| -       | subtract stack X from stack Y |
| *       | multiply stack X and Y |
| /       | divide stack Y by stack X |
| ^       | raise stack Y to a power value of stack X |
| %       | stack Y modulus stack X |
| !       | Apply factorial function to X |
| rt      | stack Y to the root of stack X |
| sqrt    | square root of stack X |
| cbrt    | cube root of stack X |
| sin     | apply sin to stack X |
| cos     | apply cos to stack X |
| tan     | apply tan to stack X |
| asin    | apply asin to stack X |
| acos    | apply acos to stack X |
| atan    | apply asin to stack X |
| log     | Base 10 logarithm of X |
| ln      | Natural Logarithm of X |
| pi      | pushes pi onto the stack |
| e       | pushes the constant e to the stack |
| degree  | sets the calculator to degree mode |
| radian  | sets the calculator to radian mode |
| toDeg   | Converts X to degrees |
| toRad   | Converts X to radians |

## To Do:
- Refactor the entire program in MVC
- Add arguments functionality; i.e. calculator -r to set it to radians from the start

## Inquiries and Recommendations
If you have anything you would like to see added to this little project of mine, please email me at:

`d [dot] ribchinski [at] googlemail [dot] com`


[1]: https://en.m.wikipedia.org/wiki/Reverse_Polish_notation
[2]: https://hansklav.home.xs4all.nl/rpn/
