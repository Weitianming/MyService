
var app = angular.module('app', []);


app.controller('appCtrl',function($scope, $http){
    $scope.username = '';
    $scope.password = '';


    $scope.doLogin = function(){
        $http({
        
method: 'post',
url: 'http://www.yukij.com/HelloWorld',
data: {
'object':'login',
'message': { 'username':$scope.username, 'password':$scope.password, 'deviceId':'123456789' }



},

}).success(function(data){
console.log('asdasdasd    '+JSON.stringify(data));
//$location.url('http://www.yukij.com/main.html');

if(data.LoginResponse == 'OK'){
window.location = 'http://www.yukij.com/main.html';
};




}).error(function(data){


})
              



}







});



