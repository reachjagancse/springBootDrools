<script src="https://cdnjs.cloudflare.com/ajax/libs/angularjs-dropdown-multiselect/2.0.0-beta.10/src/angularjs-dropdown-multiselect.js"></script>
<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Create Schemes </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	        
            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.submitRule()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrl.rule.id" />
					

					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Scheme Name</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.rule.name" value="Auto Electricals- Full Units (MJPR 180 and 181)" 
	                             id="uname1" class="username form-control input-sm" placeholder="Enter Product Name"  ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>
	                
	                <div class="row">
	                 <div class="form-group col-md-12">
	                  <label class="col-md-2 control-lable" for="uname">Select Rules</label>
	                    <div class="col-md-7">
	              <select id="example27" multiple="multiple"  ng-model="ctrl.rule.rulesSelection" class="col-md-7">
        <option ng-repeat="list in ctrl.loadAllRuleNamesFromDrools()" value="{{list}}">{{list}}</option>
    </select>
    </div>
    </div>
    </div>
	                
	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="{{!ctrl.rule.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        <button type="button" ng-click="ctrl.resetRule()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Schemes List </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>ID</th>
		                <th>Scheme Name</th>
		                <th>Selected Rules</th>
		                <th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="u in ctrl.getAllRules()">
		                <td>{{u.id}}</td>
		                <td>{{u.name}}</td>
		                 <td>{{u.rulesSelected}}</td>
		                <td><button type="button"  class="btn btn-success custom-width">Edit</button></td>
		                <td><button type="button"  class="btn btn-danger custom-width">Remove</button></td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
   <!--<div><iframe id='ifrm' height='400' 
    src='http://localhost:8180/kie-drools-wb-7.3.0.Final-tomcat8?standalone=true&amp;perspective=org.guvnor.m2repo.client.perspectives.GuvnorM2RepoPerspective&amp;header=ComplementNavArea' width='600'></iframe> </div>
  -->
</div>