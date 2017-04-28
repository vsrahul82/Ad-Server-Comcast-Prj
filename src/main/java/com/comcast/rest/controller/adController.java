package com.comcast.rest.controller;

import java.time.Instant;
import java.util.HashSet;
import java.util.NoSuchElementException;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comcast.model.Ad;
import com.comcast.utils.Utils;

/**
 * This class is a REST controller. It exposes Http POST and GET methods for ad
 * instances.
 * 
 * @author rvanimisetty
 *
 */

@RestController
public class adController {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(adController.class);

	private static final HashSet<Ad> set = new HashSet<>();;

	@RequestMapping(value = "ad", method = RequestMethod.POST)
	public String add(@RequestBody Ad ad) {

		try {

			ad.setCreation_time(Long.toString(Instant.now().getEpochSecond()));

			set.add(ad);

			LOGGER.info("List of ad instances : " + set);

			return "POST successful";

		} catch (Exception e) {

			LOGGER.error("Error occurred : ", e);

			return "Exception" + e.getMessage();
		}
	}

	@RequestMapping(value = "retrieveAll", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Ad[]> retrieveAll() {

		try {

			Ad[] array = new Ad[set.size()];

			return new ResponseEntity<>(set.toArray(array), HttpStatus.OK);

		} catch (Exception e) {

			LOGGER.error("Error occurred : ", e);

			return null;
		}
	}

	@RequestMapping(value = "/ad/{partner_id}", method = RequestMethod.GET, produces = "application/json")
	public Ad get(@PathVariable Integer partner_id) {

		Ad match = null;

		try {

			match = set.stream().filter(a -> Integer.valueOf(a.getPartner_id()) == partner_id).findFirst().get();

		} catch (NoSuchElementException e) {
			/*
			 * If above exception is thrown it means the input partner_id is not
			 * found in the set of ad instances
			 */
			Ad err = new Ad();
			err.setErrorCode("201");
			err.setErrorMsg("Ad with input partner_id(" + partner_id + ") does not exist.");
			return err;
		}

		/*
		 * If code reaches hare then match is found. Next step is to check if
		 * the ad has expired.
		 */

		if (Utils.isAdExpired(match)) {
			Ad err = new Ad();
			err.setErrorCode("202");
			err.setErrorMsg("no active ad campaigns exist for the specified partner : " + partner_id);
			return err;
		}

		match.setErrorCode("0");

		return match;

	}

}
