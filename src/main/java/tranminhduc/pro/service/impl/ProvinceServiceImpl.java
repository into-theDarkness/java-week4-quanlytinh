package tranminhduc.pro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import tranminhduc.pro.model.Province;
import tranminhduc.pro.repository.ProvinceRepository;
import tranminhduc.pro.service.ProvinceService;

public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;
    @Override
    public Iterable<Province> findAll(){
        return provinceRepository.findAll();
    }
    public Province findById(Long id){
        return provinceRepository.findOne(id);
    }
    public void save(Province province){
        provinceRepository.save(province);
    }
    public void remove(Long id){
        provinceRepository.delete(id);
    }
}
