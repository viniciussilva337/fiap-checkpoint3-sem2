package fiap_checkpoint3_sem2.chekpoint3_2;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {

    // Método de consulta por nome
    List<Contato> findByNomeContaining(String nome);

}

