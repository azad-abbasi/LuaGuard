function basicSerialize(o) 
if(type(o) =='number') then
return tostring(o)  else 
return string.format('%q',o)  
end

end
function save(name,value,saved) 
saved=saved or {}

io.write(name,'=') if(type(value) =='number' or type(value) =='string') then
io.write(basicSerialize(value) ,'') elseif(type(value) =='table') then
if(saved[value]) then
io.write(saved[value],'') else 
saved[value]=name
io.write('{}') for k,v in pairs(value) do
local fieldname=string.format('%s[%s]',name,basicSerialize(k) ) 
save(fieldname,v,saved) 
end

end
else 
error('cannotsavea'..type(value) ) 
end

end
a={{'one','two'}
,3}

b={['k']=a[1]}

local t={}

save('a',a,t) save('b',b,t) 