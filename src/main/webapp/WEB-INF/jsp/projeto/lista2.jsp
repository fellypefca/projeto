<!DOCTYPE html>

<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <style>
            #left{
                float: left;
                margin-left: 50px;
            }  

            .assoc_buttons{
                margin-left: 20px;
                width: 8em;
                margin-right: 20px;
                vertical-align: middle;
            }
            #right{
                clear: both;
                vertical-align: middle;   
            }
        </style>

    </head>
    <body>
      
    <form id="frm" name="frm">
        
        <select name="left" id="left" size="7">
            <option value="5">Location C</option>
            <option value="8">Location E</option>
        </select>
        
        <input type="button" class="assoc_buttons" name="btn_add" value="< Add" onclick="add();"><br>
        <input type="button" class="assoc_buttons" name="btn_add_all" value="<< Add All" onclick="add_all();"><br>
        <input type="button" class="assoc_buttons" name="btn_del" value="Delete >" onclick="del();"><br>
        <input type="button" class="assoc_buttons" name="btn_del_all" value="Delete All >>" onclick="del_all();">

        <select name="right" id="right" size="7">
            <option value="4">Location A</option>
            <option value="6">Location B</option>
            <option value="2">Location D</option>
            <option value="10">Location F</option>
            <option value="1">Location G</option>
            <option value="9">Location H</option>
            <option value="7">Location I</option>
            <option value="3">Location J</option>
            
        </select>
        
    </form>
    
<script type="text/javascript">

    function add(){
        
        var from = document.getElementById('right');
        var to = document.getElementById('left');
        
        if (from.selectedIndex == -1){
            alert ("No Locations were selected to be added.");
            return false;
        }
        
        var selectedOption = 
        
    }


</script>
          
    </body>  
</html>