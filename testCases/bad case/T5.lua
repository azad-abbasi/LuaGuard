 do
    -- Avoid heap allocs for performance
    local fcomp_default = function( a,b ) return a < b end
    function table.bininsert(t, value, fcomp)
       -- Initialise compare function
       local fcomp = fcomp or fcomp_default
       --  Initialise numbers
       local iStart,iEnd,iMid,iState = 1,#t,1,0
       -- Get insert position
       while iStart <= iEnd do
          -- calculate middle
          iMid = math.floor( (iStart+iEnd)/2 )
          -- compare
          if fcomp( value,t[iMid] ) then
             iEnd,iState = iMid - 1,0
          else
             iStart,iState = iMid + 1,1
          end
       end
       table.insert( t,(iMid+iState),value )
       return (iMid+iState)
    end
 end