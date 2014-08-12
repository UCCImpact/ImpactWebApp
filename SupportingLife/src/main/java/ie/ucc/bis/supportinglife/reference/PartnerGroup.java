package ie.ucc.bis.supportinglife.reference;

import java.util.List;

public class PartnerGroup {
	
	private String partnerName;
	private List<TeamMember> teamMembers;
	
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	public List<TeamMember> getTeamMembers() {
		return teamMembers;
	}
	public void setTeamMembers(List<TeamMember> teamMembers) {
		this.teamMembers = teamMembers;
	}
	
}
