package andrade.dev.contas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import andrade.dev.contas.model.RelatorioDonativo;
import andrade.dev.contas.result.RestResult;
import andrade.dev.contas.services.interfaces.RelatorioDonativoService;

@RestController
@RequestMapping("/relatorio-donativo")
public class RelatorioDonativoController {


	@Autowired
	private RelatorioDonativoService relatorioDonativoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public RestResult Listar(@RequestParam(required = false) Integer ano, @RequestParam(required = false) Integer mes, Pageable pageable) {
		
		RestResult result = new RestResult();
		
		try {
			Page<RelatorioDonativo> lstRelatorios = relatorioDonativoService.pesquisar(ano, mes, pageable);
			result.addPage("lstContas", lstRelatorios);
			result.setSuccess(true);
			
		}
		catch(Exception e) {
			
			result.handleException(e);
		}
		
		return result;
	}
	

	
	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public RestResult Teste() {
		
		RestResult result = new RestResult();
		
		try {
			relatorioDonativoService.testarSalvamentoRelatorio();
			result.setSuccess(true);
			
		}
		catch(Exception e) {
			
			result.handleException(e);
		}
		
		return result;
	}

	
}
