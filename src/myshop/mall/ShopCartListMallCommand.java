package myshop.mall;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myshop.admin.dao.CategoryDAO;
import myshop.admin.dto.CategoryDTO;
import myshop.admin.dto.ProductDTO;

public class ShopCartListMallCommand implements CommandIf{

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		CartBean cart = (CartBean)session.getAttribute("cart");
		List<ProductDTO> list = cart.listCart();
		req.setAttribute("cart", list);
		try {
			CategoryDAO dao = new CategoryDAO();
			List<CategoryDTO> clist = dao.listCate();
			if (clist == null || clist.size() == 0) {
				req.setAttribute("msg", "쇼핑몰 준비중 입니다. 처음페이지로 이동합니다.");
				req.setAttribute("url", "index.mall");
				return "message.jsp";
			}
			req.setAttribute("upPath", req.getServletContext().getRealPath("/img"));
			req.setAttribute("listCate", clist);
			return "WEB-INF/shop/display/mall_cartList.jsp";
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "plist getProduct 실행 중 DB 오류 발생!! 관리자에게 문의하세요");
			req.setAttribute("url", "index.mall");
			return "message.jsp";
		}
	}
}



