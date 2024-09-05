package com.healthcare_app.billing_service.repository;




import com.healthcare_app.billing_service.model.Bill;



/**

 *  * Author: A.A.M.C Abesinghe
 *  * Date: 2024/09/02
 */


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BillRepository extends JpaRepository<Bill , Long> {

    List<Bill> findByStatus(String status);

}
