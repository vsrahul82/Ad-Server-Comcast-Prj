package com.comcast.utils;

import static org.junit.Assert.*;

import java.time.Instant;

import org.junit.Test;

import com.comcast.model.Ad;

public class UtilsTests {

	@Test
	public void testAdExpired() {
		Ad ex = new Ad();
		ex.setCreation_time("1493306373");
		ex.setDuration("3");
		boolean flag = Utils.isAdExpired(ex);
		assertEquals(flag, true);
	}
	
	@Test
	public void testAdNotExpired() {
		Ad ex = new Ad();
		ex.setCreation_time(Long.toString(Instant.now().getEpochSecond()));
		ex.setDuration("3");
		boolean flag = Utils.isAdExpired(ex);
		assertEquals(flag, false);
	}

}
