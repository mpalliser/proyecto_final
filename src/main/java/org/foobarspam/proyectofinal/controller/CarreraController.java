package org.foobarspam.proyectofinal.controller;

import org.foobarspam.proyectofinal.model.Carrera;
import org.foobarspam.proyectofinal.service.carrera.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarreraController {

	private final CarreraService carreraService;

	private final Integer[] propinas = {1,2,3,5,10};
	private final String[] modosPago = {"MasterCard","Visa","PayPal","BitCoin"};
	private final Integer[] valoraciones = {1,2,3,4,5};

	@Autowired
	public CarreraController(CarreraService carreraService) {
		this.carreraService = carreraService;
	}

	@GetMapping("/")
	public String home(Model model) {

		model.addAttribute("carrera", new Carrera());

		return "index";

	}

	@PostMapping("/solicitar")
	public String solicitarCarrera(Carrera carrera) {

		carreraService.setCarrera(carrera);
		carreraService.transformarDistancia();
		carreraService.transformarTiempo();

		carreraService.inyectarDistanciaTiempo();
		carreraService.calcularCoste();

		return "redirect:/mostrar";

	}

	@GetMapping("/mostrar")
	public String segundaPantalla(Model model){

		model.addAttribute("carrera", carreraService.getCarrera());

		return "segundaHistoria";

	}

	@GetMapping("/info")
	public String terceraPantalla(Model model) {

		carreraService.asignarConductor();

		carreraService.getConductor().setMediaValoraciones(carreraService.valoracionMedia());
		carreraService.guardarCarrera();

		model.addAttribute("carrera", carreraService.getCarrera());
		model.addAttribute("conductor", carreraService.getConductor());

		return "terceraHistoria";

	}

	@GetMapping("/tips")
	public String cuartaPantalla(Model model) {

		model.addAttribute("carrera", carreraService.getCarrera());
		model.addAttribute("propinas", propinas);
		model.addAttribute("modosPago", modosPago);

		return "cuartaHistoria";

	}

	@PostMapping("/sendTip")
	public String sendTip(Carrera carrera) {

		carreraService.getCarrera().setPropina(carrera.getPropina());
		carreraService.getCarrera().setModoPago(carrera.getModoPago());

		carreraService.guardarCarrera();


		return "redirect:/valoraciones";

	}

	@GetMapping("/valoraciones")
	public String quintaPantalla(Model model){


		model.addAttribute("carrera", carreraService.getCarrera());
		model.addAttribute("valoraciones", valoraciones);
		model.addAttribute("conductor", carreraService.getCarrera().getConductor());

		return "quintaHistoria";

	}
	@PostMapping("/setValoracion")
	public String setValoracion(double valoracion) {

		carreraService.getCarrera().setValoracion(valoracion);

		carreraService.guardarCarrera();

		carreraService.getConductor().setMediaValoraciones(carreraService.valoracionMedia());

		carreraService.liberarConductor();

		return "redirect:/";

	}

}