var myApp = angular.module('foursquareApp',[]);

myApp.controller('MainController', ['$scope', function($scope) {
    angular.element(document).ready(function () {
        $scope.initMap();
    });

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