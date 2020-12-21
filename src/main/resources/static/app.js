var app = angular.module('app', []);
const baseUrl = 'http://localhost:8080/'

app.controller('indexController', function ($scope, $http) {
    location.replace('/login');
});

app.controller('loginController', function ($scope, $http) {
    $scope.name = null;
    $scope.password = null;
    $scope.errorMessage = false;

    $scope.login = function () {
        $http({method: 'PUT', url: baseUrl + 'users/login', data: {name: $scope.name, password: $scope.password}})
            .then(function (response) {
                location.replace('/usuarios');
            }, function (error) {
                $scope.errorMessage = true;
            });
    };
});

app.controller('registerController', function ($scope, $http) {
    $scope.user = {};
    $scope.errorMessage = {user: null, cpfcnpj: null};

    $scope.register = function () {
        $scope.errorMessage = {user: null, cpfcnpj: null};

        $http({method: 'POST', url: baseUrl + 'users', data: $scope.user})
            .then(function (response) {
                location.replace('/usuarios');
            }, function (error) {
                if (error.data.message === "User already exists") {
                    $scope.errorMessage.user = true;
                } else if (error.data.message === "Invalid cpfcnpj") {
                    $scope.errorMessage.cpfcnpj = true;
                }
            });
    };
});

app.controller('userController', function ($scope, $http) {
    $scope.user = {};
    $scope.users = [];
    $scope.showUserForm = false;
    $scope.addresses = [];
    $scope.phones = [];

    $scope.loadUsers = function () {
        $http({method: 'GET', url: baseUrl + 'users'})
            .then(function (response) {
                $scope.users = response.data;
                $scope.addresses = response.data.userAddresses;
                $scope.phones = response.data.userPhones;
            });
    }

    $scope.createUser = function () {
        $http({method: 'POST', url: baseUrl + 'users', data: $scope.user})
            .then(function (response) {
                $scope.saveAddresses(response.data.id);
                $scope.savePhones(response.data.id);
            });
    }

    $scope.saveAddresses = function (userId) {
        if ($scope.addresses?.length) {
            $scope.user.userAddresses = this.addresses.map(function (address) {
                return address.userId = userId;
            });

            $http({method: 'PUT', url: baseUrl + 'user-addresses', data: $scope.user.userAddresses})
                .then(function (response) {
                    $scope.showUserForm = false;
                    location.reload();
                });
        }

    }

    $scope.savePhones = function (userId) {
        if ($scope.phones?.length) {
            $scope.user.userPhones = this.phones.map(function (phone) {
                return phone.userId = userId;
            });

            $http({method: 'PUT', url: baseUrl + 'user-phones', data: $scope.user.userPhones})
                .then(function (response) {
                    $scope.showUserForm = false;
                    location.reload();
                });
        }
    }

    $scope.openUserForm = function () {
        $scope.showUserForm = true;
    }

    $scope.addAddress = function () {
        if (!$scope.addresses) {
            $scope.addresses = [];
        }

        $scope.addresses = [...$scope.addresses, ...[new Address()]];
    }

    $scope.addPhone = function () {
        if (!$scope.phones) {
            $scope.phones = [];
        }

        $scope.phones = [...$scope.phones, ...[{userId: null, ddd: null, phone: null}]];
    }

    $scope.getFirstPhoneNumber = function (item) {
        if (!item.userPhones.length) {
            return "Não Informado";
        }

        return '(' + item.userPhones[0].ddd + ') ' + item.userPhones[0].phone;
    }

    $scope.getFirstUserAddress = function (item) {
        if (!item.userAddresses.length) {
            return "Não Informado";
        }

        return [
            item.userAddresses[0].address,
            item.userAddresses[0].number,
            item.userAddresses[0].district,
            item.userAddresses[0].city,
            item.userAddresses[0].state,
            item.userAddresses[0].country
        ].join(', ');
    }

    $scope.loadUsers();
});

class Address {
    constructor() {
        this.country = "BR";
    }

    address;
    number;
    district;
    city;
    state;
    country;
    userId;
};