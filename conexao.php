<?php
        $host = "localhost";
        $usuario = "root";
        $senha = "";
        $banco = "femaapp";

        $dbcon = new MySqLi("$host","$usuario","$senha","$banco");

        if($dbcon->connect_error) {
            echo "erro de conexao";
        }
        
        mysqli_query($dbcon, "SET NAMES UTF8");
?>