package cn.dw.dao;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dw.model.Product;


import org.springframework.jdbc.core.JdbcTemplate;
/**
* @author Ken.Leung
* @version 2018年5月22日 上午10:36:51
* 
*/
public class ProductDaoImplTest {


	// static说明当前属性是类属性,只有一份,静态方法只能操作静态属性
	private static ProductDaoImpl daoImpl = null;
	private static ApplicationContext context = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass.....");
		context = new ClassPathXmlApplicationContext("spring-public.xml");
		daoImpl = context.getBean("productDao",ProductDaoImpl.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		System.out.println("tearDownAfterClass.....");
		daoImpl = null;
	}

	@Test
	public void testGetById() {

		System.out.println(daoImpl.getById(8));
	}

	@Test
	public void testGetByName() {

		System.out.println(daoImpl.getByName("S&K"));
	}
	
	@Test
	public void testQueryByName() {
		// "%%":代表查询所有记录
		List<Product> proList = daoImpl.queryByName("",2,3);
		for (Product temp : proList) {
			System.out.println(temp + "=======>" + temp.toString());
		}
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
		product.setName("LL");
		product.setPrice(8.32);
		product.setRemark("测试数据");
		product.setId(5);
		daoImpl.save(product);
	}

}
