package com.hep.hfc.game;

public class PlayVO {
	private int play_no;
	private int stage_no;
	private int qna_no;
	private int member_no;
	private String user_answer;
	private Boolean answer_yn;
	private int money;
	private String ip;
	
	
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getPlay_no() {
		return play_no;
	}
	public void setPlay_no(int play_no) {
		this.play_no = play_no;
	}
	public int getStage_no() {
		return stage_no;
	}
	public void setStage_no(int stage_no) {
		this.stage_no = stage_no;
	}
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getUser_answer() {
		return user_answer;
	}
	public void setUser_answer(String user_answer) {
		this.user_answer = user_answer;
	}
	public Boolean getAnswer_yn() {
		return answer_yn;
	}
	public void setAnswer_yn(Boolean answer_yn) {
		this.answer_yn = answer_yn;
	}
	
	
}
