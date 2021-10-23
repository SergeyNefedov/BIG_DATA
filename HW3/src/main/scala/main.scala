import java.io._
import breeze.linalg._


object main {
  def main(args: Array[String]): Unit = {

    val learning_rate: Double = 0.001
    val n_iterations: Int = 1000
    val train_size: Double = 0.8
    val log_path: String = "log.txt"

    val train_data = csvread(new File(args(0)),',')

    val output = new File(args(1))
    val logger = new PrintWriter(log_path)

    val split = new TrainTestSplit(train_size)
    val (x_train, y_train, x_test, y_test) = split.split(train_data)

    val model = new LinearRegression(n_iterations, learning_rate)
    logger.write("Create model...\n")
    model.fit(x_train, y_train)
    logger.write("Fit model...\n")

    var y_pred = model.predict(x_train)
    var mse = model.mse(y_train, y_pred)
    logger.write("Train predict...\n")
    logger.write("Train mse: " + mse + "\n")

    y_pred = model.predict(x_test)
    mse = model.mse(y_test, y_pred)
    logger.write("Test predict...\n")
    logger.write("Test mse: " + mse + "\n")

    csvwrite(output, y_pred.toDenseMatrix.t)
    logger.write("Save predict in file" + args(1))
    logger.close()
  }
}