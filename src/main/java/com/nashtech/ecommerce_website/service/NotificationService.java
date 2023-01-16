package com.nashtech.ecommerce_website.service;

import com.nashtech.ecommerce_website.dto.response.NotificationsResponse;

public interface NotificationService {
	public NotificationsResponse getNotificationByMemberId(String memberId);
}
