package com.healthcare_app.billing_service.util;

/**
 * Contains constant values used across the Bill Service implementation.
 * These constants help in maintaining consistent values and messages throughout the service layer.
 *
 * Author: A.A.M.C Abesinghe
 * Date: 2024/09/02
 */
public final class BillServiceConstants {

    // Private constructor to prevent instantiation
    private BillServiceConstants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
    /**
     * The status indicating that the bill has been fully paid.
     */
    // Constants related to billing status
    public static final String STATUS_PAID = "PAID";
    /**
     * The status indicating that the bill has been partially paid.
     */
    public static final String STATUS_PARTIALLY_PAID = "PARTIALLY PAID";
    /**
     * Error message indicating that the requested bill was not found.
     */

    // Error messages
    public static final String ERROR_BILL_NOT_FOUND = "Bill not found";
/**
 * Error message indicating that the payment amount provided is invalid.
 * It must be a positive value.
 */
    public static final String ERROR_INVALID_PAYMENT_AMOUNT = "Payment amount cannot be negative or zero";
    /**
     * Log message indicating that the payment was successful.
     */
    // Logging messages
    public static final String LOG_PAYMENT_SUCCESS = "Payment successful.";
    /**
     * Log message indicating that there is no outstanding balance for the bill.
     */
    public static final String LOG_NO_BALANCE = "No balance.";
    /**
     * Log message indicating that a partial payment was recorded, along with the remaining amount.
     */
    public static final String LOG_PARTIAL_PAYMENT = "Partial payment recorded. Remaining amount: ";

    // Other constants
    // Add any other constants that are reused across the service layer
}
