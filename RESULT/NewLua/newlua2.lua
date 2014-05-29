do
local oldprint=print
function print(s) 
oldprint(s=='foo' and 'bar' or s) 
end

end
