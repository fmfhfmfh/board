package reply.model;

import java.util.Date;

public class ReplyVO {
	private int reply_no;
	private int board_no;
	private String user_id;
	private Date reply_date;
	private String reply_content;
	private String reply_del_check;
	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getReply_date() {
		return reply_date;
	}
	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_del_check() {
		return reply_del_check;
	}
	public void setReply_del_check(String reply_del_check) {
		this.reply_del_check = reply_del_check;
	}
	@Override
	public String toString() {
		return "ReplyVO [reply_no=" + reply_no + ", board_no=" + board_no + ", user_id=" + user_id + ", reply_date="
				+ reply_date + ", reply_content=" + reply_content + ", reply_del_check=" + reply_del_check + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + board_no;
		result = prime * result + ((reply_content == null) ? 0 : reply_content.hashCode());
		result = prime * result + ((reply_date == null) ? 0 : reply_date.hashCode());
		result = prime * result + ((reply_del_check == null) ? 0 : reply_del_check.hashCode());
		result = prime * result + reply_no;
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
		ReplyVO other = (ReplyVO) obj;
		if (board_no != other.board_no)
			return false;
		if (reply_content == null) {
			if (other.reply_content != null)
				return false;
		} else if (!reply_content.equals(other.reply_content))
			return false;
		if (reply_date == null) {
			if (other.reply_date != null)
				return false;
		} else if (!reply_date.equals(other.reply_date))
			return false;
		if (reply_del_check == null) {
			if (other.reply_del_check != null)
				return false;
		} else if (!reply_del_check.equals(other.reply_del_check))
			return false;
		if (reply_no != other.reply_no)
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	
	
	
}
