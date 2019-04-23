#!/bin/bash
sudo apt update -y
sudo apt install git -y
sudo apt install openjdk-8-jdk -y
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
sudo apt-get update -y
apt-cache policy docker-ce
sudo apt-get install -y docker-ce
sudo apt-get -y install python-pip
sudo pip install docker-compose
sudo docker pull selenoid/video-recorder:latest-release
sudo docker pull selenoid/chrome:72.0
sudo docker pull selenoid/chrome:71.0
sudo docker pull selenoid/firefox:66.0
sudo apt install unzip
wget https://services.gradle.org/distributions/gradle-5.4-bin.zip -P /tmp
sudo unzip -d /opt/gradle /tmp/gradle-*.zip
export GRADLE_HOME=/opt/gradle/gradle-5.4
export PATH=${GRADLE_HOME}/bin:${PATH}