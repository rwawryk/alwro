package edu.alwro.pucks

import static java.lang.Math.min

/**
 * http://main.edu.pl/pl/archive/oi/13/kra
 */
class BruteForcePucksAlgorithm {

    /**
     * Reads input data from file
     * @param filePath
     */
    static def readInput(String filePath) {

        Scanner scanner = new Scanner(new File(filePath))
        int n = scanner.nextInt()
        int m = scanner.nextInt()

        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = scanner.nextInt()
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
     * @param end the last possible puck position
     * @param k the puck size
     * @return final puck level (starting at 0th index) or -1 when puck is too big/no room in a toy
     */
    static private int dropPuck(int[] r, int end, int k) {
        int depth = 0
        while (depth <= end && k <= r[depth]) {
            depth++
        }
        depth - 1
    }

    /**
     * Drops pucks one by one into a toy
     * @return latest puck position (starting at 0th index) or -1 when puck is too big/no room in a toy
     */
    static int run(int[] r, int[] k) {
        int level = -1
        int end = r.length - 1
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

    static int run(String filePath) {
        int[] r, k
        (r, k) = readInput(filePath)
        run(r, k)
    }
}
