<?php
function connect_db($host, $dbid, $dbpw, $dbname)
{
    return mysqli_connect($host, $dbid, $dbpw, $dbname);
}
?>

