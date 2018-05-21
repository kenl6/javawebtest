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

	public static void main(String[] args){
		Date date = new Date();
	}
	
	public int save(Product product){
		String sql = "";
		Connection conn = null;
		PreparedStatement pre = null;
		try{
			conn = JdbcUtils.getConnection();
			pre = conn.prepareStatement(sql);
			pre.setString(1, "1");
			pre.setString(2, "2");
			pre.setString(3, "3");
			
			return pre.executeUpdate();
		}catch(SQLException e){
			throw new RuntimeException();
		}finally{
			//无论数据库操作是否成功，资源都需要释放
			try{
				pre.close();
			}catch(){
				throw new RuntimeException();
			}finally{
				conn.close();
			}
		}
	}
}
