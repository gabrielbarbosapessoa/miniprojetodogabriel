package br.com.itb.miniprojetospring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.itb.miniprojetospring.model.Funcionario;
import br.com.itb.miniprojetospring.model.FuncionarioRepository;
import jakarta.transaction.Transactional;

@Service
public class FuncionarioService {

    // Criar objeto repository
    final FuncionarioRepository funcionarioRepository;

    // Injeção de Dependência
    public FuncionarioService(FuncionarioRepository _funcionarioRepository) {
        this.funcionarioRepository = _funcionarioRepository;
    }

    // Método INSERT INTO FUNCIONARIO
    @Transactional
    public Funcionario save(Funcionario _funcionario) {
        return funcionarioRepository.save(_funcionario);
    }

    // Método SELECT * FROM FUNCIONARIO
    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario findAllById(long id) {
        return funcionarioRepository.findAllById(id);
    }

    // Método UPDATE FUNCIONARIO
    @Transactional
    public Funcionario update(Funcionario _funcionario) {
        Funcionario funcionarioEncontrado = funcionarioRepository.findAllById(_funcionario.getId());
        if (funcionarioEncontrado.getId() > 0) {
            return funcionarioRepository.save(_funcionario);
        } else {
            return new Funcionario(0, "Funcionario não encontrado", "", "");
        }
    }

    // Método DELETE FUNCIONARIO
    @Transactional
    public void delete(long id) {
        funcionarioRepository.deleteById(id);
    }
}
