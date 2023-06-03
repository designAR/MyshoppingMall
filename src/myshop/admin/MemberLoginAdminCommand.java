package myshop.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberLoginAdminCommand implements CommandIf {

	@Override
    public String processCommand(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	return "WEB-INF/shop/admin/member_login.jsp";
    }
}
