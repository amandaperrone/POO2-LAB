package sistema.poo2.dto;

public class ClientDTO {
    private Long Id;
    private String name;

    public ClientDTO(){}

    public ClientDTO(Long id, String name){
        setId(id);
        setName(name);
        
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
