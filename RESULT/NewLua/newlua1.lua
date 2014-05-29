function dependsMany() 
NumberItems=get_select_items() 
MaxNumber=table.maxn(NumberItems) 
if(MaxNumber<=1) then
msgbox('Needmorethanoneitmeselected','Error001') else 
for inc1=1,(MaxNumber-1) do
add_depend_item(NumberItems[MaxNumber],NumberItems[inc1]) 
end
 
end

end
