package practicaltwo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import practicaltwo.StatisticsCalculator;

// TODO: Make sure that you understand the purpose of each test case

/**
 * A JUnit test suite for StatisticsCalculator.
 *
 * @author Add Your Name
 */

public class TestStatisticsCalculator {

  @Test
  public void testCalculateUnitArithmeticMean() {
    Double[] values = {1.0, 1.0, 1.0};
    Double expectedMean = new Double((1.0 + 1.0 + 1.0) / 3);
    Double actualMean = StatisticsCalculator.calculateArithmeticMean(values);
    assertEquals(actualMean, expectedMean);
  }

  @Test
  public void testCalculateUnitTimesTenArithmeticMean() {
    Double[] values = {10.0, 10.0, 10.0};
    Double expectedMean = new Double((10.0 + 10.0 + 10.0) / 3);
    Double actualMean = StatisticsCalculator.calculateArithmeticMean(values);
    assertEquals(actualMean, expectedMean);
  }

  @Test
  public void testCalculateArithmeticMeanSubtraction() {
    Double[] values = {10.0, 10.0, 10.0};
    Double actualMean = StatisticsCalculator.calculateArithmeticMean(values);
    Double actualSubtraction =
        new Double(((10.0 - actualMean) + (10.0 - actualMean) + (10.0 - actualMean)));
    Double zero = new Double(0.0);
    assertEquals(actualSubtraction, zero);
  }

  @Test
  public void testCalculateArithmeticMeanAddition() {
    Double[] values = {10.0, 10.0, 10.0};
    Double actualMean = StatisticsCalculator.calculateArithmeticMean(values);
    Double[] valuesAddition = {15.0, 15.0, 15.0};
    Double actualMeanAddition = StatisticsCalculator.calculateArithmeticMean(valuesAddition);
    assertEquals(actualMeanAddition, new Double(actualMean + 5.0));
  }

  @Test
  public void testCalculateVarianceIsNonNegative() {
    Double[] values = {10.5, 1.0, 12.5};
    Double actualVariance = StatisticsCalculator.calculateVariance(values);
    assertTrue(actualVariance > 0);
  }

  @Test
  public void testCalculateVarianceIsZero() {
    Double[] values = {10.0, 10.0, 10.0};
    Double actualVariance = StatisticsCalculator.calculateVariance(values);
    assertEquals(actualVariance, new Double(0.0));
  }

  @Test
  public void testCalculateVarianceDoesNotVaryWithConstant() {
    Double[] values = {15.2, 11.0, 11.5};
    Double actualVariance = StatisticsCalculator.calculateVariance(values);
    Double[] valuesConstant = {16.2, 12.0, 12.5};
    Double actualVarianceConstant = StatisticsCalculator.calculateVariance(valuesConstant);
    assertEquals(actualVarianceConstant, actualVariance);
  }

  @Test
  public void testCalculateStandardDeviationIsZero() {
    Double[] values = {10.0, 10.0, 10.0};
    // TODO: Complete this method
  }

  @Test
  public void testCalculateStandardDeviationIsNonNegative() {
    Double[] values = {11.0, 12.0, 15.2};
    // TODO: Complete this method
  }

}
