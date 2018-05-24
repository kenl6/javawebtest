package cn.dw.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.dw.model.Product;
import cn.dw.service.ProductServiceImpl;

/**
 * @author Ken.Leung
 * @version 2018年5月24日 上午10:47:55 此类用于取代MVC
 */
@RequestMapping(value = "/product")
@Controller // @Controller注解代表当前类交给Spring
public class ProductController {
	// MVC推荐使用注解，因此此处采用注解取代XML
	@Resource(name = "productService") // Resource会到配置文件中查找ID为指定名称的bean
	private ProductServiceImpl productService;

	@RequestMapping(value = "/save")
	public void save(Product product) {
		// 1、此处应该调用ProductService.save();
		productService.save(product);
		// 2、跳转到查询页面

	}
}
