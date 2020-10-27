package common.model;

public class PageVO {
	
	private int page;
	private int pageSize;
	private int board_type_no;
	
	public PageVO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PageVO [page=" + page + ", pageSize=" + pageSize + ", board_type_no=" + board_type_no + "]";
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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
		result = prime * result + board_type_no;
		result = prime * result + page;
		result = prime * result + pageSize;
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
		PageVO other = (PageVO) obj;
		if (board_type_no != other.board_type_no)
			return false;
		if (page != other.page)
			return false;
		if (pageSize != other.pageSize)
			return false;
		return true;
	}

	public PageVO(int page, int pageSize, int board_type_no) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.board_type_no = board_type_no;
	}
	
}
