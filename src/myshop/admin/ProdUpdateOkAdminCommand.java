package myshop.admin;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import myshop.admin.dao.ProductDAO;

public class ProdUpdateOkAdminCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		MultipartRequest mr = null;
		String upPath = req.getServletContext().getRealPath("/img");
		int len = 10*1024*1024;
		String msg = null, url = null;
		try {
			mr = new MultipartRequest(req, upPath, len, "EUC-KR");
			ProductDAO dao = new ProductDAO();
			int res = dao.updateProd(mr);
			if (res>0) {
				msg = "상품수정 성공!! 상품목록페이지로 이동합니다.";
				url = "prodList_admin.do";
			}else {
				msg = "상품수정 실패!! 상품수정페이지로 이동합니다.";
				url = "prodUpdate_admin.do?pnum=" + mr.getParameter("pnum");
			}
		}catch(IOException e) {
			e.printStackTrace();
			msg = "파일업로드 실패!! 다시 입력해 주세요!!";
			url = "prodUpdate_admin.do?pnum=" + mr.getParameter("pnum");
		}catch(SQLException e) {
			e.printStackTrace();
			msg = "prod update 실행 중 DB 오류 발생!! 관리자에게 문의하세요";
			url = "main_admin.do";
		}
		
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}
}
