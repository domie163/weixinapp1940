package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 购物车
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-02-28 09:47:02
 */
@TableName("gouwuche")
public class GouwucheEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GouwucheEntity() {
		
	}
	
	public GouwucheEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 购物车编号
	 */
					
	private String gouwuchebianhao;
	
	/**
	 * 物品名称
	 */
					
	private String wupinmingcheng;
	
	/**
	 * 物品分类
	 */
					
	private String wupinfenlei;
	
	/**
	 * 价格
	 */
					
	private String jiage;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 新旧程度
	 */
					
	private String xinjiuchengdu;
	
	/**
	 * 加入时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date jiarushijian;
	
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	/**
	 * 加入账号
	 */
					
	private String jiaruzhanghao;
	
	/**
	 * 加入姓名
	 */
					
	private String jiaruxingming;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：购物车编号
	 */
	public void setGouwuchebianhao(String gouwuchebianhao) {
		this.gouwuchebianhao = gouwuchebianhao;
	}
	/**
	 * 获取：购物车编号
	 */
	public String getGouwuchebianhao() {
		return gouwuchebianhao;
	}
	/**
	 * 设置：物品名称
	 */
	public void setWupinmingcheng(String wupinmingcheng) {
		this.wupinmingcheng = wupinmingcheng;
	}
	/**
	 * 获取：物品名称
	 */
	public String getWupinmingcheng() {
		return wupinmingcheng;
	}
	/**
	 * 设置：物品分类
	 */
	public void setWupinfenlei(String wupinfenlei) {
		this.wupinfenlei = wupinfenlei;
	}
	/**
	 * 获取：物品分类
	 */
	public String getWupinfenlei() {
		return wupinfenlei;
	}
	/**
	 * 设置：价格
	 */
	public void setJiage(String jiage) {
		this.jiage = jiage;
	}
	/**
	 * 获取：价格
	 */
	public String getJiage() {
		return jiage;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：新旧程度
	 */
	public void setXinjiuchengdu(String xinjiuchengdu) {
		this.xinjiuchengdu = xinjiuchengdu;
	}
	/**
	 * 获取：新旧程度
	 */
	public String getXinjiuchengdu() {
		return xinjiuchengdu;
	}
	/**
	 * 设置：加入时间
	 */
	public void setJiarushijian(Date jiarushijian) {
		this.jiarushijian = jiarushijian;
	}
	/**
	 * 获取：加入时间
	 */
	public Date getJiarushijian() {
		return jiarushijian;
	}
	/**
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
	/**
	 * 设置：用户姓名
	 */
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
	/**
	 * 设置：加入账号
	 */
	public void setJiaruzhanghao(String jiaruzhanghao) {
		this.jiaruzhanghao = jiaruzhanghao;
	}
	/**
	 * 获取：加入账号
	 */
	public String getJiaruzhanghao() {
		return jiaruzhanghao;
	}
	/**
	 * 设置：加入姓名
	 */
	public void setJiaruxingming(String jiaruxingming) {
		this.jiaruxingming = jiaruxingming;
	}
	/**
	 * 获取：加入姓名
	 */
	public String getJiaruxingming() {
		return jiaruxingming;
	}

}
