package sistema.poo2.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import sistema.poo2.entities.Client;

@Component
public class ClientRepository {
    
    public List<Client> getClients(){
        Client c1 = new Client();
        c1.setId(1l);
        c1.setName("Amanda");
        c1.setAddress("Rua X, 100");

        Client c2 = new Client();
        c2.setId(2l);
        c2.setName("Fernanda");
        c2.setAddress("Rua Y, 200");

        List<Client> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);

        return list;

        /* 01:23:15 */
    }
}
