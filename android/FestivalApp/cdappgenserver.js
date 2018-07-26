var http = require('http')
var url = require('url')
var ip = require('ip') // run: npm install ip
var path = require('path');
var fs = require('fs');
var express = require('express');
var fileUpload = require('express-fileupload');
var app = express();
const { exec } = require('child_process');

var port = 8080

console.log("Listening on: " + ip.address() + ":" + port);

app.use(fileUpload());

app.post('/uploadphoto', function(req, res) {
  if (!req.files) {
    return res.status(400).send('No files were uploaded.');
  }

  let splash = req.files.splash;
  let icon = req.files.icon;
  let map = req.files.map;
  
  savePhoto(splash, "splash.jpg");
  savePhoto(icon, "icon.jpg");
  savePhoto(map, "map.jpg");
});

app.get('/generateapp', function(req, res) {
  exec("./gradlew assembleDebug", (err, stdout, stderr) => {
    if (err) {
      // node couldn't execute the command
      return;
    }

    // the *entire* stdout and stderr (buffered)
    console.log(`stdout: ${stdout}`);
    console.log(`stderr: ${stderr}`);

    var appPath = path.resolve(__dirname, "app/build/outputs/apk/debug/app-debug.apk");

    if (res) {
      console.log("Sending file: " + appPath);
      res.sendFile(appPath);
    }
    else {
      console.log("res is undefined.");
    }
  });
});

function savePhoto(photo, filename) {
  var filePath = path.resolve(__dirname, "app/src/main/res/drawable/" + filename);

  photo.mv(filePath, function(err) {
    console.log("Error occurred: " + err);
  });
}

app.listen(port);
