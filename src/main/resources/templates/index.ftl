<!DOCTYPE html>

<html lang="en" ng-app="crudApp">
    <head>
        <title>Bosch Incentive App</title>
        <link href="css/bootstrap.css" rel="stylesheet"/>
        <link href="css/app.css" rel="stylesheet"/>
    </head>
    <style>
    .boschSuperGfxBorder {
    background: url(image/supergfx.png);
    background-size: 100%;
    height: 16px;
    width: 100%;
    background-position: 0 -40px;
}
    </style>
    <body ng-app="crudApp">

     <!--   <div ui-view></div>-->
        <script src="js/lib/angular.min.js" ></script>
        <script src="js/lib/angular-ui-router.min.js" ></script>
        <script src="js/lib/localforage.min.js" ></script>
        <script src="js/lib/ngStorage.min.js"></script>
        <script src="js/app/app.js"></script>
        <script src="js/app/DiscountService.js"></script>
        <script src="js/app/DiscountController.js"></script>
<!-- NAVIGATION -->

<div class="boschSuperGfxBorder"></div>
<nav class="navbar navbar-inverse" role="navigation">
    <div class="navbar-header">
        <a class="navbar-brand" ui-sref="home">Bosch AA TPM</a>
    </div>
    <ul class="nav navbar-nav">
    <li><a ui-sref="createRules">Create Rules</a></li>
        <li><a ui-sref="addRules">Create Schemes</a></li>
        <li><a ui-sref="addReportData">Sales Data</a></li>
        <li><a ui-sref="applyRule">Incentives</a></li>
        <li><a>Jagan</a></li>
        <li><a >Signout</a></li>
    </ul>
</nav>

<!-- MAIN CONTENT -->
<!-- THIS IS WHERE WE WILL INJECT OUR CONTENT ============================== -->
<div class="container">
    <div ui-view></div>
</div>

</body>
    </body>
</html>