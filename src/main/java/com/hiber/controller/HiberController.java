package com.hiber.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.hiber.model.Player;
import com.hiber.service.PlayerService;
import com.nhncorp.lucy.security.xss.XssSaxFilter;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HiberController {
	
	//@Resource(name="playerService")
	@Inject
	private PlayerService playerService;
	
	private static final Logger logger = LoggerFactory.getLogger(HiberController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView selectPlayers() {
		
		try {
			List<Player> list = playerService.selectPlayers();
			System.out.println(list);
			
			ModelAndView page = new ModelAndView("playerPage");
			page.addObject("players", list);
			
			return page;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/insertPlayer", method = RequestMethod.POST)
	public ModelAndView insertPlayer(Player player) {
	//public ModelAndView insertPlayer(@RequestParam Map<String,Object> params) {
		
		try {
			ModelAndView page;

			//String clean = XssPreventer.escape(player.getName());			
			XssSaxFilter filter = XssSaxFilter.getInstance("lucy-xss-sax.xml");
			
			/*for ( String key : params.keySet() ) {
				String clean = filter.doFilter(params.get(key).toString());
				System.out.println(clean);
				if(clean.contains("<!-- Not Allowed")){
					page = new ModelAndView("illegalError");
					return page;
				}
			}*/

			playerService.insertPlayer(player);
			//playerService.insertPlayer(params);
			//playerService.updatePlayer();
			
			page = new ModelAndView("redirect:/");
			return page;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/searchPlayer", method = RequestMethod.POST)
	public ModelAndView searchPlayer(@RequestParam String keyword) {
		
		try {
			ModelAndView page = new ModelAndView("playerPage");
					
			System.out.println(keyword);
			
			List<Player> list = playerService.searchPlayers(keyword);
			//System.out.println("Test : " + list..getName());
			
			page.addObject("players", list);
			
			return page;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
