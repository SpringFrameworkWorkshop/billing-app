package io.spring.billing.controllers;

import io.spring.billing.controllers.dtos.LineDTO;
import io.spring.billing.entities.Line;
import io.spring.billing.manager.AbstractManager;
import io.spring.billing.manager.LineManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LineControllerImpl extends AbstractController<Line, LineDTO, Long> implements LineController {

    @Autowired
    private LineManager manager;

    @Autowired
    private ModelMapper modelMapper;

    public LineControllerImpl() {
        super(Line.class, LineDTO.class);
    }

    @Override
    protected AbstractManager<Line> getManager() {
        return this.manager;
    }

    @Override
    protected LineDTO convertToDTO(final Line line) {
        if (line == null) return null;
        return modelMapper.map(line, LineDTO.class);
    }

    @Override
    protected Line convertToEntity(final LineDTO dto) {
        if (dto == null) return null;
        return modelMapper.map(dto, Line.class);
    }

    // @WTF
    public ResponseEntity<List<LineDTO>> findAll() {
        return new ResponseEntity<>(convertToDTOList(getManager().findAll()), HttpStatus.OK);
    }

}
