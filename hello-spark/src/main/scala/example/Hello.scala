package example

import org.apache.spark.sql.SparkSession

object WordCount {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("WordCount")
      .master("local[*]")
      .getOrCreate()

    val input = spark.read.textFile("src/main/resources/input.txt")

    import spark.implicits._
    val words = input
      .flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .toDF("word", "count")

    val wordCounts = words.groupBy("word").sum("count")

    wordCounts.show()

    spark.stop()
  }
}
