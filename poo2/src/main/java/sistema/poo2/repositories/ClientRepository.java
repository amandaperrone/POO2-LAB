package sistema.poo2.repositories;

import sistema.poo2.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository <Client, Long>{ // Uma interface tem métodos mais abstratos, com um conjunto de métodos sem implementação
    

}
