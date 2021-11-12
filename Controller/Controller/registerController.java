package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bo.Khachhangbo;

/**
 * Servlet implementation class registerController
 */
@WebServlet("/registerController")
public class registerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerController() {
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
		String name=request.getParameter("HotenKH");
		String un=request.getParameter("TenDN");
		String pass=request.getParameter("Matkhau");
		String repass=request.getParameter("Matkhaunhatrlai");
		String email=request.getParameter("Email");
		String address=request.getParameter("Diachi");
		String phone=request.getParameter("Dienthoai");
		Khachhangbo khbo=new Khachhangbo();
		System.out.print(name);
		try {
			khbo.add(name, address, phone, email, un, pass, repass);
			RequestDispatcher rd= request.getRequestDispatcher("htsachController");
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
