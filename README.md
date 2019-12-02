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

### Dynamic Programming : Bottom-Up (Tabulation) Approach 
We start filling the dpTable, row by row, and we fill all the columns in a single row, before moving to next row. By doing this we are solving the subproblems, which will help us, to get to the result of our actual problem.

If string1 is empty, then it will take as many insertion operations as the length of the second string (string2), to make string1 equal to string2. So the values in first row, will increment by 1 at each cell because the length of second string (string2) is increasing by 1 with each column. 


```java
public class App {
	public static void main(String[] args) {
		System.out.println("Edit Distance :" + minDistance("abc", "cbad"));
	}

	public static int minDistance(String word1, String word2) {
		int rows = word1.length();
		int columns = word2.length();

		int[][] dpTable = new int[rows + 1][columns + 1];
		for (int j = 0; j <= columns; j++) {
			dpTable[0][j] = j;
		}
		for (int i = 0; i <= rows; i++) {
			dpTable[i][0] = i;
		}

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dpTable[i][j] = dpTable[i - 1][j - 1];
				} else {
					int min = Math.min(dpTable[i - 1][j], dpTable[i][j - 1]);
					dpTable[i][j] = 1 + Math.min(min, dpTable[i - 1][j - 1]);
				}
			}
		}
		return dpTable[rows][columns];
	}
}


```
