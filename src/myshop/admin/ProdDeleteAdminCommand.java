package myshop.admin;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.admin.dao.ProductDAO;

public class ProdDeleteAdminCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pnum = req.getParameter("pnum");
		String pimage = req.getParameter("pimage");
		
		ProductDAO dao = new ProductDAO();
		String msg = null, url = "prodList_admin.do";
		try {
			int res = dao.deleteProd(Integer.parseInt(pnum));
			if (res>0) {
				String upPath = req.getServletContext().getRealPath("/img");
				File file = new File(upPath, pimage);
				if (file.exists()) {	
					file.delete();		
					msg = "상품삭제 성공(이미지 삭제도 성공)!! 상품목록페이지로 이동합니다.";
				}else {
					msg = "상품삭제 성공(이미지 삭제 실패)!! 상품목록페이지로 이동합니다.";
				}
			}else {
				msg = "상품삭제 실패!! 상품목록페이지로 이동합니다.";
			}
		}catch(SQLException e) {
			e.printStackTrace();
			msg = "prod insert 실행 중 DB 오류 발생!! 관리자에게 문의하세요";
			url = "main_admin.do";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}







