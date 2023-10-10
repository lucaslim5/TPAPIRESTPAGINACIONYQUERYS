package com.UTN.APIRest.repositories;

import com.UTN.APIRest.entities.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends BaseRepository<Autor,Long> {
    /*//Anotacion metodo QUERY
    //List<Autor> findByNombreContainingOrApellidoContainingOrbiografia(String nombre, String apellido, String biografia);
    List<Autor> findByNombreContainingOrApellidoContaining(String nombre, String apellido);


    Page<Autor> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);


    //Anotacion JPQL parametros indexados
    @Query(value = "SELECT au FROM AUTOR au WHERE au.nombre LIKE %:filtro% OR au.apellido LIKE %:filtro%")
    List<Autor> search(String filtro);

    @Query(value = "SELECT au FROM Autor au WHERE au.nombre LIKE %:filtro% OR au.apellido LIKE %:filtro%")
    Page<Autor> search(String filtro, Pageable pageable);

  *//*   //Anotacion JPQL con parametros nombrados (otra anotacion)
    @Query(value = "SELECT au FROM AUTOR au WHERE au.nombre LIKE '%:filtro%' OR au.apellido LIKE '%:filtro%'")
    List<Autor> search(@Param("filtro") String filtro);*//*

    //anotacion QUERY native
    @Query(value = "SELECT * FROM autor WHERE autor.nombre LIKE %:filtro% OR autor.apellido LIKE %:filtro%",
            nativeQuery = true
    )
    List<Autor> searchNativo(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM autor WHERE autor.nombre LIKE %:filtro% OR autor.apellido LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM autor",
            nativeQuery = true
    )
    Page<Autor> searchNativo(@Param("filtro") String filtro, Pageable pageable);*/
}
