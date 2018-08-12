<?php
include_once 'conexao.php'; 

    $ra2=$_POST['ra2'];
    $senha2=$_POST['senha2'];

    $sql = $dbcon->query("SELECT * FROM professor WHERE ra_professor='$ra2' AND senha='$senha2'");

    if(mysqli_num_rows($sql) > 0) {
        echo "login_ok";
    }else {
        echo "erro";
    }

    ?>