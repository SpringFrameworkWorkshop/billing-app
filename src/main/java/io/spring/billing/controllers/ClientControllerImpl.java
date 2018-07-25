package io.spring.billing.controllers;

import io.spring.billing.controllers.dtos.ClientDTO;
import io.spring.billing.entities.Client;
import io.spring.billing.manager.AbstractManager;
import io.spring.billing.manager.ClientManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientControllerImpl extends AbstractController<Client, ClientDTO, Long> implements ClientController {

    @Autowired
    private ClientManager manager;

    @Autowired
    private ModelMapper modelMapper;

    public ClientControllerImpl() {
        super(Client.class, ClientDTO.class);
    }

    @Override
    protected AbstractManager<Client> getManager() {
        return this.manager;
    }

    @Override
    protected ClientDTO convertToDTO(final Client client) {
        if (client == null) return null;
        return modelMapper.map(client, ClientDTO.class);
    }

    @Override
    protected Client convertToEntity(final ClientDTO dto) {
        if (dto == null) return null;
        return modelMapper.map(dto, Client.class);
    }

    // @WTF
    public ResponseEntity<List<ClientDTO>> findAll() {
        return new ResponseEntity<>(convertToDTOList(getManager().findAll()), HttpStatus.OK);
    }

}
