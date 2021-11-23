package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Khachhangbean;
import bo.Adminbo;
import bo.Khachhangbo;

/**
 * Servlet implementation class dnhomeController
 */
@WebServlet("/dnhomeController")
public class dnhomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()sds
     */
    public dnhomeController() {
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
		String un=request.getParameter("txtun");
		String pass=request.getParameter("txtpw");
		Khachhangbo khbo=new Khachhangbo();
		
		Khachhangbean kh;
		try {
				kh = khbo.ktdn(un, pass);
	     if(kh!=null){
	    	 session.setAttribute("kh", kh);
	    	 session.setAttribute("tb", null);
	    	 RequestDispatcher rd= request.getRequestDispatcher("htsachController");
			 rd.forward(request, response);
	     }else{
	    	 session.setAttribute("tb", "Dang nhap sai");
	    	 RequestDispatcher rd= request.getRequestDispatcher("htsachController");
			 rd.forward(request, response);
	     }
				
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
