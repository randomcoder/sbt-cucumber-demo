package uk.co.randomcoding.cucumberdemo

import xsbti.{AppConfiguration, AppMain}
import cucumber.api.cli.{Main => CucumberMain}

class Launcher extends AppMain {
  case class Exit(code: Int) extends xsbti.Exit

  override def run(configuration: AppConfiguration) = {
    val cucumberArgs = Seq("--glue", "uk.co.randomcoding.cucumberdemo", "classpath:feature")

    val res = CucumberMain.run(cucumberArgs.toArray, Thread.currentThread.getContextClassLoader)

    Exit(res)
  }
}
