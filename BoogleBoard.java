import java.util.Arrays;

public class BoogleBoard {

	public static void main(String[] args) {
		BoogleBoard boggleBoard = new BoogleBoard();
		String booggleArr[][] = { { "D", "R", "F" }, 
				                  { "C", "E", "G" } };
		String word = "EG";

		System.out.println("Start");
		System.out.println("end:" + checkBoogleBoard(booggleArr, word));

	}

	public static boolean checkBoogleBoard(String[][] booggleArr, String word) {
		boolean letterFound = false;
		char letter;
		char[] wordArr = word.toCharArray();
        int letterIndex = 0;
		//for (int w = 0; w < wordArr.length; w++) {
			letter = wordArr[letterIndex];
			
            //first found where in the matrix to start
			for (int x = 0; x < booggleArr.length; x++) {
				for (int y = 0; y < booggleArr[x].length; y++) {
					if (booggleArr[x][y].equals(Character.toString(letter))) {
						System.out.println("got Letter:" + letter + " w=" + letterIndex);
						letterFound = true;
						booggleArr[x][y] = "~";
						if (letterIndex + 1 < wordArr.length) // not the last digit of the word
							letterFound = checkNeighbours(x, y, wordArr[letterIndex + 1], booggleArr);
					}
				}

			}
		//}
		return letterFound;
	}

	public static boolean checkNeighbours(int x, int y, char letter, String[][] booggleArr) {
		System.out.println("x=" + x + "  y=" + y + " letter=" + letter);
		for (int x1 = 0; x1 < booggleArr.length; x1++) {
			for (int y1 = 0; y1 < booggleArr[x1].length; y1++) {
				System.out.print(booggleArr[x1][y1] + ", ");
			}
			System.out.println();
		}
		if(x + 1 < booggleArr.length ) System.out.println("Checking neighbour 1: "+ booggleArr[x + 1][y]);
		if (x + 1 < booggleArr.length && booggleArr[x + 1][y].equals(Character.toString(letter))) {
			System.out.println("found neigbour: " + booggleArr[x + 1][y]);
			return true;
		}
		
		if(x > 0) System.out.println("Checking neighbour 2: "+ booggleArr[x-1][y]);
		if (x > 0 && booggleArr[x - 1][y].equals(Character.toString(letter))) {
			System.out.println("found neigbour: " + booggleArr[x - 1][y]);
			return true;
		}
		
		if(y + 1 < booggleArr[x].length) System.out.println("Checking neighbour 3: "+ booggleArr[x][y + 1]);
		if (y + 1 < booggleArr[x].length && booggleArr[x][y + 1].equals(Character.toString(letter))) {
			System.out.println("found neigbour: " + booggleArr[x][y + 1]);
			return true;
		}
		
		if(y > 0 )	System.out.println("Checking neighbour 4: "+ booggleArr[x][y - 1]);
		if (y > 0 && booggleArr[x][y - 1].equals(Character.toString(letter))) {
			System.out.println("found neigbour: " + booggleArr[x][y - 1]);
			return true;
		}

		return false;

	}

}
