package sistema.poo2.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import sistema.poo2.dto.ClientDTO;
import sistema.poo2.dto.ClientInsertDTO;
import sistema.poo2.dto.ClientUpdateDTO;
import sistema.poo2.entities.Client;
import sistema.poo2.repositories.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository repo;

    public List<ClientDTO> getClients() {
        
        List<Client>    list = repo.findAll();
        return toDTOList(list);
    }

    public  ClientDTO getClientById (Long id){

        // Client client = repo.findById(id).get(); // pode gerar nullPointerException
        Optional <Client> op = repo.findById(id); // pode retornar null
        Client client = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found. Look under the bed."));
        return new ClientDTO(client);
    }

    public ClientDTO insert (ClientInsertDTO insertDTO){
        
        Client entity = new Client(insertDTO);
        entity = repo.save(entity);
        // se o id não existe, é dado um update
        return new ClientDTO(entity);
    } 

    public void delete(Long id){
        try {
            repo.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found. Look under the bed.");
        }
    }

    public ClientDTO update(Long id, ClientUpdateDTO updateDTO){
        try {
            Client entity = repo.getOne(id);
            entity.setName(updateDTO.getName());
            entity = repo.save(entity); // o save salva ou atualiza

            return new ClientDTO(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found. Look under the bed.");
        }
        
    }

    public List<ClientDTO> toDTOList(List<Client> list) {
        List<ClientDTO> listDTO = new ArrayList<>();
        for (Client c: list){
            listDTO.add(new ClientDTO(c.getId(), c.getName()));
            /* http://localhost:8080/h2-console/ */
        }
        return listDTO;
    }
}
