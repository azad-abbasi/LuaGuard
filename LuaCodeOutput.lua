function iiliiixiiciijljiiiftjjlhp(iiliijiiitijiijjujrllyvim,iiliizilllijjjjvlijiicijl,iiliiiikjioiiljllzpjazili) 
io.write('[2J') 
end
function iiliiiiiiltuisilijjiiilii(iiliiiljleljjiiilitlsggvl,y,iiliiiillilijiiijiijlusji,iiliiijjluhjjjijsjvnilliu,iiliillulqilleylinjjiiiij,iiliiiijijiljiijijjeeljli) 
io.write(string.format('[%d;%dH*',y,iiliiiljleljjiiilitlsggvl) ) 
end
iiliieeyvljijilljylilanjj={['w']=80,['h']=24}

function iiliijjliliiiiyiejlrjwill(iiliiilxiliiiimiijjijlhij,iiliiiiyicijilliimujliiii,iiliiiizjlljlliljiiigljzn) 
iiliiixiiciijljiiiftjjlhp(iiliiicilfiijplpjieliaiii,iiliikjiiinljkilnaiioliij,iiliijiqiilililjirjlijjll) for i=1,iiliieeyvljijilljylilanjj.w do
local iiliiiljleljjiiilitlsggvl=(i/iiliieeyvljijilljylilanjj.w*2-1)
local y=(iiliiilxiliiiimiijjijlhij(iiliiiljleljjiiilitlsggvl) +1)/2*iiliieeyvljijilljylilanjj.h
iiliiiiiiltuisilijjiiilii(i,y,iiliiliijijliiijiijajmsjl,iiliiiigijiiiiiiiiviljjii,iiliijiijkllijijisjwwvxji,iiliisjiiqiailjijjjjiljjl) 
end
 io.read() 
end
iiliijjliliiiiyiejlrjwill(function (iiliiliiuljlnjlilsjinitlj) return math.sin(iiliiliiuljlnjlilsjinitlj*2*math.pi)   end ,iiliiiulijljgiljdizljizii,iiliipiisijilmoitjjibajpd) 