package files.model;

public class FilesVO {
	private int files_no; 
	private String files_name; 
	private String real_files_name; 
	private int board_no;
	public int getFiles_no() {
		return files_no;
	}
	public void setFiles_no(int files_no) {
		this.files_no = files_no;
	}
	public String getFiles_name() {
		return files_name;
	}
	public void setFiles_name(String files_name) {
		this.files_name = files_name;
	}
	public String getReal_files_name() {
		return real_files_name;
	}
	public void setReal_files_name(String real_files_name) {
		this.real_files_name = real_files_name;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	@Override
	public String toString() {
		return "FilesVO [files_no=" + files_no + ", files_name=" + files_name + ", real_files_name=" + real_files_name
				+ ", board_no=" + board_no + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + board_no;
		result = prime * result + ((files_name == null) ? 0 : files_name.hashCode());
		result = prime * result + files_no;
		result = prime * result + ((real_files_name == null) ? 0 : real_files_name.hashCode());
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
		FilesVO other = (FilesVO) obj;
		if (board_no != other.board_no)
			return false;
		if (files_name == null) {
			if (other.files_name != null)
				return false;
		} else if (!files_name.equals(other.files_name))
			return false;
		if (files_no != other.files_no)
			return false;
		if (real_files_name == null) {
			if (other.real_files_name != null)
				return false;
		} else if (!real_files_name.equals(other.real_files_name))
			return false;
		return true;
	}
	
	
}
