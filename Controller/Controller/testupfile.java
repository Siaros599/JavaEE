package Controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class testupfile
 */
@WebServlet("/testupfile")
public class testupfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testupfile() {
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
		//DiskFileItemFactory factory = new DiskFileItemFactory();
		 DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		 ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		 String dirUrl1 = request.getServletContext().getRealPath("") +  File.separator + "files";
		 //response.getWriter().println(dirUrl1);
		 
		try {
			List<FileItem> fileItems = upload.parseRequest(request);//Lấy về các đối tượng gửi lên
			//duyệt qua các đối tượng gửi lên từ client gồm file và các control
for (FileItem fileItem : fileItems) {
			 if (!fileItem.isFormField()) {//Nếu ko phải các control=>upfile lên
				// xử lý file
				String nameimg = new File(fileItem.getName()).getName();
				System.out.println(nameimg);
				if (!nameimg.equals("")) {
			           //Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
					String dirUrl = request.getServletContext().getRealPath("")+"test2"; //+ File.separator+ "test1";
					File dir = new File(dirUrl);
					if (!dir.exists()) {
						//response.getWriter().println("check");//nếu ko có thư mục thì tạo ra
						dir.mkdir();
					}
				           //String fileImg = dirUrl+File.separator+"check";
				           //System.out.println(fileImg);
				           File file = new File(dirUrl+File.separator+nameimg);//tạo file
				            try {
				               fileItem.write(file);//lưu file
				            System.out.println(file.canWrite());
				            System.out.println("UPLOAD THÀNH CÔNG...!");
				              System.out.println("Đường dẫn lưu file là: "+dirUrl);
				 } catch (Exception e) {
					System.out.println("upload fail");
				    e.printStackTrace();
				}
			}
		 }
			else//Neu la control
			{
				String tentk=fileItem.getFieldName();
				//response.getWriter().println("check");
				if(tentk.equals("txthoten"))
					response.getWriter().println(fileItem.getString());
//response.getWriter().println(fileItem.getString("UTF-8"));
				if(tentk.equals("txtdiachi"))
					response.getWriter().println(fileItem.getString());
				if(tentk.equals("sbutton")) {
					if(fileItem.getString()!=null) {
						System.out.println("Button1 Ko rong");
					} else 
						System.out.println("Button 1 Rong");
					response.getWriter().println(fileItem.getString());
				}
				if(tentk.equals("s1button")) {
					if(fileItem.getString()!=null) {
						System.out.println("Button 2 Ko rong");
					} else 
						System.out.println("Button 2 Rong");
					response.getWriter().println(fileItem.getString());
				}
			}
			}
		
		} catch (FileUploadException e) {
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
