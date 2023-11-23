class ArraysExamples {
    public static void main(final String... args) {
        int[] a = { 1, 2, 3 };
        System.out.println(a);

        // Acccess from the start of the array
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);

        // Access from the end of the array
        System.out.println(a[a.length - 1]);
        System.out.println(a[a.length - 2]);
        System.out.println(a[a.length - 3]);

        int[][] twod;
        twod = new int[8][8];

        int[][] nonUniformTwoD;
        nonUniformTwoD = new int[5][];
        nonUniformTwoD[0] = new int[0]; // Creates a new int[] of length 0
        nonUniformTwoD[1] = new int[2];
        nonUniformTwoD[2] = new int[4];
        nonUniformTwoD[3] = new int[8];
        nonUniformTwoD[4] = new int[10];

        for (int i1 = 0; i1 < nonUniformTwoD.length; i1++) {
            for (int i2 = 0; i2 < nonUniformTwoD[i1].length; i2++) {
                System.out.format("%d %d %d\n", i1, i2, nonUniformTwoD[i1][i2]);
            }
        }

        for (int[] array : nonUniformTwoD)
            for (int n : array)
                System.out.format("%d\n", n);
    }
}
