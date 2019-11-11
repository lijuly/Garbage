package springcloud.study.microserviceOrder;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ItemService {

	@Autowired
	private ItemFeignClient itemFeignClient;

	
	// 断路保护
	@HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod")
	public Item queryItemById(Long id) {
		
		return this.itemFeignClient.queryItemById(id);
	}
	
	public Item queryItemByIdFallbackMethod(Long id){ // 请求失败执行的方法
		return new Item(id, "查询商品信息出错!", null, null, null);
	}

}
