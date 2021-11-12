package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Khachhangbean;
import bean.Loaibean;
import bean.Sachbean;

import bo.Loaibo;
import bo.Sachbo;
import bo.lichsubo;

/**
 * Servlet implementation class lichsuController
 */
@WebServlet("/lichsuController")
public class lichsuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lichsuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
	  	response.setCharacterEncoding("utf-8");
	  	Loaibo loai=new Loaibo();
	  	Sachbo sbo=new Sachbo();
	  	ArrayList<Loaibean> dsloai;
		HttpSession session=request.getSession();
		try {
			lichsubo lsbo=null;
		 	dsloai = loai.getloai();
		  	ArrayList<Sachbean> dssach=sbo.getSach();
		  	String ml=request.getParameter("ml");
		    String key=request.getParameter("key");
		    if(ml!=null)
		   	 dssach=sbo.timMaLoai(ml);
		    else
		   	 if(key!=null)
		   		 dssach=sbo.Tim(key);
		    request.setAttribute("dsloai", dsloai);
		    request.setAttribute("dssach", dssach);
				lsbo=new lichsubo();
				lsbo.kh=(Khachhangbean)session.getAttribute("kh");
				lsbo.getData();
				session.setAttribute("ls", lsbo);
			 RequestDispatcher rd= request.getRequestDispatcher("lichsumua.jsp");
			 rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
