package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int girdNum;
    private boolean[][] flagOpen;
    // 设置一个topSite与顶行相连通
    private int topSiteIndex;
    // 设置一个bottomSite与底行相连通
    private int bottomSiteIndex;
    private WeightedQuickUnionUF sites;
    // 不与bottomSite连接的sites2
    private WeightedQuickUnionUF sites2;
    private int openNum = 0;

    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N) {
        girdNum = N;
        topSiteIndex = N * N;
        bottomSiteIndex = N * N + 1;

        if (N <= 0) {
            throw new IllegalArgumentException();
        }

        sites = new WeightedQuickUnionUF(N * N + 2);
        // 连通顶行
        for (int i = 0; i < N; i++) {
            sites.union(topSiteIndex, xyTo1D(0, i));
        }
        // 连通底行
        for (int i = 0; i < N; i++) {
            sites.union(bottomSiteIndex, xyTo1D(N - 1, i));
        }

        sites2 = new WeightedQuickUnionUF(N * N + 1);
        // 连通顶行
        for (int i = 0; i < N; i++) {
            sites2.union(topSiteIndex, xyTo1D(0, i));
        }

        flagOpen = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                flagOpen[i][j] = false;
            }
        }
    }

    private int xyTo1D(int row, int col) {
        return row * girdNum + col;
    }

    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        validateRange(row, col);

        if (isOpen(row, col)) {
            return;
        }

        flagOpen[row][col] = true;

        openNum++;

        unionSite(row, col, row - 1, col);
        unionSite(row, col, row + 1, col);
        unionSite(row, col, row, col - 1);
        unionSite(row, col, row, col + 1);
    }

    private void unionSite(int row, int col, int row2union, int col2union) {
        if (row2union > girdNum - 1 || col2union > girdNum - 1 || row2union < 0 || col2union < 0) {
            return;
        }
        if (isOpen(row2union, col2union)) {
            sites.union(xyTo1D(row, col), xyTo1D(row2union, col2union));
            sites2.union(xyTo1D(row, col), xyTo1D(row2union, col2union));
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateRange(row, col);
        return flagOpen[row][col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validateRange(row, col);
        if (!isOpen(row, col)) {
            return false;
        }
        return sites2.connected(topSiteIndex, xyTo1D(row, col));
    }

    // number of open sites
    public int numberOfOpenSites() {
        return openNum;
    }

    // does the system percolate?
    public boolean percolates() {
        if (girdNum == 1) {
            return false;
        }
        return sites.connected(topSiteIndex, bottomSiteIndex);
    }

    private void validateRange(int row, int col) {
        if (row > girdNum - 1 || col > girdNum - 1 || row < 0 || col < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    // use for unit testing (not required)
    public static void main(String[] args) {
        Percolation testSites = new Percolation(5);
    }



}
