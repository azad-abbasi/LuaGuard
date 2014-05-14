do
  local oldprint = print
  -- Store current print function as oldprint
  function print(s)
    --[[ Redefine print function, the usual print function can still be used
         through oldprint. The new one has only one argument.]]
    oldprint(s == "foo" and "bar" or s)
  end
end
