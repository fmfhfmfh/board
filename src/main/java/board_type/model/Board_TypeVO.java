package board_type.model;

public class Board_TypeVO {
	private String board_name;
	private String board_use_check;
	private int board_type_no;
	
	@Override
	public String toString() {
		return "Board_TypeVO [board_name=" + board_name + ", board_use_check=" + board_use_check + ", board_type_no="
				+ board_type_no + "]";
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_use_check() {
		return board_use_check;
	}
	public void setBoard_use_check(String board_use_check) {
		this.board_use_check = board_use_check;
	}
	public int getBoard_type_no() {
		return board_type_no;
	}
	public void setBoard_type_no(int board_type_no) {
		this.board_type_no = board_type_no;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((board_name == null) ? 0 : board_name.hashCode());
		result = prime * result + board_type_no;
		result = prime * result + ((board_use_check == null) ? 0 : board_use_check.hashCode());
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
		Board_TypeVO other = (Board_TypeVO) obj;
		if (board_name == null) {
			if (other.board_name != null)
				return false;
		} else if (!board_name.equals(other.board_name))
			return false;
		if (board_type_no != other.board_type_no)
			return false;
		if (board_use_check == null) {
			if (other.board_use_check != null)
				return false;
		} else if (!board_use_check.equals(other.board_use_check))
			return false;
		return true;
	}
	
}
