package myshop.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import myshop.admin.dao.ProductDAO;

public class ProdInputOkAdminCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		MultipartRequest mr = null;
		String upPath = req.getServletContext().getRealPath("/img");
		int len = 10*1024*1024;
		String msg = null, url = null;
		try {
			mr = new MultipartRequest(req, upPath, len, "EUC-KR");
			ProductDAO dao = new ProductDAO();
			int res = dao.insertProd(mr);
			if (res>0) {
				msg = "��ǰ��� ����!! ��ǰ����������� �̵��մϴ�.";
				url = "prodList_admin.do";
			}else {
				msg = "��ǰ��� ����!! ��ǰ����������� �̵��մϴ�.";
				url = "prodInput_admin.do";
			}
		}catch(IOException e) {
			e.printStackTrace();
			msg = "���Ͼ��ε� ����!! �ٽ� �Է��� �ּ���!!";
			url = "prodInput_admin.do";
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







