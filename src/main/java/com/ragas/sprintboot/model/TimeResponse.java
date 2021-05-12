/**
 * 
 */
package com.ragas.sprintboot.model;

/**
 * @author Chandra.Jagarlamudi
 *
 */
public class TimeResponse {
	private String date;
	private Long unixTime;
	private String time;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getUnixTime() {
		return unixTime;
	}

	public void setUnixTime(Long unixTime) {
		this.unixTime = unixTime;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {

		final StringBuilder sb = new StringBuilder("TimeResponse{");
		sb.append("date='").append(getDate()).append('\'');
		sb.append(", unixtime=").append(getUnixTime());
		sb.append(", time='").append(getTime()).append('\'');
		sb.append('}');

		return sb.toString();
	}

}
