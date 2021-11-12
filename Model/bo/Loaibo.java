package bo;

import java.util.ArrayList;

import bean.Loaibean;
import dao.Loaidao;

public class Loaibo {
	Loaidao ldao=new Loaidao();
	public ArrayList<Loaibean> getloai() throws Exception {
		return ldao.getloai();
	}
}
