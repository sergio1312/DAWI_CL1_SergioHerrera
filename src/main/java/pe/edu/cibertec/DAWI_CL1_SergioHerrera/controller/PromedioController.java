package pe.edu.cibertec.DAWI_CL1_SergioHerrera.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_SergioHerrera.model.PromedioModel;

@Controller
public class PromedioController {

    @GetMapping("/promedio")
    public String promedioForm(Model model) {
        model.addAttribute("promedioModel", new PromedioModel());
        return "promedio";
    }

    @PostMapping("/calcularPromedio")
    public String calcularPromedio(PromedioModel promedioModel, Model model){

        double promedio = (promedioModel.getNota1() + promedioModel.getNota2()
                + promedioModel.getNota3()) / 3;
        promedioModel.setPromedio(promedio);

        if (promedio >= 70) {
            promedioModel.setResultado("Aprobado");
        } else {
            promedioModel.setResultado("Desaprobado");
        }

        model.addAttribute("promedioModel", promedioModel);
        return "promedio";
    }
}
