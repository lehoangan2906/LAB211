
/**
 *
 * @author darkksilver
 */
public class Matrix {

    public int row;
    public int col;
    public int[][] data;

    // constructor
    public Matrix() {
        
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    // function to get user's input on the matrix' entries
    public void inputMatrix(int number) {
        Utility utility = new Utility();
        this.row = utility.inputInteger("Enter Row of Matrix " + number + ": ", 2);
        this.col = utility.inputInteger("Enter Col of Matrix " + number + ": ", 3);

        this.data = new int[row][col];

        // loop through each row of matrix
        for (int r = 0; r < row; r++) {
            // loop through each column of matrix, then ask the user to enter the entries' values
            for (int c = 0; c < col; c++) {
                this.data[r][c] = utility.inputInteger("Enter matrix " + number + "[" + (r + 1) + "]" + "[" + (c + 1) + "]: ", 1);
            }
        }
    }

    // function to add matrices
    public int[][] addtionMatrix(Matrix matrix2) {
        
        // check the addtion condition (two matrices must have the same sizes)
        if (this.col != matrix2.col || this.row != matrix2.row) {
            return null;
        } else {
            
            // create new matrix to store the result
            Matrix result = new Matrix();
            result.row = this.row;
            result.col = this.col;
            result.data = new int[result.row][result.col];

            for (int r = 0; r < this.row; r++) {
                // add each entry in the row with the corresponding entry in matrix 2
                for (int c = 0; c < this.col; c++) {
                    result.data[r][c] = this.data[r][c] + matrix2.data[r][c];
                }
                System.out.println("");
            }
            
            // return the data array of the result matrix
            return result.data;
        }
    }

    // function to subtract matrices
    public int[][] subtractMatrix(Matrix matrix2) {
        
        // check the subtraction condition (two matrices must have the same sizes)
        if (this.col != matrix2.col || this.row != matrix2.row) {
            return null;
        } else {

            // create new matrix to store the result
            Matrix result = new Matrix();
            result.row = this.row;
            result.col = this.col;
            result.data = new int[result.row][result.col];

            for (int r = 0; r < this.row; r++) {
                // add each entry in the row with the corresponding entry in matrix 2
                for (int c = 0; c < this.col; c++) {
                    result.data[r][c] = this.data[r][c] - matrix2.data[r][c];
                }
                System.out.println("");
            }
            
            // return the data array of the result matrix
            return result.data;
        }
    }

    // function to multiply matrices
    public int[][] multiplyMatrix(Matrix matrix2) {
        
        // check the multiplication condition (the first matrix' column must be equal to the second matrix' row)
        if (this.col != matrix2.row) {
            return null;
        } else {
            
             // create new matrix to store the result
            Matrix result = new Matrix();
            result.row = row;
            result.col = matrix2.col;
            result.data = new int[result.row][result.col];
            
            //Loop through each row i of matrix 1
            for (int i = 0; i < row; i++) {
                //Loop through each column j of matrix 2
                for (int j = 0; j < matrix2.col; j++) {
                    //The entry (i,j) of the result matrix is the dot product of row i and col j
                    for (int k = 0; k < col; k++) {
                        result.data[i][j] += data[i][k] * matrix2.data[k][j];
                    }
                }
            }
            return result.data;
        }
    }

    // function to display the matrix
    public void display() {
        // traverse through each row r of the matrix
        for (int r = 0; r < row; r++) {
            // traverse through each column c of matrix and display the entry (r, c)
            for (int c = 0; c < col; c++) {
                System.out.print("[" + this.data[r][c] + "]");
            }
            System.out.println("");
        }
    }
}
