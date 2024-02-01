#!/bin/bash
# this script runs on the server
# it stops the server, compiles the java, 
#    replaces the systemd file, and restarts
#

# get the java ready
rm -rf $HOME/.m2
mvn clean
mvn compile
mvn package
echo "------ Java Compile Complete"

# kill the running service
systemctl --user stop  ${1}.service
echo "------ Service Stopped"

# replace the systemd file
mkdir --parents $HOME/.config/systemd/user
cp -f scripts/${1}.service $HOME/.config/systemd/user/${1}.service
systemctl --user daemon-reload
echo "------ systemd unit file replaced"

# restart the running service
systemctl --user start  ${1}.service
echo "------ service restarted"
systemctl --user status ${1}.service
echo "------ Done"

