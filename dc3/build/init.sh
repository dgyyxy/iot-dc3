#!/bin/sh

app_path=$(cd $(dirname $0);pwd);
project_name=iot-dc3
git_url=https://github.com/pnoker/iot-dc3.git

echo "[*] app path $app_path"
echo "[*] project $project_name"
echo "[*] git url $git_url"

cd $app_path
cd ../

git pull origin master
mvn clean -U package
cd webpage
npm install

echo "[*] init success"
