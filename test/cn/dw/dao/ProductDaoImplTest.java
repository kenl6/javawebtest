package cn.dw.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.dw.model.Product;

/**
* @author Ken.Leung
* @version 2018年5月22日 上午10:36:51
* 
*/
public class ProductDaoImplTest {


	// static说明当前属性是类属性,只有一份,静态方法只能操作静态属性
	public static ProductDaoImpl daoImpl = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass.....");
		daoImpl = new ProductDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		System.out.println("tearDownAfterClass.....");
		daoImpl = null;
	}

	@Test
	public void testGetById() {
		Product product = daoImpl.getById(2);
		System.out.println(product.toString());
	}
	
	@Test
	public void testQueryByName() {

		System.out.println("123");
		List<Product> proList = daoImpl.queryByName("S&K");
		System.out.println(proList.size());
	}

	@Test
	public void testDelete() {

		daoImpl.delete(5);
	}

	@Test
	public void testUpdate() {

		Product product = new Product();
		product.setName("S&K");
		product.setPrice(8.32);
		product.setRemark("测试数据");
		product.setId(3);
		daoImpl.update(product);
	}

	@Test
	public void testSave() {
		Product product = new Product();
		product.setName("S&K");
		product.setPrice(8.32);
		product.setRemark("测试数据");
		product.setId(5);
		daoImpl.save(product);
	}

}
