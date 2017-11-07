'use strict';

angular.module('crudApp').factory('DiscountService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllDiscounts: loadAllDiscounts,
                getAllDiscounts: getAllDiscounts,
                getDiscount: getDiscount,
                createDiscount: createDiscount,
                updateDiscount: updateDiscount,
                removeDiscount: removeDiscount,
                uploadFileToUrl:uploadFileToUrl
            };

            return factory;
            
            
            
            
         function uploadFileToUrl(file){
                var fileFormData = new FormData();
                fileFormData.append('file', file);
             
                var deferred = $q.defer();
                
                $http.post(urls.USER_SERVICE_API_FILEUPLOAD, fileFormData, {
                    transformRequest: angular.identity,
                    headers: {'Content-Type': undefined}
     
                }).success(function (response) {
                	  loadAllDiscounts();
                      deferred.resolve(response.data);
     
                }).error(function (response) {
                	 console.error('Error while uploading Excel : '+errResponse.data.errorMessage);
                     deferred.reject(errResponse);
                });
     
                return deferred.promise;
                
             }
            
            

            function loadAllDiscounts() {
                console.log('Fetching all Discounts');
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all Discounts');
                            $localStorage.discounts = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading discounts');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
           
            function getAllDiscounts(){
                return $localStorage.discounts;
            }

            function getDiscount(id) {
                console.log('Fetching Discount with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Discount with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading Discount with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createDiscount(discount) {
                console.log('Creating discount');
                var deferred = $q.defer();
                $http.post(urls.USER_SERVICE_API, discount)
                    .then(
                        function (response) {
                            loadAllDiscounts();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating Discount : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
            
            
            function createRule(rule) {
                console.log('Creating rule');
                var deferred = $q.defer();
                $http.post(urls.USER_SERVICE_API_RULE, rule)
                    .then(
                        function (response) {
                            loadAllRules();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating Rule : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
            
            
            function updateDiscount(discount, id) {
                console.log('Updating Discount with id '+id);
                var deferred = $q.defer();
                $http.put(urls.USER_SERVICE_API + id, discount)
                    .then(
                        function (response) {
                            loadAllDiscounts();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Discount with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeDiscount(id) {
                console.log('Removing Discount with id '+id);
                var deferred = $q.defer();
                $http.delete(urls.USER_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllDiscounts();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Discount with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]).factory('RuleService',
    	    ['$localStorage', '$http', '$q', 'urls',
    	        function ($localStorage, $http, $q, urls) {

    	            var factory = {
    	            		
    	            		loadAllRules:loadAllRules,
    	                createRule: createRule,
    	                getAllRules: getAllRules,
    	                getIncentives:getIncentives,
    	                getAllIncentives:getAllIncentives,
    	                getAllSchemeNames:getAllSchemeNames,
    	                getAllSchemeNamesFromDB:getAllSchemeNamesFromDB,
    	                loadAllRuleNamesFromDrools:loadAllRuleNamesFromDrools
    	              
    	            };

    	            return factory;
    	            
    	            function getAllSchemeNames(){
    	            
    	            var deferred = $q.defer();
    	            $http.get(urls.USER_SERVICE_API_LOADSCHEMES)
    	                .then(
    	                    function (response) {
    	                        console.log('Fetched successfully all schemes');
    	                        $localStorage.schemes = response.data;
    	                        deferred.resolve(response);
    	                    },
    	                    function (errResponse) {
    	                        console.error('ErroRuleloading rules');
    	                        deferred.reject(errResponse);
    	                    }
    	                );
    	            
    	            }
    	            

    	            function getAllRulesFromDrools() {
    	                console.log('Fetching all Rules From Drools');
    	                var deferred = $q.defer();
    	                $http.get(urls.USER_SERVICE_API_LOADDROOLSRULES)
    	                    .then(
    	                        function (response) {
    	                            console.log('Fetched successfully all Rules From Drools');
    	                            $localStorage.droolRulesForDropDown = response.data;
    	                            deferred.resolve(response);
    	                        },
    	                        function (errResponse) {
    	                            console.error('ErroRuleloading rules');
    	                            deferred.reject(errResponse);
    	                        }
    	                    );
    	                return deferred.promise;
    	            }
    	            
    	            
    	            function loadAllRules() {
    	                console.log('Fetching all Rules');
    	                getAllRulesFromDrools();
    	                var deferred = $q.defer();
    	                $http.get(urls.USER_SERVICE_API_RULE)
    	                    .then(
    	                        function (response) {
    	                            console.log('Fetched successfully all Rules');
    	                            $localStorage.rules = response.data;
    	                            deferred.resolve(response);
    	                        },
    	                        function (errResponse) {
    	                            console.error('ErroRuleloading rules');
    	                            deferred.reject(errResponse);
    	                        }
    	                    );
    	                return deferred.promise;
    	            }
    	            
    	            
    	            function getIncentives(schemeToApply){
    	            	
    	            	getAllSchemeNames();
    	            	console.log('Fetching all Incentives');
    	                var deferred = $q.defer();
    	                if(schemeToApply==null|| schemeToApply==''){
    	                	schemeToApply='No Rules';
    	                }
    	                $http.get(urls.USER_SERVICE_API_INCENTIVES+schemeToApply)
    	                    .then(
    	                        function (response) {
    	                            console.log('Fetched successfully all Incentives');
    	                            $localStorage.discounts = response.data;
    	                            deferred.resolve(response);
    	                        },
    	                        function (errResponse) {
    	                            console.error('ErroRuleloading rules');
    	                            deferred.reject(errResponse);
    	                        }
    	                    );
    	                return deferred.promise;
    	            }
    	            
    	            
    	            function getAllRules(){
    	                return $localStorage.rules;
    	            }
    	            function getAllIncentives(){
    	                return $localStorage.discounts;
    	            }
    	           function getAllSchemeNamesFromDB(){
    	        	   return $localStorage.schemes;
    	           }
    	           
    	           function loadAllRuleNamesFromDrools(){
    	        	   return $localStorage.droolRulesForDropDown;
    	           }
    	            
    	            function createRule(rule) {
    	                console.log('Creating rule');
    	                var deferred = $q.defer();
    	                $http.post(urls.USER_SERVICE_API_RULE, rule)
    	                    .then(
    	                        function (response) {
    	                            loadAllRules();
    	                            deferred.resolve(response.data);
    	                        },
    	                        function (errResponse) {
    	                           console.error('Error while creating Rule : '+errResponse.data.errorMessage);
    	                           deferred.reject(errResponse);
    	                        }
    	                    );
    	                return deferred.promise;
    	            }
    	            
    	            

    	        }
    	    ]);