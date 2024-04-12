package pe.edu.cibertec.DAWI_CL1_SergioHerrera.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_SergioHerrera.model.BisiestoModel;

@Controller
public class BisiestoController {

    @GetMapping("/bisiesto")
    public String bisiestoForm(Model model) {
        model.addAttribute("bisiestoModel", new BisiestoModel());
        return "bisiesto";
    }

    @PostMapping("/validarBisiesto")
    public String validarBisiesto(BisiestoModel bisiestoModel, Model model) {

        boolean esBisiesto = false;

        if((bisiestoModel.getYear() % 4 == 0 && bisiestoModel.getYear() % 100 != 0) ||
                bisiestoModel.getYear() % 400 == 0) {
            esBisiesto = true;
        }

        bisiestoModel.setEsBisiesto(esBisiesto);
        model.addAttribute("bisiestoModel", bisiestoModel);
        return "bisiesto";
    }

}
