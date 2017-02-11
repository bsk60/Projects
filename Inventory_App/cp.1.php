<!doctype HTML>
<html>
    <head>
        <script src="https://code.jquery.com/jquery-latest.min.js"></script>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>       
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <link href="cp.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
        <script src="track.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapased" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-expande="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="brand" href="#"></a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-center">
                        <li class="active"><a href="#"><i class="fa fa-book"></i>Track</a></li>
                        <li><a href="preferences.html"><i class="fa fa-cogs"></i>Preferences</a></li>
                        <li><a href="index.html"><i class="fa fa-power-off"></i>Log out</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container-fluid">
        <div class="track">
            <div class="row-fluid grid location">
                <div class="col-md-6 col-md-offset-3">
                    <div class="btn-group">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Location <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li>Kitchen Freezer</li>
                            <li>Kitchen Refrigerator</li>
                            <li>Basement Refrigerator</li>
                            <li>Wine Room</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row-fluid grid">
                <div class='col-md-12 grid'>
                    <div class="container-fluid grid">
                        <ul class="row inventory_functions">
                            <li class="inventory_function col-sm-4">
                                <h2>Item Name</h2>
                            </li>
                            <li class="inventory_function col-sm-4">
                                <h2>Current Count</h2>
                            </li>
                            <li class="inventory_function col-sm-4">
                                <h2>Modify</h2>
                            </li>
                        </ul>
                        
                        <!-- List Items -->
                        <?php
                            /*Used to grab inventory contents and display to website
                              as an html list*/
                              
                            $items = array();
                            $item_count = array();
                            
                            //Grab contents of items.txt
                            $open_items = fopen('items.txt', 'r');  
                            
                            while (!feof($open_items))
                            {
                                $item = fgets($open_items);
                                $items[] = $item;
                            }
                            fclose($open_items);
                            
                            //Grab contents of count.txt
                            $open_count = fopen('count.txt', 'r');
                            
                            while (!feof($open_count))
                            {
                                $count = fgets($open_count);
                                $item_count[] = $count;
                            }
                            fclose($open_count);
                            
                            $i = 0;
                            foreach($items as $list_item) {
                                echo "<ul class='row inventory_items'>";
                                echo "<li class='inventory_item col-sm-4'>";
                                echo $list_item;
                                echo "</li>";
                                echo "<li class='inventory_item col-sm-4'>";
                                echo "<span id='{$list_item}'>".$item_count[$i]."</span>";
                                echo "</li>";
                                echo "<li class='inventory_item col-sm-4'>";
                                echo "<span class='glyphicon glyphicon-plus' title='{$list_item}_add' aria-hidden='true'></span> | <span class='glyphicon glyphicon-minus title='{$list_item}_subtract' aria-hidden='true'></span>";
                                echo "</li>";
                                echo "</ul>";
                                $i++;
                            }
                            
                            ?>
                        <!-- ul template
                        <ul class="row inventory_items">
                            <li class="inventory_item col-sm-4">
                                Item1
                            </li>
                            <li class="inventory_item col-sm-4">
                                4
                            </li>
                            <li class="inventory_item col-sm-4">
                                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> | <span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
                            </li>
                        </ul>
                        -->
                    </div>
                </div>
            </div>
        </div>
        </div>
        <footer class="footer">
          <div class="container">
            <p class="text-muted">Copyright 2016 The Inventory App. All rights reserved.</p>
          </div>
        </footer>
    </body>
</html>