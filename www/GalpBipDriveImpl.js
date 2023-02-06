var GalpBipDriveImpl = (function () {
    var GalpBipDriveImpl = (typeof exports !== 'undefined' && exports) || {};
    var exec = cordova.require('cordova/exec'); // eslint-disable-line no-undef
   
  
    GalpBipDriveImpl.launchParkingMeter = function (success, fail) {
      return exec(success, fail, 'GalpBipDriveImpl', 'launchParkingMeter');
    };
  
    GalpBipDriveImpl.openSDK = function (success, fail) {
      return exec(success, fail, 'GalpBipDriveImpl', 'openSDK');
    };
   
    return GalpBipDriveImpl;
  })();
  
  module.exports = GalpBipDriveImpl;