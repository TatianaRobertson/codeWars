import java.util.Arrays;

public class BoogleBoard {

	public static void main(String[] args) {
		BoogleBoard boggleBoard = new BoogleBoard();
		String booggleArr[][] = { {"I","L","A","W"},
				                  {"B","N","G","E"},
				                  {"I","U","A","O"},
				                  {"A","S","R","L"} };
		String word = "EGT";

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
				//		letterFound = true;
						booggleArr[x][y] = "~";
						if (letterIndex + 1 < wordArr.length) {// not the last digit of the word
							letterFound = checkNeighbours(x, y, booggleArr, wordArr, letterIndex+1 );
							break;    //remove the break if more than one start is possible
						}
					}
				}

			}
		//}
		return letterFound;
	}

	public static boolean checkNeighbours(int x, int y, String[][] booggleArr, char[] wordArr, int letterIndex ) {
		boolean neighbourFound = false;
		char letter = wordArr[letterIndex];
		System.out.println("letterIndex="+letterIndex+" wordArr= "+ wordArr.toString());
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
			booggleArr[x + 1][y] = "~";
			neighbourFound = true;
			if (letterIndex + 1 < wordArr.length) // not the last digit of the word
			  checkNeighbours(x + 1, y, booggleArr,wordArr, letterIndex+1);
			else
				return neighbourFound;
		}
		
		if(x > 0) System.out.println("Checking neighbour 2: "+ booggleArr[x-1][y]);
		if (x > 0 && booggleArr[x - 1][y].equals(Character.toString(letter))) {
			System.out.println("found neigbour: " + booggleArr[x - 1][y]);
			booggleArr[x - 1][y] = "~";
			neighbourFound = true;
			if (letterIndex + 1 < wordArr.length) // not the last digit of the word
			  checkNeighbours(x - 1, y, booggleArr,wordArr, letterIndex+1);
			else 
				return neighbourFound;
		}
		
		if(y + 1 < booggleArr[x].length) System.out.println("Checking neighbour 3: "+ booggleArr[x][y + 1]);
		if (y + 1 < booggleArr[x].length && booggleArr[x][y + 1].equals(Character.toString(letter))) {
			System.out.println("found neigbour: " + booggleArr[x][y + 1]);
			booggleArr[x][y + 1] = "~";
			neighbourFound = true;
			if (letterIndex + 1 < wordArr.length) // not the last digit of the word
			  checkNeighbours(x, y + 1, booggleArr,wordArr, letterIndex+1);
			else
				return neighbourFound;
		}
		
		if(y > 0 )	System.out.println("Checking neighbour 4: "+ booggleArr[x][y - 1]);
		if (y > 0 && booggleArr[x][y - 1].equals(Character.toString(letter))) {
			System.out.println("found neigbour: " + booggleArr[x][y - 1]);
			booggleArr[x][y - 1] = "~";
			neighbourFound = true;
			if (letterIndex + 1 < wordArr.length) // not the last digit of the word
			  checkNeighbours(x,y - 1, booggleArr,wordArr, letterIndex+1);
			else
				return neighbourFound;					
		}

		return neighbourFound;

	}

}
