package bootstrap.model;

public class PageVO {

	private int startPage; // 게시글 화면에 보여질 첫번째 번호
	private int endPage; // 게시글 화면에 보여질 마지막 번호
	private boolean prev, next; // 이전버튼, 다음버튼 활성화여부
	
	private int pageNum; // 현재 조회하는 페이지번호
	private int listSize = 3; // 화면에 그려질 데이터 (화면에 보여지는 데이터 개수)
	private int totalCount; // 전체게시글 수
	private int pageSize = 10; // 페이지네이션개수
	private int offset = 0; //조회할 목록 시작번호
	
	// 생성자에서는 객체가 생성될때 계산을 처리
	public PageVO(int pageNum, int totalCount) {
		this.pageNum = pageNum;
		this.totalCount = totalCount;
		
		// 1. endPage결정
//		 ex) 조회하는 페이지 1 -> 끝번호 10					1, 2, 3, 4, 5, 6, 7, 8, 9, 10
//		 ex) 조회하는 페이지 9 -> 끝번호 10					1, 2, 3, 4, 5, 6, 7, 8, 9, 10
//		 ex) 조회하는 페이지 11 -> 끝번호 20					11,12,13,14,15,16,17,18,19,20 
//		 ex) 조회하는 페이지 15 -> 끝번호 20 
//		 공식 = (int)Math.ceil(페이지번호 / 페이지네이션개수) * 페이지네이션개수
		this.endPage = (int)Math.ceil(this.pageNum * 0.1) * this.pageSize; // = 10
		
		// 2. startPage결정
		// 공식 = 끝페이지 - 페이지네이션개수 + 1
		this.startPage = this.endPage - this.pageSize + 1; // = 1
		
		// 3. realEnd(진짜 끝번호) 구해서 endPage의 값을 다시 결정
//		 만약 게시글이 52개라면 -> 진짜 끝번호 6
//		 만약 게시글이 105개라면 -> 진짜 끝번호 11
//		 공식 = (int)Math.ceil(전체게시글수 / 화면에보여질데이터개수)
		int realEnd = (int)Math.ceil(this.totalCount / (double)this.listSize); // = 2
		
//		 마지막페이지 도달했을 때 보여져야 하는 끝번호가 달라집니다.
//		 ex) 131개 게시물
//		 1번 페이지 클릭시 -> endPage = 10, realEnd = 14 ( endPage로 세팅 )
//		 11번 페이지 클릭시 -> endPage = 20, realEnd = 14 ( realEnd로 세팅 )
		if(this.endPage > realEnd) {
			this.endPage = realEnd; // = 2
		}
		
		// 4. prev결정 ( startPage의 번호는 1, 11, 21... )
		this.prev = this.startPage > 1; // = true
		
		// 5. next결정
//		 ex: 131개 게시물
//		 1~10 클릭시 endPage = 10, realEnd = 14 -> 다음버튼 true
//		 11 클릭시 endPage = 14 , realEnd = 14 -> 다음버튼 false
		this.next = this.endPage < realEnd;
		
		// 6. 실제로 조회할 db 목록의 첫번째 번호
		// 보여지는 목록 개수 * (현재 선택된 페이지번호 - 1);
		this.offset = this.listSize * (this.pageNum - 1);
		
		// 확인
		System.out.println("시작페이지:" + this.startPage + ", 끝페이지:" + this.endPage + ", offset: " + this.offset);
		
		// GetListService에서 페이지VO 계산처리 코드작성...
	}

	
	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public boolean isPrev() {
		return prev;
	}


	public void setPrev(boolean prev) {
		this.prev = prev;
	}


	public boolean isNext() {
		return next;
	}


	public void setNext(boolean next) {
		this.next = next;
	}


	public int getPageNum() {
		return pageNum;
	}


	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


	public int getListSize() {
		return listSize;
	}


	public void setListSize(int listSize) {
		this.listSize = listSize;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	@Override
	public String toString() {
		return "PageVO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", pageNum=" + pageNum + ", listSize=" + listSize + ", totalCount=" + totalCount + "]";
	}
}
