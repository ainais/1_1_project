package ex1_xml3_list;

import java.util.List;

public class ListBean {
	private List<Integer> intList;
	private List<MemberBean> memberList;
	// constructor
	
	// setter, getter
	public List<Integer> getIntList() {
		return intList;
	}
	public void setIntList(List<Integer> intList) {
		this.intList = intList;
	}
	public List<MemberBean> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<MemberBean> memberList) {
		this.memberList = memberList;
	}
	
	
}
