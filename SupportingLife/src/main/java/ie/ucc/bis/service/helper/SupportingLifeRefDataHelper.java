
package ie.ucc.bis.service.helper;

import java.util.Map;

public class SupportingLifeRefDataHelper implements SupportingLifeRefDataHelperInf {

	private Map<String, String> preDefinedReports;
	private Map<String, String> customReports;
	
	@Override
	public Map<String, String> getPreDefinedReports() {
		return preDefinedReports;
	}

	public void setPreDefinedReports(Map<String, String> preDefinedReports) {
		this.preDefinedReports = preDefinedReports;
	}

	@Override
	public Map<String, String> getCustomReports() {
		return customReports;
	}

	public void setCustomReports(Map<String, String> customReports) {
		this.customReports = customReports;
	}

}
