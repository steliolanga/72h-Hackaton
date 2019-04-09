package mz.co.sbankmvp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mz.co.sbankmvp.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping("/show")
	public ModelAndView showCart(@RequestParam(name = "result", required=false)String result) {
		ModelAndView mv = new ModelAndView("page");
		if(result!=null) {
			switch(result) {
			case "updated":
					mv.addObject("message", "Actualizado ao carrinho compras");
					break;
			case "added":
				mv.addObject("message", "Adicionado do carrinho compras");
				break;
			case "deleted":
				mv.addObject("message", "Removido do carrinho de compras!");
				break;					
			case "maximum":
				mv.addObject("message", "carrinho esta esgotado");
				break;					
			case "unavailable":
				mv.addObject("message", "Quantidade insufienciente");
				break;					
			case "error":
				mv.addObject("message", "Erro ao Adicionar!");
				break;			
			}
		}
		mv.addObject("title", "User Cart");
		mv.addObject("userClickShowCart", true);
		mv.addObject("cartLines", cartService.getCartLines());		
		return mv;		
	}
	
	@RequestMapping("/{cartLineId}/update")
	public String updateCart(@PathVariable int cartLineId, @RequestParam int count) {		
		String response = cartService.manageCartLine(cartLineId, count);		
		return "redirect:/cart/show?"+response;
		
	}
		
	@RequestMapping("/{cartLineId}/delete")
	public String updateCart(@PathVariable int cartLineId) {		
		String response = cartService.deleteCartLine(cartLineId);		
		return "redirect:/cart/show?"+response;
		
	}
	
	@RequestMapping("/add/{productId}/product")
	public String addCart(@PathVariable int productId) {		
		String response = cartService.addCartLine(productId);		
		return "redirect:/cart/show?"+response;
		
	}	
	
	
}
