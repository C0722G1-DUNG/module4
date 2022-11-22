package com.email.repository.impl;

import com.email.model.Email;
import com.email.repository.IEmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmailRepository implements IEmailRepository {
    private static List<Email>  emailList = new ArrayList<>();
    static {

        emailList.add(new Email(1,"English",5,false,"Thorrrrr"));
        emailList.add(new Email(2,"Vietnamese",10,true,"Thorrrrr"));
        emailList.add(new Email(3,"Japanese",15,false,"Thorrrrr"));
        emailList.add(new Email(4,"Chinese",20,true,"Thorrrrr"));
    }
    @Override
    public List<Email> findAll() {
        return emailList;
    }

    @Override
    public Email findById(int id) {
        for (int i = 0; i <emailList.size(); i++) {
            if (emailList.get(i).getId()==id){
                return emailList.get(i);
            }
        }
        return null;
    }

    @Override
    public void update(Email email) {
        Email email1 = findById(email.getId());
        email1.setId(email.getId());
        email1.setLanguages(email.getLanguages());
        email1.setPageSize(email.getPageSize());
        email1.setSpamsFiller(email.isSpamsFiller());
        email1.setSignature(email.getSignature());

    }


}
