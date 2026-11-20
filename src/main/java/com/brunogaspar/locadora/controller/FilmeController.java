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
                new Item("Interestelar", "Ficção científica · 2014"),
                new Item("Shrek", "Animação · 2001"),
                new Item("Vingadores: Ultimato", "Ação · 2019")
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
        return mostrar(model, "generos", "Gêneros", List.of(
                new Item("Ficção científica", "Interestelar"),
                new Item("Animação", "Shrek"),
                new Item("Ação", "Vingadores: Ultimato")
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
        return mostrar(model, "locacoes", "Locações", List.of(
                new Item("Interestelar", "Ana Ribeiro · Em andamento"),
                new Item("Shrek", "Lucas Almeida · Devolvido")
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
