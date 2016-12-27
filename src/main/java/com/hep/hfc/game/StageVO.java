package com.hep.hfc.game;

public class StageVO {

	private int stage_no;
	private String stage_nm;
	private int qna_no;
	private int hint_cnt;
	private int hint_log_cnt;
	private String user_answer;
	private boolean answer_yn;

	public StageVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StageVO(int stage_no, String stage_nm, int qna_no, int hint_cnt, int hint_log_cnt, boolean answer_yn) {
		super();
		this.stage_no = stage_no;
		this.stage_nm = stage_nm;
		this.qna_no = qna_no;
		this.hint_cnt = hint_cnt;
		this.hint_log_cnt = hint_log_cnt;
		this.answer_yn = answer_yn;
	}

	public String getUser_answer() {
		return user_answer;
	}

	public void setUser_answer(String user_answer) {
		this.user_answer = user_answer;
	}

	public int getStage_no() {
		return stage_no;
	}

	public void setStage_no(int stage_no) {
		this.stage_no = stage_no;
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

	public boolean isAnswer_yn() {
		return answer_yn;
	}

	public void setAnswer_yn(boolean answer_yn) {
		this.answer_yn = answer_yn;
	}

	public int getHint_cnt() {
		return hint_cnt;
	}

	public void setHint_cnt(int hint_cnt) {
		this.hint_cnt = hint_cnt;
	}

	public int getHint_log_cnt() {
		return hint_log_cnt;
	}

	public void setHint_log_cnt(int hint_log_cnt) {
		this.hint_log_cnt = hint_log_cnt;
	}

	@Override
	public String toString() {
		return "StageVO [stage_no=" + stage_no + ", stage_nm=" + stage_nm + ", qna_no=" + qna_no + ", hint_cnt="
				+ hint_cnt + ", hint_log_cnt=" + hint_log_cnt + ", answer_yn=" + answer_yn + "]";
	}

}
