package ie.ucc.bis.supportinglife.surveillance;


/**
 * Used to capture number of disease classifications over a certain number of
 * time periods i.e.
 * 
 * - 24 hour period
 * - 7 days
 * - 30 days
 * 
 * @author TOSullivan
 */
public class SurveillancePeriodStats {
	
	private int twentyFourHours;
	private int sevenDays;
	private int thirtyDays;
	
	public SurveillancePeriodStats(int twentyFourHourStat, int sevenDayStat, int thirtyDayStat) {
		setTwentyFourHours(twentyFourHourStat);
		setSevenDays(sevenDayStat);
		setThirtyDays(thirtyDayStat);
	}
	
	public int getTwentyFourHours() {
		return twentyFourHours;
	}
	
	public void setTwentyFourHours(int twentyFourHours) {
		this.twentyFourHours = twentyFourHours;
	}
	
	public int getSevenDays() {
		return sevenDays;
	}
	
	public void setSevenDays(int sevenDays) {
		this.sevenDays = sevenDays;
	}
	
	public int getThirtyDays() {
		return thirtyDays;
	}
	
	public void setThirtyDays(int thirtyDays) {
		this.thirtyDays = thirtyDays;
	}
	
}
