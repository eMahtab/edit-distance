# Edit Distance - Levenshtein distance
Given two strings string1 and string2, find the minimum number of operations required to convert string1 to string2.

You have the following 3 operations permitted on a string:

1. Insert a character
2. Delete a character
3. Replace a character

e.g.
Input: string1 = "horse", string2 = "ros"

Output: 3

Explanation: 

horse -> rorse (replace 'h' with 'r')

rorse -> rose (remove 'r')

rose -> ros (remove 'e')

## Solution
We can solve this problem using Dynamic Programming

If string1 is empty, then it will take as many insertion operations as the length of the second string string2, to make string1 equal to string2.


