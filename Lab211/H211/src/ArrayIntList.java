
public class ArrayIntList {

    private int[] elementData;
    private int size;

    // Constructor
    public ArrayIntList(int n) {
        this.elementData = new int[n];
        this.size = n;
    }

    // Constructor
    public ArrayIntList(int[] elementData, int size) {
        this.elementData = elementData;
        this.size = size;
    }

    public ArrayIntList fromCounts() {
        int Size = 0;

        // from the heading element, after every 2 elements is the number indicates quantity of its following value
        for (int i = 0; i < this.size; i += 2) {
            Size += elementData[i];
        }

        // initialize a new array which size is Size
        int[] nElementData = new int[Size];

        // j is used to keep track of value (not element) exist in the new array
        int j = 0;
        // traverse through the initial array's size
        for (int i = 0; i < this.size; i += 2) {
            
            // c is used to keep track of number of time the value being added to the new array
            int c = 0;
            while (c < this.elementData[i]) {
                c++;
                nElementData[j] = elementData[i + 1];
                j++;
            }
        }
        return new ArrayIntList(nElementData, Size);
    }

    /*
		for example:
		initial array: [5, 4, 4, 2, 6, 8, ...]
			--> elements indicate the number of appearance of elements after them are: 5, 4, 6, ...
			
		we need to initialize new array with size equals to the sum of 5, 4, 6,...
			--> new array: [*********...*]
			--> after using fromCounts: [444442222888888 ...]

     */
    public void ShowArray() {
        System.out.print("[");
        for (int i = 0; i < this.elementData.length; i++) {
            System.out.print(this.elementData[i] + " ");
        }
        System.out.print(" ]");
    }
}
