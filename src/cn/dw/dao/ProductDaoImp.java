package cn.dw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.dw.model.Product;
import cn.dw.utils.JdbcUtils;

/**
 * @author Ken.Leung
 * @version 2018年5月21日 下午4:19:35
 * 
 */
public class ProductDaoImp extends BaseDaoImpl {

	public static void main(String[] args) {
		Product product = new Product();
		product.setName("xyz");
		product.setPrice(8.32);
		product.setRemark("测试数据");
		ProductDaoImp daoImpl = new ProductDaoImp();
		daoImpl.save(product);

	}

	public int delete(int id) {
		String sql = "delete from product where id=?";
		return super.executeUpdate(sql, new Object[] { id });
	}

	public int update(Product product) {
		String sql = "update product set name = ?, price=?, remark=? where id =?";
		return super.executeUpdate(sql,
				new Object[] { product.getName(), product.getPrice(), product.getRemark(), product.getId() });
	}

	// 应该通过创建一个Model(模型),完成对属性封装
	public int save(Product product) {
		String sql = "insert into product(name,price,remark) values(?,?,?)";
		return super.executeUpdate(sql, new Object[] { product.getName(), product.getPrice(), product.getRemark() });
	}
}
