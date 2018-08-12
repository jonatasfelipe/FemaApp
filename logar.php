<?php
include_once 'conexao.php'; 

    $ra=$_POST['ra'];
    $senha=$_POST['senha'];

    $sql = $dbcon->query("SELECT * FROM aluno WHERE ra_aluno='$ra' AND senha='$senha'");

    if(mysqli_num_rows($sql) > 0) {
        echo "login_ok";
    }else {
        echo "erro";
    }

    ?>