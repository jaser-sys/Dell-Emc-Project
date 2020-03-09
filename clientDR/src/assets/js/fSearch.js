
function checkInput() {
    var a = document.getElementById("filename").value;
    //alert(a);
    var y=document.getElementById("myDate").value;
    //alert(y);
    var x = document.getElementById("dropdown").value;
    document.getElementById("first").innerHTML = x;
    //alert(x);
}


function hide_all(){
    document.getElementById('filename').type = 'hidden';
    document.getElementById('dropdown').style.display = "none";
       document.getElementById('myDate').type = 'hidden';

}

function click_name() {
   if(document.getElementById("name").checked = true)
       document.getElementById('filename').type = 'text';
       document.getElementById('myDate').type = 'hidden';
   document.getElementById('dropdown').style.display = "none";

}

function click_size() {
   if(document.getElementById("size").checked = true)
       document.getElementById('dropdown').style.display = "block";
   document.getElementById('filename').type = 'hidden';
       document.getElementById('myDate').type = 'hidden';

}

function click_date() {
   if(document.getElementById("date").checked = true)
       document.getElementById('myDate').type = 'date';
       document.getElementById('filename').type = 'hidden';
   document.getElementById('dropdown').style.display = "none";


}
