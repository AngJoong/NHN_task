package com.nhnent.task.model.dto;

public class BoardDTO {
	private String boardNo;
	private String email;
	private String password;
	private String createTime;
	private String modificationTime;
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
	public String getModificationTime() {
		return modificationTime;
	}
	public void setModificationTime(String modificationTime) {
		this.modificationTime = modificationTime;
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
		builder.append("BoardDTO [boardNo=");
		builder.append(boardNo);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", modificationTime=");
		builder.append(modificationTime);
		builder.append(", attachment=");
		builder.append(attachment);
		builder.append(", body=");
		builder.append(body);
		builder.append("]");
		return builder.toString();
	}
	
}
