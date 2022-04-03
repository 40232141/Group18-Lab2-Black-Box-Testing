package org.jfree.data.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import junit.framework.TestCase;

public class DataUtilitiesTest extends TestCase {

	private Values2D values2D;

	private double[] arrayDoubleValues;
	private double[] arrayDoubleFalseValues;
	private Number[] arrayNumberValues;

	private double[][] arrayDoubleValues2D;
	private double[][] arrayDoubleFalseValues2D;
	private Number[][] arrayNumberValues2D;

	private KeyedValues testKeyedValues;

	@Before
	public void setUp() throws Exception {

		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		testValues.addValue(1, 0, 0);
		testValues.addValue(4, 1, 0);
		testValues.addValue(3, 0, 1);
		testValues.addValue(6, 1, 1);

		values2D = testValues;

		arrayDoubleValues = new double[] { 1.0, 2.0, 3.0, 4.0, 5.0 };
		arrayDoubleFalseValues = new double[] { 5.0, 4.0, 3.0, 2.0, 1.0 };

		arrayDoubleValues2D = new double[][] { { 1.0, 2.0, 3.0, 4.0, 5.0 }, { 5.0, 4.0, 3.0, 2.0, 1.0 } };
		arrayDoubleFalseValues2D = new double[][] { { 5.0, 4.0, 3.0, 2.0, 1.0 }, { 1.0, 2.0, 3.0, 4.0, 5.0 } };

		DefaultKeyedValues testDefaultKeyedValues = new DefaultKeyedValues();
		testDefaultKeyedValues.addValue("0", 5);
		testDefaultKeyedValues.addValue("1", 9);
		testDefaultKeyedValues.addValue("2", 2);

		testKeyedValues = testDefaultKeyedValues;
	}

	@After
	public void tearDown() throws Exception {

		values2D = null;
		arrayDoubleValues = null;
		arrayDoubleValues2D = null;
		arrayDoubleFalseValues = null;
		arrayDoubleFalseValues2D = null;
		testKeyedValues = null;

	}

