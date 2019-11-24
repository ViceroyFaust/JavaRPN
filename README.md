# JavaRPN
A CLI based RPN calculator. Inspired by Unix dc, but supports decimals.

## Syntax
Since this is an RPN calculator, the syntax for "(5 + 3) / (5 * 8)" would be "5 3 + 5 8 * /". If you would like to know more about RPN, I recommend you read this [wikipedia][1] or this [tutorial][2] article.

## Commands
| command | function          |
| :-----: | :---------------: |
| e       | exit              |
| p       | peek top of stack |
| c       | clear             |
| pop     | pop top of stack  |
| swap    | swap stack 2 and 1|
| roll    | roll stack 1 element down |
| pall    | print entire memory. First element is the Head of the stack, and last is the tail. |
| +       | add stack 2 and 1 |
| -       | subtract stack 1 from stack 2 |
| *       | multiply stack 2 and 1 |
| /       | divide stack 2 by stack 1 |
| ^       | raise stack 2 to a power value of stack 1 |
| %       | stack 2 modulus stack 1 |
| *%      | Multiplies stack 1 by 100 |
| rt      | stack 2 to the root of stack 1 |
| sqrt    | square root of stack 1 |
| cbrt    | cube root of stack 1 |
| sin     | apply sin to stack 1 in degrees |
| cos     | apply cos to stack 1 in degrees |
| tan     | apply tan to stack 1 in degrees |
| asin    | apply asin to stack 1 in degrees |
| acos    | apply acos to stack 1 in degrees |
| atan    | apply asin to stack 1 in degrees |

## To Do:
- Add the factorial function
- Add logarithms (including natural logs)
- Add "save to memory" function
- Add Radian support
- Add Scientific Notation support

## Inquiries and Recommendations
If you have anything you would like to see added to this little project of mine, please email me at:

`d [dot] ribchinski [at] google mail [dot] com`


[1]: https://en.m.wikipedia.org/wiki/Reverse_Polish_notation
[2]: https://hansklav.home.xs4all.nl/rpn/
