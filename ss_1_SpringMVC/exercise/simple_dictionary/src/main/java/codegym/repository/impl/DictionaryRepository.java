package codegym.repository.impl;

import codegym.model.Dictionary;
import codegym.repository.IDictionaryRepository;
import codegym.service.impl.DictionaryService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class DictionaryRepository implements IDictionaryRepository {
   private static List<Dictionary> dictionaryList= new ArrayList<>();
    static {
        dictionaryList.add(new Dictionary("hello","xin chào"));
        dictionaryList.add(new Dictionary("red","màu đỏ"))   ;
        dictionaryList.add(new Dictionary("house","nhà"));
        dictionaryList.add(new Dictionary("codegym","trung tâm luyện code số 1 VN"));
    }

    @Override
    public String translate(String eng) {
        for (Dictionary dictionary: dictionaryList
             ) {
            if(dictionary.getEng().equals(eng)){
                return dictionary.getVn();
            }
        }
        return "Từ Này Không Có Trong Từ Điển Của Em!!!";
    }
}
