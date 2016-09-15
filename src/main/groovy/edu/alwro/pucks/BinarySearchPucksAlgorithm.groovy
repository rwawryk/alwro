package edu.alwro.pucks

import static java.lang.Math.min

/**
 * http://main.edu.pl/pl/archive/oi/13/kra
 */
class BinarySearchPucksAlgorithm {

    static final int MAX_R = 1_000_000_000

    /**
     * Reads input data from file and improves the toy structure
     * @param filePath
     */
    static def readInput(String filePath) {

        Scanner scanner = new Scanner(new File(filePath))
        int n = scanner.nextInt()
        int m = scanner.nextInt()

        int[] r = new int[n];
        int prev = MAX_R
        for (int i = 0; i < n; i++) {
            r[i] = min(prev, scanner.nextInt())
            prev = r[i]
        }

        int[] k = new int[m]
        for (int i = 0; i < m; i++) {
            k[i] = scanner.nextInt()
        }
        scanner.close();
        [r, k]
    }

    /**
     * Drops a single puck into a toy
     * @param r the toy structure
     * @param end the last possible puck level
     * @param k the puck size
     * @return final puck level (starting at 0th index) or -1 when puck is too big/no room in a toy
     */
    static private int dropPuck(int[] r, int end, int k) {
        int level = -1
        int begin = 0
        while (begin <= end) {
            int middle = (end + begin) / 2
            if (k > r[middle] ) {
                end = middle - 1
            } else {
                level = middle
                begin = middle + 1
            }
        }
        level
    }

    /**
     * Reads the input data and drops pucks one by one into a toy
     * @return latest puck position (starting at 0th index) or -1 when puck is too big/no room in a toy
     */
    static int run(String filePath) {
        int[] r, k
        (r, k) = readInput(filePath)
        run(r, k)
    }

    /**
     * Drops pucks one by one into a toy
     * @return latest puck position (starting at 0th index) or -1 when puck is too big/no room in a toy
     */
    static int run(int[] r, int[] k) {
        int end = r.length - 1
        int level = -1
        for (int i = 0; i < k.length; i++) {
            level = dropPuck(r, end, k[i])
            if(level == -1) {
                break
            } else {
                end = level - 1
            }
        }
        level
    }
}
