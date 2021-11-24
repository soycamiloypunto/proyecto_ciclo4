/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.cctv.c4.service;

import co.cctv.c4.entity.Admin;
import co.cctv.c4.entity.custom.AdminAndMail;
import co.cctv.c4.repository.AdminRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cktv
 */
@Service
public class UserService {
    
    @Autowired
    private AdminRepository userRepository;
    
    public List<Admin> getAll(){
        return userRepository.getAll();
    }
    
    public Optional<Admin> getUser(int id){
        return userRepository.getUser(id);
    }
    
    public Admin save(Admin user){
        if(user.getId()==null){
            return userRepository.save(user);
        }else{
            Optional<Admin> e=userRepository.getUser(user.getId());
            if(e.isEmpty()){
                return userRepository.save(user);
            }else{
                return user;
            }
        }
    }
    
    public Admin update(Admin user){
        if(user.getId()!=null){
            return userRepository.save(user);
        }else{
            Optional<Admin> e=userRepository.getUser(user.getId());
            if(!e.isEmpty()){
                if(user.getEmail()!=null){
                    e.get().setEmail(user.getEmail());
                }
                if(user.getName()!=null){
                    e.get().setName(user.getName());
                }
                if(user.getPassword()!=null){
                    e.get().setPassword(user.getPassword());
                }
                return e.get();
            }else{
                return user;
            }
        }
    }
    
    public boolean deleteUser(int id){
        
        
        Boolean aBoolean=getUser(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(aBoolean=false);
        
        return aBoolean;
    }
    
    
    //CUSTOMS
    public Boolean getByEmail(String email){
        //Cuento la lista para saber si existe algún registro con ese email
        if(userRepository.findByEmail(email).size()!=0){
            return true;
        }else{
            return false; 
        }
    }
    
    public Object getEmailAndPassword(String email, String password){
        //return userRepository.findByEmailAndPassword(email, password);
        
        if(userRepository.findByEmailAndPassword(email, password).isPresent()){
            return userRepository.findByEmailAndPassword(email, password);
        }else{
            AdminAndMail ObjetoCreado= new AdminAndMail();
            ObjetoCreado.setEmail(email);
            ObjetoCreado.setPassword(password);
            ObjetoCreado.setName("NO DEFINIDO");
            System.out.println("Objeto NULO: "+ObjetoCreado);
            return ObjetoCreado;
        }
        
        
//        System.out.println("Objeto: "+userRepository.findByEmailAndPassword(email, password));
//        if(userRepository.findByEmailAndPassword(email, password)==null){
//            UserAndMail ObjetoCreado= new UserAndMail();
//            ObjetoCreado.setEmail(email);
//            ObjetoCreado.setPassword(password);
//            ObjetoCreado.setName("NO DEFINIDO");
//            System.out.println("Objeto NULO: "+ObjetoCreado);
//            return ObjetoCreado;
//        }else{
//            System.out.println("Objeto NO NULO: "+userRepository.findByEmailAndPassword(email, password));
//            return userRepository.findByEmailAndPassword(email, password);
//        }
        
    }
    
}
