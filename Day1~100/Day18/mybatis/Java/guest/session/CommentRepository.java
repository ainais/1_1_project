package mybatis.guest.session;

import java.io.*;
import java.util.*;

import mybatis.emp.model.Employee;
import mybatis.guest.model.Comment;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

public class CommentRepository 
{
	//	private final String namespace = "CommentMapper";

	private SqlSessionFactory getSqlSessionFactory() {
		
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		SqlSessionFactory sessFactory =  new SqlSessionFactoryBuilder().build(inputStream);
		return sessFactory;
	}
	
	public Integer insertComment(Comment comment) {
		// JDBC에서 connection 연결객체를 => mybatis에서는 SqlSession이라고 부른다.
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		try {
			String statement = "CommentMapper.insertComment";
			int result = sqlSess.insert(statement, comment);
			// JDBC는 auto-commit이다. mybatis는 auto-commit이 아니라서 자기가 직접 지정해야한다.
			if(result > 0 ) {
				sqlSess.commit();
			}else {
				sqlSess.rollback();
			}
			return result;
		}finally {
			sqlSess.close(); // 이것은 connection을 닫는 것이 아닌 반환이다. 개발자의 가시성을 위해 close로 명한 것이다.
		}
	} // end of insertComment
	
	public List<Comment> selectComment(){
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		try {
			String statement = "CommentMapper.selectComment";
			return sqlSess.selectList(statement); // 자동으로 list로 잡아준다.
		}finally {
			sqlSess.close();
		}
	} // end of selectComment
	
	public List<Comment> selectComment(HashMap map){
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		try {
			String statement = "CommentMapper.selectComment";
			return sqlSess.selectList(statement,map); // 자동으로 list로 잡아준다.
		}finally {
			sqlSess.close();
		}
	} // end of selectComment HashMap
	//========================================
	public  List<HashMap<String,String>> empSelect(){
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		try {
			String statement = "EmployeeMapper.empSelect";	
			return sqlSess.selectList(statement); //
		}finally {
			sqlSess.close();
		}
	} // end of selectComment HashMap
	
	public Comment selectComment(long commentNo){
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		try {

			HashMap map = new HashMap();
			map.put("commentNo", commentNo);
			String statement = "CommentMapper.selectComment";
			return sqlSess.selectOne(statement,map); 
		}finally {
			sqlSess.close();
		}
	} // end of selectCommentHashMap(commentNo)
	
	
	
	public Comment selectCommentByPK(long commentNo){
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		try {
			// 일반적인 처리
			String statement = "CommentMapper.selectCommentByPK";
			return sqlSess.selectOne(statement,commentNo); 
		}finally {
			sqlSess.close();
		}
	} // end of selectCommentPK
	
	public Integer deleteCommentByPK(long commentNo){
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		try {
			String statement = "CommentMapper.deleteCommentByPK";
			int result = sqlSess.insert(statement, commentNo);
			if(result > 0 ) {
				sqlSess.commit();
			}else {
				sqlSess.rollback();
			}
			return result; 
			
		}finally {
			sqlSess.close();
		}
	} // end of delete
	
	public Integer updateCommentByPK(Comment comment){
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		try {
			String statement = "CommentMapper.updateCommentByPK";
			int result = sqlSess.insert(statement, comment);
			if(result > 0 ) {
				sqlSess.commit();
			}else {
				sqlSess.rollback();
			}
			return result; 
			
		}finally {
			sqlSess.close();
		}
	} // end of update
	
	
	
	
	
	
	
	
}
