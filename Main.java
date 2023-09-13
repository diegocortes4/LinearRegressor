import java.util.ArrayList;
import java.util.List;

public class LinearRegressor {

  private double[] coefficients;
  
  public LinearRegressor(int numFeatures) {
    coefficients = new double[numFeatures];
  }

  public void train(List<DataPoint> data) {
    // Initialize coefficients to 0
    Arrays.fill(coefficients, 0);
    
    // Loop through data points
    for(DataPoint dp : data) {
      double[] features = dp.features;
      double target = dp.target;
      
      // Make prediction 
      double prediction = predict(features);
      
      // Calculate error
      double error = target - prediction;
      
      // Update coefficients to reduce error
      for(int i=0; i<coefficients.length; i++) {
        coefficients[i] += error * features[i]; 
      }
    }
  }

  public double predict(double[] features) {
    // Calculate dot product 
    double prediction = 0;
    for(int i=0; i<coefficients.length; i++) {
      prediction += coefficients[i] * features[i];
    }
    return prediction;
  }

}

class DataPoint {
  double[] features; 
  double target;
}