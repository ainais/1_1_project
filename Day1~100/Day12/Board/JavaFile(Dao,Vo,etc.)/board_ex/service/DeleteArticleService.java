package board_ex.service;

import board_ex.model.*;

public class DeleteArticleService {
	
	private static DeleteArticleService instance;
	public static DeleteArticleService getInstance()  throws BoardException{
		if( instance == null )
		{
			instance = new DeleteArticleService();
		}
		return instance;
	}
	
	public int delete( String id, String password ) throws BoardException{
		
		int result = BoardDao.getInstance().delete(id, password);
	
		return result;
		
	}
}
