/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.cctv.c4.repository;

import co.cctv.c4.entity.Admin;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author cktv
 */
public interface AdminCrudRepository extends CrudRepository<Admin, Integer>{
    public List<Admin> findByEmail(String email);
    public Optional<Object> findByEmailAndPassword (String email, String Password);

}
