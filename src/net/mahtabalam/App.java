package net.mahtabalam;

public class App {
	public static void main(String[] args) {
		
	}
	public int minDistance(String word1, String word2) {
        int rows = word1.length();
        int columns = word2.length();
        
        int[][] dpTable = new int[rows+1][columns+1];
        for(int j = 0; j <= columns; j++){
            dpTable[0][j] = j;
        }
        for(int i = 0; i <= rows; i++){
            dpTable[i][0] = i;
        }
        
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dpTable[i][j] = dpTable[i-1][j-1];
                } else{
                    int min = Math.min(dpTable[i-1][j], dpTable[i][j-1]);
                    dpTable[i][j] = 1 + Math.min(min, dpTable[i-1][j-1]);
                }
            }
        }
        return dpTable[rows][columns];
        
    }
}
