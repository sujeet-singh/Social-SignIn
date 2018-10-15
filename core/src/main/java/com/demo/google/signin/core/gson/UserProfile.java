package com.demo.google.signin.core.gson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"userid",
	"name",
	"verfiedEmailAdd",
	"email",
	"pictureUrl",
	"locale",
	"familyName",
	"givenName"
})
public class UserProfile {

	@JsonProperty("userid")
	private String userid;
	@JsonProperty("name")
	private String name;
	@JsonProperty("verfiedEmailAdd")
	private Boolean verfiedEmailAdd;
	@JsonProperty("email")
	private String email;
	@JsonProperty("pictureUrl")
	private String pictureUrl;
	@JsonProperty("locale")
	private String locale;
	@JsonProperty("familyName")
	private String familyName;
	@JsonProperty("givenName")
	private String givenName;

	@JsonProperty("userid")
	public String getUserid() {
		return userid;
	}

	@JsonProperty("userid")
	public void setUserid(String userid) {
		this.userid = userid;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("verfiedEmailAdd")
	public Boolean getVerfiedEmailAdd() {
		return verfiedEmailAdd;
	}

	@JsonProperty("verfiedEmailAdd")
	public void setVerfiedEmailAdd(Boolean verfiedEmailAdd) {
		this.verfiedEmailAdd = verfiedEmailAdd;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("pictureUrl")
	public String getPictureUrl() {
		return pictureUrl;
	}

	@JsonProperty("pictureUrl")
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	@JsonProperty("locale")
	public String getLocale() {
		return locale;
	}

	@JsonProperty("locale")
	public void setLocale(String locale) {
		this.locale = locale;
	}

	@JsonProperty("familyName")
	public String getFamilyName() {
		return familyName;
	}

	@JsonProperty("familyName")
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	@JsonProperty("givenName")
	public String getGivenName() {
		return givenName;
	}

	@JsonProperty("givenName")
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

}