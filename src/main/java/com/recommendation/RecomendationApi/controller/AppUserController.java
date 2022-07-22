package com.recommendation.RecomendationApi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.recommendation.RecomendationApi.model.AppUser;
import com.recommendation.RecomendationApi.service.AppUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class AppUserController {

		private final Logger LOG = LoggerFactory.getLogger(this.getClass());

		@Autowired(required=false)
		AppUserService appUserService;

		@GetMapping("/get-all-users")
		public ResponseEntity<List<AppUser>> getAllAppUsers() {
			LOG.info("get-all-appUsers");
			return new ResponseEntity<List<AppUser>>(appUserService.getAllUsers(), HttpStatus.OK);
		}

		@PostMapping("/sign-up")
		public ResponseEntity<AppUser> signUp(@RequestBody AppUser appUser) {
			LOG.info(appUser.toString());
			return new ResponseEntity<AppUser>(appUserService.signUpUser(appUser), HttpStatus.CREATED);
		}

		@PostMapping("/sign-in")
		public ResponseEntity<AppUser> signIn(@RequestBody AppUser appUser) {
			LOG.info(appUser.toString());
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "User " + appUser.getUserName() + " signed in successfully.");
			return new ResponseEntity<AppUser>(appUserService.signUpUser(appUser), headers, HttpStatus.OK);
		}

		@PutMapping("/update-user")
		public ResponseEntity<AppUser> updateAppUser(@RequestBody AppUser appUser) {
			LOG.info(appUser.toString());
			return new ResponseEntity<AppUser>(appUserService.updateUser(appUser), HttpStatus.OK);
		}
	}