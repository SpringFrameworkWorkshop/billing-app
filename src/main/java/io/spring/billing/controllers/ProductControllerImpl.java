package io.spring.billing.controllers;

import io.spring.billing.controllers.dtos.ProductDTO;
import io.spring.billing.entities.Product;
import io.spring.billing.manager.AbstractManager;
import io.spring.billing.manager.ProductManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductControllerImpl extends AbstractController<Product, ProductDTO, Long> implements ProductController {

    @Autowired
    private ProductManager manager;

    @Autowired
    private ModelMapper modelMapper;

    public ProductControllerImpl() {
        super(Product.class, ProductDTO.class);
    }

    @Override
    protected AbstractManager<Product> getManager() {
        return this.manager;
    }

    @Override
    protected ProductDTO convertToDTO(final Product product) {
        if (product == null) return null;
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    protected Product convertToEntity(final ProductDTO dto) {
        if (dto == null) return null;
        return modelMapper.map(dto, Product.class);
    }

    // @WTF
    public ResponseEntity<List<ProductDTO>> findAll() {
        return new ResponseEntity<>(convertToDTOList(getManager().findAll()), HttpStatus.OK);
    }

}
