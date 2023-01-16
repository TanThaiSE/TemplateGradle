package com.nashtech.ecommerce_website.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nashtech.ecommerce_website.dto.response.NotificationsResponse;
import com.nashtech.ecommerce_website.repository.NotificationRepository;
import com.nashtech.ecommerce_website.service.NotificationService;

@Service
public class NotificationImpl implements NotificationService {
	@Autowired
	NotificationRepository notificationRepository;

	/**
	 * Function getNotificationByMemberId is used to get data from database after query.
	 * 
	 * @param memberId is id of member
	 * @return new NotificationsResponse(notificationRepository.selectNotificationByMemberId(memberId)) return list of notifications
	 * 
	 */
	@Override
	public NotificationsResponse getNotificationByMemberId(String memberId) {
		return new NotificationsResponse(notificationRepository.selectNotificationByMemberId(memberId));
	}
}
