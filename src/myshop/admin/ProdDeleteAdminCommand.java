package myshop.admin;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.admin.dao.ProductDAO;

public class ProdDeleteAdminCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pnum = req.getParameter("pnum");
		String pimage = req.getParameter("pimage");
		
		ProductDAO dao = new ProductDAO();
		String msg = null, url = "prodList_admin.do";
		try {
			int res = dao.deleteProd(Integer.parseInt(pnum));
			if (res>0) {
				String upPath = req.getServletContext().getRealPath("/img");
				File file = new File(upPath, pimage);
				if (file.exists()) {	
					file.delete();		
					msg = "��ǰ���� ����(�̹��� ������ ����)!! ��ǰ����������� �̵��մϴ�.";
				}else {
					msg = "��ǰ���� ����(�̹��� ���� ����)!! ��ǰ����������� �̵��մϴ�.";
				}
			}else {
				msg = "��ǰ���� ����!! ��ǰ����������� �̵��մϴ�.";
			}
		}catch(SQLException e) {
			e.printStackTrace();
			msg = "prod insert ���� �� DB ���� �߻�!! �����ڿ��� �����ϼ���";
			url = "main_admin.do";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}







