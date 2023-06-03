package myshop.mall;

public class ShopMallCommandFactory {
	private ShopMallCommandFactory() {}
	private static ShopMallCommandFactory instance = 
												new ShopMallCommandFactory();
	public static ShopMallCommandFactory getInstance() {
		return instance;
	}
	
	public CommandIf createCommand(String cmd) {
		CommandIf cmdIf = null;
		if (cmd.equals("/shop_home.mall")) {
			cmdIf = new ShopHomeMallCommand();
		}else if (cmd.equals("/index.mall")) {
			cmdIf = new IndexCommand();
		}else if (cmd.equals("/shop_cgProd.mall")) {
			cmdIf = new ShopCgProdMallCommand();
		}else if (cmd.equals("/shop_prodView.mall")) {
			cmdIf = new ShopProdViewMallCommand();
		}else if (cmd.equals("/shop_cartAdd.mall")) {
			cmdIf = new ShopCartAddMallCommand();
		}else if (cmd.equals("/shop_cartList.mall")) {
			cmdIf = new ShopCartListMallCommand();
		}else if (cmd.equals("/shop_cartDel.mall")) {
			cmdIf = new ShopCartDelMallCommand();
		}else if (cmd.equals("/shop_cartEdit.mall")) {
			cmdIf = new ShopCartEditMallCommand();
		}
		return cmdIf;
	}
}
