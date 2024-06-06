package com.example.famto.controller;

import com.example.famto.entity.CustomerData;
import com.example.famto.exception.ResourceNotFoundException;
import com.example.famto.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/customers")


public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    // get all customer
    @GetMapping
    public List<CustomerData> getAllCustomers() {
        return this.customerRepo.findAll();

    }

    // get customer by id
    @GetMapping("/{customerId}")
    public CustomerData getCustomerById(@PathVariable(value = "customerId") int customerId) {
        return this.customerRepo.findById(customerId).
                orElseThrow(() -> new ResourceNotFoundException("User not found with customerId"));
    }

    // create customer
    @PostMapping

    public CustomerData createCustomer(@RequestBody CustomerData customerData) {
        return this.customerRepo.save(customerData);

    }

    // update customer data
    @PutMapping("/{customerId}")
    public CustomerData updateCustomer(@RequestBody CustomerData customerData, @PathVariable("customerId") int customerId) {
        CustomerData existingCustomer = this.customerRepo.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with customerId"));

        if (customerData.getName() != null) {
            existingCustomer.setName(customerData.getName());
        }
        if (customerData.getEmail() != null) {
            existingCustomer.setEmail(customerData.getEmail());
        }
        if (customerData.getPhone() != null) {
            existingCustomer.setPhone(customerData.getPhone());
        }
        if (customerData.getPassword() != null) {
            existingCustomer.setPassword(customerData.getPassword());
        }
        if (customerData.getLastUsedPlatform() != null) {
            existingCustomer.setLastUsedPlatform(customerData.getLastUsedPlatform());
        }
        if (customerData.getRegisterAt() != null) {
            existingCustomer.setRegisterAt(customerData.getRegisterAt());
        }
        if (customerData.getWalletBalance() != null) {
            existingCustomer.setWalletBalance(customerData.getWalletBalance());
        }
        if (customerData.getRateAndReview() != null) {
            existingCustomer.setRateAndReview(customerData.getRateAndReview());
        }
        if (customerData.getCodStatus() != null) {
            existingCustomer.setCodStatus(customerData.getCodStatus());
        }
        if (customerData.getPayLaterStatus() != null) {
            existingCustomer.setPayLaterStatus(customerData.getPayLaterStatus());
        }
        if (customerData.getReferralCode() != null) {
            existingCustomer.setReferralCode(customerData.getReferralCode());
        }
        if (customerData.getVersions() != null) {
            existingCustomer.setVersions(customerData.getVersions());
        }
        if (customerData.getTags() != null) {
            existingCustomer.setTags(customerData.getTags());
        }
        if (customerData.getAddress() != null) {
            existingCustomer.setAddress(customerData.getAddress());
        }
        if (customerData.getLocality() != null) {
            existingCustomer.setLocality(customerData.getLocality());
        }
        if (customerData.getLandMark() != null) {
            existingCustomer.setLandMark(customerData.getLandMark());
        }
        if (customerData.getHouseNo() != null) {
            existingCustomer.setHouseNo(customerData.getHouseNo());
        }
        if (customerData.getTotalWalletBalance() != null) {
            existingCustomer.setTotalWalletBalance(customerData.getTotalWalletBalance());
        }
        if (customerData.getBlocked() != null) {
            existingCustomer.setBlocked(customerData.getBlocked());
        }
        if (customerData.getAmount() != null) {
            existingCustomer.setAmount(customerData.getAmount());
        }


        return this.customerRepo.save(existingCustomer);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<CustomerData> deleteCustomer(@PathVariable("customerId") int customerId) {
        CustomerData existingCustomer = this.customerRepo.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + customerId));
        this.customerRepo.delete(existingCustomer);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public List<CustomerData> searchCustomer(String query) {
        List<CustomerData> customers = customerRepo.searchCustomers(query);
        return customers;
    }

    // Helper method to update customer block status
    private CustomerData updateCustomerBlockStatus(int customerId, boolean blockedStatus) {
        CustomerData customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + customerId));

        customer.setBlocked(blockedStatus); // Update the blocked status
        // You may want to perform additional actions here, like logging the action

        return customerRepo.save(customer);
    }

    // Block customer by ID
    @PutMapping("/{customerId}/block")
    public ResponseEntity<CustomerData> blockCustomer(@PathVariable("customerId") int customerId) {
        CustomerData blockedCustomer = updateCustomerBlockStatus(customerId, true);
        return ResponseEntity.ok(blockedCustomer);
    }

    // Unblock customer by ID
    @PutMapping("/{customerId}/unblock")
    public ResponseEntity<CustomerData> unblockCustomer(@PathVariable("customerId") int customerId) {
        CustomerData unblockedCustomer = updateCustomerBlockStatus(customerId, false);
        return ResponseEntity.ok(unblockedCustomer);
    }

    // Other controller methods...

}


