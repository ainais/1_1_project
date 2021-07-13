package ex2_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dao")
public class MemberDAO {
	@Autowired
	private MemberBean member;
	
	public void insert() {
		member.output();
	}
	
	/*
	 * // setter public void setMember(MemberBean member) { this.member=member; } //
	 * constructor public MemberDAO() { }
	 * 
	 * public MemberDAO(MemberBean member) { this.member=member; }
	 */
	

}
