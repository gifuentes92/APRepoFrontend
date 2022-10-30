package com.myApi.Springboot.Controller;

import com.myApi.Springboot.Dto.dtoEducacion;
import com.myApi.Springboot.Model.Educacion;
import com.myApi.Springboot.Security.Controller.Mensaje;
import com.myApi.Springboot.Services.EducacionService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/educacion")
public class EducacionController {

    @Autowired
    EducacionService educacionService;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = educacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") Long id) {
        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = educacionService.getOne(id).get();

        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }

        educacionService.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);

    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion) {
        if (StringUtils.isBlank(dtoeducacion.getTitulo())) {
            return new ResponseEntity(new Mensaje("El título es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoeducacion.getInstitucion())) {
            return new ResponseEntity(new Mensaje("El nombre de la institución es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoeducacion.getCurso())) {
            return new ResponseEntity(new Mensaje("el nombre del curso es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (educacionService.existePorTitulo(dtoeducacion.getTitulo())) {
            return new ResponseEntity(new Mensaje("ya existe ese título"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(
                dtoeducacion.getTitulo(),
                dtoeducacion.getInstitucion(),
                dtoeducacion.getCurso(),
                dtoeducacion.getInicio(),
                dtoeducacion.getFin()
        );
        educacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educación creada"), HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoEducacion dtoeducacion) {
        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }

        if (educacionService.existePorTitulo(dtoeducacion.getTitulo()) && educacionService.mostrarPorTitulo(dtoeducacion.getTitulo()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Este título ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (educacionService.existePorInstitucion(dtoeducacion.getInstitucion()) && educacionService.mostrarPorInstitucion(dtoeducacion.getInstitucion()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esta institución ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (educacionService.existePorCurso(dtoeducacion.getCurso()) && educacionService.mostrarPorCurso(dtoeducacion.getCurso()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Este curso ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoeducacion.getCurso())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = educacionService.getOne(id).get();

        educacion.setTitulo(dtoeducacion.getTitulo());
        educacion.setInstitucion(dtoeducacion.getInstitucion());
        educacion.setCurso(dtoeducacion.getCurso());
        educacion.setInicio(dtoeducacion.getInicio());
        educacion.setFin(dtoeducacion.getFin());

        educacionService.save(educacion);

        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }

}
