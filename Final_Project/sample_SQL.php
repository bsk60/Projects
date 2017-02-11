<?php	
	
	$servername = getenv('IP');
    $username = getenv('C9_USER');
    define('DB_HOST', $servername);
    define('DB_USER', $username);
    define('DB_PASSWORD', '');
    define('DB_NAME', 'c9');
    
	$link = mysqli_connect(DB_HOST, DB_USER, DB_PASSWORD, DB_NAME);	
	
	//family_tree is the table name; 
	//patent_id, etc. are the table fields; 
	//values are all my variables I'm inserting into the database
	$User = 
	   "INSERT INTO c9(username, password)
		VALUES('{$username}', '{$password}');";			
	$Result = mysqli_query($link, $User);
				
				
	$selectUser = 
	   "SELECT *
		FROM c9
		WHERE patient_id = $patientID
			AND ($where);";
	$Result = mysqli_query($link, $selectF);
	
	
	while($credentials = mysqli_fetch_array($Result)){
		$User['username'] = $selectFamilyTreeRow['username'];
		$User['password'] = $selectFamilyTreeRow['password'];
		$familyMember['relationTranslated'] = _($selectFamilyTreeRow['relation']);
		$familyMember['gender'] = $selectFamilyTreeRow['gender'];
		$familyMember['degree'] = $selectFamilyTreeRow['degree'];
		$familyMember['familyTreeID'] = $selectFamilyTreeRow['family_tree_id'];		
		
		$familyTree[] = $familyMember;
	}
	
	$familyTree = json_encode($familyTree);
	print($familyTree);
	
	?>