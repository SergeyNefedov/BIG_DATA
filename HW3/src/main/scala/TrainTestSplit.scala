import breeze.linalg._

class TrainTestSplit(test_size: Double ) {
  def split(df: DenseMatrix[Double]):
  (DenseMatrix[Double], DenseVector[Double], DenseMatrix[Double], DenseVector[Double]) = {
    val bound = scala.math.ceil(df.rows * this.test_size).toInt
    val X_train = df(0 until bound, 0 until df.cols - 1)
    val X_test = df(bound until df.rows, 0 until df.cols - 1)
    val y_train = df(0 until bound, df.cols - 1)
    val y_test = df(bound until df.rows, df.cols - 1)
    (X_train, y_train, X_test, y_test)
  }
}