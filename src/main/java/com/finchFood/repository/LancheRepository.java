
package com.finchFood.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.finchFood.model.LancheModel;
 
public interface LancheRepository extends JpaRepository<LancheModel, Integer> {
	
}
 
