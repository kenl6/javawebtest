package cn.dw.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
public class ProductController extends BaseController {
	
	
	// MVC推荐使用注解，因此此处采用注解取代XML
	@Resource(name = "productService") // Resource会到配置文件中查找ID为指定名称的bean
	private ProductServiceImpl productService;

	@RequestMapping(value = "/save")
	public String save(Product product) {
		// 1、此处应该调用ProductService.save();
		productService.save(product);
		// 2、跳转到查询页面
		return	"redirect:/query.jsp";

	}
	
	@RequestMapping(value = "/queryByName")
	public String queryByName(String keyword) {
		// 1、此处应该调用ProductService.queryByName();
		List<Product> proList = productService.queryByName("%"+keyword+"%", 1, 10);
		request.setAttribute("proList", proList);
		// 2、跳转到查询页面
		return	"forward:/query.jsp";

	}
}
