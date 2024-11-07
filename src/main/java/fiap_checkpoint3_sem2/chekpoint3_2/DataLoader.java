package fiap_checkpoint3_sem2.chekpoint3_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {

    @Autowired
    private ContatoRepository contatoRepository;

    @PostConstruct
    public void loadData() {
        // Insere alguns dados no banco de dados ao iniciar a aplicação
        if (contatoRepository.count() == 0) {
            Contato contato1 = new Contato();
            contato1.setNome("João");
            contatoRepository.save(contato1);

            Contato contato2 = new Contato();
            contato2.setNome("Maria");
            contatoRepository.save(contato2);

            Contato contato3 = new Contato();
            contato3.setNome("Carlos");
            contatoRepository.save(contato3);

            Contato contato4 = new Contato();
            contato4.setNome("Ana");
            contatoRepository.save(contato4);
        }
    }
}
