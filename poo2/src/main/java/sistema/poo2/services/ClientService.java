package sistema.poo2.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.poo2.dto.ClientDTO;
import sistema.poo2.entities.Client;
import sistema.poo2.repositories.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository repo;

    public List<ClientDTO> getClients() {
        
        List<Client>    list = repo.getClients();
        List<ClientDTO> listDTO = new ArrayList<>();

        for (Client c: list){
            listDTO.add(new ClientDTO(c.getId(), c.getName()));
        }
        return listDTO;
    }

}
