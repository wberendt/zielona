#!/usr/bin/env bash
echo "*** get info about java and maven ***"
java --version
mvn -v
echo "*************************************"
mvn clean install
