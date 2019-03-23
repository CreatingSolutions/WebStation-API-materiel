package webstationapi.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webstationapi.DTO.QualityDTO;
import webstationapi.DTO.StuffDTO;
import webstationapi.DTO.StuffSendDTO;
import webstationapi.Entity.Stuff;
import webstationapi.Entity.StuffBook;
import webstationapi.Repository.StuffBookRepository;
import webstationapi.Repository.StuffRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StuffService {

    private StuffRepository stuffRepository;

    private StuffBookRepository stuffBookRepository;

    public StuffService(StuffRepository stuffRepository, StuffBookRepository stuffBookRepository) {
        this.stuffRepository = stuffRepository;
        this.stuffBookRepository = stuffBookRepository;
    }

    private StuffDTO buildStuffDTO(Stuff stuff) {
        StuffDTO stuffDTO = new StuffDTO();
        stuffDTO.setImg(stuff.getImg());
        stuffDTO.setStuffId(stuff.getId());
        stuffDTO.setTitle(stuff.getTitle());
        stuffDTO.setStore(stuff.getStore());
        stuffDTO.setPrice(stuff.getPrice());

        QualityDTO qualityDTO1 = new QualityDTO();
        qualityDTO1.setLabel(stuff.getLabel1());
        qualityDTO1.setNote(stuff.getNote1());

        QualityDTO qualityDTO2 = new QualityDTO();
        qualityDTO2.setLabel(stuff.getLabel2());
        qualityDTO2.setNote(stuff.getNote2());

        QualityDTO qualityDTO3 = new QualityDTO();
        qualityDTO3.setLabel(stuff.getLabel3());
        qualityDTO3.setNote(stuff.getNote3());

        QualityDTO qualityDTO4 = new QualityDTO();
        qualityDTO4.setLabel(stuff.getLabel4());
        qualityDTO4.setNote(stuff.getNote4());

        stuffDTO.addQualityDTOS(qualityDTO1);
        stuffDTO.addQualityDTOS(qualityDTO2);
        stuffDTO.addQualityDTOS(qualityDTO3);
        stuffDTO.addQualityDTOS(qualityDTO4);

        return stuffDTO;
    }

    @Transactional(readOnly = true)
    public List<StuffDTO> getAll() {
        List<Stuff> all = this.stuffRepository.findAll();
        List<StuffDTO> stuffDTOS = new ArrayList<>();

        for (Stuff stuff : all) {
            StuffDTO stuffDTO = this.buildStuffDTO(stuff);
            stuffDTOS.add(stuffDTO);
        }
        return stuffDTOS;
    }


    public Long add(StuffSendDTO stuffBookDTO) {

        Stuff stuff = this.stuffRepository.findById(stuffBookDTO.getStuffId()).get();

        StuffBook stuffBook = new StuffBook();
        stuffBook.setIdStuff(stuffBookDTO.getStuffId());
        stuffBook.setUserId(stuffBookDTO.getUserId());
        stuffBook.setPrice(stuffBookDTO.getTaked() * stuff.getPrice());

        StuffBook save = this.stuffBookRepository.save(stuffBook);
        return save.getId();
    }
}
