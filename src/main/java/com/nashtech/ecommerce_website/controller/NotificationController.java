package com.nashtech.ecommerce_website.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.ecommerce_website.dto.response.ErrorResponse;
import com.nashtech.ecommerce_website.dto.response.NotificationsResponse;
import com.nashtech.ecommerce_website.service.NotificationService;
import com.nashtech.ecommerce_website.utils.validation.Validation;

@RestController
public class NotificationController {
	@Autowired
	NotificationService notificationService;
	private final String ERROR_CODE_MEMBER_ID_REQUIRED = "require_member_id";
    private final String ERROR_MESSAGE_MEMBER_ID_REQUIRED = "member id is required";
    private final String ERROR_CODE_MEMBER_ID_SPECIAL_CHARACTER = "invalid_member_id";
    private final String ERROR_MESSAGE_MEMBER_ID_SPECIAL_CHARACTER = "member id must not contain special character";
    /**
     * Function getNotificationByMemberId is used to get data from database after query.
     * @param memberId is id of member
     */
	@RequestMapping(value = "/searchNotification", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getNotificationByMemberId(@RequestParam("memberId") String memberId) {
		if(Validation.isEmpty(memberId)) {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse(ERROR_CODE_MEMBER_ID_REQUIRED,ERROR_MESSAGE_MEMBER_ID_REQUIRED),HttpStatus.BAD_REQUEST);
		}
		else if(Validation.hasSpecialCharacter(memberId)) {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse(ERROR_CODE_MEMBER_ID_SPECIAL_CHARACTER,ERROR_MESSAGE_MEMBER_ID_SPECIAL_CHARACTER),HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<NotificationsResponse>(notificationService.getNotificationByMemberId(memberId),HttpStatus.OK);
		}
	}
}
