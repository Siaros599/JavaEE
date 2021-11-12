package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class maytinhController
 */
@WebServlet("/maytinhController")
public class maytinhController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public maytinhController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		session.setAttribute("alo", "xin chao");
		String tama =request.getParameter("txta");
		String tamb =request.getParameter("txtb");
		if(tama==null) {
			RequestDispatcher rd= request.getRequestDispatcher("MayTinhServlet.jsp");
			rd.forward(request, response);
		}else
{
			long kq=0;
			if(request.getParameter("butcong")!=null) {//nguoi dung chon nut +
				kq=Long.parseLong(tama)+Long.parseLong(tamb);
				
				request.setAttribute("kq", kq);//Tao ra 1 bien request
				
				RequestDispatcher rd= request.getRequestDispatcher("MayTinhServlet.jsp");
				rd.forward(request, response);//Chuyen tiep request va response ve trang maytinh.jsp
			}
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
