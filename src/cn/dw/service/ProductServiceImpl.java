package cn.dw.service;

import java.util.List;

import org.springframework.dao.support.DaoSupport;

import cn.dw.dao.ProductDaoImpl;
import cn.dw.model.Product;

// 项目的业务逻辑实现,都被封装在Service层,此层不能有访问数据库的代码,如果需要进行数据库操作,则应该Service-->Dao
public class ProductServiceImpl {
	// spring通过xml的配置取代了硬编码,依赖都要交给Spring管理
	private ProductDaoImpl productDao = null;

	// 通过set注入
	public void setProductDao(ProductDaoImpl productDao) {
		this.productDao = productDao;
	}

	public Product getById(int id) {
		return productDao.getById(id);
	}

	public List<Product> queryByName(String name, int page, int size) {
		return productDao.queryByName(name, page, size);
	}

	// 此数据会从显示层传入
	public int delete(int id) {
		int result = productDao.delete(id);
		return result;
	}

	// 此数据会从显示层传入
	public int save(Product product) {
		// 购物车入库
		int result = productDao.save(product);
//		Integer.parseInt("xxx");
		return result;
	}

	public int update(Product product) {
		int result = productDao.update(product);
		return result;
	}
}
