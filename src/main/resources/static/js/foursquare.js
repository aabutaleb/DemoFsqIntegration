var myApp = angular.module('foursquareApp',[]);

myApp.controller('MainController', ['$scope', "$http", function($scope, $http) {
    angular.element(document).ready(function () {
        $scope.initMap();
    });

    $scope.search = function(){
        console.log("Searching for: "+$scope.searchKeyword);

        $http.get('/foursquare/find/'+encodeURIComponent($scope.searchKeyword)).
            success(function(locations, status, headers, config) {
                var marker;
                $scope.markers = [];

                // Add the markers and infowindows to the map
                for (var i = 0; i < locations.length; i++) {
                    marker = new google.maps.Marker({
                        position: new google.maps.LatLng(locations[i].location.lat, locations[i].location.lng),
                        map: $scope.map,
                        icon : 'http://maps.google.com/mapfiles/ms/icons/orange-dot.png',
                        shadow: 'http://maps.google.com/mapfiles/ms/icons/msmarker.shadow.png'
                    });

                    $scope.markers.push(marker);

                    google.maps.event.addListener(marker, 'click', (function(marker, i) {
                        return function() {
                            $scope.infowindow.setContent(locations[i].name);
                            $scope.infowindow.open($scope.map, marker);
                        }
                    })(marker, i));
                }

                AutoCenter();
            }).
            error(function(data, status, headers, config) {
                console.log(data);
            });
    }

    function AutoCenter() {
        //  Create a new viewpoint bound
        var bounds = new google.maps.LatLngBounds();
        //  Go through each...
        $.each($scope.markers, function (index, marker) {
            bounds.extend(marker.position);
        });
        //  Fit these bounds to the map
        $scope.map.fitBounds(bounds);
    }

    $scope.initMap = function(){
        $scope.map = new google.maps.Map(document.getElementById('map'), {
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

        $scope.markers = new Array();
        $scope.infowindow = new google.maps.InfoWindow({
            maxWidth: 160
        });
    }
}]);