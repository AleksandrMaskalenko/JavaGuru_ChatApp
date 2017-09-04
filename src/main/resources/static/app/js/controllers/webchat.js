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
        $http.post('http://localhost:8080/user/logout');
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
        $http.get('http://localhost:8080/friend/userfriends/' + $scope.user.id).then(function (response) {
            $rootScope.friends = response.data;
        });
    };

    $scope.delete = function (friend) {
        var idx = $scope.friends.indexOf(friend);
        $http.post('http://localhost:8080/friend/delete/' + friend.id).then($scope.friends.splice(idx, 1));
    };

    $scope.deleteUser = function () {
        $http.post('http://localhost:8080/user/delete/' + $scope.user.id);
    };

    $rootScope.loadUserData = function () {
        $rootScope.name = $scope.user.name;
        $rootScope.email = $scope.user.email;
        $rootScope.username = $scope.user.username;
        $rootScope.password = $scope.user.password;
    };

    $scope.updateUser = function () {
        var userObjUpd = {
            id: $scope.user.id,
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


    $rootScope.participants = [];

    $rootScope.convers = function () {
        $rootScope.participants = [];
        $rootScope.convtitle = '';
        $rootScope.addUser = false;
        $rootScope.trash = false;
        $rootScope.sing_out = false;
        $rootScope.particip = false;

        $http.get('http://localhost:8080/conversation/userconv/' + $scope.user.id).then(function (response) {
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
            user: { id: $scope.user.id}

        };

        $http.post('http://localhost:8080/conversation/create', convObj).success(function () {
            $rootScope.convers();
        });
    };

    var messages_array = [];
    $rootScope.convtitle = '';
    $rootScope.addUser = false;
    $rootScope.trash = false;
    $rootScope.sing_out = false;
    $rootScope.particip = false;
    $rootScope.addUserForm = false;

    $scope.loadChat = function (conversation) {
        $rootScope.participants = [];
        messages_array = [];

        convers = conversation;

        if (conversation.convType === 'group') {
            $rootScope.convtitle = 'group chat: ' + conversation.title;
        } else {
            $rootScope.convtitle = conversation.title;
        }


        if ((conversation.user.id === $scope.user.id) && ('group' === conversation.convType)) {
            $rootScope.addUser = true;
        } else {
            $rootScope.addUser = false;
        }

        if ((conversation.user.id !== $scope.user.id) && ('group' === conversation.convType)) {
            $rootScope.trash = false;
            $rootScope.sing_out = true;
        } else {
            $rootScope.trash = true;
            $rootScope.sing_out = false;
        }

        if ('group' === conversation.convType) {
            $rootScope.particip = true;
        } else {
            $rootScope.particip = false;
        }


        function compare(a,b) {
            if (a.date < b.date)
                return -1;
            if (a.date > b.date)
                return 1;
            return 0;
        };
        
        var messFrom = function (id) {
            if (id === $scope.user.id) {
               return 'message-remote'
            } else {
                return 'message-local'
            }
        };

        $http.get('http://localhost:8080/message/load/' + conversation.conv_id).then(function (response) {

            for (var message of response.data) {
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
                userName: $scope.user.username,
                from: 'message-remote'
            };
            messages_array.push(newMessageObj);
            $scope.text = null;

        });

    };

    $scope.groupChatForm = false;
    $scope.participantsForm = false;

    $scope.addGroupChatForm = function () {
        if ($scope.groupChatForm === true) {
            $scope.groupChatForm = false;
        } else {
            $scope.groupChatForm = true;
        }


    };

    $scope.addGroupChat =function () {

        var utc = new Date().toJSON().slice(0,10).replace(/-/g,'/');
        var convObj = {
            title: $scope.addGroupTitle,
            creationDate: utc,
            convType: 'group',
            user: { id: $scope.user.id}

        };

        $http.post('http://localhost:8080/conversation/create', convObj).success(function () {
            $rootScope.convers();
        });

        $scope.groupChatForm = false;

    };

    $rootScope.showParticipants = function () {
        if ($rootScope.participants.length !== 0) {
            $rootScope.participants = [];
            $rootScope.participForm = false;
        } else {
            $http.get('http://localhost:8080/participant/load/' + convers.conv_id).then(function (response) {

                $rootScope.participForm = true;
                $rootScope.participants = response.data;
            });
        }


    };

    $rootScope.addUserAction = function () {
        if ($rootScope.addUserForm === true) {
            $rootScope.addUserForm = false;
        } else {
            $rootScope.addUserForm = true;
        }

        $rootScope.loadFriends();


    };

    $scope.addU = function (user) {
        var newParticipObj = {
            user: user,
            conversation: convers,
        };

        $http.post('http://localhost:8080/participant/add', newParticipObj).success(function () {

        });

        $rootScope.participants.push(newParticipObj);
    };

    $scope.deleteU = function (participant) {
        var idx = $scope.participants.indexOf(participant);
        $http.post('http://localhost:8080/participant/delete/' + participant.part_id).then($scope.participants.splice(idx, 1));

    };

    $scope.deleteGroup = function () {
        $http.post('http://localhost:8080/participant/deleteall/' +  convers.conv_id).success(function () {
            $rootScope.convers();
            $scope.messages = [];
        });
        $http.post('http://localhost:8080/message/deleteall/' +  convers.conv_id);
        $http.post('http://localhost:8080/conversation/deleteconv/' +  convers.conv_id);

    };

    $scope.singOut = function () {
        $http.post('http://localhost:8080/participant/deletebyuser/' +  convers.conv_id).success(function () {
            $rootScope.convers();
            $scope.messages = [];
        });
    }




});
