package andrade.dev.contas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import andrade.dev.contas.model.Conta;
import andrade.dev.contas.result.RestResult;
import andrade.dev.contas.services.interfaces.ContasService;

@RequestMapping("/contas")
@RestController
public class ContasController {
	
	@Autowired
	private ContasService contasService;
	@RequestMapping(method = RequestMethod.GET)
	public RestResult Listar() {
		
		RestResult result = new RestResult();
		
		try {
			Iterable<Conta> lstContas = contasService.findAll();
			result.add("lstContas", lstContas);
			result.setSuccess(true);
			
		}
		catch(Exception e) {
			
			result.handleException(e);
		}
		
		return result;
	}
}
	