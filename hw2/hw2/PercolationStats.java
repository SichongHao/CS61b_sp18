package hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private int mtTimes;
    private double[] thredsholdArr;

    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T, PercolationFactory pf) {
        mtTimes = T;
        thredsholdArr = new double[T];

        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }

        Percolation mtSites = pf.make(N);

        for (int mt = 0; mt < T; mt++) {

            while (!mtSites.percolates()) {
                int chooseRow = StdRandom.uniform(N);
                int chooseCol = StdRandom.uniform(N);
                mtSites.open(chooseRow, chooseCol);
            }

            double numOpen = mtSites.numberOfOpenSites();
            double threshold = numOpen / (N * N);
            thredsholdArr[mt] = threshold;
        }

    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(thredsholdArr);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(thredsholdArr);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLow() {
        double miu = mean();
        double sigma = stddev();
        double confidence = miu - 1.96 * sigma / Math.sqrt(mtTimes);
        return confidence;
    }
    // high endpoint of 95% confidence interval
    public double confidenceHigh() {
        return mean() + 1.96 * stddev() / Math.sqrt(mtTimes);
    }

}
