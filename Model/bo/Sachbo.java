package bo;

import java.util.ArrayList;

import bean.Sachbean;
import dao.Sachdao;


public class Sachbo {
	Sachdao sdao=new Sachdao();
	public ArrayList<Sachbean> getSach() throws Exception{
		return sdao.getSach();
	}
	public ArrayList<Sachbean> timMaLoai(String maloai) throws Exception{
		ArrayList<Sachbean> tam= new ArrayList<Sachbean>();
		ArrayList<Sachbean> ds=getSach();
		for (Sachbean s:ds)
			if(s.getMaloai().equals(maloai))
				tam.add(s);
		return tam;	
	}
	public ArrayList<Sachbean> Tim(String key) throws Exception{
    	ArrayList<Sachbean> tam= new ArrayList<Sachbean>();
    	ArrayList<Sachbean> ds=getSach();
    	for(Sachbean s: ds)
    		if(s.getTensach().toLowerCase().trim().contains(key.toLowerCase().trim()) ||
    				s.getTacgia().toLowerCase().trim().contains(key.toLowerCase().trim()))
    			tam.add(s);
    	return tam;
    }
	public Long Dem(String maloai) throws Exception{
    	Long d=(long)0;
    	ArrayList<Sachbean> ds=getSach();
    	for(Sachbean s: ds)
    		if(s.getMaloai().equals(maloai))
    			d++;
    	return d;
    }
}
