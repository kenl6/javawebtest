package cn.dw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import cn.dw.model.Product;
import cn.dw.utils.JdbcUtils;

/**
 * @author Ken.Leung
 * @version 2018年5月21日 下午4:19:35
 * 
 */
public class ProductDaoImp {

	public static void main(String[] args) {
		Product product = new Product();
		product.setName("xyz");
		product.setPrice(8.32);
		product.setRemark("测试数据");
		ProductDaoImp daoImpl = new ProductDaoImp();
		daoImpl.save(product);
		
	}

	// 应该通过创建一个Model(模型),完成对属性封装
	public int save(Product product) {
		String sql = "insert into product (name,price,remark) values (?,?,?)";
		// 操作数据库的4个步骤:
		// 1:获取数据库的连接
		Connection conn = null;
		PreparedStatement pre = null;
		try {
			conn = JdbcUtils.getConnection(); // ctrl + 2
			// 2:配置参数,并且执行SQL
			pre = conn.prepareStatement(sql);
			// 下标从1开始
			pre.setString(1, product.getName()); // 1代表第一个?
			pre.setDouble(2, product.getPrice());
			pre.setString(3, product.getRemark());
			// SQL语句 + 参数 ==> 执行(返回的是int:影响的行数)
			return pre.executeUpdate(); // 在数据库中：save delete update
										// 都是称为更新(因为都修改数据)
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally { // 无论数据库操作是否成功,资源都需要释放
			// Connection > PreparedStatement > ResultSet 释放资源与创建资源的顺序相反
			try {
				pre.close(); // 无论pre是否关闭成功,conn都需要关闭
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}
