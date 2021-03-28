package sistema.poo2.repositories;

import sistema.poo2.entities.Client;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository <Client, Long>{ // Uma interface tem métodos mais abstratos, com um conjunto de métodos sem implementação
    
    //Consulta JPQL
    @Query( "Select c FROM Client c " + 
            "WHERE " + 
            "( LOWER(c.name)    LIKE LOWER(CONCAT('%', :name, '%'))) AND " + 
            "( LOWER(c.address) LIKE LOWER(CONCAT('%', :address, '%')))"
    )
    public Page<Client> find(Pageable pageRequest, String name, String address);

}
