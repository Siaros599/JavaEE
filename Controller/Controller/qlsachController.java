package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Loaibean;
import bean.Sachbean;
import bo.Loaibo;
import bo.Sachbo;

/**
 * Servlet implementation class qlsachController
 */
@WebServlet("/qlsachController")
public class qlsachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public qlsachController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
	  	response.setCharacterEncoding("utf-8");
	  	Sachbo sbo=new Sachbo();
	  	ArrayList<Sachbean> dssach;
	  	Loaibo lbo=new Loaibo();
	  	ArrayList<Loaibean> dsloai;
	  	try {
			dssach=sbo.getSach();
			request.setAttribute("dssach", dssach);
			dsloai=lbo.getloai();
			request.setAttribute("dsloai", dsloai);
			RequestDispatcher rd= request.getRequestDispatcher("qlsach_admin.jsp");
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
