package myshop.mall;

import java.util.ArrayList;
import java.util.List;

import myshop.admin.dto.ProductDTO;

public class CartBean {
	private List<ProductDTO> list;
	
	public CartBean() {
		list = new ArrayList<>();
	}
	
	public void insertCart(ProductDTO dto) {
		for(ProductDTO dto2 : list) {
			if (dto.getPnum() == dto2.getPnum()) {
				dto2.setPqty(dto2.getPqty() + dto.getPqty());
				return;
			}
		}
		list.add(dto);
	}
	
	public List<ProductDTO> listCart(){
		return list;
	}
	
	public void deleteCart(int pnum) {
		for(ProductDTO dto : list) {
			if (dto.getPnum() == pnum) {
				list.remove(dto);
				return;
			}
		}
		return;
	}
	
	public void editCart(int pnum, int pqty) {
		if (pqty <= 0) deleteCart(pnum);
		for(ProductDTO dto : list) {
			if (dto.getPnum() == pnum) {
				dto.setPqty(pqty);
			}
		}
		return;
	}
}














