package ie.ucc.bis.interceptor;

import ie.ucc.bis.service.helper.SupportingLifeRefDataHelperInf;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SupportingLifeHandlerInterceptor implements HandlerInterceptor {

	Logger log = Logger.getLogger(SupportingLifeHandlerInterceptor.class); 
	
	@Autowired
	private SupportingLifeRefDataHelperInf SupportingLifeRefDataHelper;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		log.info("IN preHandle");
		
		// Identify predefined reports for MenuBar
		Collection<String> preDefinedReports = SupportingLifeRefDataHelper.getPreDefinedReports().values();
		request.setAttribute("preDefinedReports", preDefinedReports);

		// Identify custom reports for MenuBar
		Collection<String> customReports = SupportingLifeRefDataHelper.getCustomReports().values();
		request.setAttribute("customReports", customReports);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
