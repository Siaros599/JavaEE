package Controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bo.Sachbo;

/**
 * Servlet implementation class suaqlsachController
 */
@WebServlet("/suaqlsachController")
public class suaqlsachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suaqlsachController() {
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
	  	String ms=request.getParameter("ms");
	  	DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String anh="";
		String tensach="";
		String tacgia="";
		String maloai="";
		long gia=0;
		long soluong=0;
		int bt=0;
		Timestamp ngaynhap = null;
		try {
			 List<FileItem> fItems = upload.parseRequest(request);
			 for(FileItem fItem:fItems) {
				 if(!fItem.isFormField()) {
					 String nameimg = new File(fItem.getName()).getName();
					 anh="image_sach"+File.separator+nameimg;
					 if(!nameimg.equals("")) {
						 try {
							 //fItem.write(new File("D:\\Download\\JAVA\\JAVAEE\\JavaEE_Nhom4\\WebContent\\image_sach"+File.separator+nameimg));
							 fItem.write(new File("D:\\Download\\JAVA\\JAVAEE\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\JavaEE_Nhom4\\image_sach"+File.separator+nameimg));
							 System.out.println("UPLOAD THÀNH CÔNG...!");
				             //System.out.println("Đường dẫn lưu file là: "+dirUrl);
						 } catch (Exception e) {
							// TODO: handle exception
							 e.printStackTrace();
						 }
					 }
				 } else {
					 String ten=fItem.getFieldName();
					 if(ten.equals("tensach"))
						 tensach=fItem.getString("utf-8");
					 if(ten.equals("tacgia"))
						 tacgia=fItem.getString("utf-8");
					 if(ten.equals("maloai"))
						 maloai=fItem.getString();
					 if(ten.equals("gia"))
						 gia=Long.parseLong(fItem.getString());
					 if(ten.equals("soluong"))
						 soluong=Long.parseLong(fItem.getString());
					 if(ten.equals("ngaynhap"))
						 ngaynhap=Timestamp.valueOf(fItem.getString());
					 if(ten.equals("butsua"))
						 bt=1;
					 if(ten.equals("butxoa"))
						 bt=2;
				 }
			 }
		} catch (FileUploadException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	  	try {
			Sachbo sbo=new Sachbo();
			if(ms!=null) {
				if(bt==1) {
					sbo.editSach(ms, tensach, tacgia, gia, soluong, ngaynhap, anh, maloai);
				}
				if(bt==2) {
					sbo.deleteSach(ms);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		RequestDispatcher rd= request.getRequestDispatcher("qlsachController");
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
