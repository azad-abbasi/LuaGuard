
function factorial(n)
  local x = 1
  for i = 2,n do
    x = x * i
  end
  return x
end

==================================================================
(CHUNK
    (ASSIGNMENT
        (VAR_LIST factorial)
        (EXPR_LIST
            (FUNCTION
                (PARAM_LIST n)
                (CHUNK
                    (LOCAL_ASSIGNMENT
                        (NAME_LIST x)
                        (EXPR_LIST 1)
                    )
                    (for i 2 n
                        (do
                            (CHUNK
                                (ASSIGNMENT
                                    (VAR_LIST x)
                                    (EXPR_LIST
                                        (* x i)
                                    )
                                )
                            )
                        )
                    )
                    (return x)
                )
            )
        )
    )
)