package bootstrap.model;

import java.security.Timestamp;

public class BoardVO {
	private int board_num;
	private String title;
	private String content;
	private String id;
	private String date;
	private int view_cnt;
	private int rownum;
	private int boardTotal;
	


	public BoardVO() {
		
	}
	
	public BoardVO(String title, String content, String id) {
		super();
		this.title = title;
		this.content = content;
		this.id = id;
	}
	public BoardVO(int board_num, String title, String content, String id, String date, int view_cnt) {
		super();
		this.board_num = board_num;
		this.title = title;
		this.content = content;
		this.id = id;
		this.date = date;
		this.view_cnt = view_cnt;
	}
	

	public BoardVO(int board_num, String title, String content, String id, String date, int view_cnt, int rownum, int boardTotal) {
		super();
		this.board_num = board_num;
		this.title = title;
		this.content = content;
		this.id = id;
		this.date = date;
		this.view_cnt = view_cnt;
		this.rownum = rownum;
		this.boardTotal = boardTotal;
	}
	
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getView_cnt() {
		return view_cnt;
	}

	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}
	
	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getBoardTotal() {
		return boardTotal;
	}

	public void setBoardTotal(int boardTotal) {
		this.boardTotal = boardTotal;
	}
	
	@Override
	public String toString() {
		return "BoardVO [board_num=" + board_num + ", title=" + title + ", content=" + content + ", id=" + id
				+ ", date=" + date + ", view_cnt=" + view_cnt + ", rownum=" + rownum + "]";
	} 
	
}
