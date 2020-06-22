
package com.finchFood.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.finchFood.model.IngredienteModel;
 
public interface IngredienteRepository extends JpaRepository<IngredienteModel, Integer> {


}