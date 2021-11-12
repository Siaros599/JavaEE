package bo;

import java.util.ArrayList;

import bean.Khachhangbean;
import dao.lichsudao;

public class lichsubo {
	public Khachhangbean kh=new Khachhangbean();
	public ArrayList<Giohangbo> ghbols=new ArrayList<Giohangbo>();
	public void getData() throws Exception {
		lichsudao lsdao=new lichsudao();
		lsdao.getData(kh,ghbols);
	}
	public long getTongtienchi(){
		long tongtienchi=0;
		for(Giohangbo i: ghbols) {
			tongtienchi=tongtienchi+i.Tongtien();
		}
		return tongtienchi;
	}
	
}
