package project.personal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.personal.model.Production;
import project.personal.repository.ProductionRepository;

import java.util.List;

@RestController
@RequestMapping("/productions/")
public class ProductionController {

    private ProductionRepository productionRepository;

    @Autowired
    public ProductionController(ProductionRepository productionRepository){
        this.productionRepository = productionRepository;
    }

    @GetMapping("all")
    public ResponseEntity<List<Production>> getAllProductions(){
        List<Production> productionList = productionRepository.findAll();
        return new ResponseEntity<>(productionList, HttpStatus.OK);
    }
}
