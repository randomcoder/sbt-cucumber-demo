package uk.co.randomcoding.cucumberdemo

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers

class CucumberDemoSteps extends ScalaDsl with EN with Matchers {
  private[this] var message = ""

  Given("""^a simple test that will log '(.+)'$""") { (m: String) => {
      message = m
      println(s"Given log message: $message")
    }
  }

  When("""^the test is launched using the application launcher with the arguments '(.+)'$"""){ (args: String) =>
    println(s"given arguments: $args")
  }

  Then("""^the test will log the phrase '(.+)'$""") { (expectedMessage: String) =>
    println(s"I was told to log: $message")
    message should be (expectedMessage)
  }
}
