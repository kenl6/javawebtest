package cn.dw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cn.dw.model.Product;

/**
 * @author Ken.Leung
 * @version 2018年5月21日 下午4:19:35
 * 
 */
public class ProductDaoImpl {

	// @Override
	// protected Product getRow(ResultSet rs) throws SQLException {
	// // 数据库一行记录,对应Java中对象
	// Product product = new Product();
	// // 通过列的名称,获取当前行的指定列信息
	// product.setName(rs.getString("name"));
	// product.setPrice(rs.getDouble("price"));
	// product.setRemark(rs.getString("remark"));
	// product.setId(rs.getInt("id"));
	// product.setDate(rs.getDate("date"));
	// return product;
	// }
	//
	// public Product getById(int id) {
	// String sql = "select * from product where id = ?";
	// return super.getById(sql, id);
	// }

	// public List<Product> queryByName(String name) {
	// // 声明一个集合，用来存储查询到的数据库记录
	// List<Product> proList = new ArrayList<Product>();
	//
	// Connection conn = JdbcUtils.getConnection();
	// String sql = "select * from product where name like ?";
	// try {
	//
	// PreparedStatement prep = conn.prepareStatement(sql);
	// prep.setString(1, "%" + name + "%");
	//
	// ResultSet rs = prep.executeQuery();
	// while (rs.next()) {
	// Product product = new Product();
	// product.setName(rs.getString("name"));
	// product.setPrice(rs.getDouble("price"));
	// product.setId(rs.getInt("id"));
	// product.setRemark(rs.getString("remark"));
	// proList.add(product);
	// }
	//
	// return proList;
	// } catch (SQLException e) {
	// throw new RuntimeException();
	// }
	// }
	//
	// public int delete(int id) {
	// String sql = "delete from product where id=?";
	// return super.executeUpdate(sql, new Object[] { id });
	// }
	//
	// public int update(Product product) {
	// String sql = "update product set name = ?, price=?, remark=? where id
	// =?";
	// return super.executeUpdate(sql,
	// new Object[] { product.getName(), product.getPrice(),
	// product.getRemark(), product.getId() });
	// }
	//
	// // 应该通过创建一个Model(模型),完成对属性封装
	// public int save(Product product) {
	// String sql = "insert into product(name,price,remark) values(?,?,?)";
	// return super.executeUpdate(sql, new Object[] { product.getName(),
	// product.getPrice(), product.getRemark() });
	// }

	private JdbcTemplate jdbcTemplate = null;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("setJdbcTemplate()....");
		this.jdbcTemplate = jdbcTemplate;
	}

	public Product getById(int id) {
		String sql = "select * from product where id=?";

		// 直接通过接口创建的对象，称为匿名对象，此方法优点效率高，缺点是代码量大
		// return jdbcTemplate.queryForObject(sql, new RowMapper<Product>(){
		//
		// @Override
		// public Product mapRow(ResultSet rs, int arg1) throws SQLException {
		// Product product= new Product();
		// product.setName(rs.getString("name"));
		// product.setPrice(rs.getDouble("price"));
		// return product;
		// }
		//
		//
		// },id);
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Product>(Product.class), id);
	}

	public List<Product> getByName(String name) {
		String sql = "select * from product where name like ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class), "%" + name + "%");
	}

	// 分页查询
	public List<Product> queryByName(String name, int page, int size) {
		String sql = "select * from product where name like ? limit ?,?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class),
				new Object[] { "%" + name + "%", (page - 1) * size, size });
	}

	public int delete(int id) {
		String sql = "delete from product where id=?";
		return jdbcTemplate.update(sql, id);
	}

	public int update(Product product) {
		String sql = "update product set name = ?, price=?, remark=? where id =?";

		return jdbcTemplate.update(sql,
				new Object[] { product.getName(), product.getPrice(), product.getRemark(), product.getId() });
	}

	// 应该通过创建一个Model(模型),完成对属性封装
	public int save(Product product) {
		String sql = "insert into product(name,price,remark) values(?,?,?)";
		return jdbcTemplate.update(sql, new Object[] { product.getName(), product.getPrice(), product.getRemark() });
	}

}
