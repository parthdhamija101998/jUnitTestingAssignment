package helix;


public class MatrixHelixMorph {

    /**
     * @param input
     * @return a matrix that is morphed into a helix version of input
     */
    public static int[][] helix(int[][] input) {
        if (input == null || input.length == 0)
            return null;
        int rowNum = input.length;
        int columnNum = 0;
        if (rowNum > 0) {
            columnNum = input[0].length;
            for (int i = 1; i < input.length; i++) {
                if (columnNum != input[i].length) {
                    return null;
                }
            }
        }

        int[][] output = new int[rowNum][columnNum];
        int expectedOutputRowIndex = 0, expectedOutputColIndex = 0;
        int inputMatrixRowIndex = 0, inputMatrixColumnIndex = 0;
        while (expectedOutputRowIndex < rowNum && expectedOutputColIndex < columnNum) {
            for (int i = expectedOutputColIndex; i < columnNum; ++i) {
                output[expectedOutputRowIndex][i] = input[inputMatrixRowIndex][inputMatrixColumnIndex];
                if (inputMatrixColumnIndex == input[0].length - 1) {
                    inputMatrixRowIndex++;
                    inputMatrixColumnIndex = 0;
                } else {
                    inputMatrixColumnIndex++;
                }
            }
            expectedOutputRowIndex++;
            for (int i = expectedOutputRowIndex; i < rowNum; ++i) {
                output[i][columnNum - 1] = input[inputMatrixRowIndex][inputMatrixColumnIndex];
                if (inputMatrixColumnIndex == input[0].length - 1) {
                    inputMatrixRowIndex++;
                    inputMatrixColumnIndex = 0;
                } else {
                    inputMatrixColumnIndex++;
                }
            }
            columnNum--;
            if (expectedOutputRowIndex < rowNum) {
                for (int i = columnNum - 1; i >= expectedOutputColIndex; --i) {
                    output[rowNum - 1][i] = input[inputMatrixRowIndex][inputMatrixColumnIndex];
                    if (inputMatrixColumnIndex == input[0].length - 1) {
                        inputMatrixRowIndex++;
                        inputMatrixColumnIndex = 0;
                    } else {
                        inputMatrixColumnIndex++;
                    }
                }
                rowNum--;
            }
            if (expectedOutputColIndex < columnNum) {
                for (int i = rowNum - 1; i >= expectedOutputRowIndex; --i) {
                    output[i][expectedOutputColIndex] = input[inputMatrixRowIndex][inputMatrixColumnIndex];
                    if (inputMatrixColumnIndex == input[0].length - 1) {
                        inputMatrixRowIndex++;
                        inputMatrixColumnIndex = 0;
                    } else {
                        inputMatrixColumnIndex++;
                    }
                }
                expectedOutputColIndex++;
            }
        }
        for (int i = 0; i < output.length; i++)
        {
            for (int j = 0; j < output[0].length; j++)
            {
                System.out.print(output[i][j]+ "\t");
            }
            System.out.println();
        }
        return output;
    }
}