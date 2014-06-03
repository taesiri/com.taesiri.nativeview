var ncaller = {
    makeNativeCall: function(parameters,  successCallback, errorCallback) {
        cordova.exec(
            successCallback, // success callback function
            errorCallback, // error callback function
            'NativeListener', // mapped to our native Java class called "CalendarPlugin"
            'nativeCall', // with this action name
            [{                  // and this array of custom arguments to create our entry
                "params": parameters
            }]
        );
    }
}
module.exports = ncaller;
