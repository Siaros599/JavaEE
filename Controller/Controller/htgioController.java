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

import bean.Loaibean;
import bean.Sachbean;
import bo.Giohangbo;
import bo.Loaibo;
import bo.Sachbo;


/**
 * Servlet implementation class htgioController
 */
@WebServlet("/htgioController")
public class htgioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()s
     */
    public htgioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
	  	response.setCharacterEncoding("utf-8");
	  	Loaibo loai=new Loaibo();
	  	Sachbo sbo=new Sachbo();
	  	ArrayList<Loaibean> dsloai;
		try {
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
		String masach=request.getParameter("ms");
		String tensach=request.getParameter("ts");
		String tacgia=request.getParameter("tg");
		String giatam=request.getParameter("gia");
		HttpSession session = request.getSession();
	

		if (masach!=null){
		//Tao cho 1 giohang khi dat mua quyen sach dau tien
		Giohangbo gh=null;
		if(session.getAttribute("gh")==null){
			gh=new Giohangbo();
			session.setAttribute("gh", gh);
		}
		//b1:gan session vao bien
		gh=(Giohangbo)session.getAttribute("gh");
		gh.Them(masach, tensach, tacgia, Long.parseLong(giatam), (long)1);
		session.setAttribute("gh", gh);
		}
		//request.setAttribute("gh", gh);
		 RequestDispatcher rd= request.getRequestDispatcher("htgio.jsp");
		 rd.forward(request, response);
		 
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
