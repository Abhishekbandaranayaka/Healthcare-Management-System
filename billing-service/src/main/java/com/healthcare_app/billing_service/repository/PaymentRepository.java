package com.healthcare_app.billing_service.repository;

import com.healthcare_app.billing_service.model.Payment;



/**

 *  * Author: A.A.M.C Abesinghe
 *  * Date: 2024/09/02
 */
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment , Long> {


}
