package presidente.infraestrutura.salas.controle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import presidente.aplicacao.casouso.sala.criar.CriarSalaCasoUsuarioImplementacao;
import presidente.aplicacao.casouso.sala.criar.CriarSalaIn;
import presidente.aplicacao.casouso.sala.criar.CriarSalaOut;
import presidente.aplicacao.casouso.sala.recuperar.by.id.RecuperarSalaByIdCasoUsuarioImplementacao;
import presidente.aplicacao.casouso.sala.recuperar.by.id.RecuperarSalaByIdOut;
import presidente.dominio.valorobjeto.identificador.SalaId;
import presidente.infraestrutura.salas.repositorios.SalaEmMemoriaRepositorio;

@RestController
public class ControleSala {

    @PostMapping("salas")
    @ResponseStatus(HttpStatus.CREATED)
    CriarSalaOut criarSala(@RequestBody CriarSalaIn anIn) {

        final var casoUsuario = new CriarSalaCasoUsuarioImplementacao(
                new SalaEmMemoriaRepositorio()
        );

        return casoUsuario.execute(anIn);

    }

    @GetMapping("salas/{salaId}")
    RecuperarSalaByIdOut recuperarSalaById(@PathVariable String salaId) {

        final var casoUsuario = new RecuperarSalaByIdCasoUsuarioImplementacao(
                new SalaEmMemoriaRepositorio()
        );

        return casoUsuario.execute(SalaId.of(salaId));

    }

}
