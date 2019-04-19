
public class PercolationStats {
	private double[] attemps;
	 
    /**
     * Instantiates a new Percolation stats.
     *
     * @param N      the n
     * @param trails the trails
     */
    public PercolationStats(int N, int trails) {
        if (N <= 0 || trails <= 0)
            throw new IllegalArgumentException("Illegal Argument!");
        attemps = new double[trails];
        for (int i = 0; i < trails; i++) {
            Percolation checkPerco = new Percolation(N);
            int step = 0;
            while (!checkPerco.percolates()) {
                int row = StdRandom.uniform(N) + 1;
                int column = StdRandom.uniform(N) + 1;
                if (!checkPerco.isOpen(row, column)) {
                    checkPerco.open(row, column);
                    step++;
                }
            }
            attemps[i] = (double) step / (N * N);
        }
 
    }
 
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int N = StdIn.readInt();
        int T = StdIn.readInt();
        PercolationStats ps = new PercolationStats(N, T);
        StdOut.printf("%-25s= %.7f\n", "mean", ps.mean());
        StdOut.printf("%-25s= %.17f\n", "stddev", ps.stddev());
        StdOut.printf("%-25s= [%.15f, %.15f]\n", "95% confidence interval",
                ps.confidenceLo(), ps.confidenceHi());
    }
 
    /**
     * Mean double.
     *
     * @return the double
     */
    public double mean() {
        return StdStats.mean(attemps);
    }
 
    /**
     * Stddev double.
     *
     * @return the double
     */
    public double stddev() {
        return StdStats.stddev(attemps);
    }
 
    /**
     * Confidence lo double.
     *
     * @return the double
     */
    public double confidenceLo() {
        return mean() - ((1.96 * stddev())) / Math.sqrt(attemps.length);
    }
 
    /**
     * Confidence hi double.
     *
     * @return the double
     */
    public double confidenceHi() {
        return mean() + ((1.96 * stddev())) / Math.sqrt(attemps.length);
    }
 
}
