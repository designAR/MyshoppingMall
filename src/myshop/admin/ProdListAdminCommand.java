package myshop.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.admin.dao.ProductDAO;
import myshop.admin.dto.ProductDTO;

public class ProdListAdminCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		try {
			List<ProductDTO> list = dao.listProd();
			req.setAttribute("listProd", list);
			String upPath = req.getServletContext().getRealPath("/img");
			req.setAttribute("upPath", upPath);
			return "WEB-INF/shop/admin/prod_list.jsp";
		}catch(SQLException e) {
			e.printStackTrace();
			String msg = "prod list 실행 중 DB 오류 발생!! 관리자에게 문의하세요";
			String url = "main_admin.do";
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			return "message.jsp";
		}
	}

}
