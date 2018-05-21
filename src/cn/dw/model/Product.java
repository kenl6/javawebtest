package cn.dw.model;

import java.util.Date;

/**
* @author Ken.Leung
* @version 2018年5月21日 下午4:23:12
* 此类是model  类->表    对象->记录  属性->字段  
*/
public class Product {


		private Integer id;
		private String name;
		private Double price;
		private String remark;
		private Date date;
		
		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

}
