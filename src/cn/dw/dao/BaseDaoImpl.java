package cn.dw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.dw.utils.JdbcUtils;

/**
* @author Ken.Leung
* @version 2018年5月21日 下午5:00:37
* 编写一个操作数据库的父类，此类用来实现共性代码抽取
*/
public class BaseDaoImpl {

	//编写一个方法，实现save，update，delete的功能，此方法仅仅交给子类应用
	protected int executeUpdate(String sql, Object[] params){

		// 操作数据库的4个步骤:
		// 1:获取数据库的连接
		Connection conn = null;
		PreparedStatement pre = null;
		try {
			conn = JdbcUtils.getConnection(); // ctrl + 2
			// 2:配置参数,并且执行SQL
			pre = conn.prepareStatement(sql);
			// 下标从1开始
			for(int i=0;i<params.length;i++){
				pre.setObject(i+1, params[i]);
			}
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
