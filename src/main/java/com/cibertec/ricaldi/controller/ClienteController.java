package com.cibertec.ricaldi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cibertec.ricaldi.entity.Cliente;
import com.cibertec.ricaldi.service.CiudadService;
import com.cibertec.ricaldi.service.ClienteService;

@Controller
@RequestMapping(value = "/Cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private CiudadService ciudadService;
	
	@RequestMapping(value = "/Listado")
	public String listar(Model model, @RequestParam(name = "nombre", required = false) String nombre,
			@RequestParam(name = "apellido", required = false) String apellido) {
		model.addAttribute("titulo", "Dirico - Listado de Clientes");
		model.addAttribute("encabezado", "Listado de Clientes");
		model.addAttribute("nombre", nombre);
		model.addAttribute("apellido", apellido);
		if (nombre != null && apellido != null)
			model.addAttribute("clientes", clienteService.buscarPorNombreYApellido(nombre, apellido));
		else 
			model.addAttribute("clientes", clienteService.listarTodo());
		return "cliente/listado";
	}
	
	@RequestMapping(value = "/Registro")
	public String crear(Model model) {
		model.addAttribute("titulo","Dirico - Registro de Cliente");
		model.addAttribute("encabezado","Registro de Cliente");
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("ciudades",ciudadService.listarTodo());
		return "cliente/registro";
	}
	
	@RequestMapping(value = "/Registro", method = RequestMethod.POST)
	public String guardar(Model model, @Valid @ModelAttribute Cliente cliente, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Dirico - Registro de Cliente");
			model.addAttribute("encabezado", "Registro de Cliente");
			model.addAttribute("ciudades", ciudadService.listarTodo());
			return "cliente/registro";
		}
		
		clienteService.guardar(cliente);
		attributes.addFlashAttribute("mensaje", "Cliente registrado correctamente.");
		attributes.addFlashAttribute("tipo", "alert-success");
		return "redirect:/Cliente/Listado";
	}
	
	@RequestMapping(value = "/Editar/{id}")
	public String editar(Model model, @PathVariable int id) {
		model.addAttribute("titulo","Dirico - Editar Cliente");
		model.addAttribute("encabezado","Editar Cliente");
		model.addAttribute("cliente", clienteService.buscarPorId(id));
		model.addAttribute("ciudades",ciudadService.listarTodo());
		return "cliente/editar";
	}
	
	@RequestMapping(value = "/Editar/{id}", method = RequestMethod.POST)
	public String guardar(Model model, @Valid @ModelAttribute Cliente cliente, BindingResult result, 
			RedirectAttributes attributes, @PathVariable int id) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Dirico - Editar Cliente");
			model.addAttribute("encabezado", "Editar Cliente");
			model.addAttribute("ciudades", ciudadService.listarTodo());
			return "cliente/editar";
		}
		
		clienteService.guardar(cliente);
		attributes.addFlashAttribute("mensaje", "Datos del cliente actualizados correctamente.");
		attributes.addFlashAttribute("tipo", "alert-success");
		return "redirect:/Cliente/Listado";
	}
	
	@RequestMapping(value = "/Eliminar/{id}")
	public String eliminar(@PathVariable int id, RedirectAttributes attributes) {
		clienteService.eliminar(id);
		attributes.addFlashAttribute("mensaje", "Cliente eliminado correctamente.");
		attributes.addFlashAttribute("tipo", "alert-success");
		return "redirect:/Cliente/Listado";
	}
}
