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

    $rootScope.loadUserData = function () {
        $rootScope.name = $scope.user.principal.name;
        $rootScope.email = $scope.user.principal.email;
        $rootScope.username = $scope.user.principal.username;
        $rootScope.password = $scope.user.principal.password;
    };

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



    $rootScope.convers = function () {
        $http.get('http://localhost:8080/conversation/userconv/' + $scope.user.principal.id).then(function (response) {
            $rootScope.conversations = response.data;
        });
    };

    $rootScope.convers();

    $scope.write = function (friend) {
        var utc = new Date().toJSON().slice(0,10).replace(/-/g,'/');
        var convObj = {
            title: friend.user.username,
            creationDate: utc,
            convType: 'pair',
            user: { id: $scope.user.principal.id}

        };

        $http.post('http://localhost:8080/conversation/create', convObj).success(function () {
            $rootScope.convers();
        });
    };

    var messages_array = [];

    $scope.loadChat = function (conversation) {
        messages_array = [];

        convers = conversation;

        $rootScope.convtitle = conversation.title;

        function compare(a,b) {
            if (a.date < b.date)
                return -1;
            if (a.date > b.date)
                return 1;
            return 0;
        }
        
        var messFrom = function (id) {
            if (id === $scope.user.principal.id) {
               return 'message-remote'
            } else {
                return 'message-local'
            }
        };

        $http.get('http://localhost:8080/message/load/' + conversation.conv_id).then(function (response) {

            for (let message of response.data) {
                var newMessageObj = {
                    text: message.text,
                    date: message.date,
                    userName: message.user.username,
                    from: messFrom(message.user.id)
                };
                messages_array.push(newMessageObj);
            }
            $scope.messages = messages_array.sort(compare);
        });

    };

    $scope.messageInput = function () {
        var convMessObj = {
            text: $scope.text,
            date: Date.now(),
            conversation: convers
        };

        $http.post('http://localhost:8080/message/save', convMessObj).success(function () {
            var newMessageObj = {
                text: convMessObj.text,
                date: convMessObj.date,
                userName: $scope.user.principal.username,
                from: 'message-remote'
            };
            messages_array.push(newMessageObj);
            $scope.text = null;

        });

    };


});
