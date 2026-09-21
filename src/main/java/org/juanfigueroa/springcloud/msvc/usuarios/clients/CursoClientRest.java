package org.juanfigueroa.springcloud.msvc.usuarios.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-cursos", url = "host.docker.internal:8002")
public interface CursoClientRest {

    @DeleteMapping("/eliminar-usuario-curso/{usuarioId}")
    void eliminarCursoUsuarioPorId(@PathVariable Long usuarioId);
}
