package fiap_checkpoint3_sem2.chekpoint3_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contatos") // URL base para o controlador
public class ContatoController {

    @Autowired
    private ContatoService contatoService;  // Injeção da camada Service para manipulação de dados

    // Rota para listar todos os contatos
    @GetMapping
    public List<ContatoDTO> listarContatos() {
        return contatoService.listarContatos();
    }

    // Rota para buscar um contato pelo id
    @GetMapping("/{id}")
    public Optional<ContatoDTO> buscarContatoPorId(@PathVariable int id) {
        return contatoService.buscarContatoPorId(id);
    }

    // Rota para buscar contatos por nome
    @GetMapping("/buscar")
    public List<ContatoDTO> buscarContatoPorNome(@RequestParam(required = false) String nome) {
        if (nome != null) {
            return contatoService.buscarContatoPorNome(nome);
        }
        return contatoService.listarContatos(); // Retorna todos se nome não for fornecido
    }

    // Rota para criar um novo contato
    @PostMapping
    public ContatoDTO criarContato(@RequestBody ContatoDTO contatoDTO) {
        return contatoService.criarContato(contatoDTO);
    }

    // Rota para atualizar um contato existente
    @PutMapping("/{id}")
    public ContatoDTO atualizarContato(@PathVariable int id, @RequestBody ContatoDTO contatoDTO) {
        return contatoService.atualizarContato(id, contatoDTO);
    }

    // Rota para excluir um contato
    @DeleteMapping("/{id}")
    public void excluirContato(@PathVariable int id) {
        contatoService.excluirContato(id);
    }
}
