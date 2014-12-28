package com.nhnent.task.model.dto;

public class BoardDTO {
	private String boardNo;
	private String email;
	private String password;
	private String createTime;
	private String attachment;
	private String body;
	
	public BoardDTO() {
		super();
	}
	
	public BoardDTO(String email, String password, String body) {
		super();
		this.email = email;
		this.password = password;
		this.body = body;
	}
	
	public BoardDTO(String email, String password, String attachment, String body) {
		super();
		this.email = email;
		this.password = password;
		this.attachment = attachment;
		this.body = body;
	}
	
	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String data) {
		this.attachment = data;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BoardDTO [boardNo=").append(boardNo).append(", email=")
				.append(email).append(", password=").append(password)
				.append(", createTime=").append(createTime).append(", attachment=")
				.append(attachment).append(", body=").append(body).append("]");
		return builder.toString();
	}
}
