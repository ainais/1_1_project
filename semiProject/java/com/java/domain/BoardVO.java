package com.java.domain;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
   private String userID; //아이디
   private String boardID; //게시글 번호
   private String boardTitle; //제목
   private String boardContent; //내용
   private String boardRegdate; //등록일
   private String boardCnt; //조회수
   private String boardType; // 게시판 타입
   private String boardLike; //게시글 좋아요 갯수
   private String boardFname; // 업로드한 파일명
   private long boardFsize; //업로드한  
   private String boardIP;
   private String boardSecret;
   private String boardGrade;
   private String productName;
	//*************************************************
	// 멀티파트파일
	MultipartFile file;	// jsp에서 파일첨부시 name="file"과 동일한 변수명
	
	public MultipartFile getFile() {
		return file;
	}
	
	public void setFile(MultipartFile file) {
		this.file = file;
		
		
		//***********************************************
		// ▼ 업로드 파일 접근 ▼
		if(! file.isEmpty()){
			this.boardFname = file.getOriginalFilename();
			this.boardFsize = file.getSize();
			
			//***********************************************
			// ▼ 해당 경로로 변경 ▼ (그리고 경로 맞춰서 upload 폴더 만들기)
			File f = new File("D:\\1_2021_Java_Bigdata\\LJS_workspace\\springwork\\semiProject\\src\\main\\webapp\\resources\\upload\\"+boardFname);
			
			//***********************************************
			// ▼ try-catch ▼
			try {
				file.transferTo(f);
				
			} catch (IllegalStateException e) {				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
   public String getUserID() {
      return userID;
   }
   public void setUserID(String userID) {
      this.userID = userID;
   }
   public String getBoardID() {
      return boardID;
   }
   public void setBoardID(String boardID) {
      this.boardID = boardID;
   }
   public String getBoardTitle() {
      return boardTitle;
   }
   public void setBoardTitle(String boardTitle) {
      this.boardTitle = boardTitle;
   }
   public String getBoardContent() {
      return boardContent;
   }
   public void setBoardContent(String boardContent) {
      this.boardContent = boardContent;
   }
   public String getBoardRegdate() {
      return boardRegdate;
   }
   public void setBoardRegdate(String boardRegdate) {
      this.boardRegdate = boardRegdate;
   }
   public String getBoardCnt() {
      return boardCnt;
   }
   public void setBoardCnt(String boardCnt) {
      this.boardCnt = boardCnt;
   }
   public String getBoardType() {
      return boardType;
   }
   public void setBoardType(String boardType) {
      this.boardType = boardType;
   }
   public String getBoardLike() {
      return boardLike;
   }
   public void setBoardLike(String boardLike) {
      this.boardLike = boardLike;
   }
   public String getBoardFname() {
      return boardFname;
   }
   public void setBoardFname(String boardFname) {
      this.boardFname = boardFname;
   }
   
   public long getBoardFsize() {
	return boardFsize;
}

public void setBoardFsize(long boardFsize) {
	this.boardFsize = boardFsize;
}

public String getBoardIP() {
      return boardIP;
   }
   public void setBoardIP(String boardIP) {
      this.boardIP = boardIP;
   }
   public String getBoardSecret() {
      return boardSecret;
   }
   public void setBoardSecret(String boardSecret) {
      this.boardSecret = boardSecret;
   }
   public String getBoardGrade() {
      return boardGrade;
   }
   public void setBoardGrade(String boardGrade) {
      this.boardGrade = boardGrade;
   }
   public String getProductName() {
      return productName;
   }
   public void setProductName(String productName) {
      this.productName = productName;
   }
   
}