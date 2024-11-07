package fiap_checkpoint3_sem2.chekpoint3_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    // Método para listar todos os contatos
    public List<ContatoDTO> listarContatos() {
        // Converte a lista de Contato para ContatoDTO
        List<Contato> contatos = contatoRepository.findAll();
        return contatos.stream()
                .map(contato -> new ContatoDTO(contato.getId(), contato.getNome()))
                .collect(Collectors.toList());
    }

    // Método para buscar um contato por ID
    public Optional<ContatoDTO> buscarContatoPorId(int id) {
        Optional<Contato> contato = contatoRepository.findById(id);
        return contato.map(c -> new ContatoDTO(c.getId(), c.getNome()));
    }

    // Método para buscar contatos por nome
    public List<ContatoDTO> buscarContatoPorNome(String nome) {
        List<Contato> contatos = contatoRepository.findByNomeContaining(nome);
        return contatos.stream()
                .map(contato -> new ContatoDTO(contato.getId(), contato.getNome()))
                .collect(Collectors.toList());
    }

    // Método para criar um novo contato
    public ContatoDTO criarContato(ContatoDTO contatoDTO) {
        Contato contato = new Contato();
        contato.setNome(contatoDTO.getNome()); // Preenche a entidade com o nome
        contato = contatoRepository.save(contato); // Salva no banco
        return new ContatoDTO(contato.getId(), contato.getNome()); // Retorna o DTO
    }

    // Método para atualizar um contato existente
    public ContatoDTO atualizarContato(int id, ContatoDTO contatoDTO) {
        Contato contato = contatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));
        contato.setNome(contatoDTO.getNome()); // Atualiza o nome
        contato = contatoRepository.save(contato); // Salva a entidade atualizada
        return new ContatoDTO(contato.getId(), contato.getNome()); // Retorna o DTO
    }

    // Método para excluir um contato
    public void excluirContato(int id) {
        contatoRepository.deleteById(id); // Deleta o contato pelo id
    }
}
