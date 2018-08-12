<?php

$host='localhost';
$username='root';
$pwd='';
$db="femaapp";

$dbcon=mysqli_connect($host,$username,$pwd,$db) or die('Impossivel estabelecer Conexão');

if(mysqli_connect_error($dbcon))
{
  echo "Falha na conexão com o BD ".mysqli_connect_error();
}

$query=mysqli_query($dbcon,"SELECT * FROM aluno");

if($query)
{
    while($row=mysqli_fetch_array($query))
  {
    $flag[]=$row;
  }

    print(json_encode($flag));
}
mysqli_close($dbcon);

?>