/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.cctv.c4.repository;

import co.cctv.c4.entity.Admin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author cktv
 */
@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository userCrudRepository;
    
    //Get ALl
    public List<Admin> getAll(){
        return (List<Admin>) userCrudRepository.findAll();
    }
    
    //Get por Id
    public Optional <Admin> getUser(int id){
        return userCrudRepository.findById(id);
    }
    
    //SAVE
    public Admin save(Admin admin){
        return userCrudRepository.save(admin);
    }
    
    //DELETE
    public void delete(Admin admin){
        userCrudRepository.delete(admin);
    }
    
    
    //CUSTOMS
    public List<Admin> findByEmail(String email){
        return userCrudRepository.findByEmail(email);
        
    }
    
    public Optional<Object> findByEmailAndPassword(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
        
    }
}
