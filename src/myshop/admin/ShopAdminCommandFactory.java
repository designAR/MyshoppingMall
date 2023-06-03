package myshop.admin;

public class ShopAdminCommandFactory {
    private ShopAdminCommandFactory() {}
    private static ShopAdminCommandFactory instance = new ShopAdminCommandFactory();

    public static ShopAdminCommandFactory getInstance() {
        return instance;
    }

    public CommandIf createCommand(String cmd) {
        CommandIf cmdIf = null;
        if (cmd.equals("/main_admin.do")) {
            cmdIf = new MainAdminCommand();
        } else if (cmd.equals("/cateInput_admin.do")) {
            cmdIf = new CateInputAdminCommand();
        } else if (cmd.equals("/cateInputOk_admin.do")) {
            cmdIf = new CateInputOkAdminCommand();
        } else if (cmd.equals("/cateList_admin.do")) {
            cmdIf = new CateListAdminCommand();
        } else if (cmd.equals("/cateDelete_admin.do")) {
            cmdIf = new CateDeleteAdminCommand();
        } else if (cmd.equals("/prodInput_admin.do")) {
            cmdIf = new ProdInputAdminCommand();
        } else if (cmd.equals("/prodInputOk_admin.do")) {
            cmdIf = new ProdInputOkAdminCommand();
        } else if (cmd.equals("/prodList_admin.do")) {
            cmdIf = new ProdListAdminCommand();
        } else if (cmd.equals("/prodView_admin.do")) {
            cmdIf = new ProdViewAdminCommand();
        } else if (cmd.equals("/prodDelete_admin.do")) {
            cmdIf = new ProdDeleteAdminCommand();
        } else if (cmd.equals("/prodUpdate_admin.do")) {
            cmdIf = new ProdUpdateAdminCommand();
        } else if (cmd.equals("/prodUpdateOk_admin.do")) {
            cmdIf = new ProdUpdateOkAdminCommand();
        } else if (cmd.equals("/memberList_admin.do")) {
            cmdIf = new MemberListAdminCommand();
        } else if (cmd.equals("/memberDelete_admin.do")) {
            cmdIf = new MemberDeleteAdminCommand();
        } else if (cmd.equals("/memberUpdate_admin.do")) {
            cmdIf = new MemberUpdateAdminCommand();
        } else if (cmd.equals("/memberUpdateOk_admin.do")) {
            cmdIf = new MemberUpdateOkAdminCommand();
        } else if (cmd.equals("/memberInput_admin.do")) {
            cmdIf = new MemberInputAdminCommand();
        } else if (cmd.equals("/memberInputOk_admin.do")) {
            cmdIf = new MemberInputOkAdminCommand();
        } else if (cmd.equals("/memberLogin_admin.do")) {
            cmdIf = new MemberLoginAdminCommand();
        } else if (cmd.equals("/memberLoginOk_admin.do")) {
            cmdIf = new MemberLoginOkAdminCommand();
        } else if (cmd.equals("/memberLogout_admin.do")) {
            cmdIf = new MemberLogoutAdminCommand();
        } else if (cmd.equals("/boardList1_admin.do")) {
            cmdIf = new BoardList1AdminCommand();
        } else if (cmd.equals("/boardContent_admin.do")) {
            cmdIf = new BoardContentAdminCommand();
        } else if (cmd.equals("/boardDeleteForm_admin.do")) {
            cmdIf = new BoardDeleteFormAdminCommand();
        } else if (cmd.equals("/boardDeletePro_admin.do")) {
            cmdIf = new BoardDeleteProAdminCommand();
        } else if (cmd.equals("/boardInsertForm_admin.do")) {
            cmdIf = new BoardInsertFormAdminCommand();
        } else if (cmd.equals("/boardInsertPro_admin.do")) {
            cmdIf = new BoardInsertProAdminCommand();
        } else if (cmd.equals("/boardUpdate_admin.do")) {
            cmdIf = new BoardUpdateAdminCommand();
        } else if (cmd.equals("/boardUpdateOk_admin.do")) {
            cmdIf = new BoardUpdateOkAdminCommand();
        } 
     
        return cmdIf;
    }
}

