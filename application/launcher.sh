#! /bin/bash

export http_proxy=
java -jar lib/sbt-launch.jar @conf/launcher.launch "$@"
