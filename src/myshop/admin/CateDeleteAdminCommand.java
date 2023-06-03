package myshop.admin;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.admin.dao.CategoryDAO;

public class CateDeleteAdminCommand implements CommandIf {
   
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cnum = req.getParameter("cnum");
		CategoryDAO dao = new CategoryDAO();
		String msg = null, url = "cateList_admin.do";
		try {
			int res = dao.deleteCate(Integer.parseInt(cnum));
			if (res>0) {
				msg = "ī�װ� ���� ����!! �л������������ �̵��մϴ�.";
			}else {
				msg = "ī�װ� ���� ����!! �л������������ �̵��մϴ�.";
			}
		}catch(SQLException e) {
			e.printStackTrace();
			msg = "cate delete ���� �� DB ���� �߻�!! �����ڿ��� �����ϼ���";
			url = "main_admin.do";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
