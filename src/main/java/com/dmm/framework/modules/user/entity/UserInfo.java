/**
 *
 */
package com.dmm.framework.modules.user.entity;

import com.dmm.framework.common.mongo.MongoBean;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 知乎用户Entity
 * @author pzg
 * @version 2017-02-09
 */
@Document
public class UserInfo extends MongoBean {
	
	private static final long serialVersionUID = 1L;
	private String zhihuId;       //知乎id
	private String nickName;		// 昵称
	private String type;		// 类型
	private String peopleType;		// 用户类型
	private String avatarUrl;		// 头像
	private Integer age;		// 年龄
	private Integer sex;		// 性别
	private String industry;		// 所在行业
	private String address;		// 居住地
	private String description;		// 个人简介
	private String eduRecord;		// 教育经历
	private String jobRecord;		// 职业经历
	private String url;		// 个人主页
	private Integer answerNum;		// 回答数
	private String headline;		// 一句话介绍
	private Integer isFollowNum;		// 关注者数
	private Integer followNum;		// 关注数
	private Integer followerTopic;		// 关注的话题
	private Integer collectionNum;		// 收藏数
	private Integer followerQuestion;		// 关注的问题数
	private String urlToken;		// url_token
	private String authInfo;		// 认证信息
	private String isGrab;		// 0.未抓取1.已抓取
	
	public UserInfo() {
		super();
	}

	public String getZhihuId() {
		return zhihuId;
	}

	public void setZhihuId(String zhihuId) {
		this.zhihuId = zhihuId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPeopleType() {
		return peopleType;
	}

	public void setPeopleType(String peopleType) {
		this.peopleType = peopleType;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEduRecord() {
		return eduRecord;
	}

	public void setEduRecord(String eduRecord) {
		this.eduRecord = eduRecord;
	}

	public String getJobRecord() {
		return jobRecord;
	}

	public void setJobRecord(String jobRecord) {
		this.jobRecord = jobRecord;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getAnswerNum() {
		return answerNum;
	}

	public void setAnswerNum(Integer answerNum) {
		this.answerNum = answerNum;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public Integer getIsFollowNum() {
		return isFollowNum;
	}

	public void setIsFollowNum(Integer isFollowNum) {
		this.isFollowNum = isFollowNum;
	}

	public Integer getFollowNum() {
		return followNum;
	}

	public void setFollowNum(Integer followNum) {
		this.followNum = followNum;
	}

	public Integer getFollowerTopic() {
		return followerTopic;
	}

	public void setFollowerTopic(Integer followerTopic) {
		this.followerTopic = followerTopic;
	}

	public Integer getCollectionNum() {
		return collectionNum;
	}

	public void setCollectionNum(Integer collectionNum) {
		this.collectionNum = collectionNum;
	}

	public Integer getFollowerQuestion() {
		return followerQuestion;
	}

	public void setFollowerQuestion(Integer followerQuestion) {
		this.followerQuestion = followerQuestion;
	}

	public String getUrlToken() {
		return urlToken;
	}

	public void setUrlToken(String urlToken) {
		this.urlToken = urlToken;
	}

	public String getAuthInfo() {
		return authInfo;
	}

	public void setAuthInfo(String authInfo) {
		this.authInfo = authInfo;
	}
	public String getIsGrab() {
		return isGrab;
	}

	public void setIsGrab(String isGrab) {
		this.isGrab = isGrab;
	}
}