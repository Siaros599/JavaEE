package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Giohangbean;
import bo.Giohangbo;

/**
 * Servlet implementation class suaghController
 */
@WebServlet("/suaghController")
public class suaghController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()s
     */
    public suaghController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();		
		String ms=request.getParameter("ms");
		try {
			long sl=Long.parseLong(request.getParameter("txtsl"));
			if(ms!=null){
				Giohangbo gh=(Giohangbo)session.getAttribute("gh");
				if(request.getParameter("butxoa")!=null)
					gh.Xoa(ms);
				if(request.getParameter("butsua")!=null){
				for(Giohangbean g:gh.ds)
					if(g.getMasach().equals(ms))
					if(g.getSlmua()+sl<=0)
						break;
					else	{
						gh.Them(ms,"", "", (long)0,sl);
						break;
					}
				}
				session.setAttribute("gh", gh);
				RequestDispatcher rd= request.getRequestDispatcher("ghController");
				 rd.forward(request, response);
				}
			
			RequestDispatcher rd= request.getRequestDispatcher("ghController");
			 rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			if(ms!=null){
				Giohangbo gh=(Giohangbo)session.getAttribute("gh");
				if(request.getParameter("butxoa")!=null)
					gh.Xoa(ms);
				
				session.setAttribute("gh", gh);
				RequestDispatcher rd= request.getRequestDispatcher("ghController");
				 rd.forward(request, response);
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
