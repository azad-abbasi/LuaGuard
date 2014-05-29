printResult = ""

    function print (...)
      for i,v in ipairs(arg) do
        printResult = printResult .. tostring(v) .. "\t"
      end
      printResult = printResult .. "\n"
    end