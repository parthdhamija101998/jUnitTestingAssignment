package helix;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
public class MatrixHelixMorphTest {

    /** Check if two integer matrices have the same contents
     *
     * @param m1
     * @param m2
     * @return true if the contents of matrix1 and matrix2 are identical and false otherwise
     */
    public static boolean testEqual(int[][] m1, int[][] m2) {

        /*
            Basic sanity checking:
                Verify that lengths are equal
         */
        if (m1 == null || m2 == null) {
            return true;
        }
        if (m1.length != m2.length) {
            return false;
        }
        if (m1[0].length != m2[0].length) {
            return false;
        }

        /*
            Test the contents of the matrices
         */
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                if (m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

//    Parth Dhamija
//    Tests

    @Test
    public void testMatrixwithoutValues(){
        int[][] checkMatrix = {};
        int[][] outputExpected = {};
        assertTrue(testEqual(outputExpected, MatrixHelixMorph.helix(checkMatrix)));
    }

    @Test
    public void test2by2Matrix() {
        int[][] checkMatrix  = { {11, 22}, {33, 44} };
        int[][] outputExpected = { {11, 22}, {44, 33} };
        assertTrue(testEqual(outputExpected, MatrixHelixMorph.helix(checkMatrix)));
    }

    @Test
    public void test1by1Matrix() {
        int[][] checkMatrix  = { {99} };
        int[][] outputExpected = { {99} };
        assertTrue(testEqual(outputExpected, MatrixHelixMorph.helix(checkMatrix)));
    }

    @Test
    public void test1by2Matrix() {
        int[][] checkMatrix = {{7, 2}};
        int[][] outputExpected = {{7, 2}};
        assertTrue(testEqual(outputExpected, MatrixHelixMorph.helix(checkMatrix)));
    }

    @Test
    public void test2by1Matrix() {
        int[][] checkMatrix = {{7}, {2}};
        int[][] outputExpected = {{7}, {2}};
        assertTrue(testEqual(outputExpected, MatrixHelixMorph.helix(checkMatrix)));
    }

    @Test
    public void test3by3Matrix(){
        int[][] checkMatrix  = { {7, 2, 3 }, {4, 5, 9}, {7, 7, 9 } };
        int[][] outputExpected = { { 7, 2, 3 }, { 7, 9, 4 }, { 7, 9, 5 } };
        assertTrue(testEqual(outputExpected, MatrixHelixMorph.helix(checkMatrix)));
    }

    @Test
    public void test4by5Matrix(){
        int[][] checkMatrix = { { 7, 5, 7, 4, 9 }, { 3, 2, 9, 7, 7 }, { 7, 3, 2, 4, 7 }, { 10, 11, 15, 19, 14 } };
        int[][] outputExpected = { { 7, 5, 7, 4, 9 }, { 4, 7, 10, 11, 3 }, { 2, 14, 19, 15, 2 }, { 3, 7, 7, 7, 9 } };
        assertTrue(testEqual(outputExpected, MatrixHelixMorph.helix(checkMatrix)));
    }

    @Test
    public void test5by3Matrix() {
        int[][] checkMatrix = {{7, 2, 3}, {4, 5, 9}, {7, 7, 9}, {10, 11, 12}, {13, 14, 15}};
        int[][] outputExpected = {{7, 2, 3}, {12, 13, 4}, {11, 14, 5}, {10, 15, 9}, {9, 7, 7}};
        assertTrue(testEqual(outputExpected, MatrixHelixMorph.helix(checkMatrix)));
    }

    @Test
    public void test4by6Matrix() {
        int[][] checkMatrix = {{7, 3, 5, 7, 9, 11}, {2, 4, 9, 7, 10, 12}, {13, 15, 17, 19, 21, 23}, {22, 24, 26, 28, 30, 32}};
        int[][] outputExpected = {{7, 3, 5, 7, 9, 11}, {19, 21, 23, 22, 24, 2}, {17, 32, 30, 28, 26, 4}, {15, 13, 12, 10, 7, 9}};
        assertTrue(testEqual(outputExpected, MatrixHelixMorph.helix(checkMatrix)));
    }

    @Test
    public void test6by4Matrix() {
        int[][] checkMatrix = {{7, 3, 5, 7}, {2, 4, 9, 7}, {9, 11, 13, 15}, {10, 12, 14, 16}, {17, 19, 21, 23}, {18, 20, 22, 24}};
        int[][] outputExpected = {{7, 3, 5, 7}, {16, 17, 19, 2}, {14, 24, 21, 4}, {12, 22, 23, 9}, {10, 20, 18, 7}, {15, 13, 11, 9}};
        assertTrue(testEqual(outputExpected, MatrixHelixMorph.helix(checkMatrix)));
    }

    @Test
    public void test3by5Matrix() {
        int[][] checkMatrix = {{7, 2, 3, 4, 5},{ 9, 7, 7, 9, 10},{ 11, 12, 13, 14, 15}};
        int[][] outputExpected = {{7, 2, 3, 4, 5}, {12, 13, 14, 15, 9}, {11, 10, 9, 7, 7}};
        assertTrue(testEqual(outputExpected, MatrixHelixMorph.helix(checkMatrix)));
    }

    @Test
    public  void nullTest(){
        int[][] checkMatrix = null;
        int[][] outputExpected = null;
        assertTrue(testEqual(outputExpected, MatrixHelixMorph.helix(checkMatrix)));
    }

    @Test
    public void invalidTest() {
        int[][] checkMatrix = {{7, 2}, {3, 7 , 9}, {9, 7}};
        int[][] outputExpected = null;
        assertTrue(testEqual(outputExpected, MatrixHelixMorph.helix(checkMatrix)));
    }
}

