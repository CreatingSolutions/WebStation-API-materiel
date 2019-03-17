package webstationapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webstationapi.DTO.StuffDTO;
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

}
