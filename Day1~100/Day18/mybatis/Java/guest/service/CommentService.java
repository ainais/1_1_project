package mybatis.guest.service;

import java.util.*;

import mybatis.guest.model.Comment;
import mybatis.emp.model.Employee;
import mybatis.guest.session.CommentRepository;

public class CommentService {
	
	private static CommentService service;
	
	private CommentService() {}
	public static CommentService getInstance(){
		if( service == null) service = new CommentService();
		return service;
	}
	
	CommentRepository repo = new CommentRepository();
	
	public Integer insertComment(Comment comment) {
		
		return repo.insertComment(comment);
	}
	
	public List<Comment> selectComment(){
		return repo.selectComment();
	}
	
	public List<Comment> selectComment(HashMap map){
		return repo.selectComment(map);
	}
	
	public Comment selectComment(long commentNo){
		return repo.selectComment(commentNo);
	}
	public Comment selectCommentByPK(long commentNo){
		return repo.selectCommentByPK(commentNo);
	}
	
	public Integer deleteCommentByPK(long commentNo) {
		return repo.deleteCommentByPK(commentNo);
	}
	public Integer updateCommentByPK(Comment comment) {
		return repo.updateCommentByPK(comment);
	}
	//=====================================
	public  List<HashMap<String,String>> empSelect(){
		return repo.empSelect();
	}
}