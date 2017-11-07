<div class="generic-container">


<div class="panel panel-default">
  <div class="panel-heading"><span class="lead">Bulk Upload Sales Data </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
       <form  name="excelUpload" class="form-horizontal">
	            
	            
	            <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Excel Upload</label>
	                        <div class="col-md-7">
	                        
	                         <div>
         <input type = "file" file-model = "ctrl.file"/>
         <button ng-click = "ctrl.uploadFile()">Upload</button>
      </div>
	                            
	                        </div>
	                    </div>
	                </div>
	            
	             
	             
	             </form>
	             </div>
	             </div></div>
	             
</div>



    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Add Sales Data </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	        
            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	      
	             
	             
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	            
	            
	            
	                <input type="hidden" ng-model="ctrl.discount.id" />
					

					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Product Name</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.discount.name" value="Auto Electricals- Full Units (MJPR 180 and 181)"  id="uname1" class="username form-control input-sm" placeholder="Enter  Name"  ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>
					
					
				<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Target Sales</label>
	                        <div class="col-md-7">
	                            <input type="text" value="Zing-1706001" id="uname2" ng-model="ctrl.discount.target" class="username form-control input-sm" placeholder="Enter Target Sales"  />
	                        </div>
	                    </div>
	                </div>
	                
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Actual Sales</label>
	                        <div class="col-md-7">
	                            <input type="text" value="Zing-1706001" id="uname2" ng-model="ctrl.discount.netInvoiceCurYear" class="username form-control input-sm" placeholder="Enter Actual Sales"  />
	                        </div>
	                    </div>
	                </div>
	                
	                
					
					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Current Year</label>
	                        <div class="col-md-7">
	                            <input type="text" value="2017" id="uname3" ng-model="ctrl.discount.currentYear"  class="username form-control input-sm" placeholder="Enter Current Year"  />
	                        </div>
	                    </div>
	                </div>
					
					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Previous Year</label>
	                        <div class="col-md-7">
	                            <input type="text" value="2016" id="uname4"   ng-model="ctrl.discount.previousYear" class="username form-control input-sm" placeholder="Enter Previous Year"  />
	                        </div>
	                    </div>
	                </div>
					
					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Month</label>
	                        <div class="col-md-7">
	                            <input type="text" value="May" id="uname5"   class="username form-control input-sm" ng-model="ctrl.discount.month"
								placeholder="Enter Month"  />
	                        </div>
	                    </div>
	                </div>
					
								
					 <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Sum of Billed Qty(Last Year)</label>
	                        <div class="col-md-7">
	                            <input type="text" value="8315000" ng-model="ctrl.discount.sumOfBilledQtyLastYear" id="uname7" class="username form-control input-sm" placeholder="Enter Sum of Billed Qty(Last Year)"  />
	                        </div>
	                    </div>
	                </div>
					
					
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Sum of Net Value(Last Year)</label>
	                        <div class="col-md-7">
	                            <input type="text" value="147163" ng-model="ctrl.discount.sumOfNetValueLastYear" id="uname8" class="username form-control input-sm" placeholder="Enter Sum of Net Value(Last Year)"  />
	                        </div>
	                    </div>
	                </div>


 <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="age">Sum of Billed Qty(Current Year)</label>
	                        <div class="col-md-7">
	                            <input type="text" value="107726" ng-model="ctrl.discount.sumOfBilledQtyCurYear" id="age" class="form-control input-sm" placeholder="Enter Sum of Billed Qty(Current Year)"  />
								<!--ng-pattern="ctrl.onlyIntegers"-->
	                        </div>
	                    </div>
	                </div>
	                
	                
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="age">Sum of Net Value (Current Year)</label>
	                        <div class="col-md-7">
	                            <input type="text" value="107726" ng-model="ctrl.discount.sumOfNetValueCurYear" id="age" class="form-control input-sm" placeholder="Enter Sum of Net Value (Current Year)"  />
								<!--ng-pattern="ctrl.onlyIntegers"-->
	                        </div>
	                    </div>
	                </div>
	
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="salary">Growth</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.discount.growth" id="salary"  ng-disabled="true" class="form-control input-sm" placeholder="This Will be Calculated based on above input fields" 
	                            ng-pattern="ctrl.onlyNumbers"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="{{!ctrl.discount.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Sales Data </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>ID</th>
		                <th>Sold to party name</th>
		                <th>Target Sales</th>
		                 <th>Actual Sales</th>
		                <th>Current Year</th>
		                <th>Previous Year</th>
		                <th>Month</th>
		                
		                <th>Sum of Billed Qty(Previous)</th>
		                    <th>Sum of Net Value (Previous)</th>
		                    <th>Sum of Billed Qty(Current)</th>
		                <th>Sum Of Net Value (Current)</th>
		               
		            
		                <th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="u in ctrl.getAllDiscounts()">
		                <td>{{u.id}}</td>
		                <td>{{u.name}}</td>
		                <td>{{u.target}}</td>
		                  <td>{{u.netInvoiceCurYear}}</td>
		                <td>{{u.currentYear}}</td>
		                  <td>{{u.previousYear}}</td>
		                <td>{{u.month}}</td>
		                
		                
		                  <td>{{u.sumOfBilledQtyLastYear}}</td>
		                <td>{{u.sumOfNetValueLastYear}}</td>
		                
		                <td>{{u.sumOfBilledQtyCurYear}}</td>
		                
		                  <td>{{u.sumOfNetValueCurYear}}</td>
		               
		                
		                
		                <td><button type="button" ng-click="ctrl.editDiscount(u.id)" class="btn btn-success custom-width">Edit</button></td>
		                <td><button type="button" ng-click="ctrl.removeDiscount(u.id)" class="btn btn-danger custom-width">Remove</button></td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>