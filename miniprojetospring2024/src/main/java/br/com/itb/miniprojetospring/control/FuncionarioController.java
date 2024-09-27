package br.com.itb.miniprojetospring.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.itb.miniprojetospring.model.Funcionario;
import br.com.itb.miniprojetospring.service.FuncionarioService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
@RequestMapping("/funcionario")
public class FuncionarioController {

    // Criação do objeto de serviço
    final FuncionarioService funcionarioService;

    // Injeção de Dependência
    public FuncionarioController(FuncionarioService _funcionarioService) {
        this.funcionarioService = _funcionarioService;
    }

    // ROTA POST
    @PostMapping
    public ResponseEntity<Object> saveFuncionario(@RequestBody Funcionario funcionario) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(funcionarioService.save(funcionario));
    }

    // ROTA GET
    @GetMapping
    public ResponseEntity<List<Funcionario>> getAllFuncionarios() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.findAll());
    }

    // ROTA PUT
    @PutMapping
    public ResponseEntity<Object> updateFuncionario(@RequestBody Funcionario funcionario) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioService.update(funcionario));
    }

    // ROTA DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFuncionario(@PathVariable long id) {
        funcionarioService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
