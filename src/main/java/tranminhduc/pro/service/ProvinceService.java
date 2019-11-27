package tranminhduc.pro.service;

import tranminhduc.pro.model.Province;

public interface ProvinceService {
        Iterable<Province> findAll();
        Province findById(Long id);
        void save(Province province);
        void remove(Long id);
}
