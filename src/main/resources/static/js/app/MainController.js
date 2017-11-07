'use strict';


angular.module('crudApp').controller("MainController", function($scope, $http) {
  $scope.menus = [
  {
    title: "Menu1", 
    action: "#", 
    menus: [
      {
        title: "Submenu 1a",
        action: "stuff"
      },
      {
        title: "Submenu 1b",
        action: "moreStuff",
        menus: [
          {
            title: "Submenu 1b 1",
            action: "stuff"
          },
          {
            title: "Submenu 1b 2",
            action: "moreStuff"
          }
        ]
      }
    ]
  },

]
});
