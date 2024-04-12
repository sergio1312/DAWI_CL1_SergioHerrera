package pe.edu.cibertec.DAWI_CL1_SergioHerrera.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_SergioHerrera.model.NumeroModel;

@Controller
public class NumeroController {
    @GetMapping("/numero")
    public String numeroForm(Model model) {
        model.addAttribute("numeroModel", new NumeroModel());
        return "numero";
    }

    @PostMapping("/calcularNumero")
    public String calcularNumero(NumeroModel numeroModel, Model model) {
        int limite = numeroModel.getNumero();
        String resultado = "";

        for (int num = 1; num <= limite; num++) {
            int sum = 0;
            for (int i = 1; i <= num / 2; i++) {
                if (num % i == 0) {
                    sum += i;
                }
            }
            if (sum == num) {
                if (!resultado.isEmpty()) {
                    resultado += ", ";
                }
                resultado += num;
            }
        }

        numeroModel.setResultado(resultado.isEmpty() ? "No hay numero perfecto" : resultado);
        model.addAttribute("numeroModel", numeroModel);
        return "numero";
    }
}
