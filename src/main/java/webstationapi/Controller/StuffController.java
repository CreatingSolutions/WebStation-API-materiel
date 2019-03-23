package webstationapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webstationapi.DTO.StuffDTO;
import webstationapi.DTO.StuffSendDTO;
import webstationapi.Entity.StuffBook;
import webstationapi.Service.StuffService;

import java.util.List;

@RestController
@RequestMapping(path = "/stuffs")
public class StuffController {

    @Autowired
    private StuffService stuffService;

    @GetMapping
    public List<StuffDTO> getAll() {
        return this.stuffService.getAll();
    }

    @PostMapping("/add")
    public Long addCart(@RequestBody StuffSendDTO stuffBookDTO){
        return this.stuffService.add(stuffBookDTO);
    }

    @GetMapping("/{iduser}")
    public List<StuffBook> getCart(@PathVariable("iduser") int iduser){
        return this.stuffService.getcart(iduser);
    }

}
