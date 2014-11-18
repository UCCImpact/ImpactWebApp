package ie.ucc.bis.supportinglife.controller.interfaces;

import java.sql.SQLException;

import org.springframework.ui.ModelMap;

public interface UserAuthenticationControllerInf {

	String displayLoginPage(ModelMap model) throws SQLException;
}
