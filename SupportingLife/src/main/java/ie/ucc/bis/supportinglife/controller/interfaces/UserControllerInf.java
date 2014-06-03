package ie.ucc.bis.supportinglife.controller.interfaces;

import ie.ucc.bis.supportinglife.communication.UserAuthenticationComms;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


public interface UserControllerInf {
	public @ResponseBody Boolean registerUser(@RequestBody UserAuthenticationComms userDetails);
}
