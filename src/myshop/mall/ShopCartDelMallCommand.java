package myshop.mall;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShopCartDelMallCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pnum = req.getParameter("pnum");
		HttpSession session = req.getSession();
		CartBean cart = (CartBean)session.getAttribute("cart");
		cart.deleteCart(Integer.parseInt(pnum));
		session.setAttribute("cart", cart);
		return "shop_cartList.mall";
	}

}
