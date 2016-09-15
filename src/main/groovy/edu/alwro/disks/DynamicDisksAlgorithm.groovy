package edu.alwro.disks

import static java.lang.Math.min

/**
 * http://main.edu.pl/pl/archive/oi/13/kra
 */
class DynamicDisksAlgorithm {

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
     * Drops a single disk into a toy
     * @param r the toy structure
     * @param end the last possible disk level
     * @param k the disk size
     * @return final disk level (starting at 0th index) or -1 when disk is too big/no room in a toy
     */
    static private int dropDisk(int[] r, int end, int k) {
        int level = end
        while(level >=0 && k > r[level]) {
            level--
        }
        level
    }

    /**
     * Reads the input data and drops disks one by one into a toy
     * @return latest disk position (starting at 0th index) or -1 when disk is too big/no room in a toy
     */
    static int run(String filePath) {
        int[] r, k
        (r, k) = readInput(filePath)
        run(r, k)
    }

    /**
     * Drops disks one by one into a toy
     * @return latest disk position (starting at 0th index) or -1 when disk is too big/no room in a toy
     */
    static int run(int[] r, int[] k) {
        int end = r.length - 1
        int level = -1
        for (int i = 0; i < k.length; i++) {
            level = dropDisk(r, end, k[i])
            if(level == -1) {
                break
            } else {
                end = level - 1
            }
        }
        level
    }
}
