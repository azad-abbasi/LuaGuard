function permgen(a,n) 
if(n==0) then
coroutine.yield(a) else 
for i=1,n do
a[n],a[i]=a[i],a[n]
permgen(a,(n-1)) a[n],a[i]=a[i],a[n]

end
 
end

end
function perm(a) 
local n=table.getn(a) 
return coroutine.wrap(function () permgen(a,n)  end )  
end
function printResult(a) 
for i,v in ipairs(a) do
io.write(v,'') 
end
io.write('') 
end
for p in perm({'a','b','c'}
) do
printResult(p) 
end
