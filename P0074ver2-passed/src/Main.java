
/**
 *
 * @author darkksilver
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Utility utility = new Utility();

        do {
            //step 1: display menu
            System.out.println("\n=====================================");
            System.out.println("|          Matrix Calculator        |");
            System.out.println("-------------------------------------");
            System.out.println("|\t1. Matrix Addition          |");
            System.out.println("|\t2. Matrix Subtraction       |");
            System.out.println("|\t3. Matrix Multiplication    |");
            System.out.println("|\t4. Exit                     |");
            System.out.println("=====================================");

            //step 2: ask users to select an option
            int choice = utility.selectOption("Enter your choice: ", 1, 4);

            //step 3: perform function based on the selected option
            
            // create 3 matrices
            Matrix matrix1 = new Matrix();
            Matrix matrix2 = new Matrix();
            Matrix result = new Matrix();

            try {
                switch (choice) {
                    //Addition
                    case 1:
                        System.out.println("\n-------- Addition --------");
                        
                        // get user input for matrix 1 and matrix 2
                        matrix1.inputMatrix(1);
                        System.out.println("");
                        matrix2.inputMatrix(2);

                        // set result matrix' column and row
                        result.row = matrix1.row;
                        result.col = matrix1.col;

                        System.out.println("\n-------- Result --------");
                        matrix1.display();
                        System.out.println("+");
                        matrix2.display();
                        System.out.println("=");

                        // call matrix addtion function
                        result.data = matrix1.addtionMatrix(matrix2);

                        // if the result is null then print out cannot perform matrix addition, otherwise display the result matrix
                        if (result.data == null) {
                            System.out.println("Cannot perform addtion");
                        } else {
                            result.display();
                        }

                        break;

                    //Subtraction
                    case 2:
                        System.out.println("\n-------- Subtraction --------");

                        // get user input for matrix 1 and matrix 2
                        matrix1.inputMatrix(1);
                        System.out.println("");
                        matrix2.inputMatrix(2);

                        // set result matrix' column and row
                        result.row = matrix1.row;
                        result.col = matrix1.col;

                        System.out.println("\n-------- Result --------");
                        matrix1.display();
                        System.out.println("-");
                        matrix2.display();
                        System.out.println("=");

                        // call matrix subtraction function
                        result.data = matrix1.subtractMatrix(matrix2);

                        // if the result is null then print out cannot perform matrix addition, otherwise display the result matrix
                        if (result.data == null) {
                            System.out.println("Cannot perform subtraction");
                        } else {
                            result.display();
                        }

                        break;

                    //Multiplication
                    case 3:
                        System.out.println("\n-------- Multiplication --------");

                        // get user input for matrix 1 and matrix 2
                        matrix1.inputMatrix(1);
                        System.out.println("");
                        matrix2.inputMatrix(2);

                        // set result matrix' column and row, 
                        // 2 matrices are multiplicable if the first matrix' column has the same length with the second matrix' row
                        // set result matrix' row to be equal to  the first matrix' row, column to be equal to the second matrix' column
                        result.row = matrix1.row;
                        result.col = matrix2.col;

                        System.out.println("\n-------- Result --------");
                        matrix1.display();
                        System.out.println("*");
                        matrix2.display();
                        System.out.println("=");

                        // perform matrix multiplication function
                        result.data = matrix1.multiplyMatrix(matrix2);

                        // if the result is null then print out cannot perform matrix addition, otherwise display the result matrix
                        if (result.data == null) {
                            System.out.println("Cannot perform multiplication");
                        } else {
                            result.display();
                        }

                        break;

                    //Exit
                    case 4:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

}
