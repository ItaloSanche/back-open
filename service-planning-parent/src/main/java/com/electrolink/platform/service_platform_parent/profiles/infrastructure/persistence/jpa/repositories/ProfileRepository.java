package com.electrolink.platform.service_platform_parent.profiles.infrastructure.persistence.jpa.repositories;


import com.electrolink.platform.service_platform_parent.profiles.domain.model.aggregates.Profile;
import com.electrolink.platform.service_platform_parent.profiles.domain.model.valueobjects.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

  // Buscar por nombre completo (value object PersonName)
  Optional<Profile> findByPersonName_FirstNameAndPersonName_LastName(String firstName, String lastName);

  // Buscar por dirección de correo (value object EmailAddress)
  Optional<Profile> findByEmail_Address(String email);

  // Filtrar por rol
  List<Profile> findByRole(Role role);

  // Verificar existencia por correo (si se desea validar duplicados)
  boolean existsByEmail_Address(String email);

  // Verificar existencia por correo excluyendo ID (para update seguro)
  boolean existsByEmail_AddressAndIdIsNot(String email, Long id);
}
