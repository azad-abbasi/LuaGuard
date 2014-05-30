b=2
function fsbtfUfsnjobm(iiliiisuiilll,iiliillillicn,iiliijiljlrjj,iiliijllilzli) 
io.write('[2J') 
end
function nbsl(y,y,iiliitjjilwlj) 
io.write(string.format('[%d;%dH*',y,y) ) 
end
UfsnTjaf={['w']=80,['h']=24}

function qmpu(g,iiliijziloill,iiliiizrxglbi) 
fsbtfUfsnjobm(iiliiiejcilii,iiliiljilrlge,iiliiijjuvsii,iiliiwbjiiijj) for i=1,UfsnTjaf.w do
local y=(i/UfsnTjaf.w*2-1)
local y=(g(y) +1)/2*UfsnTjaf.h
nbsl(i,y,iiliiinjiajii) 
end
 io.read() 
end
qmpu(function (y) return math.sin(y*2*math.pi)   end ,iiliiiiicoilh,iiliiiliwjfhj) 