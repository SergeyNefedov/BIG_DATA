import breeze.linalg._
import breeze.numerics.pow


class LinearRegression(n_iterations: Int, learning_rate: Double) {
  var w: DenseVector[Double] = DenseVector[Double]()

  def mse(y_true: DenseVector[Double], y_pred: DenseVector[Double]): Double = {
    val error = sum((y_true - y_pred).map(el => pow(el, 2)))
    error / y_true.length
  }

  def fit(X: DenseMatrix[Double], y: DenseVector[Double]): Unit = {
    this.w = DenseVector.zeros[Double](X.cols)
    for(_ <- 1 to this.n_iterations) {
      val preds = this.predict(X)
      val grad = 2.0 * X.t * (preds - y) / (y.length : Double)
      this.w = this.w - this.learning_rate * grad
    }
  }

  def predict(X : DenseMatrix[Double]): DenseVector[Double] = {
    X * this.w
  }
}