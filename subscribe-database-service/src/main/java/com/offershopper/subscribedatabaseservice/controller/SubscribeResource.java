package com.offershopper.subscribedatabaseservice.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.offershopper.subscribedatabaseservice.model.SubscribeBean;
import com.offershopper.subscribedatabaseservice.repository.SubscribeRepository;

@RestController
@RequestMapping("/rest/subscribe")
public class SubscribeResource {


	private SubscribeRepository subscribeRepository;
	
    public SubscribeResource(SubscribeRepository subscribeRepository) {
        this.subscribeRepository = subscribeRepository;
    }
    
/*    @GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public SubscribeBean getAll() {
        return new SubscribeBean(2,10,"shirt");
    }*/
    
	@HystrixCommand(fallbackMethod="fallback")
    @GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SubscribeBean> getAll() {
        return subscribeRepository.findAll();
    }

	public List<SubscribeBean> fallback() {

		return Collections.emptyList();
	}
    
	@PostMapping(value="/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public void addSubscribeBean(@RequestBody SubscribeBean subscribeBean) {
		Optional<SubscribeBean> option = subscribeRepository.findById(subscribeBean.getUserId());

		if(option.isPresent()) {
			if(option.get().getCategory().equals(subscribeBean.getCategory())) {
				return;
			} 
		}
		subscribeRepository.insert(subscribeBean);
		//return subscribeBean;
	}
	
	@DeleteMapping("/del/{userId}")
	public void del(@PathVariable("userId") Integer userId) {
		subscribeRepository.deleteById(userId);
		
	}

	

}
