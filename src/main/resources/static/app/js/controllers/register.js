angular.module('myApp')

.controller('RegisterController', function($http, $scope, $timeout, $state) {
	$scope.submit = function() {
		$http.post('http://localhost:8080/user/save', $scope.user).success(function() {
			$scope.user = null;
			$scope.message = "Registration successfull !";
            $timeout(function(){$state.go('login');}, 3000);
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
});
