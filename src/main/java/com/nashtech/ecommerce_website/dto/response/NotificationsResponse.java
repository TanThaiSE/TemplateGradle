package com.nashtech.ecommerce_website.dto.response;

import java.util.List;
import java.util.Map;

import lombok.*;

public class NotificationsResponse {
	private List<Map<String, Object>> listNotifications;

	/**
	 * 
	 * コンストラクタ.
	 * 
	 * @param listNotifications :list of notifications
	 * 
	 */
	public NotificationsResponse(List<Map<String, Object>> listNotifications) {
		this.listNotifications = listNotifications;
	}

	public List<Map<String, Object>> getListNotifications() {
		return listNotifications;
	}

	public void setListNotifications(List<Map<String, Object>> listNotifications) {
		this.listNotifications = listNotifications;
	}

}
