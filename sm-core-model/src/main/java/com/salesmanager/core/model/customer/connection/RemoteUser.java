package com.salesmanager.core.model.customer.connection;

//import org.springframework.social.UserIdSource;

@Deprecated
public interface RemoteUser { //extends UserIdSource{

	String getUserId();

	void setUserId(String id);

	/*
	 * Provider identifier: Facebook, Twitter, LinkedIn etc
	 */
	String getProviderUserId();

	void setProviderUserId(String provider);

	String getProviderId();

	void setProviderId(String providerId);

	int getRank();

	void setRank(int rank);

	String getSecret();

	void setSecret(String secret);

	String getDisplayName();

	void setDisplayName(String displayName);

	String getProfileUrl();

	void setProfileUrl(String profileUrl);

	String getImageUrl();

	void setImageUrl(String imageUrl);

	String getAccessToken();

	void setAccessToken(String accessToken);

	String getRefreshToken();

	void setRefreshToken(String refreshToken);

	Long getExpireTime();

	void setExpireTime(Long expireTime);

}
