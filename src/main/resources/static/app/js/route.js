angular.module('myApp').config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/chat');
    $stateProvider.state('nav', {
        abstract : true,
        url : '',
        views : {
            'nav@' : {
                templateUrl : 'app/views/nav.html',
                controller : 'NavController'
            }
        }
    }).state('login', {
        url : '/login',
        views : {
            'content@' : {
                templateUrl : 'app/views/login.html',
                controller : 'NavController'
            }
        }
    }).state('chat', {
        parent : 'nav',
        url : '/chat',
        views : {
            'content@' : {
                templateUrl : 'app/views/chat.html',
                controller : 'NavController'
            }
        }
    }).state('user', {
        parent : 'nav',
        url : '/user',
        views : {
            'content@' : {
                templateUrl : 'app/views/user-config.html',
                controller : 'NavController'
            }
        }
    }).state('friends', {
        parent : 'nav',
        url : '/friends',
        views : {
            'content@' : {
                templateUrl : 'app/views/friends.html',
                controller : 'NavController'
            }
        }
    }).state('find', {
        parent : 'nav',
        url : '/find',
        views : {
            'content@' : {
                templateUrl : 'app/views/find-friend.html',
                controller : 'NavController'
            }
        }
    }).state('register', {
        url : '/register',
        views : {
            'content@' : {
                templateUrl : 'app/views/register.html',
                controller : 'NavController'
            }
        }
    });
});