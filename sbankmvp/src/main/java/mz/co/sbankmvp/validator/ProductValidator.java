package mz.co.sbankmvp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import mz.co.sbankbackend.entity.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Product product = (Product) target;
		
		// whether file has been selected or not
		if(product.getFile() == null || 
				product.getFile().getOriginalFilename().equals("")) {
			
			errors.rejectValue("file", null, "Por favor inseria uma imagem!");
			return;
		}
		
		if(! (
			  product.getFile().getContentType().equals("image/jpeg") ||
			  product.getFile().getContentType().equals("image/png") ||
			  product.getFile().getContentType().equals("image/gif")			  
			  ))
 				
			{
			
			errors.rejectValue("file", null, "So pode carregar imagem!");
			return;			
		}
		
		
		

	}

}
