<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script>
function selectIngredient(select)
{
  var option = select.options[select.selectedIndex];
  var ul = select.parentNode.getElementsByTagName('ul')[0];
     
  var choices = ul.getElementsByTagName('input');
  for (var i = 0; i < choices.length; i++)
    if (choices[i].value == option.value)
      return;
     
  var li = document.createElement('li');
  var input = document.createElement('input');
  var text = document.createTextNode(option.firstChild.data);
     
  input.type = 'hidden';
  input.name = 'ingredients[]';
  input.value = option.value;

  li.appendChild(input);
  li.appendChild(text);
  li.setAttribute('onclick', 'this.parentNode.removeChild(this);');     
    
  ul.appendChild(li);
}

</script>
</head>
<body>
<ul>
 <li onclick="this.parentNode.removeChild(this);">
  <input type="hidden" name="ingredients[]" value="Cheese" />
  Cheese
 </li>
 <li onclick="this.parentNode.removeChild(this);">
  <input type="hidden" name="ingredients[]" value="Ham" />
  Ham
 </li>
 <li onclick="this.parentNode.removeChild(this);">
  <input type="hidden" name="ingredients[]" value="Mushrooms" />
  Mushrooms
 </li>
</ul>
<select onchange="selectIngredient(this);">
 <option value="Cheese">Cheese</option>
 <option value="Olives">Olives</option>
 <option value="Pepperoni">Pepperoni</option>

</select>
</body>
</html>
