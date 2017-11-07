'use strict';

angular.module('crudApp').controller('DiscountController',
    ['DiscountService', '$scope',  function( DiscountService, $scope) {

        var self = this;
        self.discount = {};
        self.discounts=[];

        self.file = '';
        self.submit = submit;
        self.getAllDiscounts = getAllDiscounts;
        self.createDiscount = createDiscount;
        self.updateDiscount = updateDiscount;
        self.removeDiscount = removeDiscount;
        self.editDiscount = editDiscount;
        self.reset = reset;
        self.uploadFile=uploadFile;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit() {
            console.log('Submitting');
            if (self.discount.id === undefined || self.discount.id === null) {
                console.log('Saving New Discount', self.discount);
                createDiscount(self.discount);
            } else {
                updateDiscount(self.discount, self.discount.id);
                console.log('Discount updated with id ', self.discount.id);
            }
        }
        
       
        function createDiscount(discount) {
            console.log('About to create discount');
            DiscountService.createDiscount(discount)
                .then(
                    function (response) {
                        console.log('Discount created successfully');
                        self.successMessage = 'Discount created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.discount={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Discount');
                        self.errorMessage = 'Error while creating Discount: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateDiscount(discount, id){
            console.log('About to update discount');
            DiscountService.updateDiscount(discount, id)
                .then(
                    function (response){
                        console.log('Discount updated successfully');
                        self.successMessage='Discount updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Discount');
                        self.errorMessage='Error while updating Discount '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeDiscount(id){
            console.log('About to remove Discount with id '+id);
            DiscountService.removeDiscount(id)
                .then(
                    function(){
                        console.log('Discount '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing Discount '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllDiscounts(){
            return DiscountService.getAllDiscounts();
        }

        
       function uploadFile(){
            var file = self.file;
            
            console.log('file is ' );
            console.dir(file);
            DiscountService.uploadFileToUrl(file);
         };
         
         
         
         
        function editDiscount(id) {
            self.successMessage='';
            self.errorMessage='';
            DiscountService.getDiscount(id).then(
                function (discount) {
                    self.discount = discount;
                },
                function (errResponse) {
                    console.error('Error while removing discount ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.discount={};
            $scope.myForm.$setPristine(); //reset Form
        }
        

    }


    ]).controller('RuleController',
    	    ['RuleService', '$scope',  function( RuleService, $scope) {

    	    	
    	        var self = this;
    	        
self.getAllSchemeNames=getAllSchemeNames;
    	        self.displayIncentives=false;

    	        self.droolRulesForDropDown = [];
    	        
    	        
    	        self.getIncentives=getIncentives;
    	        
    	        self.discount = {};
    	        self.discounts=[];

    	        
    	        self.rule = {};
    	        self.rules=[];
    	        self.loadAllRuleNamesFromDrools=loadAllRuleNamesFromDrools;
    	        
    	        self.getAllIncentives=getAllIncentives;
    	        self.submitRule=submitRule;
    	               
    	        self.getAllRules = getAllRules;
    	        self.createRule = createRule;
    	        self.rulesToApply='';
    	        
    	       
    	        self.resetRule = resetRule;

    	        self.successMessage = '';
    	        self.errorMessage = '';
    	        self.done = false;

    	        self.onlyIntegers = /^\d+$/;
    	        self.onlyNumbers = /^\d+([,.]\d+)?$/;
    	        
    	        self.schemes=[];
    	        self.schemes={};

    	        function getAllRules(){
    	            return RuleService.getAllRules();
    	        }
    	        
    	        function getAllIncentives(){
    	            return RuleService.getAllIncentives();
    	        }

function getIncentives(){
	RuleService.getIncentives(self.rulesToApply);
}



function loadAllRuleNamesFromDrools(){
	self.droolRulesForDropDown=RuleService.loadAllRuleNamesFromDrools();
	return self.droolRulesForDropDown;
}



function getAllSchemeNames(){
	
	self.schemes=RuleService.getAllSchemeNamesFromDB();
	
	return self.schemes;
	
}
    	        
    	        
    	        function submitRule() {
    	            console.log('Submitting');
    	            if (self.rule.id === undefined || self.rule.id === null) {
    	                console.log('Saving New rule', self.rule);
    	                createRule(self.rule);
    	            } else {
    	                updateRule(self.rule, self.rule.id);
    	                console.log('rule updated with id ', self.rule.id);
    	            }
    	        }
    	        function createRule(rule) {
    	            console.log('About to create rule');
    	            RuleService.createRule(rule)
    	                .then(
    	                    function (response) {
    	                        console.log('Rule created successfully');
    	                        self.successMessage = 'Rule created successfully';
    	                        self.errorMessage='';
    	                        self.done = true;
    	                        self.rule={};
    	                        $scope.myForm.$setPristine();
    	                    },
    	                    function (errResponse) {
    	                        console.error('Error while creating Rule');
    	                        self.errorMessage = 'Error while creating Rule: ' + errResponse.data.errorMessage;
    	                        self.successMessage='';
    	                    }
    	                );
    	        }
    	        
    	        
    	       
    	        function resetRule(){
    	            self.successMessage='';
    	            self.errorMessage='';
    	            self.discount={};
    	            $scope.myForm.$setPristine(); //reset Form
    	        }
    	        

    	    }


    	    ]);