	// Returns exception because of null value
	@Test
	public void testNullDataColumnTotal() {

		try {

			DataUtilities.calculateColumnTotal(null, 0);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");

		} catch (Exception e) {

			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}

	// Checks number of values added together in column 0. total to 5 or return assert message
	@Test
	public void testValidDataAndColumnTotalTrue() {
		assertEquals("Wrong sum returned. It should be 5.0", 5.0, DataUtilities.calculateColumnTotal(values2D, 0));

	}
	
	// Checks number of values added together in column 1. total to 3 or return assert message
	@Test
	public void testValidDataAndColumnTotalFalse() {
		assertEquals("Wrong sum returned. It should be 3.0", 1.0, DataUtilities.calculateColumnTotal(values2D, 1));

	}

	// Returns exception because of null value
	@Test
	public void testNullDataRowTotal() {

		try {

			DataUtilities.calculateRowTotal(null, 0);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");

		} catch (Exception e) {

			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}

	// Checks number of values added together in row 0. total to 1 or return assert message
	@Test
	public void testValidDataAndRowTotalTrue() {
		assertEquals("Wrong sum returned. It should be 1.0", 1.0, DataUtilities.calculateRowTotal(values2D, 0));
	}
	
	// Checks number of values added together in row 1. total to 4 or return assert message
	@Test
	public void testValidDataAndRowTotalFalse() {
		assertEquals("Wrong sum returned. It should be 4.0", 3.0, DataUtilities.calculateRowTotal(values2D, 1));
	}

	// Returns exception because of null value
	@Test
	public void testNullNumberArrayData() {

		try {

			DataUtilities.createNumberArray(null);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");

		} catch (Exception e) {

			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}

	// checks values within created number array are the same as the data values provided
	@Test
	public void testValidNumberArrayDataTrue() {

		arrayNumberValues = DataUtilities.createNumberArray(arrayDoubleValues);

		for (int i = 0; i < arrayNumberValues.length - 1; i++) {
			assertEquals("Mismatch at Position " + i, arrayNumberValues[i], arrayDoubleValues[i]);
		}
	}
	
	// checks values within created number array are the same as the data values provided
	@Test
	public void testValidNumberArrayDataFalse() {

		arrayNumberValues = DataUtilities.createNumberArray(arrayDoubleValues);

		for (int i = 0; i < arrayNumberValues.length - 1; i++) {
			assertEquals("Mismatch at Position " + i, arrayNumberValues[i], arrayDoubleFalseValues[i]);
		}
	}

	// Returns exception because of null value
	@Test
	public void testNullNumberArrayData2D() {

		try {

			DataUtilities.createNumberArray2D(null);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");

		} catch (Exception e) {

			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}

	// checks values within created 2D number array are the same as the data values provided
	@Test
	public void testValidNumberArrayData2DTrue() {
		arrayNumberValues2D = DataUtilities.createNumberArray2D(arrayDoubleValues2D);

		for (int i = 0; i < arrayNumberValues2D.length - 1; i++) {
			assertEquals("Mismatch at Position " + i, arrayNumberValues2D[i][i], arrayDoubleValues2D[i][i]);
		}
	}
	
	// checks values within created 2D number array are the same as the data values provided
	@Test
	public void testValidNumberArrayData2DFalse() {
		arrayNumberValues2D = DataUtilities.createNumberArray2D(arrayDoubleValues2D);

		for (int i = 0; i < arrayNumberValues2D.length - 1; i++) {
			assertEquals("Mismatch at Position " + i, arrayNumberValues2D[i][i], arrayDoubleFalseValues2D[i][i]);
		}
	}

	// Returns exception because of null value
	@Test
	public void testNullCumulativePercentages() {

		try {

			DataUtilities.getCumulativePercentages(null);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");

		} catch (Exception e) {

			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}

	// Checks percentage value is correct with the values provided.
	@Test
	public void testValidCumulativePercentagesTrue() {
		double percentageValue1 = (double) DataUtilities.getCumulativePercentages(testKeyedValues).getValue(0);
		assertEquals("Wrong percentage returned. It should be 0.4", percentageValue1,
				DataUtilities.getCumulativePercentages(testKeyedValues).getValue(0));

		double percentageValue2 = (double) DataUtilities.getCumulativePercentages(testKeyedValues).getValue(1);
		assertEquals("Wrong percentage returned. It should be 1.2", percentageValue2,
				DataUtilities.getCumulativePercentages(testKeyedValues).getValue(1));

		double percentageValue3 = (double) DataUtilities.getCumulativePercentages(testKeyedValues).getValue(2);
		assertEquals("Wrong percentage returned. It should be 1.4", percentageValue3,
				DataUtilities.getCumulativePercentages(testKeyedValues).getValue(2));
	}
	
	// Checks percentage value is correct with the values provided.
	@Test
	public void testValidCumulativePercentagesFalse() {
		double percentageValue1 = (double) DataUtilities.getCumulativePercentages(testKeyedValues).getValue(0);
		assertEquals("Wrong percentage returned. It should be 0.4", percentageValue1,
				DataUtilities.getCumulativePercentages(testKeyedValues).getValue(1));

		double percentageValue2 = (double) DataUtilities.getCumulativePercentages(testKeyedValues).getValue(1);
		assertEquals("Wrong percentage returned. It should be 1.2", percentageValue2,
				DataUtilities.getCumulativePercentages(testKeyedValues).getValue(2));

		double percentageValue3 = (double) DataUtilities.getCumulativePercentages(testKeyedValues).getValue(2);
		assertEquals("Wrong percentage returned. It should be 1.4", percentageValue3,
				DataUtilities.getCumulativePercentages(testKeyedValues).getValue(0));
	}
}
