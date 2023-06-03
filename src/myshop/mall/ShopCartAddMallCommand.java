package myshop.mall;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myshop.admin.dto.ProductDTO;

public class ShopCartAddMallCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pnum = req.getParameter("pnum");
		String select = req.getParameter("select");
		String pqty = req.getParameter("pqty");
		
		HttpSession session = req.getSession();
		ProductList plist = (ProductList)session.getAttribute("plist");
		ProductDTO dto = plist.getProduct(Integer.parseInt(pnum), select);
		dto.setPqty(Integer.parseInt(pqty));
		CartBean cart = (CartBean)session.getAttribute("cart");
		if (cart == null) cart = new CartBean();
		cart.insertCart(dto);		
		session.setAttribute("cart", cart);
		return "shop_cartList.mall";
	}

}








