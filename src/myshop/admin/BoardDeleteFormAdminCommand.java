package myshop.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardDeleteFormAdminCommand implements CommandIf {

    @Override
    public String processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num = req.getParameter("num");
        if (num == null || num.trim().equals("")) {
            resp.sendRedirect("boardList1_admin.do");
            return null;
        }
        req.setAttribute("num", num);
        return "WEB-INF/shop/admin/board_deleteForm.jsp";
    }
}
