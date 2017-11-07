<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Add Rules </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	        
            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.submitRule()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrl.rule.id" />
					

					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Rule Name</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.rule.name" value="Auto Electricals- Full Units (MJPR 180 and 181)"  id="uname1" 

class="username form-control input-sm" placeholder="Enter Rule Name"  ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>
					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Product/Distributor Name</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.rule.productName" value="Auto Electricals- Full Units (MJPR 180 and 181)"  id="uname1" 

class="username form-control input-sm" placeholder="Enter Product/Distributor Name"  ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>
					
					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Target Value</label>
	                        <div class="col-md-7">
	                            <input type="text" value="Zing-1706001" id="uname2" ng-model="ctrl.rule.minValue" class="username form-control input-sm" 

placeholder="Enter Target Value"  />
	                        </div>
	                    </div>
	                </div>
					
					
					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Incentive Percentage</label>
	                        <div class="col-md-7">
	                            <input type="text" value="2016" id="uname4"   ng-model="ctrl.rule.incentivePercentage" class="username form-control 

input-sm" placeholder="Enter Previous Year"  />
	                        </div>
	                    </div>
	                </div>
					
								

	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="{{!ctrl.rule.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.

$invalid || myForm.$pristine">
	                        <button type="button" ng-click="ctrl.resetRule()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset 

Form</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Rules </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>ID</th>
		                <th>Rule Name</th>
		                <th>Distributor Name</th>
		                <th>Target</th>
		                <th>Incentive Percentage</th>
		                <th>Rule Detail</th>
		                <th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr >
		                <td>1</td>
		                <td>Growth Rule</td>
		                 <td>All</td>
		                <td>7600000</td>
		                  <td>0.1</td>
		                  <td> <b> if </b> "Total Turover-Actual Sales" is <b>Greater than</b>
		                  <br> "Total Turover-Target Sales" <br> <b>And</b>  "Sum of Net Value Current Year" is <b>
 Greater than</b><br> "Sum of Net Value Previous Year" <br>
		                  <b>then</b> Incentive will be Total Turover-Actual Salesx0.1
		                  </td>
		                <td><button type="button"  class="btn btn-success custom-width">Edit</button></td>
		                <td><button type="button"  class="btn btn-danger custom-width">Remove</button></td>
		            </tr>
		             <tr>
		                <td>2</td>
		                <td>Target Acheived Rule</td>
		                 <td>All</td>
		                <td>7600000</td>
		                  <td>0.1</td>
		                  <td> <b> if </b> "Total Turover-Actual Sales" is <b>Greater than</b>
		                  <br> "Total Turover-Target Sales" <br>
		                  <b>then</b> Incentive will be Total Turover-Actual Salesx0.1
		                  </td>
		                <td><button type="button"  class="btn btn-success custom-width">Edit</button></td>
		                <td><button type="button"  class="btn btn-danger custom-width">Remove</button></td>
		            </tr>
		            <tr>
		                <td>3</td>
		                <td>Incentive Rule</td>
		                 <td>All</td>
		                <td>7600000</td>
		                  <td>0.1</td>
		                  <td> <b> if </b> "Total Turover-Actual Sales" is <b>Greater than</b>
		                  <br> "Total Turover-Target Sales" <br> <b>And</b>  "Sum of Net Value Current Year" is <b>
 Greater than</b><br> "Sum of Net Value Previous Year" <br>
		                  <b>then</b> Incentive will be Total Turover-Actual Salesx0.1
		                  </td>
		                <td><button type="button"  class="btn btn-success custom-width">Edit</button></td>
		                <td><button type="button"  class="btn btn-danger custom-width">Remove</button></td>
		            </tr>
		            
		           
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>