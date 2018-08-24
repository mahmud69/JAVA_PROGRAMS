package com.mahmud.scala
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global

object RunningMultipleTasksWithFutures {

  def startTask(number: Int): Future[Unit] = Future {
    debug(s"Starting task#$number")
    Thread.sleep(2000) // wait 2secs
    debug(s"Finished task#$number")
  }

  def main(args: Array[String]): Unit = {
    debug("Starting Main")
    val tasks = Future.traverse(1 to 20)(startTask)
    debug("Continuing Main")
    // waits for all tasks to complete before exiting
    Await.result(tasks, Duration.Inf)
  }
    def debug(message: String): Unit = {
      val now = java.time.format.DateTimeFormatter.ISO_INSTANT
        .format(java.time.Instant.now)
        .substring(11, 23) // keep only time component
      val thread = Thread.currentThread.getName()
      println(s"$now [$thread] $message")
    }
}


