package myshop.mall;
import java.util.*;
import java.sql.*;

import myshop.admin.dao.ProductDAO;
import myshop.admin.dto.ProductDTO;

public class ProductList {
	private Hashtable<String, List<ProductDTO>> ht;
	
	public ProductList() {
		ht = new Hashtable<>();
	}
	
	public List<ProductDTO> selectBySpec(String pspec) throws SQLException {
		ProductDAO dao = new ProductDAO();
		List<ProductDTO> list = dao.listPspec(pspec);
		ht.put(pspec, list);
		return list;
	}
	
	public List<ProductDTO> selectByCode(String code) throws SQLException {
		ProductDAO dao = new ProductDAO();
		List<ProductDTO> list = dao.listCode(code);
		ht.put(code, list);
		return list;
	}
	
	public ProductDTO getProduct(int pnum, String select) {
		List<ProductDTO> list = ht.get(select);
		for(ProductDTO dto : list) {
			if (dto.getPnum() == pnum) {
				return dto;
			}
		}
		return null;
	}
}







