package cn.dw.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.dw.model.Product;

/**
* @author Ken.Leung
* @version 2018年5月24日 上午10:40:55
* 
*/
public class ProductServiceImplTest {

	// static说明当前属性是类属性,只有一份,静态方法只能操作静态属性
		private static ProductServiceImpl serviceImpl = null;
		private static ApplicationContext context = null;

		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			System.out.println("setUpBeforeClass.....");
			context = new ClassPathXmlApplicationContext("spring-public.xml");
			// daoImpl = (ProductDaoImpl)context.getBean("productDao");
			serviceImpl = context.getBean("productService", ProductServiceImpl.class);
		}

		@AfterClass
		public static void tearDownAfterClass() throws Exception {
			System.out.println("tearDownAfterClass.....");
			serviceImpl = null;
		}

		@Test
		public void testQueryByName() {
			// "%%":代表查询所有记录
			List<Product> proList = serviceImpl.queryByName("", 2, 3);
			for (Product temp : proList) {
				System.out.println(temp + "=======>" + temp.toString());
			}
		}

		//
		@Test
		public void testGetById() {
			// "%%":代表查询所有记录
			System.out.println(serviceImpl.getById(4));
		}

		@Test
		public void testDelete() {
			fail("Not yet implemented");
		}

		@Test
		public void testUpdate() {
			fail("Not yet implemented");
		}

		@Test
		public void testSave() {
			Product product = new Product();
			product.setName("aop demo7");
			product.setPrice(3.14);
			product.setRemark("remark");
			serviceImpl.save(product);
		}

}
