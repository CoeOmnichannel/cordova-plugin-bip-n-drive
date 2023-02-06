var exec = require('cordova/exec');
const pluginName = "GalpBipDriveImpl"

var exports = {
  
    launchParkingMeter: (success, error) => {
      exec(success, error, pluginName, 'launchParkingMeter')
    },
     
    openSDK: (success, error) => {
        exec(success, error, pluginName, 'openSDK')
      },
  
  }
  
module.exports = exports