package aula11_27102017;

public class ArrayTransform {

	static int lastArrayPosition;
	static boolean areBothRotateRight;
	static final char ROTATE_RIGHT = 'R';
	final static char INVERT_DIRECTION = 'I';
	final static char MOVE_LEFT = 'L';
	
	//Tested
	public static char[] transformsArray(char[] orders) {
		
		lastArrayPosition = orders.length - 1;
		
		if(arrayIsEmpty(orders)) {
			System.out.println("Empty array. Program terminated.");
			System.exit(1);
		}
		if(arrayHasOnlyOneElement(orders)) return orders;
		
		orders = verifyArrayErrors(orders);
		
		for (int i = 0; i < lastArrayPosition; i++) {
			
			int currentOrder = orders[i];
			
			if (currentOrder == ROTATE_RIGHT) {
				if (!(arrayHasNextElement(i))) {
					return orders;
			    }
				else {
					areBothRotateRight = compareWithNextOrder(orders, i);
				}
				if (areBothRotateRight) {
					if (!(arrayHasNextElement(i + 1))) {
						invertMovement(orders, i);
				    }
					else {
						areBothRotateRight = compareWithNextOrder(orders, i + 1);
					}
					if (areBothRotateRight) {
						moveLeft(orders, i);
					}
					else {
						invertMovement(orders, i);
					}
				}	
			}	
			
		}
		return orders;
	}

	// Tested
	public static boolean arrayIsEmpty(char[] orders) {

		if (orders.length == 0)
			return true;
		return false;
	}

	// Tested
	public static boolean arrayHasOnlyOneElement(char[] orders) {

		if (orders.length == 1)
			return true;
		return false;
	}
	
	//Tested
	public static char[] verifyArrayErrors(char[] orders) {
		
		for (int i = 0; i < lastArrayPosition; i++) {
			if (!(DrawMatrix.isValidOrder(orders[i]))) {
				orders = removeElement(orders, i);
			}	
		}
		return orders;
	}
	
	//Tested
	public static char[] removeElement(char[] orders, int index) {

		for (int i = index; i < lastArrayPosition; i++) {
			orders[i] = orders[i + 1];
		}
		lastArrayPosition--;

		return orders;
	}
	
	// Tested
	public static boolean arrayHasNextElement(int index) {

		if (index == lastArrayPosition)
			return false;

		return true;
	}
	
	//Tested
	public static boolean compareWithNextOrder(char[] orders, int index) {
		
		char nextOrder = fetchNextArrayElement(orders, index); 
		
		return (nextOrder == ROTATE_RIGHT);
	}
	
	// Tested
	public static char fetchNextArrayElement(char[] orders, int index) {

		return (orders[index + 1]);
	}

	//Tested
	public static char[] invertMovement(char[] orders, int index) {

		orders[index] = INVERT_DIRECTION;
		orders = removeElement(orders, index + 1);
		return orders;
	}

	//Tested
	public static char[] moveLeft(char[] orders, int index) {

		orders[index] = MOVE_LEFT;
		orders = removeElement(orders, index + 1);
		orders = removeElement(orders, index + 1);
		return orders;
	}
}