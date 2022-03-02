package hw2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPercolatoin {

    @Test
    public void testOpen() {
        Percolation testSites = new Percolation(1);
//        testSites.open(3, 4);
//        testSites.open(2, 4);
//        assertTrue(testSites.isOpen(2, 4));
//        assertFalse(testSites.isOpen(1, 1));
//        assertEquals(2, testSites.numberOfOpenSites());
//        testSites.open(2, 2);
//        testSites.open(2, 3);
//        testSites.open(0, 2);
//        testSites.open(1, 2);
//        testSites.open(4, 4);
//        assertTrue(testSites.isFull(4, 4));
        testSites.open(0, 0);
        assertTrue(testSites.percolates());
    }

}
