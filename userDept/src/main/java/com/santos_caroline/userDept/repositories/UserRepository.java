package com.santos_caroline.userDept.repositories;

//Repository é o nome padrão de implementação de objetos responsáveis por acessar dados de uma entidade do domínio
// objetos específicos para acessar dados de uma entidade

import com.santos_caroline.userDept.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
