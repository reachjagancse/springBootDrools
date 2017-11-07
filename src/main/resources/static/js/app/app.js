var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/SpringBootCRUDApp',
    USER_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/discount/',
    	 USER_SERVICE_API_RULE : 'http://localhost:8080/SpringBootCRUDApp/api/rule/',
    	 USER_SERVICE_API_INCENTIVES:  'http://localhost:8080/SpringBootCRUDApp/api/inci/',
    	 USER_SERVICE_API_FILEUPLOAD:'http://localhost:8080/SpringBootCRUDApp/api/fileUpload/',
    		 USER_SERVICE_API_APPLYRULES:'http://localhost:8080/SpringBootCRUDApp/api/applyShemes/',
    			 USER_SERVICE_API_LOADSCHEMES:'http://localhost:8080/SpringBootCRUDApp/api/loadAllShemes/',
    			 USER_SERVICE_API_LOADDROOLSRULES:'http://localhost:8080/SpringBootCRUDApp/api/loadAllRuleNamesFromDrools/'
});


app.directive('fileModel', ['$parse', function ($parse) {
   return {
      restrict: 'A',
      link: function(scope, element, attrs) {
         var model = $parse(attrs.fileModel);
         var modelSetter = model.assign;
         
         element.bind('change', function(){
            scope.$apply(function(){
               modelSetter(scope, element[0].files[0]);
            });
         });
      }
   };
}]);




app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
        .state('home', {
            url: '/home',
            template: "<div><h1>Welcome to Bosch AA Trade Promotion Management!!!</h1><br>  <div>",
            controllerAs:'ctrl'
        })
         .state('createRules', {
            url: '/createRules',
            templateUrl: 'partials/createRules',
            controller:'RuleController',
            controllerAs:'ctrl',
        })
        
        .state('addRules', {
            url: '/addRules',
            templateUrl: 'partials/addRules',
            controller:'RuleController',
            controllerAs:'ctrl',
            resolve: {
                discounts: function ($q, RuleService) {
                    console.log('Load all Rules');
                    var deferred = $q.defer();
                    RuleService.loadAllRules().then(deferred.resolve, deferred.resolve);
                    return deferred.promise;
                }
            }
        })
        
        .state('applyRule', {
                url: '/applyRule',
                templateUrl: 'partials/incentiveDetails',
                controller:'RuleController',
                controllerAs:'ctrl',
                resolve: {
                    discounts: function ($q, RuleService) {
                        console.log('Load all Incentives');
                        var deferred = $q.defer();
                        RuleService.getIncentives('').then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            })
        
            .state('addReportData', {
                url: '/addReportData',
                templateUrl: 'partials/list',
                controller:'DiscountController',
                controllerAs:'ctrl',
                resolve: {
                    discounts: function ($q, DiscountService) {
                        console.log('Load all Discounts');
                        var deferred = $q.defer();
                        DiscountService.loadAllDiscounts().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
       <!-- $urlRouterProvider.otherwise('/');-->
    }]);

