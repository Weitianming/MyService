/**
 * Created by Administrator on 2016/7/13.
 */
//var app = angular.module('myApp', []);
//app.controller('OrderFormController', function ($scope) {
//
//    $scope.services = [
//        {name: '苹果', price: 100, active: true},
//        {name: '香蕉', price: 200, active: false},
//        {name: '西瓜', price: 300, active: false},
//        {name: '黄焖鸡米饭', price: 200, active: false}
//    ];
//
//    $scope.toggleActive = function (s) {
//        s.active = !s.active;
//    };
//
//    $scope.total = function () {
//        var total = 0;
//        angular.forEach($scope.services, function (s) {
//            if (s.active) {
//                total += s.price;
//            }
//        });
//        return total;
//    };
//})


var app = angular.module('myApp', []);
app.controller('OrderFormController', function($scope, $http) {

    $http.get("commodity.json")
        .success(function(response) {$scope.services = response.commodity;});

    $scope.toggleActive = function (s) {
        s.active = !s.active;
    };

    $scope.total = function () {
        var total = 0;
        angular.forEach($scope.services, function (s) {
            if (s.active) {
                total += s.price;
            }
        });
        return total;
    };


});