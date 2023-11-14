package Service;

import java.util.ArrayList;

import dto.TestDto;

public class TestService {

	public ArrayList<TestDto> getBoardList() {
		// 1. select >> DB접속 >> Dao 클래스
		
		ArrayList<TestDto> list = new ArrayList<TestDto>();
		for(int i = 0; i < 4; i ++) {
			TestDto tdto = new TestDto();
			tdto.setNum(i+1);
			tdto.setTitle("제목" + (i+1));
			tdto.setWriter("작성자" + (i+1));
			list.add(tdto);
		}
		return list;
	}

}
