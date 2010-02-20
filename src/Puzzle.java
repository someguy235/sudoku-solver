import java.io.*;
//import java.util.*;

public class Puzzle implements java.io.Serializable {
	//[col][row][0:answer, 1-9:possible answers (0 if not possible), 10:# of possible answers]
	int[][][] puzzle = new int[9][9][11];
	
	//squares left to solve
	int unsolvedCount = 81;
	
	public void setValue(int col, int row, int height, int value){
		puzzle[col][row][height] = value;
	}
	public int getValue(int col, int row, int height){
		return puzzle[col][row][height];
	}
	public int[] getCell(int col, int row){
		return puzzle[col][row];
	}
	public void decrementUnsolved(){
		unsolvedCount--;
	}
	public int getUnsolvedCount(){
		return unsolvedCount;
	}
		
	// deep copy via serialization
    public Puzzle deepCopy(Puzzle puzzle) throws Exception {
        
        	// serialize ArrayList into byte array
	        ByteArrayOutputStream baos = new ByteArrayOutputStream(100);
	        ObjectOutputStream oos = new ObjectOutputStream(baos);
	        oos.writeObject(puzzle);
	        byte buf[] = baos.toByteArray();
	        oos.close();
	
	        // deserialize byte array into ArrayList
	        ByteArrayInputStream bais = new ByteArrayInputStream(buf);
	        ObjectInputStream ois = new ObjectInputStream(bais);
	        Puzzle newlist = (Puzzle)ois.readObject();
	        ois.close();
        
        return newlist;
    }

}
