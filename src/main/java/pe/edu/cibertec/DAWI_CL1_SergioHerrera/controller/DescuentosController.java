package pe.edu.cibertec.DAWI_CL1_SergioHerrera.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_SergioHerrera.model.DescuentosModel;

@Controller
public class DescuentosController {

    @GetMapping("/descuentos")
    public String descuentosForm(Model model) {
        model.addAttribute("descuentosModel", new DescuentosModel());
        return "descuentos";
    }

    @PostMapping("/calcularDescuento")
    public String calcularDescuento(DescuentosModel descuentosModel, Model model) {

        double precioFinal = 0.0;

        if (descuentosModel.getCantidad() > 20) {
            precioFinal = descuentosModel.getPrecioUnitario() * descuentosModel.getCantidad() * 0.9;
        } else if (descuentosModel.getCantidad() > 10) {
            precioFinal = descuentosModel.getPrecioUnitario() * descuentosModel.getCantidad() * 0.95;
        } else {
            precioFinal = descuentosModel.getPrecioUnitario() * descuentosModel.getCantidad();
        }

        descuentosModel.setPrecioFinal(precioFinal);
        model.addAttribute("descuentosModel", descuentosModel);

        return "descuentos";
    }
}
