package com.gotico.diario;

import com.gotico.diario.model.Poesia;
import com.gotico.diario.repository.PoesiaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final PoesiaRepository repository;

    public DataInitializer(PoesiaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            // --- 3 LIVROS ---
            repository.save(new Poesia("Drácula", "Bram Stoker", "LIVRO", null, null));
            repository.save(new Poesia("Frankenstein", "Mary Shelley", "LIVRO", null, null));
            repository.save(new Poesia("O Retrato de Dorian Gray", "Oscar Wilde", "LIVRO", null, null));

            // --- 3 POESIAS ---
            repository.save(new Poesia("O Corvo", "Edgar Allan Poe", "POESIA", "E o Corvo, na noite escura, nunca mais voou... Ficou sentado, pálido e solitário sobre o busto pálido de Pallas.", null));
            repository.save(new Poesia("Annabel Lee", "Edgar Allan Poe", "POESIA", "E nem os anjos do céu lá no alto, nem os demônios debaixo do mar, poderão jamais separar a minha alma da alma da bela Annabel Lee.", null));
            repository.save(new Poesia("A Noite", "Lord Byron", "POESIA", "Ela caminha em beleza, como a noite de climas sem nuvens e céus estrelados; e tudo o que há de melhor de escuro e brilhante reúne-se em seu aspecto e em seus olhos.", null));

            // --- 3 MÚSICAS GÓTICAS (Com seus embeds) ---
            repository.save(new Poesia("Música Gótica I", "Artista Sombrio", "MUSICA", null, "https://open.spotify.com/embed/track/7yZvWX3xZ50oh555vREpin?utm_source=generator&theme=0"));
            repository.save(new Poesia("Música Gótica II", "Artista Sombrio", "MUSICA", null, "https://open.spotify.com/embed/track/26I8Se3pMUKf56A2NAL9va?utm_source=generator&theme=0"));
            repository.save(new Poesia("Música Gótica III", "Artista Sombrio", "MUSICA", null, "https://open.spotify.com/embed/track/3ilnnpmMMpp863r2X0EHQK?utm_source=generator&theme=0"));
        }
    }
}