package com.comcast.model;

/**
 * Model class Ad. It represents the real world object of ads. For simplicity it
 * has 6 fields as seen below
 * 
 * @author rvanimisetty
 */

public class Ad {

	private String partner_id;
	private String duration;
	private String ad_content;
	
	private String errorCode;
	private String errorMsg;
	private String creation_time;

	public String getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(String partner_id) {
		this.partner_id = partner_id;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getAd_content() {
		return ad_content;
	}

	public void setAd_content(String ad_content) {
		this.ad_content = ad_content;
	}

	@Override
	public String toString() {
		return "Ad [partner_id=" + partner_id + ", duration=" + duration + ", ad_content=" + ad_content + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ad_content == null) ? 0 : ad_content.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((partner_id == null) ? 0 : partner_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ad other = (Ad) obj;
		if (ad_content == null) {
			if (other.ad_content != null)
				return false;
		} else if (!ad_content.equals(other.ad_content))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (partner_id == null) {
			if (other.partner_id != null)
				return false;
		} else if (!partner_id.equals(other.partner_id))
			return false;
		return true;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getCreation_time() {
		return creation_time;
	}

	public void setCreation_time(String creation_time) {
		this.creation_time = creation_time;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
