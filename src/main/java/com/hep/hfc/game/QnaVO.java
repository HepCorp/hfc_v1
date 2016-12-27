package com.hep.hfc.game;

public class QnaVO {

	private int qna_no;
	private int stage_no;
	private String stage_nm;
	private String question;
	private String answer;
	private String attach_type;
	private String attach_file;
	private int money;
	private String user_answer;
	private Boolean answer_yn;

	public QnaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QnaVO(int qna_no, int stage_no, String question, String answer, String attach_type, String attach_file,
			int money, String user_answer, Boolean answer_yn) {
		super();
		this.qna_no = qna_no;
		this.stage_no = stage_no;
		this.question = question;
		this.answer = answer;
		this.attach_type = attach_type;
		this.attach_file = attach_file;
		this.money = money;
		this.user_answer = user_answer;
		this.answer_yn = answer_yn;
	}

	@Override
	public String toString() {
		return "QnaVO [qna_no=" + qna_no + ", stage_no=" + stage_no + ", question=" + question + ", answer=" + answer
				+ ", attach_type=" + attach_type + ", attach_file=" + attach_file + ", money=" + money
				+ ", user_answer=" + user_answer + ", answer_yn=" + answer_yn + "]";
	}

	public String getStage_nm() {
		return stage_nm;
	}

	public void setStage_nm(String stage_nm) {
		this.stage_nm = stage_nm;
	}

	public int getQna_no() {
		return qna_no;
	}

	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}

	public int getStage_no() {
		return stage_no;
	}

	public void setStage_no(int stage_no) {
		this.stage_no = stage_no;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAttach_type() {
		return attach_type;
	}

	public void setAttach_type(String attach_type) {
		this.attach_type = attach_type;
	}

	public String getAttach_file() {
		return attach_file;
	}

	public void setAttach_file(String attach_file) {
		this.attach_file = attach_file;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
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
