package myshop.mall;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShopCartEditMallCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pnum = req.getParameter("pnum");
		String pqty = req.getParameter("pqty");
		HttpSession session = req.getSession();
		CartBean cart = (CartBean)session.getAttribute("cart");
		cart.editCart(Integer.parseInt(pnum), Integer.parseInt(pqty));
		session.setAttribute("cart", cart);
		return "shop_cartList.mall";
	}

}
