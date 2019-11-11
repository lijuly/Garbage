package springcloud.study.microserviceOrder;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "microserviceItem")
public interface ItemFeignClient {

	@RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
	public Item queryItemById(@PathVariable("id") Long id);
}
