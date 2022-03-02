package hw2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPercolationStats {
    @Test
    public void testMt() {
        PercolationFactory pf = new PercolationFactory();
        PercolationStats testStats = new PercolationStats(20, 10, pf);
        System.out.println(testStats.mean());
        System.out.println(testStats.stddev());
        System.out.println(testStats.confidenceLow());
        System.out.println(testStats.confidenceHigh());
    }
}
