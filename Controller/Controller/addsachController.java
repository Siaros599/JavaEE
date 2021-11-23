package Controller;

import java.io.File;
import java.util.List;
import java.io.IOException;

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
 * Servlet implementation class addsachController
 */
@WebServlet("/addsachController")
public class addsachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addsachController() {
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
	  	 DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		 ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		 String anh="";
		 String masach="";
		 String tensach="";
		 String tacgia="";
		 String maloai="";
		 long gia=0;
		 long soluong=0;
		 try {
			 List<FileItem> fItems = upload.parseRequest(request);
			 for(FileItem fItem:fItems) {
				 if(!fItem.isFormField()) {
					 String nameimg = new File(fItem.getName()).getName();
					 anh="image_sach"+File.separator+nameimg;
					 if(!nameimg.equals("")) {
						 //String dirUrl = request.getServletContext().getRealPath("")+"image_sach";
						 //System.out.println(dirUrl);
						 //File dir=new File(dirUrl);
						 //if(!dir.exists()) 
							 //dir.mkdir();
						 //File file=new File(dirUrl+File.separator+nameimg);
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
					 if(ten.equals("masach"))
						 masach=fItem.getString("utf-8");
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
					 
				 }
			 }
		} catch (FileUploadException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 
		 System.out.println(masach+tensach+tacgia+maloai);
		 try {
			 Sachbo sbo=new Sachbo();
			 sbo.addsach(masach, tensach, tacgia, gia, soluong, anh, maloai);
		 } catch (Exception e) {
				// TODO: handle exception
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
