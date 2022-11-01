# Linter

## Index

[Home](../../README.md)

## The Linter

The linter is designed to check for text errors in a given file. Spcifically it is designed to look for missing ; at the end of an expression. A few rules apply to the linters behavior:

```
If a line doesn't end with ";" then  

1. does it contain "if"? Then ignore this line.
2. does it contain "else"? Then ignore this line.
3. does it end with "{"? Then ignore this line.
4. does it end with "}"? Then ignore this line.
5. is the line empty? Then ignore this line.

Otherwise, throw an error stating the line is missing an ";".
```