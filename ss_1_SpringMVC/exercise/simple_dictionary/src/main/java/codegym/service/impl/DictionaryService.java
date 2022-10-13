package codegym.service.impl;

import codegym.repository.IDictionaryRepository;
import codegym.repository.impl.DictionaryRepository;
import codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    IDictionaryRepository iDictionaryRepository ;

    @Override
    public String translate(String eng) {
        return iDictionaryRepository.translate(eng);
    }
}
