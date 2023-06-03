package myshop.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.admin.dao.ProductDAO;
import myshop.admin.dto.ProductDTO;

public class ProdUpdateAdminCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pnum = req.getParameter("pnum");
		ProductDAO dao = new ProductDAO();
		try {
			ProductDTO dto = dao.getProduct(Integer.parseInt(pnum));
			req.setAttribute("getProduct", dto);
			String upPath = req.getServletContext().getRealPath("/img");
			req.setAttribute("upPath", upPath);
			return "WEB-INF/shop/admin/prod_update.jsp";
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "prod view 실행 중 DB 오류 발생!! 관리자에게 문의하세요");
			req.setAttribute("url", "main_admin.do");
			return "message.jsp";
		}
	}

}
