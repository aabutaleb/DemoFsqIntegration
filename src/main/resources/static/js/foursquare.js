var myApp = angular.module('foursquareApp',[]);

myApp.controller('MainController', ['$scope', "$http", function($scope, $http) {
    angular.element(document).ready(function () {
        $scope.initMap();
    });

    $scope.search = function(){
        console.log("Searching for: "+$scope.searchKeyword);

        $http.get('/foursquare/find/'+encodeURIComponent($scope.searchKeyword)).
            success(function(data, status, headers, config) {
                // this callback will be called asynchronously
                // when the response is available
            }).
            error(function(data, status, headers, config) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            });
    }

    $scope.initMap = function(){
        new google.maps.Map(document.getElementById('map'), {
            zoom: 12,
            center: new google.maps.LatLng(51.507906, -0.139755),
            mapTypeId: google.maps.MapTypeId.ROADMAP,
            mapTypeControl: false,
            streetViewControl: false,
            panControl: false,
            zoomControlOptions: {
                position: google.maps.ControlPosition.LEFT_BOTTOM
            }
        });
    }
}]);