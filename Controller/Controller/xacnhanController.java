package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.Hoadonbo;

/**
 * Servlet implementation class xacnhanController
 */
@WebServlet("/xacnhanController")
public class xacnhanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xacnhanController() {
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
	  	String mahd=request.getParameter("hd");
	  	String ms=request.getParameter("ms");
	  	Hoadonbo hdbo=new Hoadonbo();
	  	
	  	try {
			if(mahd!=null&&ms!=null) {
				System.out.println(mahd+" "+ms);
				System.out.println("Xac nhan chi tiet hoa don");
				hdbo.xacnhancthd(Long.parseLong(mahd), ms);
			}
			if(mahd!=null&&ms==null) {
				System.out.println(mahd);
				System.out.println("Xac nhan hoa don");
				hdbo.xacnhanhd(Long.parseLong(mahd));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	  	RequestDispatcher rd= request.getRequestDispatcher("qlhdController");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
