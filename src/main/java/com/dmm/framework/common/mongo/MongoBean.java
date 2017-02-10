/**
 * 不要因为走了很远就忘记当初出发的目的:whatever happened,be yourself
 */
package com.dmm.framework.common.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * mongo基础公共参数
 * 
 * @author xiaoyu 2016年5月11日
 */
@Document
public class MongoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 所有参数都有初始化,这样所有的参数都会存入mongo 这样看起来像mysql多点,习惯些,没有实际性的用处
	 */
	@Transient
	Date date = new Date();

	// @Transient
	// private static Calendar ca = Calendar.getInstance();

	// 转换8小时的时间差
	// static {
	// ca.setTime(date);
	// ca.add(Calendar.HOUR_OF_DAY, 8);
	// System.out.println("初始化时间:" + ca.getTime());
	// }

	@Id
	private String id;
	private String delFlag = "0";// 删除标志 0正常 1删除
	private Date createDate = date;
	private Date updateDate = date;
	private Date deleteDate = date;
	@Transient
	private String dataRange;// 数据权限范围

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
