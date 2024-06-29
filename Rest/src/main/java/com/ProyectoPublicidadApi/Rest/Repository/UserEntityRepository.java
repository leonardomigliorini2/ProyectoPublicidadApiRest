package com.ProyectoPublicidadApi.Rest.Repository;

import com.ProyectoPublicidadApi.Rest.Entidades.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity,Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.id IN (:ids)")
    List<UserEntity> findAllById();
}
