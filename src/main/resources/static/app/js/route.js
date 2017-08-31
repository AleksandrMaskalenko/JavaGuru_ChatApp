angular.module('myApp').config(function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise('/page-not-found');
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
				controller : 'LoginController'
			}
		}
	}).state('page-not-found', {
        parent : 'nav',
        url : '/page-not-found',
        views : {
            'content@' : {
                templateUrl : 'app/views/page-not-found.html',
                controller : 'PageNotFoundController'
            }
        }
    }).state('register', {
        url : '/register',
        views : {
            'content@' : {
                templateUrl : 'app/views/register.html',
                controller : 'RegisterController'
            }
        }
    }).state('home', {
        parent : 'nav',
        url : '/',
        views : {
            'content@' : {
                templateUrl : 'app/views/chat.html',
                controller : 'WebChatController'
            }
        }
    }).state('friends', {
        parent : 'nav',
        url : '/friends',
        views : {
            'content@' : {
                templateUrl : 'app/views/friends.html',
                controller : 'WebChatController'
            }
        }
    }).state('find', {
        parent : 'nav',
        url : '/find',
        views : {
            'content@' : {
                templateUrl : 'app/views/find-friend.html',
                controller : 'WebChatController'
            }
        }
    }).state('user', {
        parent : 'nav',
        url : '/user',
        views : {
            'content@' : {
                templateUrl : 'app/views/user-config.html',
                controller : 'WebChatController'
            }
        }
    });
});
