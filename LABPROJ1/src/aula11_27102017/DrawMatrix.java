package aula11_27102017;

public class DrawMatrix {

	enum move {LEFT_TO_RIGHT, DOWNWARD, RIGHT_TO_LEFT, UPWARD};
	static move dirOfMovement = move.LEFT_TO_RIGHT;
	static int enumOrdinal = 0; // não utilizo mas daria para fazer no método rotateRight
    final static char MOVE_FORWARD = 'F';
    final static char ROTATE_RIGHT = 'R';
    final static char PAINT = 'P';
    final static int MATRIX_RIGHT_LIMIT = 5;
    final static int MATRIX_LEFT_LIMIT = 0;
    final static int MATRIX_LOWER_LIMIT = 5;
    final static int MATRIX_UPPER_LIMIT = 0;
    
	
	public static char[][] paintMatrix(char[] orders) {
		
		char[][] matrixToPaint = new char[6][6];
		int[] cursorPosition = {0,0};
		
		for(char order: orders) {
			
			if (!(isValidOrder(order))) {
				System.out.println(order + " is not a valid order. Continuing with next order.");
				continue;
			}
			executeOrder(order, cursorPosition, matrixToPaint); 
		}
		
		displayPaintedMatrix(matrixToPaint);
		
		return matrixToPaint;
	}
	
	/**
	 * Checks if order is valid or not.
	 * @param order Order to be checked.
	 * @return true if order is valid, false if it is not.
	 */
	public static boolean isValidOrder(char order) {
		
		if ((order == MOVE_FORWARD) || (order == ROTATE_RIGHT) || (order == PAINT)) return true;
		
		return false;
	}
	
	/**
	 * Selects and calls the appropriate method according to the order given
	 * @param order given Order
	 * @param cursorPosition Array with the (x,y) position of the cursor
	 * @param matrixToPaint Matrix to paint
	 */
	public static void executeOrder(char order, int[] cursorPosition, char[][] matrixToPaint) {
		
		if (order == MOVE_FORWARD) moveForward(cursorPosition);
		if (order == ROTATE_RIGHT) rotateRight();
		if (order == PAINT) paintMatrix(matrixToPaint, cursorPosition);
	}
	
	/**
	 * Displays the final (painted) matrix
	 * @param matrixToPaint Matrix to paint
	 */
	public static void displayPaintedMatrix(char[][] matrixToPaint) {

		System.out.print("____________");
		
		for(int i = 0; i < matrixToPaint.length; i++) {
			System.out.println();
			for(int j = 0; j < matrixToPaint.length; j++) {
				if(matrixToPaint[i][j] == '\u0000') System.out.print(" ");
				System.out.print("." + matrixToPaint[i][j]);
			}
		}
		System.out.println("\n-------------");
	}
	
	/**
	 * Executes the order to move forward
	 * @param cursorPosition Array with the current cursor position
	 * @return The new cursor position
	 */
	public static int[] moveForward(int[] cursorPosition) {
		
		if (!(isValidForwardMove(cursorPosition))) {
			System.out.println("Invalid movement, exceeds matrix's limits. Returning same position.");
			return cursorPosition;
		}
		
		if (dirOfMovement == move.LEFT_TO_RIGHT) cursorPosition[1]++;
		if (dirOfMovement == move.RIGHT_TO_LEFT) cursorPosition[1]--;
		if (dirOfMovement == move.DOWNWARD) cursorPosition[0]++;
		if (dirOfMovement == move.UPWARD) cursorPosition[0]--;
		
		return cursorPosition;	
	}
	
	/**
	 * Executes the order to rotate right
	 * @return The direction of movement
	 */
	public static move rotateRight() {
		
		//XXX code with a minor bug
		//if (enumOrdinal == 0) enumOrdinal = 1;
		//return (dirOfMovement = move.values()[(enumOrdinal == 4) ? enumOrdinal = 0 : enumOrdinal++]);
		
		if (dirOfMovement == move.UPWARD) return (dirOfMovement = move.LEFT_TO_RIGHT);
		if (dirOfMovement == move.LEFT_TO_RIGHT) return (dirOfMovement = move.DOWNWARD);
		if (dirOfMovement == move.DOWNWARD) return (dirOfMovement = move.RIGHT_TO_LEFT);
	    if (dirOfMovement == move.RIGHT_TO_LEFT) return (dirOfMovement = move.UPWARD);
	    return move.DOWNWARD;
	}
	
	/**
	 * "Paints" the matrix
	 * @param matrixToPaint Matrix to be painted
	 * @param cursorPosition The current cursor position
	 * @return "Painted" matrix
	 */
	public static char[][] paintMatrix(char[][] matrixToPaint, int[] cursorPosition) {
		
		matrixToPaint[cursorPosition[0]][cursorPosition[1]] = '@';
		
		return matrixToPaint;
	}
	
	/**
	 * Checks if the cursor can move forward (whichever direction) without passing the matrix's limits
	 * @param cursorPosition The current cursor position
	 * @return True if it's a valid move, false if it is not.
	 */
	public static boolean isValidForwardMove(int[] cursorPosition) {
		
		if ((dirOfMovement == move.LEFT_TO_RIGHT) && (cursorPosition[1] == MATRIX_RIGHT_LIMIT)) 
			return false;
		if ((dirOfMovement == move.RIGHT_TO_LEFT) && (cursorPosition[1] == MATRIX_LEFT_LIMIT)) 
			return false;
		if ((dirOfMovement == move.DOWNWARD) && (cursorPosition[0] == MATRIX_LOWER_LIMIT)) 
			return false;
		if ((dirOfMovement == move.UPWARD) && (cursorPosition[0] == MATRIX_UPPER_LIMIT)) 
			return false;
		
		return true;
	}
}
