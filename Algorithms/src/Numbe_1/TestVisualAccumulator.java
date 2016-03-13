package Numbe_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

//可视化累加器

/******************************************************************************
 *  Compilation:  javac VisualAccumulator.java
 *  Execution:    java VisualAccumulator < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *
 *  Mutable data type that calculates the mean, sample standard
 *  deviation, and sample variance of a stream of real numbers
 *  use a stable, one-pass algorithm.
 *
 ******************************************************************************/

/**
 * The <tt>VisualAccumulator</tt> class is a data type for computing the running
 * mean, sample standard deviation, and sample variance of a stream of real
 * numbers. It provides an example of a mutable data type and a streaming
 * algorithm.
 * <p>
 * This implementation uses a one-pass algorithm that is less susceptible to
 * floating-point roundoff error than the more straightforward implementation
 * based on saving the total of the squares of the numbers. This technique is
 * due to <a href =
 * "https://en.wikipedia.org/wiki/Algorithms_for_calculating_variance#Online_algorithm">
 * B. P. Welford</a>. Each operation takes constant time in the worst case. The
 * amount of memory is constant - the data values are not stored.
 * <p>
 * For additional documentation, see
 * <a href="http://algs4.cs.princeton.edu/12oop">Section 1.2</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
class VisualAccumulator {
	private int n = 0; // number of data values
	private double total = 0.0; // sample variance * (n-1)
	

	/**
	 * Initializes an VisualAccumulator.
	 */
	public VisualAccumulator(int tri, double max) {
		StdDraw.setXscale(0, tri);
		StdDraw.setYscale(0, max);
		StdDraw.setPenRadius(.005);
	}

	/**
	 * Adds the specified data value to the VisualAccumulator.
	 * 
	 * @param x
	 *            the data value
	 */
	public void addDataValue(double val) {
		n++;
		total += val;
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.point(n, val);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.point(n, total / n);
	}

	/**
	 * Returns the mean of the data values.
	 * 
	 * @return the mean of the data values
	 */
	public double mean() {
		return total/n;
	}

	/**
	 * Returns the sample variance of the data values.
	 * 
	 * @return the sample variance of the data values
	 */
	public double var() {
		return total / (n - 1);
	}

	/**
	 * Returns the sample standard deviation of the data values.
	 * 
	 * @return the sample standard deviation of the data values
	 */
	public double stddev() {
		return Math.sqrt(this.var());
	}

	/**
	 * Returns the number of data values.
	 * 
	 * @return the number of data values
	 */
	public int count() {
		return n;
	}

	public String toString() {
		// TODO Auto-generated method stub
		return "average:"+mean();
	}
	/**
	 * Unit tests the <tt>VisualAccumulator</tt> data type. Reads in a stream of
	 * real number from standard input; adds them to the VisualAccumulator; and
	 * prints the mean, sample standard deviation, and sample variance to
	 * standard output.
	 */

}

/******************************************************************************
 * Copyright 2002-2015, Robert Sedgewick and Kevin Wayne.
 *
 * This file is part of algs4.jar, which accompanies the textbook
 *
 * Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne, Addison-Wesley
 * Professional, 2011, ISBN 0-321-57351-X. http://algs4.cs.princeton.edu
 *
 *
 * algs4.jar is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * algs4.jar is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * algs4.jar. If not, see http://www.gnu.org/licenses.
 ******************************************************************************/

public class TestVisualAccumulator {
	public static void main(String[] args) {
		int T = Integer.parseInt(args[0]);
		VisualAccumulator a = new VisualAccumulator(T, 1.0);

		for (int i = 0; i < T; i++) {
			a.addDataValue(Math.random());
		}
		StdOut.println(a);
	}

}
