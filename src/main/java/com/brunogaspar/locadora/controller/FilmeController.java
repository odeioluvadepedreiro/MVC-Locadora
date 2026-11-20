package com.brunogaspar.locadora.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FilmeController {

    @GetMapping({"/", "/filmes"})
    public String filmes(Model model) {
        return mostrar(model, "filmes", "Filmes", List.of(
                new Item("Interestelar", "Fic��o cient�fica � 2014"),
                new Item("Shrek", "Anima��o � 2001"),
                new Item("Vingadores: Ultimato", "A��o � 2019")
        ));
    }

    @GetMapping("/diretores")
    public String diretores(Model model) {
        return mostrar(model, "diretores", "Diretores", List.of(
                new Item("Christopher Nolan", "Interestelar"),
                new Item("Andrew Adamson", "Shrek"),
                new Item("Anthony e Joe Russo", "Vingadores: Ultimato")
        ));
    }

    @GetMapping("/generos")
    public String generos(Model model) {
        return mostrar(model, "generos", "G�neros", List.of(
                new Item("Fic��o cient�fica", "Interestelar"),
                new Item("Anima��o", "Shrek"),
                new Item("A��o", "Vingadores: Ultimato")
        ));
    }

    @GetMapping("/clientes")
    public String clientes(Model model) {
        return mostrar(model, "clientes", "Clientes", List.of(
                new Item("Ana Ribeiro", "Cliente cadastrado"),
                new Item("Lucas Almeida", "Cliente cadastrado")
        ));
    }

    @GetMapping("/locacoes")
    public String locacoes(Model model) {
        return mostrar(model, "locacoes", "Loca��es", List.of(
                new Item("Interestelar", "Ana Ribeiro � Em andamento"),
                new Item("Shrek", "Lucas Almeida � Devolvido")
        ));
    }

    private String mostrar(Model model, String modulo, String titulo, List<Item> itens) {
        model.addAttribute("modulo", modulo);
        model.addAttribute("titulo", titulo);
        model.addAttribute("itens", itens);
        return "filmes/inicio";
    }

    public record Item(String nome, String detalhe) {
    }
}
