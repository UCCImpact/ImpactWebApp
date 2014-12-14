package ie.ucc.bis.supportinglife.controller.interfaces;

import ie.ucc.bis.supportinglife.form.NewsEntryCreationForm;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

public interface MediaControllerInf {
	String displayUserForm(Boolean newsEntryCreated, ModelMap model);
	ModelAndView createNewsEntry(NewsEntryCreationForm newsEntryCreationForm, ModelMap model);
}
