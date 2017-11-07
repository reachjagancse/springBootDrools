        <div class="panel panel-default">

        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Apply Scheme</span></div>
		<div class="panel-body">
		
		 <div class="row">
	                 <div class="form-group col-md-12">
	                  <label class="col-md-2 control-lable" for="uname">Select Schemes</label>
	                    <div class="col-md-7">
	              <select id="example27" ng-model="ctrl.rulesToApply" class="col-md-7">
        <option ng-repeat="list in ctrl.getAllSchemeNames()" value="{{list.name}}">{{list.name}}</option>
        
        
    </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="submit"  value="Apply Rule" class="btn btn-primary btn-sm" ng-click="ctrl.getIncentives()">
    </div>
    
    </div>
    </div>
    
    
   
		</div>
		</div>
		</div>
    
    
    <div class="panel panel-default"  >
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Incentives</span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>ID</th>
		                <th>Sold to party name</th>
		                <th>Current Year</th>
		                
		                <th>Previous Year</th>
		                <th>Month</th>
		                <th>Target</th>
		                <th>Net Invoice (Current)</th>
		                <th>Sum Of Net Value (Current)</th>
		                <th>Sum of Net Value (Previous)</th>
		                <th>Growth</th>
		                <th>Incentive</th>
		                
		                <th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="u in ctrl.getAllIncentives()">
		                <td>{{u.id}}</td>
		                <td>{{u.name}}</td>
		                <td>{{u.currentYear}}</td>
		                
		                
		                  <td>{{u.previousYear}}</td>
		                <td>{{u.month}}</td>
		                <td>{{u.target}}</td>
		                <td>{{u.netInvoiceCurYear}}</td>
		                
		                  <td>{{u.sumOfNetValueCurYear}}</td>
		                <td>{{u.sumOfNetValueLastYear}}</td>
		                  <td>{{u.growth}} %</td>
		                <td>{{u.incentive}}</td>
		                
		                
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>