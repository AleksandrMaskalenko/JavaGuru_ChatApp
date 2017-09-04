angular.module('myApp')

.controller('LoginController', function($http, $scope, $state, AuthService, $rootScope) {


	function reload() {
        $http.get('http://localhost:8080/user/reload').success(function(res) {
            AuthService.user = res;
            $rootScope.$broadcast('LoginSuccessful');
            $state.go('home');
        });
    }

    reload();

	$scope.login = function() {

		var base64Credential = btoa($scope.username + ':' + $scope.password);

		$http.get('http://localhost:8080/user/user', {
			headers : {

				'Authorization' : 'Basic ' + base64Credential
			}
		}).success(function(res) {
			$scope.password = null;
			if (res.authenticated) {
				$scope.message = '';

				$http.defaults.headers.common['Authorization'] = 'Basic ' + base64Credential;
				AuthService.user = res.principal;
				$rootScope.$broadcast('LoginSuccessful');
				$state.go('home');
			} else {
				$scope.message = 'Authetication Failed !';
			}
		}).error(function(error) {
			$scope.message = 'Authetication Failed !';
		});
	};

	$rootScope.logout = function() {
        $http.post('http://localhost:8080/user/logout');

		$http.defaults.headers.common['Authorization'] = null;
		$scope.user = null;
		$scope.message = 'Successfully logged out';
		$scope.resource = null;
        $rootScope.$broadcast('LogoutSuccessful');
		$state.go('login');
	};
});
