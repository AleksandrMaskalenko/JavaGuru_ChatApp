angular.module('myApp')

.run(function($rootScope) {

})

.controller('WebChatController', function ($http, $scope, AuthService, $state, $rootScope, $timeout) {

    $rootScope.user = AuthService.user;

    $scope.$on('LoginSuccessful', function() {
        $rootScope.user = AuthService.user;
    });
    $scope.$on('LogoutSuccessful', function() {
        $rootScope.user = null;
    });
    $rootScope.logout = function() {
        AuthService.user = null;
        $rootScope.$broadcast('LogoutSuccessful');
        $state.go('login');
    };

    $scope.findFriend = function () {
        $http.get('http://localhost:8080/user/find/' + $scope.find).then(function (response) {

            $rootScope.users = response.data;
        });

        $scope.find = '';
    };

    $scope.addToFriends = function (user) {
        $http.post('http://localhost:8080/friend/add/' + user.id)
            .success(function () {
                $scope.message = "User added successfully!";
                $timeout(function(){$scope.message = '';}, 3000);
            })
            .error(function () {
                $scope.message = "This user already in a playlist!";
                $timeout(function(){$scope.message = '';}, 3000);
            });
    };


    $rootScope.loadFriends = function () {
        $http.get('http://localhost:8080/friend/userfriends/' + $scope.user.principal.id).then(function (response) {
            $rootScope.friends = response.data;
        });
    };

    $scope.delete = function (friend) {
        var idx = $scope.friends.indexOf(friend);
        $http.post('http://localhost:8080/friend/delete/' + friend.id).then($scope.friends.splice(idx, 1));
    };

    $scope.deleteUser = function () {
        $http.post('http://localhost:8080/user/delete/' + $scope.user.principal.id);
    };

    $scope.name = $scope.user.principal.username;
    $scope.email = $scope.user.principal.email;
    $scope.username = $scope.user.principal.username;
    $scope.password = $scope.user.principal.password;

    $scope.updateUser = function () {
        var userObjUpd = {
            id: $scope.user.principal.id,
            name: $scope.name,
            email: $scope.email,
            username: $scope.username,
            password: $scope.password
        };

        $http.post('http://localhost:8080/user/save', userObjUpd).success(function () {
            $scope.message = "User updated successfully!";
            $timeout(function(){
                $scope.message = '';
                $rootScope.logout();
                }, 1000);

        });
    };

    // $rootScope.convers();
    // $rootScope.convers = function () {
        $http.get('http://localhost:8080/conversation/userconv/' + $scope.user.principal.id).then(function (response) {
            $rootScope.conversations = response.data;
        });
    // };

    $scope.write = function (friend) {
        var utc = new Date().toJSON().slice(0,10).replace(/-/g,'/');
        var convObj = {
            title: friend.user.username,
            creationDate: utc,
            convType: 'pair',
            user: { id: $scope.user.principal.id}

        };

        $http.post('http://localhost:8080/conversation/create', convObj).success(function () {


        });
    }

});
