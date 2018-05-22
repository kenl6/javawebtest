package cn.dw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.dw.model.Product;
import cn.dw.utils.JdbcUtils;

/**
 * @author Ken.Leung
 * @version 2018年5月21日 下午4:19:35
 * 
 */
public class ProductDaoImpl extends BaseDaoImpl<Product> {
	

	@Override
	protected Product getRow(ResultSet rs) throws SQLException {
		// 数据库一行记录,对应Java中对象
		Product product = new Product();
		// 通过列的名称,获取当前行的指定列信息
		product.setName(rs.getString("name"));
		product.setPrice(rs.getDouble("price"));
		product.setRemark(rs.getString("remark"));
		product.setId(rs.getInt("id"));
		product.setDate(rs.getDate("date"));
		return product;
	}
	
	public Product getById(int id) {
		String sql = "select * from product where id = ?";
		return super.getById(sql, id);
	}

	public List<Product> queryByName(String name) {
		// 声明一个集合，用来存储查询到的数据库记录
		List<Product> proList = new ArrayList<Product>();

		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from product where name like ?";
		try {

			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setString(1, "%" + name + "%");
			
			ResultSet rs = prep.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setId(rs.getInt("id"));
				product.setRemark(rs.getString("remark"));
				proList.add(product);
			}

			return proList;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
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
