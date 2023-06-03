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

public class ShopProdViewMallCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pnum = req.getParameter("pnum");
		String select = req.getParameter("select");
		HttpSession session = req.getSession();
		ProductList plist = (ProductList)session.getAttribute("plist");
		ProductDTO dto = plist.getProduct(Integer.parseInt(pnum), select);
		try {
			CategoryDAO dao = new CategoryDAO();
			List<CategoryDTO> list = dao.listCate();
			if (list == null || list.size() == 0) {
				req.setAttribute("msg", "���θ� �غ��� �Դϴ�. ó���������� �̵��մϴ�.");
				req.setAttribute("url", "index.mall");
				return "message.jsp";
			}
			req.setAttribute("listCate", list);
			req.setAttribute("pdto", dto);
			req.setAttribute("upPath", req.getServletContext().getRealPath("/img"));
			return "WEB-INF/shop/display/mall_prodView.jsp";
		}catch(SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "plist getProduct ���� �� DB ���� �߻�!! �����ڿ��� �����ϼ���");
			req.setAttribute("url", "index.mall");
			return "message.jsp";
		}
	}

}
