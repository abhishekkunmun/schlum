var toDo = angular.module('toDo', []);


function eic(strTerm, strToSearch) 
{ 
strToSearch = strToSearch.toLowerCase(); 
strTerm = strTerm.toLowerCase(); 
if(strToSearch==strTerm) 
{ 
return true; 
} else { 
return false; 
} 
}