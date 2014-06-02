a = 5
function b(s,t)
d = t*2-s + 40
while d>1 do
s = s+1
d = d-1
end
return s
end
local s = a + b(2,20)
print(s+a)