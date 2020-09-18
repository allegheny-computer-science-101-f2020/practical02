package practicaltwo;

// TODO: Add in the correct import for the DecimalFormat class
// NOTE: If you do not add this import then the program will not compile

/**
 * This class provides static methods that calculate statistical values.
 *
 * @author Add Your Name
 */
public class StatisticsCalculator {

  /**
   * Calculates the arithmetic mean of Double values in an array.
   *
   * @param timings the list of Double values from timing an algorithm
   */
  public static Double calculateArithmeticMean(Double[] timings) {
    double runningTotal = 0.0;
    // TODO: Make sure that you understand how this for loop works
    for (int i = 0; i < timings.length; i++) {
      runningTotal = runningTotal + timings[i];
    }
    // TODO: Make sure that you understand how casting works in Java
    return runningTotal / (double)timings.length;
  }

  /**
   * Calculates the variance of Double values in an array.
   *
   * @param timings the list of Double values from timing an algorithm
   */
  public static Double calculateVariance(Double[] timings) {
    Double arithmeticMean = calculateArithmeticMean(timings);
    Double runningTotal = 0.0;
    // TODO: Add for loop and correct computation here
    return runningTotal / ((double)timings.length - 1);
  }

  /**
   * Calculates the standard deviation of Double values in an array.
   *
   * @param timings the list of Double values from timing an algorithm
   */
  public static Double calculateStandardDeviation(Double[] timings) {
    // TODO: use a static method in Math to calculate the standard deviation
    return 0.0;
  }

  /**
   * Create an array of double values and then calculate statistics.
   */
  public static void main(String[] args) {
    Double[] values = {12.5, 6.2, 1.5, 2.9, 10.8};
    System.out.println("Displaying the values in the array.");
    ArrayPrinter.print(values);
    Double arithmeticMean = StatisticsCalculator.calculateArithmeticMean(values);
    Double variance = StatisticsCalculator.calculateVariance(values);
    Double standardDeviation = StatisticsCalculator.calculateStandardDeviation(values);
    // TODO: Make sure that you added the correct import above ^^^ so that this works
    DecimalFormat formatter = new DecimalFormat("#.00");
    System.out.println("Displaying the output with two decimal places.");
    System.out.println("This is the arithmetic mean: " + formatter.format(arithmeticMean));
    // TODO: Add the other output statements to create the correct output
    // see the README file in your GitHub repository for an output example
  }

}
