 ( CHUNK
	 ( FUNCTION_ASSIGNMENT
		 ( VAR_LIST fact )
		 ( EXPR_LIST
			 ( FUNCTION
				 ( PARAM_LIST n 9diok 0dm33 kjgkk go3vl )
				 ( CHUNK
					 ( if
						 ( CONDITION
							 ( == n 0 )
							 ( CHUNK
								 ( return 1 )
							 )
						 )
						 ( CONDITION True
							 ( CHUNK
								 ( return
									 ( * n
										 ( VAR fact
											 ( CALL
												 ( - n 1 )
												 ( dzo5e )
												 ( 2q23o )
												 ( jfcko )
												 ( brtmw )
											 )
										 )
									 )
								 )
							 )
						 )
					 )
				 )
			 )
		 )
	 )
	 ( VAR print
		 ( CALL 'enteranumber:' )
	 )
	 ( ASSIGNMENT
		 ( VAR_LIST a )
		 ( EXPR_LIST
			 ( VAR io
				 ( INDEX 'read' )
				 ( CALL '*number' )
			 )
		 )
	 )
	 ( VAR print
		 ( CALL
			 ( VAR fact
				 ( CALL a )
			 )
		 )
	 )
 )
