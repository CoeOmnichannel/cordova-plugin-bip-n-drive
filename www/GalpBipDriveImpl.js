

  module.exports = {
    launchParkingMeter: function(successCallback, errorCallback) {
      cordova.exec(successCallback, errorCallback, 'GalpBipDriveImpl', 'launchParkingMeter', []);
    },

    openSDK: function(successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, 'GalpBipDriveImpl', 'openSDK', []);
      },
 
  };
  