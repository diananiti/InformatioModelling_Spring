angular.module('demo', []).controller(
    'usersCtrl',
    function($scope, $http) {
        $http.get('http://localhost:8090/v2/user').then(
            function(response) {
                $scope.users = response.data;
            });
        $scope.username="";
        $scope.email="";
        $scope.password="";
       // $scope.id="";
        $scope.edit = true;
        $scope.error = false;
        $scope.incomplete = false;
        $scope.hideform = true;
        $scope.editUser = function(id) {
            $scope.hideform = false;
            if (id == 'new') {
                $scope.edit = true;
                $scope.incomplete = true;
                $scope.id = '';
                $scope.username = '';
                $scope.password = '';
                $scope.email= '';
            } else {
                $scope.edit = true;
                $scope.username = $scope.users[id].username;
                $scope.email= $scope.users[id].email;
                $scope.id= $scope.users[id].id;
                $scope.password=$scope.users[id].password;
            }
        };

        $scope.saveUser = function() {
            var obj = {
                password : $scope.password,
               username: $scope.username,
                email: $scope.email,
                id:$scope.id
            };
            $scope.hideform = true;


            if($scope.id=='')
                $http.post('http://localhost:8090/v2/user', obj, {
                    headers : {
                        'Content-Type' : 'application/json; charset=UTF-8'
                    },
                    'Accept' : 'application/json'
                }).then(function onSuccess(data) {
                    window.alert(JSON.stringify(data.data));
                    $http.get('http://localhost:8090/v2/user').then(
                        function(response) {
                            $scope.users = response.data;
                        });

                }, function onError(err) {
                    // do something on error
                });
            else
                $http.put('http://localhost:8090/v2/user', obj, {
                    headers : {
                        'Content-Type' : 'application/json; charset=UTF-8'
                    },
                    'Accept' : 'application/json'
                }).then(function onSuccess(data) {
                    window.alert(JSON.stringify(data.data));
                    $http.get('http://localhost:8090/v2/user').then(
                        function(response) {
                            $scope.users = response.data;
                        });

                }, function onError(err) {
                    // do something on error
                });
            $scope.id=''
        };

        $scope.$watch('password', function() {
            $scope.test();
        });
        $scope.$watch('username', function() {
            $scope.test();
        });
        $scope.$watch('email', function() {
            $scope.test();
        });
        $scope.$watch('id', function() {
            $scope.test();
        });

        $scope.test = function() {
            $scope.incomplete = false;
            if ($scope.edit
                && (!$scope.username.length || !$scope.email.length || !$scope.password.length)) {
                $scope.incomplete = true;
            }
        };
    });