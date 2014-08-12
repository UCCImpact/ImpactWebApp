package ie.ucc.bis.supportinglife.reference;

public class TeamMember {

	private String name;
	private String qualifications;
	private String role;
	private String bio;
	private boolean photoPresent;
	private boolean linkedInProfilePresent;
	private boolean researchProfilePresent;
	private String linkedInUrl;
	private String researchUrl;
	private String imageRef;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQualifications() {
		return qualifications;
	}
	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}

	public boolean isPhotoPresent() {
		return photoPresent;
	}
	public void setPhotoPresent(boolean photoPresent) {
		this.photoPresent = photoPresent;
	}
	public boolean isLinkedInProfilePresent() {
		return linkedInProfilePresent;
	}
	public void setLinkedInProfilePresent(boolean linkedInProfilePresent) {
		this.linkedInProfilePresent = linkedInProfilePresent;
	}
	public boolean isResearchProfilePresent() {
		return researchProfilePresent;
	}
	public void setResearchProfilePresent(boolean researchProfilePresent) {
		this.researchProfilePresent = researchProfilePresent;
	}
	public String getLinkedInUrl() {
		return linkedInUrl;
	}
	public void setLinkedInUrl(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}
	public String getResearchUrl() {
		return researchUrl;
	}
	public void setResearchUrl(String researchUrl) {
		this.researchUrl = researchUrl;
	}
	public String getImageRef() {
		return imageRef;
	}
	public void setImageRef(String imageRef) {
		this.imageRef = imageRef;
	}	
}
