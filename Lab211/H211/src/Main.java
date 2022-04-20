
public class Main {

	public static void main(String[] args) {
		
		// Enter the size of the first arrayList, it contains pairs of numbers so the size must be even
		int size = 0;
		while(true){
			size = Utilities.inputInt("Enter the Size which is an even number: ", 2, Integer.MAX_VALUE);
			if (size % 2 == 0){
				break;
			}
			System.out.println("Size of the array must be even");
		}
		
		// allocate new array
		int[] tElementData = new int[size];

		// add elements to the new array
		for (int i = 0; i < size; ++i){
			if (i % 2 == 0){
				tElementData[i] = Utilities.inputInt("Enter a positive integer (>=0): ", 0, Integer.MAX_VALUE);
			}else{
				tElementData[i] = Utilities.inputInt("Enter an integer: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
			}
		}

		// create new ArrayIntList contains data from the array we just created
		ArrayIntList list1 = new ArrayIntList(tElementData, size);

		ArrayIntList list2 = list1.fromCounts();
		
		list2.ShowArray();
	}
	
}
