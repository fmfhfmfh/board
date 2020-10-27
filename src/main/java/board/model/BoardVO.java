package board.model;

import java.util.Date;

public class BoardVO {
	private int board_no;
	private String board_title; 
	private String board_content;
	private Date board_date; 
	private String board_del_check;
	private String user_id; 
	private int board_group_no;
	private int board_type_no;
	
	public BoardVO() {

	}
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	public String getBoard_del_check() {
		return board_del_check;
	}
	public void setBoard_del_check(String board_del_check) {
		this.board_del_check = board_del_check;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getBoard_group_no() {
		return board_group_no;
	}
	public void setBoard_group_no(int board_group_no) {
		this.board_group_no = board_group_no;
	}
	public int getBoard_type_no() {
		return board_type_no;
	}
	public void setBoard_type_no(int board_type_no) {
		this.board_type_no = board_type_no;
	}
	@Override
	public String toString() {
		return "BoardVO [board_no=" + board_no + ", board_title=" + board_title + ", board_content=" + board_content
				+ ", board_date=" + board_date + ", board_del_check=" + board_del_check + ", user_id=" + user_id
				+ ", board_group_no=" + board_group_no + ", board_type_no=" + board_type_no + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((board_content == null) ? 0 : board_content.hashCode());
		result = prime * result + ((board_date == null) ? 0 : board_date.hashCode());
		result = prime * result + ((board_del_check == null) ? 0 : board_del_check.hashCode());
		result = prime * result + board_group_no;
		result = prime * result + board_no;
		result = prime * result + ((board_title == null) ? 0 : board_title.hashCode());
		result = prime * result + board_type_no;
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardVO other = (BoardVO) obj;
		if (board_content == null) {
			if (other.board_content != null)
				return false;
		} else if (!board_content.equals(other.board_content))
			return false;
		if (board_date == null) {
			if (other.board_date != null)
				return false;
		} else if (!board_date.equals(other.board_date))
			return false;
		if (board_del_check == null) {
			if (other.board_del_check != null)
				return false;
		} else if (!board_del_check.equals(other.board_del_check))
			return false;
		if (board_group_no != other.board_group_no)
			return false;
		if (board_no != other.board_no)
			return false;
		if (board_title == null) {
			if (other.board_title != null)
				return false;
		} else if (!board_title.equals(other.board_title))
			return false;
		if (board_type_no != other.board_type_no)
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	public BoardVO(int board_no, String board_title, String board_content, Date board_date, String board_del_check,
			String user_id, int board_group_no, int board_type_no) {
		super();
		this.board_no = board_no;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_date = board_date;
		this.board_del_check = board_del_check;
		this.user_id = user_id;
		this.board_group_no = board_group_no;
		this.board_type_no = board_type_no;
	}
	
	
}
