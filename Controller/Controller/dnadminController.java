package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import nl.captcha.Captcha;
import bo.Adminbo;

/**
 * Servlet implementation class dnadminController
 */
@WebServlet("/dnadminController")
public class dnadminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dnadminController() {
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
	  	HttpSession session=request.getSession();
	  	Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
		String un=request.getParameter("txtun"); 
		String pass=request.getParameter("txtpw");
		String answer = request.getParameter("answer");
	  	Adminbo adbo=new Adminbo();
	  	long dem;
	  	if(session.getAttribute("showcapt")==null){
	  		dem=0;
	  		session.setAttribute("showcapt", dem);//=Integer.parseInt( (String) session.getAttribute("showcapt"));
	  	}
	  	dem=(Long) session.getAttribute("showcapt");
	  	try {
	  	if(adbo.ktdnAdmin(un, pass)) {
	  		if(dem>=3) {
	  		if(!captcha.isCorrect(answer)) {
	  			dem++;
	  			session.setAttribute("showcapt", dem);
	  			session.setAttribute("tbad", "Capcha sai");
		    	 RequestDispatcher rd= request.getRequestDispatcher("htadminController");
				 rd.forward(request, response);
	  		} else {
	  			dem=0;
				session.setAttribute("showcapt", dem);
				session.setAttribute("adun", un);
				RequestDispatcher rd= request.getRequestDispatcher("htadminController");
				rd.forward(request, response);
	  		}
	  		} else {
	  		dem=0;
			session.setAttribute("showcapt", dem);
			session.setAttribute("adun", un);
			RequestDispatcher rd= request.getRequestDispatcher("htadminController");
			rd.forward(request, response);
	  		}
	  	}else {
	  		dem++;
	  		session.setAttribute("showcapt", dem);
	  		session.setAttribute("tbad", "Dang nhap sai");
	    	 RequestDispatcher rd= request.getRequestDispatcher("htadminController");
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
