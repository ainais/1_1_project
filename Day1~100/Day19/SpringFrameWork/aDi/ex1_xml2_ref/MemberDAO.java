package ex1_xml2_ref;

public class MemberDAO {
	private MemberBean member;
	
	// setter
	public void setMember(MemberBean member) {
		this.member=member;
	}
	// constructor
	public MemberDAO() {
	}
	
	public MemberDAO(MemberBean member) {
		this.member=member;
	}
	
	public void insert() {
		member.output();
	}
}
