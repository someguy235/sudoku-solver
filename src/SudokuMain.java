//import javax.swing.*;
//import java.util.Map;
//import java.util.HashMap;
//import java.util.ArrayList;
//import java.util.List;
//import java.awt.*;
//import java.SudokuSquare.*;



public class SudokuMain {
	
	public static void main(String[] args) {
		Puzzle puzzle = new Puzzle();
		
		/*
		JFrame p = new SudokuMain();
		p.setVisible(true);
		
		SudokuSquare square = new SudokuSquare();
		p.add(square);
		p.pack();
		*/

		makePuzzle(puzzle);
		printPuzzle(puzzle);
		
		if (solvePuzzle(puzzle)){//puzzle is broken
			System.out.println("Collision");
		}else{
			System.out.println("Solved");
			//printPuzzle(puzzle);
		}
	}
	
	/*
	public SudokuMain(){
		setLayout(new BorderLayout(5, 5));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sudoku");
        setSize(100, 100);
        setLocationRelativeTo(null);  // Center window.
		pack();
	}
	*/
	
	/*
	public int[] SudokuSquare(){
		int[] values = new int[10];
		JPanel square = new JPanel();
		return values;
	}
	*/

	private static void printPuzzle(Puzzle puzzle){
		System.out.println("-----------------------------");
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(puzzle.getValue(j, i, 0)==0)
					System.out.print("[_]");
				else
					System.out.print("["+ puzzle.getValue(j, i, 0)+"]");
				if(j==2 || j==5)
					System.out.print(" ");
			}
			if (i==2 || i==5)
				System.out.println();
			System.out.println();
		}
		System.out.println("-----------------------------");
	}
	
	private static void makePuzzle(Puzzle puzzle){
		
		//build the empty puzzle
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				for(int k=0;k<11;k++){
					puzzle.setValue(i, j, k, k);
					if (k==10)
						//start with 9 possible solutions per square
						puzzle.setValue(i, j, k, 9);
				}
			}
		}
		/*
		int[][] puzzleArray = {
				{8,0,1, 0,0,4, 0,0,0},
				{0,0,0, 0,6,0, 0,5,0},
				{3,0,2, 7,0,0, 0,0,6},
				
				{0,9,0, 0,4,0, 0,0,7},
				{2,0,0, 3,0,9, 0,0,5},
				{1,0,0, 0,5,0, 0,2,0},
				
				{6,0,0, 0,0,7, 4,0,2},
				{0,7,0, 0,8,0, 0,0,0},
				{0,0,0, 6,0,0, 3,0,9},
		};
		*/
		/*
		int[][] puzzleArray = {
				{0,0,0, 0,0,0, 0,0,0},
				{0,0,0, 0,0,0, 0,0,0},
				{0,0,0, 0,0,0, 0,0,0},
				
				{0,0,0, 0,0,0, 0,0,0},
				{0,0,0, 0,0,0, 0,0,0},
				{0,0,0, 0,0,0, 0,0,0},
				
				{0,0,0, 0,0,0, 0,0,0},
				{0,0,0, 0,0,0, 0,0,0},
				{0,0,0, 0,0,0, 0,0,0},
		};
		*/		
		int[][] puzzleArray = {
				{0,5,0, 0,3,0, 0,7,0},
				{0,0,0, 1,0,8, 0,0,0},
				{6,2,0, 0,0,0, 0,9,8},
				
				{1,0,0, 0,0,0, 0,0,2},
				{7,0,5, 4,0,2, 6,0,1},
				{0,0,2, 0,0,0, 7,0,0},
				
				{0,0,0, 8,0,7, 0,0,0},
				{0,0,4, 0,0,0, 9,0,0},
				{0,6,0, 5,0,4, 0,2,0},
		};

		//maually add the starting numbers, for now
		puzzle.setValue(0, 0, 0, (puzzleArray[0][0]));
		puzzle.setValue(0, 1, 0, (puzzleArray[1][0]));
		puzzle.setValue(0, 2, 0, (puzzleArray[2][0]));
		puzzle.setValue(0, 3, 0, (puzzleArray[3][0]));
		puzzle.setValue(0, 4, 0, (puzzleArray[4][0]));
		puzzle.setValue(0, 5, 0, (puzzleArray[5][0]));
		puzzle.setValue(0, 6, 0, (puzzleArray[6][0]));
		puzzle.setValue(0, 7, 0, (puzzleArray[7][0]));
		puzzle.setValue(0, 8, 0, (puzzleArray[8][0]));
		
		puzzle.setValue(1, 0, 0, (puzzleArray[0][1]));
		puzzle.setValue(1, 1, 0, (puzzleArray[1][1]));
		puzzle.setValue(1, 2, 0, (puzzleArray[2][1]));
		puzzle.setValue(1, 3, 0, (puzzleArray[3][1]));
		puzzle.setValue(1, 4, 0, (puzzleArray[4][1]));
		puzzle.setValue(1, 5, 0, (puzzleArray[5][1]));
		puzzle.setValue(1, 6, 0, (puzzleArray[6][1]));
		puzzle.setValue(1, 7, 0, (puzzleArray[7][1]));
		puzzle.setValue(1, 8, 0, (puzzleArray[8][1]));
		
		puzzle.setValue(2, 0, 0, (puzzleArray[0][2]));
		puzzle.setValue(2, 1, 0, (puzzleArray[1][2]));
		puzzle.setValue(2, 2, 0, (puzzleArray[2][2]));
		puzzle.setValue(2, 3, 0, (puzzleArray[3][2]));
		puzzle.setValue(2, 4, 0, (puzzleArray[4][2]));
		puzzle.setValue(2, 5, 0, (puzzleArray[5][2]));
		puzzle.setValue(2, 6, 0, (puzzleArray[6][2]));
		puzzle.setValue(2, 7, 0, (puzzleArray[7][2]));
		puzzle.setValue(2, 8, 0, (puzzleArray[8][2]));
		
		puzzle.setValue(3, 0, 0, (puzzleArray[0][3]));
		puzzle.setValue(3, 1, 0, (puzzleArray[1][3]));
		puzzle.setValue(3, 2, 0, (puzzleArray[2][3]));
		puzzle.setValue(3, 3, 0, (puzzleArray[3][3]));
		puzzle.setValue(3, 4, 0, (puzzleArray[4][3]));
		puzzle.setValue(3, 5, 0, (puzzleArray[5][3]));
		puzzle.setValue(3, 6, 0, (puzzleArray[6][3]));
		puzzle.setValue(3, 7, 0, (puzzleArray[7][3]));
		puzzle.setValue(3, 8, 0, (puzzleArray[8][3]));
		
		puzzle.setValue(4, 0, 0, (puzzleArray[0][4]));
		puzzle.setValue(4, 1, 0, (puzzleArray[1][4]));
		puzzle.setValue(4, 2, 0, (puzzleArray[2][4]));
		puzzle.setValue(4, 3, 0, (puzzleArray[3][4]));
		puzzle.setValue(4, 4, 0, (puzzleArray[4][4]));
		puzzle.setValue(4, 5, 0, (puzzleArray[5][4]));
		puzzle.setValue(4, 6, 0, (puzzleArray[6][4]));
		puzzle.setValue(4, 7, 0, (puzzleArray[7][4]));
		puzzle.setValue(4, 8, 0, (puzzleArray[8][4]));
		
		puzzle.setValue(5, 0, 0, (puzzleArray[0][5]));
		puzzle.setValue(5, 1, 0, (puzzleArray[1][5]));
		puzzle.setValue(5, 2, 0, (puzzleArray[2][5]));
		puzzle.setValue(5, 3, 0, (puzzleArray[3][5]));
		puzzle.setValue(5, 4, 0, (puzzleArray[4][5]));
		puzzle.setValue(5, 5, 0, (puzzleArray[5][5]));
		puzzle.setValue(5, 6, 0, (puzzleArray[6][5]));
		puzzle.setValue(5, 7, 0, (puzzleArray[7][5]));
		puzzle.setValue(5, 8, 0, (puzzleArray[8][5]));
		
		puzzle.setValue(6, 0, 0, (puzzleArray[0][6]));
		puzzle.setValue(6, 1, 0, (puzzleArray[1][6]));
		puzzle.setValue(6, 2, 0, (puzzleArray[2][6]));
		puzzle.setValue(6, 3, 0, (puzzleArray[3][6]));
		puzzle.setValue(6, 4, 0, (puzzleArray[4][6]));
		puzzle.setValue(6, 5, 0, (puzzleArray[5][6]));
		puzzle.setValue(6, 6, 0, (puzzleArray[6][6]));
		puzzle.setValue(6, 7, 0, (puzzleArray[7][6]));
		puzzle.setValue(6, 8, 0, (puzzleArray[8][6]));
		
		puzzle.setValue(7, 0, 0, (puzzleArray[0][7]));
		puzzle.setValue(7, 1, 0, (puzzleArray[1][7]));
		puzzle.setValue(7, 2, 0, (puzzleArray[2][7]));
		puzzle.setValue(7, 3, 0, (puzzleArray[3][7]));
		puzzle.setValue(7, 4, 0, (puzzleArray[4][7]));
		puzzle.setValue(7, 5, 0, (puzzleArray[5][7]));
		puzzle.setValue(7, 6, 0, (puzzleArray[6][7]));
		puzzle.setValue(7, 7, 0, (puzzleArray[7][7]));
		puzzle.setValue(7, 8, 0, (puzzleArray[8][7]));
		
		puzzle.setValue(8, 0, 0, (puzzleArray[0][8]));
		puzzle.setValue(8, 1, 0, (puzzleArray[1][8]));
		puzzle.setValue(8, 2, 0, (puzzleArray[2][8]));
		puzzle.setValue(8, 3, 0, (puzzleArray[3][8]));
		puzzle.setValue(8, 4, 0, (puzzleArray[4][8]));
		puzzle.setValue(8, 5, 0, (puzzleArray[5][8]));
		puzzle.setValue(8, 6, 0, (puzzleArray[6][8]));
		puzzle.setValue(8, 7, 0, (puzzleArray[7][8]));
		puzzle.setValue(8, 8, 0, (puzzleArray[8][8]));
				
		//find squares that start with an answer
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if (puzzle.getValue(i, j, 0) != 0){ //i.e. has an answer
					puzzle.setValue(i, j, 10, 1); //solved squares have no options left
					puzzle.decrementUnsolved(); //one less square to solve for
				}
			}
		}
	}
	
	private static boolean solvePuzzle(Puzzle puzzle){
		boolean collision = false; //used for recursion
		int[] targetCell; //square we're trying to solve
		boolean madeProgress = true; //did this round of tests move forward, or do we have to guess
		
		while((madeProgress == true)&&(collision == false)&&(puzzle.getUnsolvedCount()>0)){
			madeProgress = false;//not yet
			for(int col=0;col<9;col++){//formerly i
				for(int row=0;row<9;row++){//formerly j
					targetCell = puzzle.getCell(col, row);
					if(targetCell[0]==0){ //cell is unsolved, maybe need to change
						madeProgress = testRow(puzzle, targetCell, row, madeProgress);
						madeProgress = testCol(puzzle, targetCell, col, madeProgress);
						madeProgress = testArea(puzzle, targetCell, row, col, madeProgress);
						
						//check for collision (wrong guess)
						if(targetCell[10]==0){
							collision = true;
						}//otherwise check for only 1 answer
						else if(targetCell[10]==1){ //1 remaining answer
							int temp = 1;
							while(targetCell[temp]==0){ //while not the remaining answer
								temp++;
							}
							targetCell[0] = temp; //found this square's answer
							puzzle.decrementUnsolved();
						}
					}
				}
			}
			System.out.println("Progress: (unsolved: " + puzzle.getUnsolvedCount() + ")");
			printPuzzle(puzzle); //prints each full step of solving
		}
		if (collision){//this guess (or puzzle) is wrong
		}
		else if (puzzle.getUnsolvedCount()>0){//otherwise start guessing
			//System.out.println("Guessing...");
			//printPuzzle(puzzle);
			int numberOfGuessables = 0;
			int[] guessCellLocation = {0, 0}; //
			int[] guessCellValues = new int[9];
			Puzzle tempPuzzle = new Puzzle();
			
			//find a square with the fewest possible answers (2 if possible)
			//System.out.println("Unsolved Count:" + puzzle.getUnsolvedCount());
			guessCellLocation = findGuessableCell(puzzle);
			//System.out.print("{" + guessCellLocation[0] + ", " + guessCellLocation[1] + "}");
			
			for (int i=1;i<10;i++){//find all possible answers for this square
				if(puzzle.getValue(guessCellLocation[0], guessCellLocation[1], i) != 0){
					guessCellValues[numberOfGuessables] = 
									puzzle.getValue(guessCellLocation[0], 
													guessCellLocation[1], i);
					//System.out.print(" " + guessCellValues[numberOfGuessables]);
					numberOfGuessables++;
				}
			}
			//System.out.println(" # of Guessables: " + numberOfGuessables);
			//guess one
			int currentGuessIndex = 0; //which of the possible answers we are guessing
			boolean foundCorrectGuess = false;
			while((currentGuessIndex < numberOfGuessables)&&(foundCorrectGuess == false)){
				//tempPuzzle = (Puzzle) puzzle.clone();
				try{
					tempPuzzle = puzzle.deepCopy(puzzle);
					//apply the guess answer
					
					tempPuzzle.setValue(guessCellLocation[0],  
										guessCellLocation[1], 0, 
										guessCellValues[currentGuessIndex]);
					//possible answers in the test square becomes 1
					tempPuzzle.setValue(guessCellLocation[0], 
										guessCellLocation[1], 10, 1); 
					tempPuzzle.decrementUnsolved();
					//System.out.println("State before recurse:");
					//printPuzzle(puzzle);
					//printPuzzle(tempPuzzle);
					//System.out.println("Recursing...guess is " + guessCellValues[currentGuessIndex]);
					collision = solvePuzzle(tempPuzzle);
					if (!collision){
						puzzle = tempPuzzle;
						foundCorrectGuess = true;
						//System.out.println("Guessed right!");
					}
					else{
						//System.out.println("Guess failed");
						currentGuessIndex++;
					}
				}catch(Exception e){
					System.out.println("Exception!");
				}
			}
		}
		return collision;
	}
	
	private static boolean testRow(Puzzle puzzle, int[] targetCell, int row, boolean madeProgress){
		int testValue = 0;
		for(int k=0;k<9;k++){//for each square in this row
			testValue = puzzle.getValue(k, row, 0);
			if (testValue != 0){
				if (targetCell[testValue]!=0){
					targetCell[testValue]=0;
					targetCell[10]--;
					madeProgress = true;
				}
			}
		}
		return madeProgress;
	}
	
	private static boolean testCol(Puzzle puzzle, int[] targetCell, int col, boolean madeProgress){
		int testValue = 0;
		for(int k=0;k<9;k++){//for each square in this column
			testValue = puzzle.getValue(col, k, 0);
			if (testValue != 0){
				if (targetCell[testValue]!=0){
					targetCell[testValue]=0;
					targetCell[10]--;
					madeProgress = true;
				}
			}
		}
		return madeProgress;
	}
	
	private static boolean testArea(Puzzle puzzle, int[] targetCell, int row, int col, boolean madeProgress){
		//for each square in this 3x3 area
		int testValue = 0;
		int xstart = 0;
		if (row==3 || row==4 || row==5)
			xstart = 3;
		else if (row==6 || row==7 || row==8)
			xstart = 6;
		int ystart = 0;
		if (col==3 || col==4 || col==5)
			ystart = 3;
		else if (col==6 || col==7 || col==8)
			ystart = 6;
		for(int y=ystart; y<ystart+3; y++){
			for(int x=xstart; x<xstart+3; x++){
				testValue = puzzle.getValue(y, x, 0);
				if (puzzle.getValue(y, x, 0) != 0){
					if (targetCell[testValue]!=0){
						targetCell[testValue]=0;
						targetCell[10]--;
						madeProgress = true;
					}
				}
			}
		}
		return madeProgress;
	}
	
	private static int[] findGuessableCell(Puzzle puzzle){
		int[] guessCellLocation = {0, 0};
		int actualPossibleAnswers = 0;
		int desiredPossibleAnswers = 2;
		while(actualPossibleAnswers == 0){
			for(int col=0;col<9;col++){//formerly i
				for(int row=0;row<9;row++){//formerly j
					//System.out.print("  " + puzzle.getValue(col, row, 10));
					if(puzzle.getValue(col, row, 10) == desiredPossibleAnswers){
						guessCellLocation[0] = col;
						guessCellLocation[1] = row;
						actualPossibleAnswers = desiredPossibleAnswers;
					}
				}
				//System.out.println();
				
			}
			desiredPossibleAnswers++;
		}
		return guessCellLocation;
	}
}
