# JavaRPN
A CLI based RPN calculator. Inspired by Unix dc, but supports decimals.

## Syntax
Since this is an RPN calculator, the syntax for "(5 + 3) / (5 * 8)" would be "5 3 + 5 8 * /". If you would like to know more about RPN, I recommend you read [this][1] article.

## Commands
| command | function          |
| :-----: | :---------------: |
| e       | exit              |
| p       | peek top of stack |
| c       | clear             |
| pop     | pop top of stack  |
| swap    | swap stack 2 and 1|
| +       | add stack 2 and 1 |
| -       | subtract stack 1 from 2 |
| *       | multiply stack 2 and 1 |
| /       | divide stack 2 and 1 |
| ^       | raise stack 2 to a power value of 1 |
| sin     | apply sin to stack 1 in degrees |
| cos     | apply cos to stack 1 in degrees |
| tan     | apply tan to stack 1 in degrees |
| asin    | apply asin to stack 1 in degrees |
| acos    | apply acos to stack 1 in degrees |
| atan    | apply asin to stack 1 in degrees |

## To Do:
- Add square root and cube root functions
- Add a roll feature, meaning the user can "roll" the stacks down
- Add a percent feature
- Add the factorial function
- Add logarithms (including natural logs)
- Add "save to memory" function
- Add a modulus operation
- Add Radian support
- Add Scientific Notation support

## Inquiries and Recommendations
If you have anything you would like to see added to this little project of mine, please email me at:

`d [dot] ribchinski [at] google mail [dot] com`


[1]: https://en.m.wikipedia.org/wiki/Reverse_Polish_notation
