package com.example.SpringMongoProject.Controller;

import com.example.SpringMongoProject.Entity.FormData;
import com.example.SpringMongoProject.Repo.FormDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/formData")
public class FormController {

    @Autowired
    private FormDataRepository formDataRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/submitForm")
    public String submitForm(@RequestBody FormData formData){
        formDataRepository.save(formData);

        try {
            sendConfirmationEmail(formData);
            return "Form submitted successfully!";
        }catch (Exception e){

            return "Error submitting the form. Please try again.";
        }
    }

    @GetMapping("/getAllFormData")
    public List<FormData> getAllFormData(){
        return formDataRepository.findAll();
    }

    @GetMapping("/search/{patientNIC}")
    public List<FormData> getByPatientNIC(@PathVariable String patientNIC){
        return formDataRepository.findByPatientNIC(patientNIC);
    }

    private void sendConfirmationEmail(FormData formData) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(formData.getEmail());
        message.setSubject("ABC-Laboratory Payment Reciept");
        message.setText("Payment Successfully - Thank You :\n\n" +
                "Name: " + formData.getName() + "\n" +
                "Subject: " + formData.getSubject() + "\n" +
                "Message: " + formData.getMessage() + "\n" +
                "Patient NIC: " + formData.getPatientNIC() + "\n" +
                "Card Type: " + formData.getCardType() + "\n" +
                "Price: " + formData.getPrice() + "\n" +
                "Card Number: " + formData.getCardNumber() + "\n" +
                "Expire Date: " + formData.getExpireDate() + "\n" +
                "CVV: " + formData.getCvv());

        javaMailSender.send(message);
    }


}
