package com.comcast.utils;

import java.time.Instant;

import com.comcast.model.Ad;

public class Utils {

	public static boolean isAdExpired(Ad ad) {

		long creationTime = Long.parseLong(ad.getCreation_time());
		long currentTime = Instant.now().getEpochSecond();
		long duration = Long.parseLong(ad.getDuration());
		
		if(currentTime - creationTime >  duration)
			return true;
		else 
			return false;
		
	}

}
