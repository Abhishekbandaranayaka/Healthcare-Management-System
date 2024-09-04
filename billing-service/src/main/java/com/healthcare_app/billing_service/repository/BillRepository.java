package com.healthcare_app.billing_service.repository;




import com.healthcare_app.billing_service.model.Bill;



/**

 *  * Author: A.A.M.C Abesinghe
 *  * Date: 2024/09/02
 */


import org.springframework.data.jpa.repository.JpaRepository;



public interface BillRepository extends JpaRepository<Bill , Long> {


}
