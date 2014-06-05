 ( CHUNK
	 ( if
		 ( CONDITION
			 ( == 100
				 ( + 50 50 )
			 )
			 ( CHUNK
				 ( if
					 ( CONDITION
						 ( == op  ' + '  )
						 ( CHUNK
							 ( ASSIGNMENT
								 ( VAR_LIST r )
								 ( EXPR_LIST
									 ( + a b )
								 )
							 )
						 )
					 )
					 ( CONDITION
						 ( == op  ' - '  )
						 ( CHUNK
							 ( ASSIGNMENT
								 ( VAR_LIST r )
								 ( EXPR_LIST
									 ( - a b )
								 )
							 )
						 )
					 )
					 ( CONDITION
						 ( == op  ' * '  )
						 ( CHUNK
							 ( ASSIGNMENT
								 ( VAR_LIST r )
								 ( EXPR_LIST
									 ( * a b )
								 )
							 )
						 )
					 )
					 ( CONDITION
						 ( == op  ' / '  )
						 ( CHUNK
							 ( ASSIGNMENT
								 ( VAR_LIST r )
								 ( EXPR_LIST
									 ( / a b )
								 )
							 )
						 )
					 )
					 ( CONDITION True
						 ( CHUNK
							 ( VAR error
								 ( CALL  ' invalid operation '  )
							 )
						 )
					 )
				 )
			 )
		 )
	 )
 )
